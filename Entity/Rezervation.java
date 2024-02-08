package Entity;

import java.time.LocalDate;

public class Rezervation {
    private int id;
    private int room_id;
    private LocalDate check_in_date;
    private LocalDate check_out_date;
    private int total_price;
    private int guest_count;
    private String guest_name;
    private int guest_citizen_id;
    private String guest_mail;
    private int guest_phone;
    private Room room;

    public Rezervation() {
    }

    public Rezervation(int id, int room_id, LocalDate check_in_date, LocalDate check_out_date, int total_price,
                       int guest_count, String guest_name, int guest_citizen_id, String guest_mail, int guest_phone, Room room) {
        this.id = id;
        this.room_id = room_id;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.total_price = total_price;
        this.guest_count = guest_count;
        this.guest_name = guest_name;
        this.guest_citizen_id = guest_citizen_id;
        this.guest_mail = guest_mail;
        this.guest_phone = guest_phone;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public LocalDate getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(LocalDate check_in_date) {
        this.check_in_date = check_in_date;
    }

    public LocalDate getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(LocalDate check_out_date) {
        this.check_out_date = check_out_date;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getGuest_count() {
        return guest_count;
    }

    public void setGuest_count(int guest_count) {
        this.guest_count = guest_count;
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public int getGuest_citizen_id() {
        return guest_citizen_id;
    }

    public void setGuest_citizen_id(int guest_citizen_id) {
        this.guest_citizen_id = guest_citizen_id;
    }

    public String getGuest_mail() {
        return guest_mail;
    }

    public void setGuest_mail(String guest_mail) {
        this.guest_mail = guest_mail;
    }

    public int getGuest_phone() {
        return guest_phone;
    }

    public void setGuest_phone(int guest_phone) {
        this.guest_phone = guest_phone;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}