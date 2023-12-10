package org.example.vistas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.*;
import org.example.modelos.*;

public class panelAsientos extends JPanel{
    private int asientos;
    public panelAsientos(int asientos, int separacion_clase) {
        this.setLayout(new BorderLayout());
    }

}
