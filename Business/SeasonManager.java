package Business;

import Core.Helper;
import Dao.SeasonDao;
import Entity.Hotel;
import Entity.Season;

import java.util.ArrayList;

public class SeasonManager {
    private SeasonDao seasonDao;

    public SeasonManager() {
        this.seasonDao = new SeasonDao();
    }

    public ArrayList<Season> findAll(){
        return this.seasonDao.findAll();
    }

    public boolean save(Season season){
        // eğer verdiğimizi season'un id'si 0 değilse yani bir id'si varsa bunu tabloya ekleyemeyiz bu durumda hata yapmışız demektir
        if(season.getId() != 0){
            Helper.showMsg("error");
        }
        return this.seasonDao.save(season);
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> seasonRowList = new ArrayList<>();

        for(Season season1: this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = season1.getId();
            rowObject[i++] = season1.getOtel_id();
            rowObject[i++] = season1.getFinish_date();
            rowObject[i++] = season1.getStart_date();

            seasonRowList.add(rowObject);
        }
        return seasonRowList;
    }
}
