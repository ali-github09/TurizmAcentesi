package Dao;

import Core.Db;
import Entity.Hotel;
import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDao {
    private final Connection con;

    //constructor
    public HotelDao() {
        this.con = Db.getInstance();
    }


    public ArrayList<Hotel> findAll(){
        ArrayList<Hotel> hotelList = new ArrayList<>();
        String sql = "SELECT * FROM public.otel ORDER BY otel_id";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                hotelList.add(this.match(rs));
            }
        } catch (Exception e){
            e.getMessage();
        }
        return hotelList;
    }

    public Hotel match(ResultSet rs) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("otel_id"));
        hotel.setHotelname(rs.getString("otel_name"));
        hotel.setHoteladress(rs.getString("otel_adress"));
        hotel.setHotelmail(rs.getString("otel_mail"));
        hotel.setHotelphone(rs.getString("otel_phone"));
        hotel.setHotelstar(rs.getString("otel_star"));
        hotel.setCarpark(rs.getBoolean("carpark"));
        hotel.setWifi(rs.getBoolean("wifi"));
        hotel.setPool(rs.getBoolean("pool"));
        hotel.setFitness(rs.getBoolean("fitness"));
        hotel.setConcierge(rs.getBoolean("concierge"));
        hotel.setSpa(rs.getBoolean("spa"));
        hotel.setRoomservice(rs.getBoolean("room_service"));

        return hotel;
    }

    public boolean save(Hotel hotel){
        // kaç adet veri eklenecekse o kadar soru işareti olması gerekiyor.
        String query = "INSERT INTO public.otel (otel_name,otel_adress,otel_mail,otel_phone,otel_star,carpark,wifi,pool,fitness,concierge,room_service,spa) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, hotel.getHotelname());
            pr.setString(2, hotel.getHoteladress());
            pr.setString(3, hotel.getHotelmail());
            pr.setString(4, hotel.getHotelphone());
            pr.setString(5, hotel.getHotelstar());
            pr.setBoolean(6, hotel.isCarpark());
            pr.setBoolean(7, hotel.isWifi());
            pr.setBoolean(8, hotel.isPool());
            pr.setBoolean(9, hotel.isFitness());
            pr.setBoolean(10, hotel.isConcierge());
            pr.setBoolean(11, hotel.isRoomservice());
            pr.setBoolean(12, hotel.isSpa());
            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

}
