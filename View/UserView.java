package View;

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

    public UserView(User user) {
        this.user = user;
        this.add(container);
        this.GuiInitiliaze(250,300);
    }
}
