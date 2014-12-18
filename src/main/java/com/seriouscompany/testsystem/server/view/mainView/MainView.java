package com.seriouscompany.testsystem.server.view.mainView;

import com.seriouscompany.testsystem.server.entities.Test;
import com.seriouscompany.testsystem.server.view.crateTestView.CreateTestView;
import com.sun.javafx.font.freetype.HBGlyphLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author Igor
 */
public class MainView extends JFrame implements Observer {

    private final String BUTTON_DEL_TITLE = "X";

    public Map<String, List<Map<JLabel, JButton>>> dataMap = new LinkedHashMap<>();
    private final JPanel content;
    private final JTabbedPane tabbedPane;
    private JPanel findForm;
    private JButton findButton;
    private JButton updateButton;
    private JLabel findLable;
    private JTextField findTextField;
    private JComboBox findComboBox;

    private Image img = null;
    private BufferedImage image = null;
    private File file = null;

    public MainView(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        content = new JPanel(new BorderLayout());

        initIcon();
        setJMenuBar(new MainMenuBar());
        initData();
        tabbedPane = new JTabbedPane();
        initTabbedPanes();
        content.add(tabbedPane, BorderLayout.CENTER);
//        initFont();
        initListeners();
        getContentPane().add(content);
        setPreferredSize(new Dimension(1000, 500));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initIcon() {
        try {
            file = new File("main.png");
            image = ImageIO.read(file);
            img = image;
            setIconImage(img);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ("Произошла проблема с загруской иконки."));
        }
    }

    private void initData() {
        Map<JLabel, JButton> map1 = new HashMap<>();
        map1.put(new JLabel("1"), null);
        Map<JLabel, JButton> map2 = new HashMap<>();
        map2.put(new JLabel("2"), null);
        Map<JLabel, JButton> map3 = new HashMap<>();
        map3.put(new JLabel("3"), null);
        Map<JLabel, JButton> map4 = new HashMap<>();
        map4.put(new JLabel("4"), null);
        Map<JLabel, JButton> map5 = new HashMap<>();
        map5.put(new JLabel("5"), null);
        Map<JLabel, JButton> map6 = new HashMap<>();
        map6.put(new JLabel("6"), null);
        List<Map<JLabel, JButton>> listMaps = new ArrayList<>();
        listMaps.add(map1);
        listMaps.add(map2);
        listMaps.add(map3);
        List<Map<JLabel, JButton>> listMaps1 = new ArrayList<>();
        listMaps1.add(map4);
        listMaps1.add(map5);
        listMaps1.add(map6);
        dataMap.put("русский", listMaps);
        dataMap.put("математика", listMaps1);
    }

    private void initTabbedPanes() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        JPanel nothJP = null;
        JPanel jp = null;
        JScrollPane sp = null;
        for (String key : dataMap.keySet()) {
            nothJP = new JPanel(new BorderLayout());
            jp = new JPanel(new GridBagLayout());
            nothJP.add(jp, BorderLayout.NORTH);
            sp = new JScrollPane(nothJP);
            int k = 0;
            for (Map<JLabel, JButton> map : dataMap.get(key)) {
                for (JLabel lable : map.keySet()) {
                    c.gridx = 0;
                    c.gridy = k;
                    c.weightx = 1;
                    jp.add(lable, c);
                    c.gridx = 1;
                    c.gridy = k;
                    c.weightx = 0;
//                    jp.add(map.get(lable), c);
                }
                k++;
            }
            tabbedPane.addTab(key, sp);
        }
    }

    private void initFont() {
        Font font = new Font("Verdana", Font.PLAIN, 14);
        tabbedPane.setFont(font);
        content.setFont(font);
        findForm.setFont(font);
        findButton.setFont(font);
        findLable.setFont(font);
        findTextField.setFont(font);
        findComboBox.setFont(font);
        updateButton.setFont(font);
    }

    private void initListeners() {
        int i = 0;
        for (String key : dataMap.keySet()) {
            int k = 0;
            for (Map<JLabel, JButton> map : dataMap.get(key)) {
                for (JLabel label : map.keySet()) {
                    label.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            final String title = ((JLabel) e.getSource()).getText();
                            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    CreateTestView testView = new CreateTestView(title);
                                }
                            });
                        }
                    });
//                    map.get(label).addActionListener(new DeleteButtonListener(key, k, dataMap, this));
                }
                k++;
            }
            i++;
        }
    }

    public void repaintTabs() {
        tabbedPane.removeAll();
        initTabbedPanes();        
    }

    public void updateTabs(Test newTest) {

    }

    @Override
    public void update(Observable o, Object arg) {
    }
}
