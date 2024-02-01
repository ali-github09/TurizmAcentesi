import Business.UserManager;
import Core.Helper;
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
        //AdminView adminView = new AdminView(userManager.findByLogin("ali","1234"));
        EmployeeView employeeView = new EmployeeView(userManager.findByLogin("ali","1234"));
    }
}
