package Business;

import Core.Helper;
import Dao.UserDao;
import Entity.User;

import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    private final UserDao userDao;

    public UserManager() {
        this.userDao = new UserDao();
    }

    public User findByLogin(String username, String password){
        return this.userDao.findByLogin(username,password);
    }

    public ArrayList<User> findAll(){
        return this.userDao.findAll();
    }

    //yeni user oluşturup bunu userdao'ya gönderiyoruz. o da veritabanına kaydediyor
    public boolean save(User user){
        // eğer verdiğimizi user'in id'si 0 değilse yani bir id'si varsa bunu tabloya ekleyemeyiz bu durumda hata yapmışız demektir
         if(user.getId() != 0){
             Helper.showMsg("error");
         }
        return this.userDao.save(user);
    }

    public boolean update(User user){
        if(this.getById(user.getId()) == null){
            Helper.showMsg("notFound");
        }
        return this.userDao.update(user);
    }

    public User getById(int id){
        return this.userDao.getById(id);
    }

    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> userRowList = new ArrayList<>();

        for(User user1: this.findAll()){
            Object[] rowObject = new Object[size];
            int i = 0;
            rowObject[i++] = user1.getId();
            rowObject[i++] = user1.getUsername();
            rowObject[i++] = user1.getPassword();
            rowObject[i++] = user1.getRole();
            userRowList.add(rowObject);
        }
        return userRowList;
    }

    public boolean delete(int id){
        if(this.getById(id) == null){
            Helper.showMsg(id + " ID kayıtlı ID bulunamadı.");
            return false;
        }
        return this.userDao.delete(id);
    }
}
