package Dao;

import Core.Db;
import Entity.Rezervation;
import Entity.Room;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RezervationDao {
    private final Connection con;
    private RoomDao roomDao;

    public RezervationDao() {
        this.roomDao = new RoomDao();
        this.con = Db.getInstance();
    }

    public ArrayList<Rezervation> findAll(){
        ArrayList<Rezervation> rezervationList = new ArrayList<>();
        String sql = "SELECT * FROM public.rezervasyon ORDER BY id";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                rezervationList.add(this.match(rs));
            }

        } catch (Exception e){
            e.getMessage();
        }
        return rezervationList;
    }

    public Rezervation match(ResultSet rs) throws SQLException {
        Rezervation rezervation = new Rezervation();
        rezervation.setId(rs.getInt("id"));
        rezervation.setRoom_id(rs.getInt("room_id"));
        rezervation.setCheck_in_date((rs.getDate("check_in_date").toLocalDate()));
        rezervation.setCheck_out_date((rs.getDate("check_out_date").toLocalDate()));
        rezervation.setTotal_price(rs.getInt("total_price"));
        rezervation.setGuest_count(rs.getInt("guest_count"));
        rezervation.setGuest_name(rs.getString("guest_name"));
        rezervation.setGuest_citizen_id(rs.getInt("guest_citizen_id"));
        rezervation.setGuest_mail(rs.getString("guest_mail"));
        rezervation.setGuest_phone(rs.getInt("guest_phone"));
        return rezervation;
    }

    public boolean save(Rezervation rezervation){
        // kaç adet veri eklenecekse o kadar soru işareti olması gerekiyor.
        String query = "INSERT INTO public.rezervasyon (room_id,check_in_date,check_out_date,total_price,guest_count,guest_name,guest_citizen_id,guest_mail,guest_phone) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, rezervation.getRoom_id());
            pr.setDate(2, Date.valueOf(rezervation.getCheck_in_date()));
            pr.setDate(3, Date.valueOf(rezervation.getCheck_out_date()));
            pr.setInt(4, rezervation.getTotal_price());
            pr.setInt(5, rezervation.getGuest_count());
            pr.setString(6, rezervation.getGuest_name());
            pr.setInt(7,rezervation.getGuest_citizen_id());
            pr.setString(8, rezervation.getGuest_mail());
            pr.setInt(9, rezervation.getGuest_phone());
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
