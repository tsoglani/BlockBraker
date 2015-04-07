/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_brickbreacke;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author gaitanesnikos
 */
public class Main {

    String name;
int x;
    public Main() {
        
        enderName();
    }
    
    public void enderName(){
    int y= (int)(Math.random()*4);
    name=JOptionPane.showInputDialog(null,"enterName","",y);
   
    x=confirmName();
    if(x==1){
    enderName();
    }
    else if(x==2){
    System.exit(1);
    }
    }
    
    public int confirmName(){
    x=JOptionPane.showConfirmDialog(null,"isYourName "+name+" ?");
        
        
    return x;
    }
    

    public static void main(String[] args) throws IOException {
        Main m = new Main();


      CentralFrame f = new CentralFrame(m.name);
    }
}
