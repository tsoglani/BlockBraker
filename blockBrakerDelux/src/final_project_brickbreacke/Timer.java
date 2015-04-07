/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_brickbreacke;

import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.util.logging.*;

import javax.sound.sampled.*;
import javax.swing.*;

/**
 *
 * @author gaitanesnikos
 */
public class Timer extends Thread {

    JPanel panel;
    int totalSec = 0;
    boolean waiting = false;

    public int getDekata() {
        return dekata;
    }

    public void setDekata(int dekata) {
        this.dekata = dekata;
    }
    JProgressBar progressBar;

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getTotalSec() {
        return totalSec;
    }

    public void setTotalSec(int totalSec) {
        this.totalSec = totalSec;
    }
    Thread time;
    JPanel pDate = new JPanel();
    //JButton stop = new JButton("||");
    Date d = new Date();
    int hour = 0;
    int dekata;
    int minutes = 0;
    int seconds = 0;
    JLabel labelTime = new JLabel();
    CentralFrame frame;

    @SuppressWarnings("deprecation")
    public Timer(CentralFrame f) {
        time = this;
        frame = f;

        d.setMonth(3);
        d.setDate(23);
        //frame.paint(null);
        //  stop.addActionListener(actionStop);
        panel = frame.getPanelName();
        //panel.add(stop);
        panel.add(pDate);

        pDate.add(labelTime);
        progressBar = new JProgressBar();
        panel.add(progressBar);
        progressBar.setMinimum(0);
        progressBar.setMaximum(180);
        progressBar.setBackground(Color.blue);

    }

    public synchronized void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
            }
            if (waiting) {


                suspend();


            }

            if (minutes >= 3) {
                try {
                    Clip clip;
                    if (CentralFrame.isMutte == false) {
                        AudioInputStream audio = null;
                        clip = AudioSystem.getClip();
                        audio = AudioSystem.getAudioInputStream(new File("finishTime.au"));

                        clip.open(audio);
                        clip.start();
                    }
                    frame.pan.gameOver(true);
                    seconds = 0;
                    totalSec = 0;
                    minutes = 0;

                    suspend();
                } catch (Exception ex) {
                    Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }


            dekata++;
            if (dekata >= 10) {
                seconds++;
                dekata = 0;
                totalSec++;
            }


            if (seconds >= 60) {
                minutes++;
                seconds = 0;
            }


            if (minutes >= 60) {
                minutes = 0;
                hour++;
            }
            d.setHours(hour);
            d.setMinutes(minutes);


            d.setSeconds(seconds);

            pDate.add(labelTime);

            String convDekataToString = Integer.toString(dekata);
            String convHoursToString = Integer.toString(d.getHours());
            String convMinToString = Integer.toString(d.getMinutes());


            String convSecToString = Integer.toString(d.getSeconds());


            labelTime.setText("timer :" + convHoursToString + " : " + convMinToString + " : " + convSecToString + " : " + dekata);


            progressBar.setValue(totalSec);
        }
    }
//    ActionListener actionStop = new ActionListener() {
//
//        public void actionPerformed(ActionEvent ae) {
//            if (waiting) {
//
//                time.resume();
//
//            }
//            waiting = !waiting;
//
//
//
//        }
//    };
}
