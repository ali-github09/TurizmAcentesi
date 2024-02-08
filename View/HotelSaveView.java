package View;

import Business.HotelManager;
import Core.ComboItem;
import Core.Helper;
import Entity.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelSaveView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JLabel lbl_otel_name;
    private JTextField fld_hotel_name;
    private JLabel lbl_mail;
    private JTextField fld_mail;
    private JTextField fld_phone;
    private JTextField fld_adres;
    private JComboBox cmb_star;
    private JRadioButton carParkRadioButton;
    private JRadioButton wifiRadioButton;
    private JRadioButton poolRadioButton;
    private JRadioButton fitnessRadioButton;
    private JRadioButton conciergeRadioButton;
    private JRadioButton spaRadioButton;
    private JRadioButton rommServiceRadioButton;
    private JButton kaydetButton;
    private Hotel hotel;
    private HotelManager hotelManager;



    public HotelSaveView(Hotel hotel) {


        this.hotelManager = new HotelManager();
        this.hotel = hotel;
        this.add(container);
        this.GuiInitiliaze(500,500);


        cmb_star.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Seçilen öğeyi al
                String selectedStar = "";
                selectedStar = (String) cmb_star.getSelectedItem();
            }
        });


        this.kaydetButton.addActionListener(e -> {

            JTextField[] textfields = {fld_hotel_name, fld_mail,fld_phone,fld_adres};
            if(Helper.isFieldListEmpty(textfields)){
                Helper.showMsg("fill");
            } else{

                boolean result;
                this.hotel.setHotelname(fld_hotel_name.getText());
                this.hotel.setHoteladress(fld_adres.getText());
                this.hotel.setHotelmail(fld_mail.getText());
                this.hotel.setHotelphone(fld_phone.getText());
                this.hotel.setHotelstar(cmb_star.getSelectedItem().toString());
                this.hotel.setCarpark(carParkRadioButton.isSelected());
                this.hotel.setWifi(wifiRadioButton.isSelected());
                this.hotel.setPool(poolRadioButton.isSelected());
                this.hotel.setFitness(fitnessRadioButton.isSelected());
                this.hotel.setConcierge(conciergeRadioButton.isSelected());
                this.hotel.setSpa(spaRadioButton.isSelected());
                this.hotel.setRoomservice(rommServiceRadioButton.isSelected());

                result = this.hotelManager.save(this.hotel);
                dispose();

            }
        });
    }
}



