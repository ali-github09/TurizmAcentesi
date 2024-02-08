package Dao;

import Core.Db;
import Entity.Hotel;
import Entity.Season;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeasonDao {
    private final Connection con;

    public SeasonDao() {
        this.con = Db.getInstance();
    }


    public ArrayList<Season> findAll(){
        ArrayList<Season> seasonList = new ArrayList<>();
        String sql = "SELECT * FROM public.season ORDER BY season_id";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                seasonList.add(this.match(rs));
            }
        } catch (Exception e){
            e.getMessage();
        }
        return seasonList;
    }

    public Season match(ResultSet rs) throws SQLException {
        Season season = new Season();
        season.setId(rs.getInt("season_id"));
        season.setOtel_id(rs.getInt("otel_id"));
        season.setStart_date(rs.getString("start_date"));
        season.setFinish_date(rs.getString("finish_date"));

        return season;

    }

    public boolean save(Season season){
        // kaç adet veri eklenecekse o kadar soru işareti olması gerekiyor.
        String query = "INSERT INTO public.season (season_id,otel_id,finish_date,start_date) VALUES (?,?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, season.getId());
            pr.setInt(2, season.getOtel_id());
            pr.setString(3, season.getFinish_date());
            pr.setString(4, season.getStart_date());

            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Season> getSeasonsByOtelId(int otelId) {
        ArrayList<Season> seasons = new ArrayList<>();
        String query = "SELECT * FROM public.season WHERE otel_id = ?";

        try (PreparedStatement pr = con.prepareStatement(query)) {
            pr.setInt(1, otelId);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                Season season = match(rs);
                seasons.add(season);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seasons;
    }




}