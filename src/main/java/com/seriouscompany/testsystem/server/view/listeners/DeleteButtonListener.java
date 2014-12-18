package com.seriouscompany.testsystem.server.view.listeners;

import com.seriouscompany.testsystem.server.view.mainView.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Igor
 */
public class DeleteButtonListener implements ActionListener {

    private int index;
    private String key;
    private int keyIndex;
    private Map<String, List<Map<JLabel, JButton>>> dataMap;
    private MainView mainView;

    public DeleteButtonListener() {
    }

    public DeleteButtonListener(String key, int index, Map<String, List<Map<JLabel, JButton>>> dataMap, MainView mainView) {
        this.index = index;
        this.key = key;
        this.dataMap = dataMap;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (dataMap.get(key).size() == 1) {
            dataMap.remove(key, dataMap.get(key));
        } else {
            dataMap.get(key).remove(index);
        }
        mainView.repaintTabs();
    }
}
