package View;

import Business.HotelManager;
import Business.PansiyonManager;
import Business.RoomManager;
import Business.SeasonManager;
import Core.ComboItem;
import Core.Helper;
import Entity.Hotel;
import Entity.Pansiyon;
import Entity.Room;
import Entity.Season;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RoomSaveView extends Layout{
    private Room room;
    private Hotel hotel;
    private HotelManager hotelManager = new HotelManager();
    private RoomManager roomManager;
    private ComboItem comboItem = new ComboItem();
    private PansiyonManager pansiyonManager = new PansiyonManager();
    private SeasonManager seasonManager = new SeasonManager();
    private JPanel container;
    private JPanel pnl_left;
    private JComboBox cmb_otel;
    private JComboBox cmb_pansiyon;
    private JComboBox cmb_sezon;
    private JComboBox cmb_oda_tipi;
    private JTextField fld_stok;
    private JTextField fld_yetişkin_fiyat;
    private JTextField fld_çocuk_fiyat;
    private JTextField fld_yatak_kapasitesi;
    private JTextField fld_metrekare;
    private JRadioButton tvRadioButton;
    private JRadioButton mniBarRadioButton;
    private JRadioButton oyunKonsoluRadioButton;
    private JRadioButton kasaRadioButton;
    private JRadioButton projeksiyonRadioButton;
    private JButton kaydetButton;
    private JPanel pnl_right;
    private JLabel lbl_yetişkin_fiyat;

    public RoomSaveView() {
        this.hotel = new Hotel();
        this.add(container);
        this.room = new Room();
        this.roomManager = new RoomManager();
        this.GuiInitiliaze(430,400);

        for (Hotel hotel : hotelManager.findAll()) {
            this.cmb_otel.addItem(hotel.getComboItem());
        }

        this.cmb_otel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComboItem selectedItem = (ComboItem) cmb_otel.getSelectedItem();
                int selectedOtelId = selectedItem.getKey();
                ArrayList<Pansiyon> pansiyons = pansiyonManager.getPensionByOtelId(((ComboItem) cmb_otel.getSelectedItem()).getKey());
                cmb_pansiyon.removeAllItems();
                for(Pansiyon pansiyon: pansiyons){
                    cmb_pansiyon.addItem(pansiyon.getComboItem());
                }
                ArrayList<Season> seasons = seasonManager.getSeasonsByOtelId(((ComboItem) cmb_otel.getSelectedItem()).getKey());
                cmb_sezon.removeAllItems();
                for (Season season : seasons) {
                    cmb_sezon.addItem(season.getComboItem());

                }
            }
        });


        this.kaydetButton.addActionListener(e -> {

            JTextField[] textfields = {fld_stok, fld_yetişkin_fiyat,fld_çocuk_fiyat,fld_yatak_kapasitesi,fld_metrekare};
            if(Helper.isFieldListEmpty(textfields)){
                Helper.showMsg("fill");
            } else{

                boolean result;
                ComboItem selectedHotel = (ComboItem) cmb_otel.getSelectedItem();
                ComboItem selectedPension = (ComboItem) cmb_pansiyon.getSelectedItem();
                ComboItem selectedSeason=(ComboItem) cmb_sezon.getSelectedItem();
                int stok = Integer.parseInt(fld_stok.getText());
                this.room.setStok(stok);
                int yetişkin_fiyat = Integer.parseInt(fld_yetişkin_fiyat.getText());
                this.room.setYetişkin_fiyat(yetişkin_fiyat);
                int çocuk_fiyatı = Integer.parseInt(fld_çocuk_fiyat.getText());
                this.room.setÇocuk_fiyat(çocuk_fiyatı);
                int yatak_kapasitesi = Integer.parseInt(fld_yatak_kapasitesi.getText());
                this.room.setYatak_kapasitesi(yatak_kapasitesi);
                int alan = Integer.parseInt(fld_metrekare.getText());
                this.room.setAlan(alan);
                this.room.setTv(tvRadioButton.isSelected());
                this.room.setMinibar(mniBarRadioButton.isSelected());
                this.room.setOyun_konsolu(oyunKonsoluRadioButton.isSelected());
                this.room.setKasa(kasaRadioButton.isSelected());
                this.room.setProjeksiyon(projeksiyonRadioButton.isSelected());

                result = this.roomManager.save(this.room);

                dispose();
            }
        });




    }




}
