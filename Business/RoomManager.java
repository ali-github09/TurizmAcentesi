package Business;

import Core.Helper;
import Dao.RoomDao;
import Entity.Room;
import Entity.Season;

import java.util.ArrayList;

public class RoomManager {
    private RoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDao();
    }

    public ArrayList<Room> findAll(){
        return this.roomDao.findAll();
    }

    public boolean save(Room room){
        // eğer verdiğimizi room'un id'si 0 değilse yani bir id'si varsa bunu tabloya ekleyemeyiz bu durumda hata yapmışız demektir
        if(room.getId() != 0){
            Helper.showMsg("error");
        }
        return this.roomDao.save(room);
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> roomRowList = new ArrayList<>();

        for(Room room1: this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = room1.getId();
            rowObject[i++] = room1.getOtel_id();
            rowObject[i++] = room1.getPansiyon();
            rowObject[i++] = room1.getSeason();
            rowObject[i++] = room1.getOda_tipi();
            rowObject[i++] = room1.getStok();
            rowObject[i++] = room1.getYetişkin_fiyat();
            rowObject[i++] = room1.getÇocuk_fiyat();
            rowObject[i++] = room1.getYatak_kapasitesi();
            rowObject[i++] = room1.getAlan();
            rowObject[i++] = room1.isTv();
            rowObject[i++] = room1.isMinibar();
            rowObject[i++] = room1.isOyun_konsolu();
            rowObject[i++] = room1.isKasa();
            rowObject[i++] = room1.isProjeksiyon();
            roomRowList.add(rowObject);
        }
        return roomRowList;
    }
}
