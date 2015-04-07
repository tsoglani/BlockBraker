/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_brickbreacke;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author gaitanesnikos
 */
public class OnePanel extends JPanel {
//private boolean hasIterator=false;
    private int row;

    
//    public boolean isHasIterator() {
//        return hasIterator;
//    }
//
//    public void setHasIterator(boolean hasIterator) {
//        this.hasIterator = hasIterator;
//    }
    private int colum;

    private Color[] clr = {Color.YELLOW, Color.BLUE,Color.GREEN,Color.ORANGE, Color.RED, Color.CYAN, Color.CYAN, Color.MAGENTA, Color.BLACK,Color.gray,Color.darkGray};

    public Color[] getClr() {
        return clr;
    }

    public void setClr(Color[] clr) {
        this.clr = clr;
    }


    public int getColum() {
        return colum;
    }

    public void setColum(int colum) {
        this.colum = colum;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public OnePanel(int row, int colum, int xromata) {
        this.row = row;
        this.colum = colum;
        int rand = (int) (Math.random() * xromata);
        this.setBackground(clr[rand]);
        setBorder(BorderFactory.createLineBorder(Color.white));

    }

    
}
