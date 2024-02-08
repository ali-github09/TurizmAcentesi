package View;

import Business.*;
import Entity.Hotel;
import Entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class EmployeeView extends Layout{
    private JPanel container;
    private JButton btn_logout;
    private JLabel lbl_welcome;
    private JTabbedPane tabbedPane1;
    private JTable tbl_otel;
    private JTable tbl_reservation;
    private JButton otelEkleButton;
    private JTable tbl_season;
    private JTable tbl_pansiyon;
    private JTable tbl_rooms;
    private JPanel pnl_room_list;
    private JTextField fld_otel_name;
    private JTextField fld_city_name;
    private JTextField fld_start_date;
    private JTextField fld_finish_date;
    private JTextField fld_adult_number;
    private JTextField fld_child_number;
    private JButton button_add;
    private JButton button_search;
    private JButton button_reset;
    private User user;
    private UserManager userManager;
    private DefaultTableModel taslak_otel_tablosu = new DefaultTableModel();
    private DefaultTableModel taslak_season_tablosu = new DefaultTableModel();
    private DefaultTableModel taslak_donem_tablosu = new DefaultTableModel();
    private DefaultTableModel taslak_pansiyon_tablosu = new DefaultTableModel();
    private DefaultTableModel taslak_oda_tablosu = new DefaultTableModel();
    private DefaultTableModel taslak_rezervasyon_talosu = new DefaultTableModel();
    private HotelManager hotelManager;
    private Hotel hotel;
    private SeasonManager seasonManager;
    private PansiyonManager pansiyonManager;
    private RoomManager roomManager;
    private JPopupMenu rezervationmenu;
    private RezervationManager rezervationManager;

    public EmployeeView(User user) {
        this.rezervationManager = new RezervationManager();
        this.rezervationmenu = new JPopupMenu();
        this.roomManager = new RoomManager();
        this.pansiyonManager = new PansiyonManager();
        this.seasonManager = new SeasonManager();
        this.hotel = new Hotel();
        this.hotelManager = new HotelManager();
        this.userManager = new UserManager();
        this.add(container);
        this.GuiInitiliaze(1500,1000);
        this.lbl_welcome.setText("Hoşgeldiniz");


        loadoteltable();
        addNewHotel();
        loadseasontable(); // herhangi bir otelini üstüne tıklandığında gösterilecek.
        loadpansiyontable(); // herhangi bir otelini üstüne tıklandığında gösterilecek.
        loadroomtable();
        addNewRomm();
        loadRoomComponent();
        loadReservationtable();
    }

    public void loadReservationtable() {
        Object[] col_user = {"id", "room_id", "check_in_date", "chech_out_date", "total_price", "guest_count", "guest_name",
                "guest_citizen_id", "guest_mail", "guest_phone"};
        ArrayList<Object[]> rezervationList = this.rezervationManager.getForTable(col_user.length);
        this.createTable(this.taslak_rezervasyon_talosu,this.tbl_reservation,col_user,rezervationList);
    }

    public void loadRoomComponent(){
        tableRowSelect(tbl_rooms);
        //mouse konumunu bulmak için pressed ile  basıldığı andaki konumunu aldık ve bir integer değere atadık.
        //onu da tıkladığımız rowu seçili halel getirmek için kullandık.
        this.tbl_rooms.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_rooms.rowAtPoint(e.getPoint());
                tbl_rooms.setRowSelectionInterval(selected_row,selected_row);
            }
        });
        this.rezervationmenu = new JPopupMenu();
        this.rezervationmenu.add("Yeni").addActionListener(e -> {
            ReservationSaveView reservationSaveView = new ReservationSaveView();

            //açtığımız popup ekranı kapatıldığında tetiklenen bir yüklme işlemi yapıp tablomuzu güncel haliyle tekrar yüklüyoruz.
            // böylece yaptığımız değişikliği anında görebiliyoruz.
            reservationSaveView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadReservationtable();
                }
            });
        });
        this.tbl_rooms.setComponentPopupMenu(rezervationmenu);
    }





    private void addNewRomm() {
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomSaveView roomSaveView = new RoomSaveView();
                roomSaveView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadroomtable();
                    }
                });
            }
        });
    }


    public void addNewHotel() {
        this.otelEkleButton.addActionListener(e -> {
            HotelSaveView hotelSaveView = new HotelSaveView(hotel);
            hotelSaveView.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadoteltable();
                }
            });
        });
    }


    public void loadoteltable(){
        tableRowSelect(tbl_otel);
        //oluşturduğumuz taslak tablonun kolonlarını oluşturduk
        Object[] col_user = {"otel_id", "otel_name", "otel_adress", "otel_mail", "otel_phone", "otel_star", "carpark", "wifi", "pool", "fitness" , "concierge" , "spa" , "room_service"};
        // bütün otelleri getfortable metoduyla alıp bir arraylistin içine attık.
        ArrayList<Object[]> hotelList = this.hotelManager.getForTable(col_user.length);
        //createtable metoduyla bir taslak tablo oluşturduk kolonları oluştuduk listeyi oluşturduk bunu swingdeki asıl tablomuza eşitledik.
        this.createTable(this.taslak_otel_tablosu,this.tbl_otel,col_user,hotelList);
    }

    public void loadseasontable() {
        Object[] col_user = {"season_id", "otel_id", "start date", "finish date"};
        ArrayList<Object[]> seasonList = this.seasonManager.getForTable(col_user.length);
        this.createTable(this.taslak_season_tablosu,this.tbl_season,col_user,seasonList);
    }

    public void loadpansiyontable() {
        Object[] col_user = {"pansiyon_id", "otel_id", "pansiyon tipi"};
        ArrayList<Object[]> pansiyonList = this.pansiyonManager.getForTable(col_user.length);
        this.createTable(this.taslak_pansiyon_tablosu,this.tbl_pansiyon,col_user,pansiyonList);
    }

    public void loadroomtable() {
        Object[] col_user = {"id", "otel_id", "pansiyon", "dönem", "oda tipi", "stok", "yetişkin fiyatı",
                "çocuk fiyatı", "yatak kapasitesi", "alan", "tv", "minibar", "oyunkonsolu", "kasa", "projeksiyon"};
        ArrayList<Object[]> roomList = this.roomManager.getForTable(col_user.length);
        this.createTable(this.taslak_oda_tablosu,this.tbl_rooms,col_user,roomList);
    }






}



