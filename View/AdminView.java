package View;

import Business.UserManager;
import Entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JButton btn_exit;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btn_save;
    private JTable tbl_users;
    private JTextField textField3;
    private JLabel lbl_welcome;
    private JLabel lbl_username_in;
    private JLabel lbl_password_in;
    private JLabel lbl_rol_in;
    private JTabbedPane tabbedPane1;
    private User user;
    // kendimiz bir tablo oluşturduk taslak olarak
    private DefaultTableModel tbml_user = new DefaultTableModel();
    private UserManager userManager;
    // sağ tıklama yapınca güncelle ekle sil işlemleri için açılan menu
    private JPopupMenu userMenu;


    //her zaman bir userla işlem yapacağı için kurucu metoda bir user girdisi vermek zorundayız
    public AdminView(User user) {
        this.userManager = new UserManager();
        this.user = user;
        this.add(container);
        this.GuiInitiliaze(800,600);
        this.lbl_welcome.setText("Hoşgeldiniz : " + this.user.getUsername());

        //oluşturduğumuz tablonun kolonlarını oluşturduk
       Object[] col_user = {"user_id", "user_name", "user_password", "user_role"};
        this.tbml_user.setColumnIdentifiers(col_user);
        ArrayList<User> userList = this.userManager.findAll();
        for(User user1: userList){
            Object[] obj = {user1.getId(),user1.getUsername(),user1.getPassword(),user1.getRole()};
            this.tbml_user.addRow(obj);
        }


        //gerçek tabloya bizim oluşturduğumuz taslak tabloyu atıyoruz
        this.tbl_users.setModel(this.tbml_user);
        //headerlearın yerlerini dokunarak değiştirmeyi kapattık
        this.tbl_users.getTableHeader().setReorderingAllowed(false);
        //taloya çift tıklayıp düzenleme özelliğini kapattık
        this.tbl_users.setEnabled(false);

        //mouse konumunu bulmak için pressed ile  basıldığı andaki konumunu aldık ve bir integer değere atadık.
        //onu da tıkladığımız rowu seçili halel getirmek için kullandık.
        this.tbl_users.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = tbl_users.rowAtPoint(e.getPoint());
                tbl_users.setRowSelectionInterval(selected_row,selected_row);
            }
        });

        this.userMenu = new JPopupMenu();
        this.userMenu.add("Yeni").addActionListener(e -> {
        UserView userView = new UserView(null);
        });


        this.userMenu.add("Güncelle");
        this.userMenu.add("Sil");

        //oluşturdupumuz popupmune'yü tablomuza setVomponent metoduyla ekledik.
        this.tbl_users.setComponentPopupMenu(userMenu);



    }



}
