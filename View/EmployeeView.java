package View;

import Business.HotelManager;
import Business.UserManager;
import Entity.Hotel;
import Entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EmployeeView extends Layout{
    private JPanel container;
    private JButton btn_logout;
    private JLabel lbl_welcome;
    private JTabbedPane tabbedPane1;
    private JTable tbl_otel;
    private JTable table2;
    private JTable table3;
    private JPanel pnl_pansiyon;
    private JPanel pnl_dönem;
    private JButton otelEkleButton;
    private User user;
    private UserManager userManager;
    private DefaultTableModel taslak_otel_tablosu = new DefaultTableModel();
    private HotelManager hotelManager;
    private Hotel hotel;

    public EmployeeView(User user) {
        this.hotel = new Hotel();
        this.hotelManager = new HotelManager();
        this.userManager = new UserManager();
        this.add(container);
        this.GuiInitiliaze(1500,1000);
        this.lbl_welcome.setText("Hoşgeldiniz");

    loadoteltable();
    this.otelEkleButton.addActionListener(e -> {
        HotelSaveView hotelSaveView = new HotelSaveView(hotel);
    });
    }



    public void loadoteltable(){
        //oluşturduğumuz taslak tablonun kolonlarını oluşturduk
        Object[] col_user = {"otel_id", "otel_name", "otel_adress", "otel_mail", "otel_phone", "otel_star", "carpark", "wifi", "pool", "fitness" , "concierge" , "spa" , "room_service"};
        // bütün otelleri getfortable metoduyla alıp bir arraylistin içine attık.
        ArrayList<Object[]> hotelList = this.hotelManager.getForTable(col_user.length);
        //createtable metoduyla bir taslak tablo oluşturduk kolonları oluştuduk listeyi oluşturduk bunu swingdeki asıl tablomuza eşitledik.
        this.createTable(this.taslak_otel_tablosu,this.tbl_otel,col_user,hotelList);
    }


}



