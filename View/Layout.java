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
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setMaxWidth(75);
        table.setEnabled(false);

        DefaultTableModel claerModel = (DefaultTableModel) table.getModel();
        claerModel.setRowCount(0);

        if(rows == null){
            rows = new ArrayList<>();
        }

        for(Object[] row: rows){
            model.addRow(row);
        }
    }

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


}
