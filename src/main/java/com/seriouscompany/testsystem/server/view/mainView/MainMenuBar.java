package com.seriouscompany.testsystem.server.view.mainView;

import com.seriouscompany.testsystem.server.view.crateTestView.CreateTestView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Igor
 */
public class MainMenuBar extends JMenuBar {

    private JMenu fileMenu;
    private JMenuItem createTest;
    private JMenu importFile;
    private JMenuItem importFromXML;
    private JMenuItem importFromEXCEL;
    private JMenuItem menuExit;
    private JMenu menuHelp;
    private JMenuItem about;
    private JFrame frame;

    public MainMenuBar() {
        fileMenu = new JMenu("File");
        createTest = new JMenuItem("Crate new test");
        importFile = new JMenu("Import File");
        menuExit = new JMenuItem("Exit");
        importFromXML = new JMenuItem("Import test form XML");
        importFromEXCEL = new JMenuItem("Import test from EXCEL");
        menuHelp = new JMenu("Help");
        about = new JMenuItem("About System of Test");

        initListeners();

        importFile.add(importFromXML);
        importFile.add(importFromEXCEL);
        menuHelp.add(about);
        fileMenu.add(createTest);
        fileMenu.add(importFile);
        fileMenu.addSeparator();
        fileMenu.add(menuExit);
        this.add(fileMenu);
        this.add(menuHelp);
        frame = (JFrame) this.getParent();
    }

    private void initListeners() {
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        createTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String themeName = JOptionPane.showInputDialog(frame,
                        "Введите имя нового теста.",
                        "Create Test Dialog",
                        JOptionPane.WARNING_MESSAGE);
                if (themeName != null && themeName.length() > 0) {
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            CreateTestView createTestView = new CreateTestView(themeName);
                        }
                    });
                }
            }
        });
    }
}
