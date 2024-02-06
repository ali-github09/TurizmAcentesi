package Business;

import Core.Helper;
import Dao.PansiyonDao;
import Entity.Hotel;
import Entity.Pansiyon;

import java.util.ArrayList;

public class PansiyonManager {
    private PansiyonDao pansiyonDao;


    public PansiyonManager() {
        this.pansiyonDao = new PansiyonDao();
    }

    public ArrayList<Pansiyon> findAll(){
        return this.pansiyonDao.findAll();
    }

    public boolean save(Pansiyon pansiyon){
        // eğer verdiğimizi otelin'in id'si 0 değilse yani bir id'si varsa bunu tabloya ekleyemeyiz bu durumda hata yapmışız demektir
        if(pansiyon.getId() != 0){
            Helper.showMsg("error");
        }
        return this.pansiyonDao.save(pansiyon);
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> pansiyonRowList = new ArrayList<>();

        for(Pansiyon pansiyon1: this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = pansiyon1.getId();
            rowObject[i++] = pansiyon1.getOtel_id();
            rowObject[i++] = pansiyon1.getPansiyon_name();
            pansiyonRowList.add(rowObject);
        }
        return pansiyonRowList;
    }

}
