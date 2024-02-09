package core;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static void setTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
    }

    public static void showMsg(String str) {
        optionPaneTR();
        String msg;
        String title = switch (str) {
            case "fill" -> {
                msg = "Please fill in all fields.";
                yield "Error!";
            }
            case "done" -> {
                msg = "Successful";
                yield "Result";
            }
            case "notFound" -> {
                msg = str + " Not found!";
                yield "Not found.";
            }
            case "error" -> {
                msg = "You Made a Wrong Transaction!";
                yield "Error!";
            }
            default -> {
                msg = str;
                yield "Message";
            }
        };

        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);


    }
    public static boolean confirm(String str){
        optionPaneTR();
        String msg;
        if(str.equals("Sure")){
            msg = "Are you sure you want to do this action ?";
        }else{
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Are you sure ?",JOptionPane.YES_NO_OPTION) == 0 ;
    }


    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldListEmpty(JTextField[] fieldList) {
        for (JTextField field : fieldList) {
            if (isFieldEmpty(field)) return true;
        }
        return false;
    }

    public static int getLocationPoint(String type, Dimension size) {
        return switch (type) {
            case "x" -> (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
            case "y" -> (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
            default -> 0;
        };
    }
    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText","Ok");
        UIManager.put("OptionPane.yesButtonText","Yes");
        UIManager.put("OptionPane.noButtonText","No");
    }
}