/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_brickbreacke;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author user
 */
public class ReadFromBaseFile {
int firts5=1;
    String bigestName;
    JLabel label;
    ArrayList<String> array = new ArrayList<String>();
    BufferedReader bufread;
    Hashtable table;
JPanel p;
    public ReadFromBaseFile() {
         JLabel labIcon;
     BrickPanel.panel.setLayout(new GridLayout(3,1));
       p = new JPanel();   
       
        labIcon = new JLabel(new ImageIcon("image/top5.png"));
      labIcon.setText("TOP 5");
    
      Font f= new Font ("BOLD",60,93);
     
      labIcon.setFont(f);
    
       BrickPanel.panel.add(labIcon);

     try {
            table = new Hashtable();
            bufread = new BufferedReader(new FileReader("fr.txt"));
            String readFromFile;

            while ((readFromFile = bufread.readLine()) != null) {
                array.add(readFromFile);
                System.out.println("readingf");
                String[] ksexwrizwStringMeInt = readFromFile.split("-");
      

                addToHash(ksexwrizwStringMeInt[0], Integer.valueOf(ksexwrizwStringMeInt[1]));
               
            }
             
      


        } catch (Exception ex) { 
            System.out.println("exeptionsssss");
        }
     finally{    
        useHash();
     
     }

    }

    public void addToHash(String x, int y) {


        table.put(y, x);





    }

    public void useHash() {
      
findTheBiggest();


    }

    public void addToPanel(String name, int score) {
  

        p.setLayout(new GridLayout(6, 1));
        p.setBackground(Color.yellow);
        label = new JLabel();
        label.setText(firts5+"-     username :  " + name + " -   score: " + score);
        label.setForeground(Color.red);
        label.setHorizontalAlignment(JLabel.CENTER);
        p.add(label);
        BrickPanel.panel.add(p);
firts5++;
    }

    public void findTheBiggest(){

        for (int i = 0; i < 5; i++) {
            String BiggestScoreName=null;
            int BiggestScore=0;
        Iterator iter= table.keySet().iterator();
    while(iter.hasNext()){
 Integer score = (Integer) iter.next();
       
    String names =(String) table.get(score);
    if(score>=BiggestScore&&names!=null){
    BiggestScore=score;
    BiggestScoreName=names;
        
    }
    if(iter.hasNext()==false){
      table.remove(BiggestScore);
    }
    
    
    }
                  
 if(BiggestScoreName!=null)
   
    addToPanel(BiggestScoreName,BiggestScore);
    
   
    
    }
    }
}
