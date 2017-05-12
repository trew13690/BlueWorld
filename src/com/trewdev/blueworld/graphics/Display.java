package com.trewdev.blueworld.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * Created by trew1 on 5/7/2017.
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

    public Display(String title, int width, int height) {


        this.title = title;
        this.width = width;
        this.height = height;


        createDisplay();


    }


    private void createDisplay() {

        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();


    }

    public JFrame getFrame() {


        return frame;

    }

}
