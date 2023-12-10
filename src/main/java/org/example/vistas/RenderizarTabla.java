package org.example.vistas;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * La clase {@code RenderizarTabla} personaliza la apariencia de las celdas de una tabla,
 * especialmente cuando la celda contiene un botón.
 */
public class RenderizarTabla extends DefaultTableCellRenderer {

    /**
     * Obtiene el componente de la celda de la tabla y personaliza su apariencia si contiene un botón.
     *
     * @param tabla  La tabla a la que pertenece la celda.
     * @param objeto El objeto contenido en la celda.
     * @param bln    Indica si la celda está seleccionada.
     * @param bln1   Indica si la celda tiene el foco.
     * @param i      Índice de la fila de la celda.
     * @param i1     Índice de la columna de la celda.
     * @return El componente de la celda personalizado.
     */
    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object objeto, boolean bln, boolean bln1, int i, int i1) {
        // Si el objeto en la celda es un botón, devuelve el botón
        if (objeto instanceof JButton) {
            return (JButton) objeto;
        }

        // De lo contrario, utiliza la apariencia predeterminada de la celda
        return super.getTableCellRendererComponent(tabla, objeto, bln, bln1, i, i1);
    }
}
