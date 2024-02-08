package Dao;

import Core.Db;
import Entity.Room;
import Entity.Season;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class RoomDao {
    private final Connection con;

    public RoomDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Room> findAll(){
        ArrayList<Room> roomList = new ArrayList<>();
        String sql = "SELECT * FROM public.room ORDER BY id";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while(rs.next()){
                roomList.add(this.match(rs));
            }
        } catch (Exception e){
            e.getMessage();
        }
        return roomList;
    }

    public Room match(ResultSet rs) throws SQLException {
        Room room = new Room();
        room.setId(rs.getInt("id"));
        room.setOtel_id(rs.getInt("otel_id"));
        room.setPansiyon(rs.getString("pansiyon"));
        room.setSeason(rs.getString("dönem"));
        room.setOda_tipi(rs.getString("oda_tipi"));
        room.setStok(rs.getInt("stok"));
        room.setYetişkin_fiyat(rs.getInt("yetişkin_fiyat"));
        room.setÇocuk_fiyat(rs.getInt("çocuk_fiyat"));
        room.setYatak_kapasitesi(rs.getInt("yatak_kapasitesi"));
        room.setAlan(rs.getInt("alan"));
        room.setTv(rs.getBoolean("tv"));
        room.setMinibar(rs.getBoolean("minibar"));
        room.setOyun_konsolu(rs.getBoolean("oyun_konsolu"));
        room.setKasa(rs.getBoolean("kasa"));
        room.setProjeksiyon(rs.getBoolean("projeksiyon"));
        return room;
    }

    public boolean save(Room room){
        // kaç adet veri eklenecekse o kadar soru işareti olması gerekiyor.
        String query = "INSERT INTO public.room (otel_id,pansiyon,dönem,oda_tipi,stok,yetişkin_fiyat,çocuk_fiyat,yatak_kapasitesi,alan,tv,minibar,oyun_konsolu,kasa,projeksiyon) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, room.getOtel_id());
            pr.setString(2, room.getPansiyon());
            pr.setString(3, room.getSeason());
            pr.setString(4, room.getOda_tipi());
            pr.setInt(5, room.getStok());
            pr.setInt(6, room.getYetişkin_fiyat());
            pr.setInt(7, room.getÇocuk_fiyat());
            pr.setInt(8, room.getYatak_kapasitesi());
            pr.setInt(9, room.getAlan());
            pr.setBoolean(10, room.isTv());
            pr.setBoolean(11, room.isMinibar());
            pr.setBoolean(12,room.isOyun_konsolu());
            pr.setBoolean(13,room.isKasa());
            pr.setBoolean(14,room.isProjeksiyon());

            return pr.executeUpdate() != -1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public Room getById(int id){
        Room obj = null;
        String query = "SELECT * FROM public.room WHERE id = ?";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1,id);
            ResultSet rs = pr.executeQuery();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        } return obj;
    }
}
