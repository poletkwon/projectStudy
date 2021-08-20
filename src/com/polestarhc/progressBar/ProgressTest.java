package com.polestarhc.progressBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressTest {
    private JProgressBar progressBar;
    private JPanel panelProgress;
    private JButton buttonIncress;
    private JButton buttonDecress;

    int position = 0;
    public JPanel getPanel() {
        return panelProgress;
    }


    public ProgressTest() {
        progressBar.setMaximum(100);
        buttonIncress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                position++;

                if ( 100 < position) {
                    position = 100;
                }
                progressBar.setValue(position);
            }
        });
        buttonDecress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                position --;
                if ( position <= 0) {
                    position = 0;
                }
                progressBar.setValue(position);
            }
        });
    }
}
