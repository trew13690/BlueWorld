package com.trewdev.blueworld.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by trew on 5/7/2017.
 */
public class Display {

    private JFrame frame;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    private Canvas canvas;

    private String title;
    private int width, height;

    public Display(String title) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        this.title = title;
        this.width = (int) tk.getScreenSize().getWidth();
        this.height = (int) tk.getScreenSize().getHeight();


        createDisplay();


    }


    private void createDisplay() {

        frame = new JFrame(title);
        frame.setSize(200,400);
        frame.setUndecorated(true);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);







        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(500, 600));
        canvas.setMinimumSize(new Dimension(300, 200));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();


    }

    public JFrame getFrame() {


        return frame;

    }

}
