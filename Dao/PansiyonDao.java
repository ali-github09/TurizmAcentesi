package Dao;

import Core.Db;
import Entity.Pansiyon;
import Entity.Season;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PansiyonDao {
    private final Connection con;

    public PansiyonDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Pansiyon> findAll(){
        ArrayList<Pansiyon> pansiyonList = new ArrayList<>();
        String sql = "SELECT * FROM public.pansiyon ORDER BY id";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                pansiyonList.add(this.match(rs));
            }
        } catch (Exception e){
            e.getMessage();
        }
        return pansiyonList;
    }

    public Pansiyon match(ResultSet rs) throws SQLException {
        Pansiyon pansiyon = new Pansiyon();
        pansiyon.setId(rs.getInt("id"));
        pansiyon.setOtel_id(rs.getInt("otel_id"));
        pansiyon.setPansiyon_name(rs.getString("pansiyon_tipi"));
        return pansiyon;
    }

    public boolean save(Pansiyon pansiyon){
        // kaç adet veri eklenecekse o kadar soru işareti olması gerekiyor.
        String query = "INSERT INTO public.pansiyon (id,otel_id,pansiyon_tipi) VALUES (?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, pansiyon.getId());
            pr.setInt(2, pansiyon.getOtel_id());
            pr.setString(3, pansiyon.getPansiyon_name());
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Pansiyon> getPensionByOtelId(int id) {
        ArrayList<Pansiyon> pansiyons = new ArrayList<>();
        String query = "SELECT * FROM public.pansiyon WHERE otel_id = ?";

        try (PreparedStatement pr = con.prepareStatement(query)) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                Pansiyon pansiyon = match(rs);
                pansiyons.add(pansiyon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pansiyons;
    }



}
