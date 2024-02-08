package Business;

import Core.Helper;
import Dao.RezervationDao;
import Entity.Rezervation;
import Entity.Room;

import java.util.ArrayList;

public class RezervationManager {
    private RezervationDao rezervationDao;

    public RezervationManager() {
        this.rezervationDao = new RezervationDao();
    }

    public ArrayList<Rezervation> findAll(){
        return this.rezervationDao.findAll();
    }

    public boolean save(Rezervation rezervation){
        // eğer verdiğimizi room'un id'si 0 değilse yani bir id'si varsa bunu tabloya ekleyemeyiz bu durumda hata yapmışız demektir
        if(rezervation.getId() != 0){
            Helper.showMsg("error");
        }
        return this.rezervationDao.save(rezervation);
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> reservationRowList = new ArrayList<>();
        for(Rezervation rezervation1: this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = rezervation1.getId();
            rowObject[i++] = rezervation1.getRoom_id();
            rowObject[i++] = rezervation1.getCheck_in_date();
            rowObject[i++] = rezervation1.getCheck_out_date();
            rowObject[i++] = rezervation1.getTotal_price();
            rowObject[i++] = rezervation1.getTotal_price();
            rowObject[i++] = rezervation1.getGuest_name();
            rowObject[i++] = rezervation1.getGuest_phone();
            rowObject[i++] = rezervation1.getGuest_mail();
            rowObject[i++] = rezervation1.getGuest_citizen_id();

            reservationRowList.add(rowObject);
        }
        return reservationRowList;
    }

}
