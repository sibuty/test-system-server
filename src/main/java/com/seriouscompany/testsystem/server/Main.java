package com.seriouscompany.testsystem.server;

import com.seriouscompany.testsystem.server.view.mainView.MainView;

import javax.swing.*;

/**
 *
 * @author Igor
 */
public class Main {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainView mainView = new MainView("System of Test.");
                JOptionPane.showMessageDialog(new JFrame(), ("2 правильных ответов из 2.\nТест пройден на 100%.\nВаша оценка — отлично."));
            }
        });
        
        
//         java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Jframe().setVisible(true);
//            }
//        });

//        Locale.setDefault(Locale.ENGLISH);
//
////        DBConnector.ex();      
//        System.out.println(FromExcelParser.parseTest("123.xls"));
    }
}
