package View;

import Business.RezervationManager;
import Core.Helper;
import Entity.Rezervation;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;

public class ReservationSaveView extends Layout{
    private JPanel container;
    private JTextField fld_guest_number;
    private JTextField fld_guest_name;
    private JTextField fld_guest_citizen_id;
    private JTextField fld_guest_mail;
    private JTextField fld_guest_phone;
    private JButton rezervasyonOluşturButton;
    private JTextField fld_room_type;
    private JTextField fld_bed_number;
    private JTextField fld_pansion_type;
    private JTextField Oda_alanı;
    private JTextField fld_checkin_date;
    private JTextField fld_checkout_date;
    private JTextField fld_total_price;
    private JTextField fld_hotel_name;
    private JTextField fld_city;
    private JTextField fld_star;
    private JLabel çıkışTarihiLabel;
    private RezervationManager rezervationManager;
    private Rezervation rezervation;


    public ReservationSaveView() {
        this.rezervation = new Rezervation();
        this.rezervationManager = new RezervationManager();
        this.add(container);
        this.GuiInitiliaze(500,800);

       rezervasyonOluşturButton.addActionListener(e -> {

           JTextField[] textfields = {};
           if(Helper.isFieldListEmpty(textfields)){
               Helper.showMsg("fill");
           } else{

               boolean result;

               this.rezervation.setGuest_phone(Integer.parseInt(fld_guest_phone.getText()));
               this.rezervation.setGuest_mail(fld_guest_mail.getText());
               this.rezervation.setGuest_citizen_id(Integer.parseInt(fld_guest_citizen_id.getText()));
               this.rezervation.setGuest_name(fld_guest_name.getText());
               this.rezervation.setCheck_in_date(LocalDate.parse(fld_checkin_date.getText()));
               this.rezervation.setCheck_out_date(LocalDate.parse(fld_checkout_date.getText()));
               this.rezervation.setTotal_price(Integer.parseInt(fld_total_price.getText()));

               result = this.rezervationManager.save(rezervation);

               dispose();
           }
       });
    }


    private void createUIComponents() throws ParseException {
        this.fld_checkin_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
        this.fld_checkout_date = new JFormattedTextField(new MaskFormatter("##/##/####"));
    }
}
