import Business.UserManager;
import Core.Helper;
import Entity.User;
import View.AdminView;
import View.EmployeeView;
import View.LoginView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {


        Helper.setTheme();
        UserManager userManager = new UserManager();
        LoginView loginView = new LoginView();
    }
}
