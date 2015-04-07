package final_project_brickbreacke;

import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author gaitanesnikos
 */
public class CentralFrame extends JFrame {

    private ArrayList<String> array = new ArrayList<String>();
    private JButton notMutteButton = new JButton(new ImageIcon("image/24.png"));
    private JButton soundButton;
    Thread thread;
    Sounds sound;
    static String playerName;
    JButton ShowDetails;
    static boolean isMutte = false;
    boolean isHard = true;
    int ii = 0;
    JComboBox combo = new JComboBox();
    JMenu menu;
    JMenu exitMenu;
    JMenuItem menuItems;
    JMenuBar menuBar;
    JButton exit;

    public boolean isIsHard() {
        return isHard;
    }

    public void setIsHard(boolean isHard) {
        this.isHard = isHard;
    }
    BrickPanel pan;
    private CentralFrame frame;
    private JPanel panelName = new JPanel();

    public ActionListener getAct() {
        return act;
    }

    public void setAct(ActionListener act) {
        this.act = act;
    }

    public CentralFrame getFrame() {
        return frame;
    }

    public void setFrame(CentralFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanelName() {
        return panelName;
    }

    public void setPanelName(JPanel panelName) {
        this.panelName = panelName;
    }

    public CentralFrame(String name) {
        frame = this;

        this.playerName = name;
        this.setSize(900, 800);
        JCheckBox checkBoxEasy = new JCheckBox("easy");
        JCheckBox checkBoxHard = new JCheckBox("hard (you have 3 minutes for each level  )");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        JPanel CheskBoxPanel = new JPanel();
        CheskBoxPanel.add(checkBoxEasy);
        CheskBoxPanel.add(checkBoxHard);
        checkBoxEasy.setFocusable(false);
        checkBoxEasy.addActionListener(easyListener);
        checkBoxHard.addActionListener(hardListener);
        this.add(CheskBoxPanel);

        this.setVisible(true);






    }

    public CentralFrame() {
    }

    public CentralFrame(String playerName, boolean isHard) {
        frame = this;

        this.isHard = isHard;
        String name = "Γαϊτάνης Νίκος";
        exit = new JButton("close ");


        String am = "1870";
        JLabel label = new JLabel("creator " + name + " AM: " + am);
        JTextArea playerTextAreaName = new JTextArea("           player's name is : " + playerName);
        playerTextAreaName.setEditable(false);
        this.addToList(null);
        this.addToList("SuperMario.au");
        this.addToList("m.au");
        this.addToList("MarioCard1.au");
        this.addToList("MarioCardMountains.au");

        combo.addActionListener(itemListen);
        Iterator iter = array.iterator();
        while (iter.hasNext()) {
            String s = (String) iter.next();
            combo.addItem(s);
        }

        this.setSize(900, 800);
        panelName.add(label);
        // panelName.add(exit);
        panelName.add(playerTextAreaName);
        soundButton = notMutteButton;
        panelName.add(soundButton);
        panelName.add(combo);
        this.add(panelName, BorderLayout.NORTH);

        pan = new BrickPanel(this);

        menu = new JMenu(" Menu ");
        exitMenu = new JMenu(" CloseInfo's");
        exitMenu.add(exit);
        JButton bInfo = pan.getInfo();
        menu.add(bInfo);

        ShowDetails = new JButton("Show Timer & info");
        ShowDetails.addActionListener(backNameAndTimeListener);
        exitMenu.add(ShowDetails);
        ShowDetails.setEnabled(false);
        menuBar = new JMenuBar();
        menuBar.add(menu);
        menuBar.add(exitMenu);
//        menuBar.add(musicMenu);
        this.setJMenuBar(menuBar);

        soundButton.addActionListener(mutte);

        this.add(pan, BorderLayout.CENTER);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        exit.addActionListener(act);
        this.setVisible(true);
        this.setTitle("level 1");
//        sound = new Sounds("SuperMario.au");
//        thread = new Thread(sound);
//        thread.start();




////////////////////String [] s=(String[]) menu.getSelectedObjects();
////////////////////        System.out.println(s);



    }
    ActionListener backNameAndTimeListener = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {

            frame.add(panelName, BorderLayout.NORTH);
            frame.repaint();
            ShowDetails.setEnabled(false);
            exit.setEnabled(true);
        }
    };
    ActionListener act = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            JButton b = (JButton) ae.getSource();
            exitMenu.repaint();
            ShowDetails.setEnabled(true);
            b.setEnabled(false);
            frame.remove(panelName);
            //pan.time = null;
            frame.repaint();

        }
    };
    ActionListener easyListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ii == 0) {
                ii++;
                System.out.println(" you select easy mode");
                isHard = false;
                frame.setVisible(false);
                //  frame.dispose();

                frame = new CentralFrame(playerName, isHard);

                frame.repaint();

            }


        }
    };
    ActionListener hardListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ii == 0) {
                ii++;

                System.out.println(" you select hard mode");
                isHard = true;


//frame.dispose();
                frame.setVisible(false);

                frame = new CentralFrame(playerName, isHard);

                frame.repaint();
            }
        }
    };
    ActionListener mutte = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {


            isMutte = !isMutte;
            if (isMutte) {
                if (sound != null) {
                    sound.stopClip();
                }

                soundButton.setIcon(new ImageIcon("image/mute.png"));
            } else {
                if (sound != null) {
                    sound.run();
                }
                soundButton.setIcon(new ImageIcon("image/24.png"));
            }
            System.out.println(isMutte);
        }
    };

    public void addToList(String s) {
        array.add(s);

    }
    ActionListener itemListen = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            JComboBox combobox = (JComboBox) e.getSource();
            String s = (String) combobox.getSelectedItem();


            if (sound != null) {
                sound.stopClip();
                sound.destroy();
            }
            sound = new Sounds(s);
            thread = new Thread(sound);
            thread.start();

        }
    };
}
