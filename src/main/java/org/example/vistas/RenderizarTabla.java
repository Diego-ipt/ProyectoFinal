package org.example.vistas;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderizarTabla extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object objeto, boolean bln, boolean bln1, int i, int i1) {
        if(objeto instanceof JButton) {
            return (JButton) objeto;
        }

        return super.getTableCellRendererComponent(tabla, objeto, bln, bln1, i, i1);
    }
}
