package View;

import Business.UserManager;
import Core.Helper;
import Entity.User;

import javax.swing.*;

public class UserView extends Layout{

    private JPanel container;
    private JLabel pnl_top;
    private JLabel lbl_user_name;
    private JTextField fld_username;
    private JTextField fld_userpassword;
    private JTextField fld_userrole;
    private JButton kaydetButton;
    private User user;
    private UserManager userManager;

    public UserView(User user) {
        this.userManager = new UserManager();
        this.user = user;
        this.add(container);
        this.GuiInitiliaze(250,300);


        if(user != null){
            fld_username.setText(user.getUsername());
            fld_userpassword.setText(user.getPassword());
            fld_userrole.setText(user.getRole());
        }

        kaydetButton.addActionListener(e -> {
            // eğer doldurmamız gerekn textfieldlar boşsa hata vermesi için kontrol ediyoruz.
            //birden fazla textfield olduğu için liste yapıp öyle kontrol ettik.
            JTextField[] fieldList = {fld_username,fld_userpassword,fld_userrole};
            if(Helper.isFieldListEmpty(fieldList)) {
            Helper.showMsg("fill");
            } else {
                boolean result;
                // eğer kullanıcı null ise kendimiz değerleri girerek bir kullanıcı oluşturuyoruz.
                if(this.user == null){
                    result = this.userManager.save(new User(fld_username.getText(),fld_userpassword.getText(),fld_userrole.getText()));
                // burda ise güncellenecek satırın yeni bilgilerini girip textfieldlardan aldığımız değerleri update metoduna gönderiyoruz.
                } else {
                    this.user.setUsername(fld_username.getText());
                    this.user.setPassword(fld_userpassword.getText());
                    this.user.setRole(fld_userrole.getText());
                    //değerleri girilen yeni user'ı update metoduna girdi olarak verip databesedeki satırı güncelliyoruz.
                    result = this.userManager.update(this.user);
                }

                if (result){
                    Helper.showMsg("done");
                    dispose();
                } else {
                    Helper.showMsg("error");
                }
            }
        });











    }
}
