package View;

import Core.Helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Layout extends JFrame{

    public void GuiInitiliaze(int width, int height){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Turizm Acentesi");
        this.setSize(width,height);
        this.setVisible(true);
        this.setLocation(Helper.getlocationPoint("x",this.getSize()),Helper.getlocationPoint("y",this.getSize()));
    }


    public void createTable(DefaultTableModel model, JTable table, Object[] columns, ArrayList<Object[]> rows){
        //taslak olarak oluşturulan modelin kolonlarını belirledik.
        model.setColumnIdentifiers(columns);
        //taslak modelimizi gerçek modele geçirdik
        table.setModel(model);
        //tablo headerlarının değiştirilmesini engelledik.
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        //tablonun manuel olarak değiştirilmesini engelledik.
        table.setEnabled(false);

        //tabloyu her seferinde temizleyerek güncelleme sonrasu üzerine yazılma problemini engelledik.
        DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
        clearModel.setRowCount(0);


        if(rows == null){
            rows = new ArrayList<>();
        }

        //aldığımız database entitiy'lerini teker teker objeye dönüştürüp tablomuzu onlarla doldurduk.
        // bu dönüştürmeyi getfortable metodyla yapmıştık. burda objeye dönüşmüş elemanları tabloya doldurduk.
        for(Object[] row: rows){
            model.addRow(row);
        }
    }

    //sağ tıkla addactionlistener kullanabilmemiz için seçili rowun konumunu veren metod.
    public int getTableSelectedRow(JTable table, int index){
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(),index).toString());
    }

    public void tableRowSelect(JTable table){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selected_row = table.rowAtPoint(e.getPoint());
                table.setRowSelectionInterval(selected_row,selected_row);
            }
        });
    }

    public static boolean confirm(String str){
        String msg;
        if(str.equals("sure")){
            msg = "BU işlemi yapmak istediğine emin misin ?";
        } else{
            msg = str;
        }
        return JOptionPane.showConfirmDialog(null,msg,"Emin misin?",JOptionPane.YES_NO_OPTION) == 0;
    }

}
