package com.company.display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas c;
    public JFrame getFrame() {
        return frame;
    }

    public Canvas getCanvas() {
        return c;
    }

    public Display(int w, int h, String name) {
        frame = new JFrame(name);
        frame.setSize(new Dimension(w,h));
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        c = new Canvas();
        c.setMaximumSize(new Dimension(w,h));
        c.setMinimumSize(new Dimension(w,h));
        c.setPreferredSize(new Dimension(w,h));
        c.setFocusable(false);
        frame.add(c);
        frame.setVisible(true);
        frame.pack();

    }

}