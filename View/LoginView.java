package View;

import Business.UserManager;
import Core.Helper;
import Entity.User;

import javax.swing.*;

public class LoginView extends Layout{
    private JPanel container;
    private JLabel lbl_welcome;
    private JLabel lbl_user_name;
    private JTextField fld_user_name;
    private JLabel lbl_user_password;
    private JTextField fld_user_password;
    private JButton btn_login;
    private final UserManager userManager;


    public LoginView() {
        this.userManager = new UserManager();
       // JFrame özellikleri olarak add size kullanıyoruz. Guiinitiliaze içinde olanlar da var
        add(container);
        this.GuiInitiliaze(330,250);

        this.setLocation(Helper.getlocationPoint("x",this.getSize()),Helper.getlocationPoint("y",this.getSize()));

        btn_login.addActionListener(e -> {
            // kontrol edilmesi gereken alanlardan oluşan bir array oluşturduk. türü jtextfield. hepsini kontrol ediyo.
            JTextField[] checkFieldList = {this.fld_user_name, this.fld_user_password};
            if(Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");
            } else {
                User loginUser = this.userManager.findByLogin(this.fld_user_name.getText(),this.fld_user_password.getText());
                if(loginUser == null){
                    Helper.showMsg("notFound");
                }
                else {
                  AdminView adminView = new AdminView(loginUser);
                  dispose();
                }
            }
        });
    }
}
