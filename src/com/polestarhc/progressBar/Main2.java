package com.polestarhc.progressBar;

import javax.swing.*;
import java.awt.*;

public class Main2 {

    public static void main(String [] args) {

        ProgressTest progressTest = new ProgressTest();

        Dimension dimension = new Dimension(500,200);
        JFrame frame = new JFrame();
        frame.setSize(dimension);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(progressTest.getPanel(), BorderLayout.CENTER);
        frame.setVisible(true);

//        Thread thread0 = new Thread(new ThreadTest(0));
//        Thread thread1 = new Thread(new ThreadTest(1));
//        Thread thread2 = new Thread(new ThreadTest(2));
//        Thread thread3 = new Thread(new ThreadTest(3));
//        Thread thread4 = new Thread(new ThreadTest(4));
//
//        thread0.start();
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        threadTest.run();
    }
}
