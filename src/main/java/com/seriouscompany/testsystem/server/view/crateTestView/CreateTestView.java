package com.seriouscompany.testsystem.server.view.crateTestView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Igor
 */
public class CreateTestView extends JFrame {

    private JPanel content;

    public CreateTestView(String title) {
        super(title);
        content = new JPanel(new BorderLayout());
        getContentPane().add(content);
        setPreferredSize(new Dimension(1000, 500));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
