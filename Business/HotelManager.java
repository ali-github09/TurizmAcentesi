package Business;

import Core.Helper;
import Dao.HotelDao;
import Entity.Hotel;
import Entity.User;

import java.util.ArrayList;

public class HotelManager {
    private HotelDao hotelDao;

    public HotelManager() {
        this.hotelDao = new HotelDao();
    }

    public ArrayList<Hotel> findAll(){
        return this.hotelDao.findAll();
    }

    public boolean save(Hotel hotel){
        // eğer verdiğimizi otelin'in id'si 0 değilse yani bir id'si varsa bunu tabloya ekleyemeyiz bu durumda hata yapmışız demektir
        if(hotel.getId() != 0){
            Helper.showMsg("error");
        }
        return this.hotelDao.save(hotel);
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> hotelRowList = new ArrayList<>();

        for(Hotel hotel1: this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = hotel1.getId();
            rowObject[i++] = hotel1.getHotelname();
            rowObject[i++] = hotel1.getHoteladress();
            rowObject[i++] = hotel1.getHotelmail();
            rowObject[i++] = hotel1.getHotelphone();
            rowObject[i++] = hotel1.getHotelstar();
            rowObject[i++] = hotel1.isCarpark();
            rowObject[i++] = hotel1.isWifi();
            rowObject[i++] = hotel1.isPool();
            rowObject[i++] = hotel1.isFitness();
            rowObject[i++] = hotel1.isConcierge();
            rowObject[i++] = hotel1.isSpa();
            rowObject[i++] = hotel1.isRoomservice();

            hotelRowList.add(rowObject);
        }
        return hotelRowList;
    }
}
