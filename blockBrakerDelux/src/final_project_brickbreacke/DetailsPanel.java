/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_brickbreacke;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gaitanesnikos
 */
public class DetailsPanel extends JPanel implements Runnable {
 JPanel p;
 int moveInfoX=0,moveInfoY=0;
    private int move = 300;
    private int moveUp = 250;
    private Thread motion;

    public Thread getMotion() {
        return motion;
    }

    public void setMotion(Thread motion) {
        this.motion = motion;
    }
    private String details = " details";
    private String det = " με το πατημα καθε πανελ διαγραφοντε ολα τα γειτωνικα πανελ ,  καθε πιστα εχει ενα απο τα παρακατω δωρα σκοπος του παιχνιδιου ειναι να μην εχεις πανω απο 3 γειτωνικα με το ιδιο χρωμα";
    private String det2 = "εχεις 3 λεπτα για να ολοκληρωσεις την καθε πιστα";
    private ImageIcon images = new ImageIcon("image/ingredients.jpg");
    private String ingre1 = " με το πατημα του bomb Brick διαγραφονται ολα τα γειτωνικα και τα διαγωνια  ";
    private String ingre2 = " με το πατημα του color bomb Brick διαγραφονται ολα τα γειτωνικα και το πανω αριστερα  διαγωνιο  ";
    private String ingre3 = " με το πατημα του new break line προστιθεται μια νεα γραμμη απο πανω \n με την προϊποθεση οτι εχει αδειασει 1 τουλ. γραμμη  ";
    private String ingre4 = " με το πατημα του bomb suffle brick αλλαξει χρωμα το πανελ  ";
    private String ingre5 = " με το πατημα του jocker Brick  αν τα απεναντι εχουν το ιδιο χρωμα εξαφανιζοντε \n και μαζι τους και τα γειτωνικα τους αν εχουν ιδιο χρωμα ";
    private JLabel labelIMage = new JLabel(images);
    private ScrollPane scroll ;
JPanel pImage;

    public DetailsPanel() {
scroll = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
  
        p = new JPanel();
         pImage = new JPanel();
        JLabel label = new JLabel();
        JLabel label0 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        label.setText(det);
        label0.setText(det2);
        label2.setText(ingre1);
        label3.setText(ingre2);
        label4.setText(ingre3);
        label5.setText(ingre4);
        label6.setText(ingre5);
        this.setLayout(new GridLayout(3, 1));
        p.setLayout(new GridLayout(8, 1));

       pImage.add(labelIMage);

        p.add(label);
        p.add(label0);
        p.add(label2);
        p.add(label3);
        p.add(label4);
        p.add(label5);
        p.add(label6);
//


     this.addMouseMotionListener(mouse);
        scroll.add(p);

        scroll.doLayout(); 
        this.add(pImage);
        this.add(scroll);
      scroll.addMouseMotionListener(mouse); 
    
        motion = new Thread(this);
        motion.start();
    }

    public void update(Graphics g) {
        System.out.println("graphics");

    }

    public void paint(Graphics g) {

    g.clearRect(0, 0, 1400, 1400);
    super.paint(g);

   

     
//
    g.setColor(Color.green);
g.drawString("info", moveInfoX, moveInfoY);
g.setColor(Color.yellow);
g.fillRoundRect(moveInfoX, moveInfoY, moveUp-250, moveUp-250, 100, 30);
   g.setColor(Color.blue);
        g.drawString("blockBraker rooles", move, moveUp);




    }
    MouseMotionListener mouse= new MouseMotionListener(){

        @Override
        public void mouseDragged(MouseEvent me) {
           
        }

        @Override
        public void mouseMoved(MouseEvent me) {
      moveInfoX=   me.getX();
    
        moveInfoY=   me.getY();
            
        }

    };
    
    

    public void run() {
        boolean isInEnd = false;
        boolean isEndUp = false;
        int sleep = 1;
        boolean inLongTheSleep = false;
        while (true) {

            try {

                motion.sleep(sleep);
                if (moveUp < 280 && isEndUp == false) {
                    moveUp++;
                } else if (moveUp > 260) {
                    isEndUp = true;
                    moveUp--;

                    if (inLongTheSleep) {
                        sleep--;
                    } else {
                        sleep++;
                    }
                    if (sleep == 60 && inLongTheSleep == false) {
                        inLongTheSleep = true;
                    } else if (sleep == 5 && inLongTheSleep == true) {
                        inLongTheSleep = false;

                    }
                 

                }
                if (moveUp == 260) {
                    isEndUp = false;
                }



                if (move < 1100 && isInEnd == false) {
                    move++;
                } else if (move > 100) {
                    isInEnd = true;
                    move--;

                }

                if (move == 100) {
                    isInEnd = false;
                }

                repaint();
            } catch (InterruptedException ex) {
              
            }catch (Exception ex) {

            }


        }


    }
}
