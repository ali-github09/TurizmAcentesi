package View;
import Business.UserManager;
import Core.Helper;
import Entity.User;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

        loadUserTable();
        loadUserComponent();

        //oluşturdupumuz popupmune'yü tablomuza setComponent metoduyla ekledik.
        this.tbl_users.setComponentPopupMenu(userMenu);
    }

        public void loadUserTable(){
            //oluşturduğumuz taslak tablonun kolonlarını oluşturduk
            Object[] col_user = {"user_id", "user_name", "user_password", "user_role"};
            // bütün userları getfortable metoduyla alıp bir arraylistin içine attık.
            ArrayList<Object[]> userList = this.userManager.getForTable(col_user.length);
            this.createTable(this.tbml_user,this.tbl_users,col_user,userList);
        }

        public void loadUserComponent(){
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

                //açtığımız popup ekranı kapatıldığında tetiklenen bir yüklme işlemi yapıp tablomuzu güncel haliyle tekrar yüklüyoruz.
                // böylece yaptığımız değişikliği anında görebiliyoruz.
                userView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadUserTable();
                    }
                });

            });

            //güncellemek isteiğimiz rowdaki elemanın tablodaki ilk değeri id'si olduğu için 0.index değerini alıyoruz.
            //yani selectedrowdaki value bizim user'larımızdan biri. onu güncellemek istiyoruz. onun değerleri soldan sağa sıralarsak 0. indexteki değeri id'sidir.
            //onu da alırken tostring olarak aldığımız için parseint ile integera çevirmemeiz gerekiyor.
            this.userMenu.add("Güncelle").addActionListener(e -> {
                int selectedid = this.getTableSelectedRow(tbl_users,0);
                // şimdi id'sini aldığım user'ı databaseden alıp bir user objesine aktarıp ordan da userview'a göndermem lazım ki güncellenmiş olsun
                // bunu da userdao daki getbyid metodu ile yapıyoruz.
                UserView userView = new UserView(this.userManager.getById(selectedid));

                //yukarıda belirttiğim aynı güncelleme işlemi.
                userView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadUserTable();
                    }
                });
            });

            this.userMenu.add("Sil").addActionListener(e -> {
                if(Helper.confirm("sure")){
                }
                int selectedid = this.getTableSelectedRow(tbl_users,0);
                if(this.userManager.delete(selectedid)){
                    Helper.showMsg("done");
                    loadUserTable();
                } else {
                    Helper.showMsg("error");
                }
            });

        }

}
