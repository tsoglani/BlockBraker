package final_project_brickbreacke;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Base {

    String playerName = null;
    int playerScore;
    static Hashtable<String, Integer> scoreTable;
    FileWriter writeFile;
    String read, write;

    public Base(String name, int score) {
        this.playerName = name;
        this.playerScore = score;
        scoreTable = new Hashtable<String, Integer>();




    }

    public void readAndWriteFromBase(String read, String write, boolean isNotCompared) {

        try {


            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("fr.txt", true), "UTF-8");
            BufferedWriter fbw = new BufferedWriter(writer);
            fbw.write(playerName + " -" + playerScore);
            fbw.newLine();
            fbw.close();
            ReadFromBaseFile r= new ReadFromBaseFile();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
