package Entity;

import Business.HotelManager;
import Core.ComboItem;

public class Hotel {

    private int id;
    private String hotelname;
    private String hoteladress;
    private String hotelmail;
    private String hotelphone;
    private String hotelstar;
    private boolean carpark;
    private boolean wifi;
    private boolean pool;
    private boolean fitness;
    private boolean concierge;
    private boolean spa;
    private boolean roomservice;
    private HotelManager hotelManager;
    private Pansiyon pansiyon;

    public Hotel() {
    }

    public Hotel(int id, String hotelname, String hoteladress, String hotelmail, String hotelphone, String hotelstar,
                 boolean carpark, boolean wifi, boolean pool, boolean fitness, boolean concierge, boolean spa, boolean roomservice) {
        this.id = id;
        this.hotelname = hotelname;
        this.hoteladress = hoteladress;
        this.hotelmail = hotelmail;
        this.hotelphone = hotelphone;
        this.hotelstar = hotelstar;
        this.carpark = carpark;
        this.wifi = wifi;
        this.pool = pool;
        this.fitness = fitness;
        this.concierge = concierge;
        this.spa = spa;
        this.roomservice = roomservice;
        HotelManager hotelManager = new HotelManager();
        Pansiyon pansiyon = new Pansiyon();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHoteladress() {
        return hoteladress;
    }

    public void setHoteladress(String hoteladress) {
        this.hoteladress = hoteladress;
    }

    public String getHotelmail() {
        return hotelmail;
    }

    public void setHotelmail(String hotelmail) {
        this.hotelmail = hotelmail;
    }

    public String getHotelphone() {
        return hotelphone;
    }

    public void setHotelphone(String hotelphone) {
        this.hotelphone = hotelphone;
    }

    public String getHotelstar() {
        return hotelstar;
    }

    public void setHotelstar(String hotelstar) {
        this.hotelstar = hotelstar;
    }

    public boolean isCarpark() {
        return carpark;
    }

    public void setCarpark(boolean carpark) {
        this.carpark = carpark;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isFitness() {
        return fitness;
    }

    public void setFitness(boolean fitness) {
        this.fitness = fitness;
    }

    public boolean isConcierge() {
        return concierge;
    }

    public void setConcierge(boolean concierge) {
        this.concierge = concierge;
    }

    public boolean isSpa() {
        return spa;
    }

    public void setSpa(boolean spa) {
        this.spa = spa;
    }

    public boolean isRoomservice() {
        return roomservice;
    }

    public void setRoomservice(boolean roomservice) {
        this.roomservice = roomservice;
    }

    public ComboItem getComboItem(){
        return new ComboItem(this.getId(), this.getHotelname());
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelname='" + hotelname + '\'' +
                ", hoteladress='" + hoteladress + '\'' +
                ", hotelmail='" + hotelmail + '\'' +
                ", hotelphone='" + hotelphone + '\'' +
                ", hotelstar='" + hotelstar + '\'' +
                ", carpark=" + carpark +
                ", wifi=" + wifi +
                ", pool=" + pool +
                ", fitness=" + fitness +
                ", concierge=" + concierge +
                ", spa=" + spa +
                ", roomservice=" + roomservice +
                '}';
    }
}
