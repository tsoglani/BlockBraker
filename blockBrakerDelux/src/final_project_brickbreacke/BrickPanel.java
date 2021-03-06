/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_brickbreacke;

import final_project_brickbreacke.OnePanel;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gaitanesnikos
 */
public class BrickPanel extends JPanel {

    boolean isDificoult = true;
    boolean isBomb = false;
    private Base b;
////Query vasi= new Query();

    public boolean isIsDificoult() {
        return isDificoult;
    }

    public void setIsDificoult(boolean isDificoult) {
        this.isDificoult = isDificoult;
    }
    Thread thread;
    private int boomRow, boomColum;
    DetailsDialog f;
    Timer time;
    AudioClip audio;
    private boolean isDetailsPressed = false;
    Color enterMouseColor = null;
    private int moveIngredientsRow = 0;
    private boolean isingrePresser = false;
    private int moveIngredientsColumn = 0;
    private JPanel countScorePanel = new JPanel();
    private JLabel countLab = new JLabel();
    private String count;
    private JButton retryLevel = new JButton("retry level");
    private JButton exitScore = new JButton("exit score");
    private Color ingreBackround;
    private JButton ingre1 = new JButton(new ImageIcon("image/im1.jpg"));
    private JButton ingre2 = new JButton(new ImageIcon("image/im2.jpg"));
    private JButton ingre3 = new JButton(new ImageIcon("image/im3.jpg"));
    private JButton ingre4 = new JButton(new ImageIcon("image/im4.jpg"));
    private JButton ingre5 = new JButton(new ImageIcon("image/im5.jpg"));
    private JButton[] arrayIngredients  = {ingre1, ingre2, ingre3, ingre4, ingre5};
    private Random rand = new Random();
    private JButton info = new JButton("info");

    public JButton getInfo() {
        return info;
    }

    public void setInfo(JButton info) {
        this.info = info;
    }
    private int choseIngre;
    private JButton chosenIngre;
    private int choseIngreRow;
    private int choseIngreColumn;
    //  private JPanel ingredients  = new JPanel();
    private int whatLevelIsNow = 2;
    private int stathera = 1;
    private int column = 12 + stathera / 2;
    private int row = 14 + (stathera - 1) / 2;
    private CentralFrame fram;
    private int totalScore = 0;
    private int score = 0;
    private int minScore = 100;
    private int arxikaColors = 3;
    private JPanel finishPanel = new JPanel();
    private JLabel finish;
    private JButton newGame = new JButton("new game");
    static JPanel panel;
    private Color clr = null;
    private OnePanel kathePanel;
    private int countPanelsWithSameColors = 0;
    // private JPanel panelInfo = new JPanel();
    private OnePanel[][] numOfPanel = new OnePanel[row][column];
    // private JButton closeInfo = new JButton("exit");
    private int allPanels = row * column;

    public Color getClr() {
        return clr;
    }

    public void setClr(Color clr) {
        this.clr = clr;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getCountPanelsWithSameColors() {
        return countPanelsWithSameColors;
    }

    public void setCountPanelsWithSameColors(int countPanelsWithSameColors) {
        this.countPanelsWithSameColors = countPanelsWithSameColors;
    }

    public JPanel getFinishPanel() {
        return finishPanel;
    }

    public void setFinishPanel(JPanel finishPanel) {
        this.finishPanel = finishPanel;
    }

    public CentralFrame getFram() {
        return fram;
    }

    public void setFram(CentralFrame fram) {
        this.fram = fram;
    }

    public int getMinScore() {
        return minScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    public MouseListener getMouse() {
        return mouse;
    }

    public void setMouse(MouseListener mouse) {
        this.mouse = mouse;
    }

    public ActionListener getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(ActionListener nextLevel) {
        this.nextLevel = nextLevel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStathera() {
        return stathera;
    }

    public void setStathera(int stathera) {
        this.stathera = stathera;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getWhatLevelIsNow() {
        return whatLevelIsNow;
    }

    public void setWhatLevelIsNow(int whatLevelIsNow) {
        this.whatLevelIsNow = whatLevelIsNow;
    }

    public int getArxikaColors() {
        return arxikaColors;
    }

    public void setArxikaColors(int arxikaColors) {
        this.arxikaColors = arxikaColors;
    }

    public OnePanel getKathePanel() {
        return kathePanel;
    }

    public void setKathePanel(OnePanel kathePanel) {
        this.kathePanel = kathePanel;
    }

    public OnePanel[][] getNumOfPanel() {
        return numOfPanel;
    }

    public void setNumOfPanel(OnePanel[][] numOfPanel) {
        this.numOfPanel = numOfPanel;
    }

    public BrickPanel() {
    }

    public BrickPanel(CentralFrame fram) {
//        ingredients .add(ingre1);
//        ingredients .add(ingre2);
//        ingredients .add(ingre3);
//        ingredients .add(ingre4);

        exitScore.addActionListener(exScore);
//        panelInfo.setLayout(new GridLayout(5, 1));
//        panelInfo.add(info);
//        panelInfo.add(closeInfo);
        countScorePanel.setLayout(new GridLayout(1, 2));
        fram.add(countScorePanel, BorderLayout.SOUTH);
        info.addActionListener(details);
//        fram.add(panelInfo, BorderLayout.EAST);
        ingre1.addActionListener(im1Listener);
        ingre2.addActionListener(im2Listener);
        ingre3.addActionListener(im3Listener);
        ingre4.addActionListener(im4Listener);
        ingre5.addActionListener(im5Listener);
//        Info.addActionListener(closeDetails);
        panel = this;
        finishPanel.setLayout(new BorderLayout());

        this.fram = fram;
        this.setLayout(new GridLayout(row, column));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                kathePanel = new OnePanel(i, j, arxikaColors);
                this.add(kathePanel);
                numOfPanel[i][j] = kathePanel;
                kathePanel.addMouseListener(mouse);

//                ingredients .setLayout(new GridLayout(7, 7));
//                fram.add(ingredients , BorderLayout.EAST);


            }
        }
        choseIngre = rand.nextInt(5);

        choseIngreRow = rand.nextInt(row);
        choseIngreColumn = rand.nextInt(column);
        chosenIngre = arrayIngredients [choseIngre];
        numOfPanel[choseIngreRow][choseIngreColumn].add(chosenIngre);
        ingreBackround = numOfPanel[choseIngreRow][choseIngreColumn].getBackground();
        retryLevel.addActionListener(retry);
        if (fram.isHard) {


            time = new Timer(fram);
            time.start();
        }
    }

    public void right(int row, int colum) {

        for (int i = colum + 1; i < this.column; i++) {
            if (clr == numOfPanel[row][i].getBackground()) {

                numOfPanel[row][i].setBackground(Color.WHITE);




                if (row < this.row - 1 && clr == numOfPanel[row + 1][i].getBackground()) {
                    down(row, i);
                }
                if (row > 0 && clr == numOfPanel[row - 1][i].getBackground()) {
                    up(row, i);
                }


            } else {
                break;
            }
        }
    }

    public void left(int row, int colum) {
        try {
            for (int i = colum - 1; i >= 0; i--) {


                if (clr == numOfPanel[row][i].getBackground() && numOfPanel[row][i].getBackground() != Color.white) {
                    numOfPanel[row][i].setBackground(Color.WHITE);






                    if (row < this.row - 1 && clr == numOfPanel[row + 1][i].getBackground()) {
                        down(row, i);
                    }
                    if (row > 0 && clr == numOfPanel[row - 1][i].getBackground()) {
                        up(row, i);
                    }

                } else {
                    break;
                }
            }
        } catch (StackOverflowError e) {
        }
    }

    public void up(int row, int colum) {

        for (int i = row - 1; i >= 0; i--) {
            if (clr == numOfPanel[i][colum].getBackground()) {
                numOfPanel[i][colum].setBackground(Color.WHITE);





                if (colum < column - 1 && clr == numOfPanel[i][colum + 1].getBackground()) {
                    right(i, colum);
                }
                if (colum > 0 && clr == numOfPanel[i][colum - 1].getBackground()) {
                    left(i, colum);
                }

            } else {
                break;
            }
        }
    }

    public void down(int row, int colum) {
        for (int i = row + 1; i < this.row; i++) {
            if (clr == numOfPanel[i][colum].getBackground()) {
                numOfPanel[i][colum].setBackground(Color.WHITE);






                if (colum < column - 1 && clr == numOfPanel[i][colum + 1].getBackground()) {
                    right(i, colum);
                }
                if (colum > 0 && clr == numOfPanel[i][colum - 1].getBackground()) {
                    left(i, colum);
                }

            } else {
                break;
            }
        }
    }

    public void checkRight(int row, int colum) {
        try {
            for (int i = colum + 1; i < this.column; i++) {
                if (clr == numOfPanel[row][i].getBackground()) {
                    countPanelsWithSameColors++;

                    if (row < this.row - 1 && clr == numOfPanel[row + 1][i].getBackground()) {
                        checkDown(row, i);
                    }
                    if (row > 0 && clr == numOfPanel[row - 1][i].getBackground()) {
                        checkUp(row, i);
                    }


                } else {
                    break;
                }
            }
        } catch (StackOverflowError e) {
        }
    }

    public void checkLeft(int row, int colum) {

        for (int i = colum - 1; i > 0; i--) {


            if (clr == numOfPanel[row][i].getBackground()) {
                countPanelsWithSameColors++;
                if (row < this.row - 1 && clr == numOfPanel[row + 1][i].getBackground()) {
                    checkDown(row, i);
                }
                if (row > 0 && clr == numOfPanel[row - 1][i].getBackground()) {
                    checkUp(row, i);
                }
            } else {
                break;
            }
        }
    }

    public void checkUp(int row, int colum) throws StackOverflowError {
        try {
            for (int i = row - 1; i >= 0; i--) {
                if (clr == numOfPanel[i][colum].getBackground()) {
                    countPanelsWithSameColors++;////
//                    if (colum < column - 1 && clr == numOfPanel[i][colum + 1].getBackground()) {
//                        checkRight(i, colum);
//                    }
//                    if (colum > 0 && clr == numOfPanel[i][colum - 1].getBackground()) {
//                        checkLeft(i, colum);
//                    }
////


                } else {
                    break;
                }
            }
        } catch (StackOverflowError e) {
            System.out.println();
        }
    }

    public int checkForGameOver(int ro, int co) {
        Color colorOfPanel = null;
        int countSameColorsOfPanel = 0;
        colorOfPanel = numOfPanel[ro][co].getBackground();
        for (int i = ro; i < row; i++) {
            if (numOfPanel[i][co].getBackground() == colorOfPanel) {
                for (int j = co; j < column; j++) {
                    if (numOfPanel[i][j].getBackground() == colorOfPanel) {
                        if (i < row - 1) {
                            for (int k = i + 1; k < row; k++) {
                                if (numOfPanel[k][j].getBackground() == colorOfPanel) {
                                    countSameColorsOfPanel++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (i > 0) {
                            for (int k = i - 1; k >= 0; k--) {
                                if (numOfPanel[k][j].getBackground() == colorOfPanel) {
                                    countSameColorsOfPanel++;
                                } else {
                                    break;
                                }

                            }
                        }


                        if (j < column - 1) {
                            for (int k = j + 1; k < column; k++) {
                                if (numOfPanel[i][k].getBackground() == colorOfPanel) {
                                    countSameColorsOfPanel++;
                                } else {
                                    break;
                                }
                            }
                        }
                        if (j > 0) {
                            for (int k = j - 1; k >= 0; k--) {
                                if (numOfPanel[i][k].getBackground() == colorOfPanel) {
                                    countSameColorsOfPanel++;
                                } else {
                                    break;
                                }

                            }
                        }
                    } else {
                        break;

                    }
                }
            } else {
                break;
            }
        }
        return countSameColorsOfPanel;



    }

    public void checkDown(int row, int colum) {
        for (int i = row + 1; i < this.row; i++) {
            if (clr == numOfPanel[i][colum].getBackground()) {
                countPanelsWithSameColors++;
                if (colum < column - 1 && clr == numOfPanel[i][colum + 1].getBackground()) {
                    checkRight(i, colum);
                }
                if (colum > 0 && clr == numOfPanel[i][colum - 1].getBackground()) {
                    checkLeft(i, colum);
                }



            } else {
                break;
            }
        }
    }

    public void goRightTheNull() {
        boolean move = true;
        for (int j = 0; j < column; j++) {
            int k = 0;

            for (int i = 0; i < row; i++) {
                if (numOfPanel[i][j].getBackground() == Color.WHITE) {
                    k++;

                }
            }


            if (k == row) {


                for (int l = 0; l < row; l++) {
                    if (j < column - 1) {
                        numOfPanel[l][j].setBackground(numOfPanel[l][j + 1].getBackground());
                        numOfPanel[l][j + 1].setBackground(Color.white);
                    }
                }
                if (j <= choseIngreColumn && move) {
                    move = false;
                    choseIngreColumn--;

                }


            }

        }

    }

    public void goUpTheNull() {
        boolean monoTinPrwtiFora = true;
        for (int i = row - 1; i >= 0; i--) {

            for (int j = column - 1; j >= 0; j--) {




                if (i < row - 1 && numOfPanel[i][j].getBackground() != Color.WHITE && numOfPanel[i + 1][j].getBackground() == Color.WHITE) {
                    numOfPanel[i + 1][j].setBackground(numOfPanel[i][j].getBackground());
                    numOfPanel[i][j].setBackground(Color.white);


                }







            }
            if (monoTinPrwtiFora && i >= choseIngreRow && numOfPanel[i][choseIngreColumn].getBackground() == Color.WHITE) {
                choseIngreRow++;
                monoTinPrwtiFora = false;

            }
        }

    }

    public void nextLevel() {


        column = 12 + stathera / 2;
        row = 14 + (stathera - 1) / 2;

        this.removeAll();
        stathera++;

        arxikaColors++;
        minScore = 80 + stathera * 20;

        /// allazw diastaseis ston pinaka
        numOfPanel = new OnePanel[row][column];
        this.setLayout(new GridLayout(row, column));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {


                kathePanel = new OnePanel(i, j, arxikaColors);

                this.add(kathePanel);
                numOfPanel[i][j] = kathePanel;
                kathePanel.addMouseListener(mouse);

            }
        }
        //// gia tis vomves ktl
        choseIngre = rand.nextInt(5);
        choseIngreRow = rand.nextInt(row);
        choseIngreColumn = rand.nextInt(column);
        numOfPanel[choseIngreRow][choseIngreColumn].add(arrayIngredients [choseIngre]);
        ingreBackround = numOfPanel[choseIngreRow][choseIngreColumn].getBackground();
        fram.setSize(900, 800 - stathera);


        String titleLevel = Integer.toString(whatLevelIsNow);
        fram.setTitle("level " + titleLevel);
        whatLevelIsNow++;
        fram.repaint();
        panel.repaint();
        isingrePresser = false;
        allPanels = row * column;

    }

    public int finalCount() {
        int count = 0;
        int fscore = 0;
        int numOfPanels = row * column;
        int emptyPanels = 0;
        int allPanl = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (numOfPanel[i][j].getBackground() != Color.white) {
                    count++;
                }
                if (numOfPanel[i][j].getBackground() == Color.white) {
                    emptyPanels++;
                }
                allPanl++;
            }
        }

        if (allPanl - count <= 4) {
            fscore = allPanels - count;
        }

        if (allPanl - count <= 12 && allPanl - count >= 5) {
            fscore = (int) (1.5 * (allPanels - count));
        }
        if (allPanl - count > 12) {
            fscore = 2 * (allPanels - count);
        }
        allPanels = count;
        return fscore;
    }

    public void moveIngre() {


        for (int i = 0; i < 20; i++) {
            goUpTheNull();

        }
        for (int i = 0; i < 20; i++) {

            goRightTheNull();
        }





        fram.repaint();
        panel.repaint();




    }

    public void panelRightAddLineBorder(int row, int colum) {

        for (int i = colum + 1; i < this.column; i++) {
            if (enterMouseColor == numOfPanel[row][i].getBackground()) {

                numOfPanel[row][i].setBorder(BorderFactory.createLineBorder(Color.black));




                if (row < this.row - 1 && enterMouseColor == numOfPanel[row + 1][i].getBackground()) {
                    panelDownAddLineBorder(row, i);
                }
                if (row > 0 && enterMouseColor == numOfPanel[row - 1][i].getBackground()) {
                    panelUpAddLineBorder(row, i);
                }


            } else {
                break;
            }
        }
    }

    public void panelLeftAddLineBorder(int row, int colum) {
        try {
            for (int i = colum - 1; i >= 0; i--) {


                if (enterMouseColor == numOfPanel[row][i].getBackground() && numOfPanel[row][i].getBackground() != Color.white) {
                    numOfPanel[row][i].setBorder(BorderFactory.createLineBorder(Color.BLACK));






                    if (row < this.row - 1 && enterMouseColor == numOfPanel[row + 1][i].getBackground()) {
                        panelDownAddLineBorder(row, i);
                    }
                    if (row > 0 && enterMouseColor == numOfPanel[row - 1][i].getBackground()) {
                        panelUpAddLineBorder(row, i);
                    }

                } else {
                    break;
                }
            }
        } catch (StackOverflowError e) {
        }
    }

    public void panelUpAddLineBorder(int row, int colum) {

        for (int i = row - 1; i >= 0; i--) {
            if (enterMouseColor == numOfPanel[i][colum].getBackground()) {
                numOfPanel[i][colum].setBorder(BorderFactory.createLineBorder(Color.black));





                if (colum < column - 1 && enterMouseColor == numOfPanel[i][colum + 1].getBackground()) {
                    panelRightAddLineBorder(i, colum);
                }
                if (colum > 0 && enterMouseColor == numOfPanel[i][colum - 1].getBackground()) {
                    panelLeftAddLineBorder(i, colum);
                }

            } else {
                break;
            }
        }
    }

    public void panelDownAddLineBorder(int row, int colum) {
        for (int i = row + 1; i < this.row; i++) {
            if (enterMouseColor == numOfPanel[i][colum].getBackground()) {
                numOfPanel[i][colum].setBorder(BorderFactory.createLineBorder(Color.black));






                if (colum < column - 1 && enterMouseColor == numOfPanel[i][colum + 1].getBackground()) {
                    panelRightAddLineBorder(i, colum);
                }
                if (colum > 0 && enterMouseColor == numOfPanel[i][colum - 1].getBackground()) {
                    panelLeftAddLineBorder(i, colum);
                }

            } else {
                break;
            }
        }
    }

    public void gameOver(boolean isOver) {

        JLabel faild = new JLabel("you faild to pass this level your score is " + score + "  minimum score was :" + minScore);
        JLabel faild2 = new JLabel("your total score is : " + totalScore);
        System.out.println("game overrrr");
        JPanel finalPanel = new JPanel();
        JPanel finalPanelButton = new JPanel();
        finalPanel.add(faild);

//newGame.setPreferredSize(new Dimension (10,10));


        finalPanel.add(finalPanelButton);

        finalPanel.setLayout(new GridLayout(2, 1));

        finalPanel.add(faild2);

        newGame.addActionListener(faildToPass);
        panel.removeAll();
        panel.add(finalPanel);
        if (!isOver) {
            panel.add(newGame);
            newGame.setForeground(Color.black);
            newGame.setIcon(null);
            newGame.setBackground(panel.getBackground());
        }


        if (isOver) {
            finalPanelButton.add(newGame);
            System.out.println("is over");
            b = new Base(CentralFrame.playerName, totalScore);
            try {
                newGame.setBackground(Color.BLACK);
                newGame.setIcon(new ImageIcon("image/newGame.png"));
                newGame.setPressedIcon(new ImageIcon("image/playAgain.png"));
                newGame.setForeground(Color.white);

                b.readAndWriteFromBase(("fr.txt"), ("fw.txt"), true);
            } catch (Exception ex) {
            }
        }



        fram.setSize(900, 800 + stathera);

    }
    MouseListener mouse = new MouseListener() {

        public void mouseClicked(MouseEvent me) {
        }

        public void mousePressed(MouseEvent me) {
            OnePanel p = (OnePanel) me.getSource();


            countPanelsWithSameColors = 1;


            if (numOfPanel[p.getRow()][p.getColum()].getBackground() == Color.white) {
                return;
            }
            clr = p.getBackground();
            try {
                checkUp(p.getRow(), p.getColum());
                checkDown(p.getRow(), p.getColum());
                checkRight(p.getRow(), p.getColum());
                checkLeft(p.getRow(), p.getColum());
            } catch (StackOverflowError ee) {
            }


            if (countPanelsWithSameColors > 2) {
                moveIngredientsRow = 0;
                moveIngredientsColumn = 0;

                if (p.getRow() < row - 1 && clr == numOfPanel[p.getRow() + 1][p.getColum()].getBackground()) {
                    down(p.getRow(), p.getColum());

                }
                if (p.getRow() - 1 >= 0 && clr == numOfPanel[p.getRow() - 1][p.getColum()].getBackground()) {
                    up(p.getRow(), p.getColum());

                }
                if (p.getColum() < column - 1 && clr == numOfPanel[p.getRow()][p.getColum() + 1].getBackground()) {
                    right(p.getRow(), p.getColum());

                }
                if (p.getColum() > 0 && clr == numOfPanel[p.getRow()][p.getColum() - 1].getBackground()) {
                    left(p.getRow(), p.getColum());

                }
                numOfPanel[p.getRow()][p.getColum()].setBackground(Color.WHITE);
//////////////               new Thread(){
//////////////               public void run(){
//////////////                        try {
//////////////                           this.sleep(50);
//////////////                            for (int i = 0; i < 10; i++) {
//////////////                                this.sleep(70); 
//////////////                                goRightTheNull();
//////////////                                goUpTheNull();
//////////////                            }
//////////////                            for (int i = 0; i < 10; i++) {
//////////////                                this.sleep(70); 
//////////////                                goRightTheNull();
//////////////                                goUpTheNull();
//////////////                            }
//////////////                        } catch (InterruptedException ex) {
//////////////                          
//////////////                        }
//////////////               
//////////////               }
//////////////               
//////////////               }.start();




                if ((choseIngreRow + moveIngredientsRow) <= row - 1 && (isingrePresser == false) && choseIngreColumn - moveIngredientsColumn >= 0) {
                    numOfPanel[choseIngreRow + moveIngredientsRow][choseIngreColumn - moveIngredientsColumn].add(arrayIngredients [choseIngre]);

                } else {
                    if (row - 1 >= 0 && isingrePresser == false && choseIngreColumn - moveIngredientsColumn >= 0) {
                        numOfPanel[row - 1][choseIngreColumn - moveIngredientsColumn].add(arrayIngredients [choseIngre]);
                    }
                }
                score = score + finalCount();
            }





        }

        public void mouseReleased(MouseEvent me) {

            moveIngre();


            int countColors = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {

                    if (numOfPanel[i][j].getBackground() != Color.white) {
                        int countSameColorsOfPanel = checkForGameOver(i, j);









                        if (countSameColorsOfPanel > 2) {
                            countColors++;

                        }
                    }


                }

            }
            if (countColors == 0) {
                try {
                    if (fram.isHard) {
                        time.suspend();
                    }
                } catch (NullPointerException e) {
                }

                System.out.println("next level ?");

                if (score > minScore) {
                    totalScore = totalScore + score;
                    if (arxikaColors < 10) {



                        JLabel epomeniPista = new JLabel("you have passed this level your score is " + score + "  minimum score was :" + minScore);

                        JLabel totalScoreLabel = new JLabel("your total score is " + totalScore);
                        JButton passed = new JButton(" submit to play lavel " + whatLevelIsNow);
                        panel.removeAll();
                        panel.add(passed);
                        panel.add(epomeniPista);
                        panel.add(totalScoreLabel);
                        passed.addActionListener(nextLevel);

                        fram.setSize(900, 800 + stathera);

                    } else {
                        finish = new JLabel("congratulations you have finish the game your total score is :" + totalScore);
                        finishPanel.add(finish, BorderLayout.CENTER);
                        panel.removeAll();

                        panel.add(finishPanel);
                        fram.setSize(900, 800 + stathera);
                    }
                } else {
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    gameOver(false);
                    panel.add(retryLevel);


                }


            }
            System.out.println(countColors);



        }

        public void mouseEntered(MouseEvent me) {
            OnePanel p = (OnePanel) me.getSource();




        }

        public void mouseExited(MouseEvent me) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    numOfPanel[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
                }
            }
            enterMouseColor = null;
            count = "score: " + Integer.toString(score);
            String minScr = Integer.toString(minScore);
            countLab.setText(count + " minimum score is : " + minScr);
            countLab.setEnabled(false);
            countScorePanel.add(countLab);

            countScorePanel.add(exitScore);

            countScorePanel.repaint();
            goUpTheNull();
        }
    };
    ActionListener nextLevel = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {

            score = 0;
            nextLevel();
            if (fram.isHard) {


                time.resume();

                time.setMinutes(0);
                time.setDekata(0);
                time.setSeconds(0);
                time.setTotalSec(0);
            }
        }
    };
    ActionListener faildToPass = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            time.setMinutes(0);
            time.setSeconds(0);
            time.setDekata(0);
            totalScore = totalScore + score;
            arxikaColors = 2;
            whatLevelIsNow = 1;
            String titleLevel = Integer.toString(whatLevelIsNow);
            fram.setTitle("level " + titleLevel);
            minScore = 80;
            stathera = 0;
            column = 12 + stathera / 2;
            row = 14 + (stathera - 1) / 2;
            panel.setLayout(new GridLayout(row, column));
            score = 0;

            totalScore = 0;
            nextLevel();
            if (fram.isHard) {
                time.resume();
            }
        }
    };
    ActionListener im1Listener = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            try {
                if (CentralFrame.isMutte == false) {
                    Sounds sound = new Sounds("Bomb.au");
                    thread = new Thread(sound);
                    thread.start();
                }

                isBomb = true;
                JButton b = (JButton) ae.getSource();
                OnePanel p = (OnePanel) b.getParent();
                boomRow = p.getX();
                boomColum = p.getY();

                if (p.getRow() < row - 1) {
                    numOfPanel[p.getRow() + 1][p.getColum()].setBackground(Color.white);
                }
                if (p.getRow() > 0) {
                    numOfPanel[p.getRow() - 1][p.getColum()].setBackground(Color.white);
                }
                if (p.getColum() < column - 1) {
                    numOfPanel[p.getRow()][p.getColum() + 1].setBackground(Color.white);
                }
                if (p.getColum() > 0) {
                    numOfPanel[p.getRow()][p.getColum() - 1].setBackground(Color.white);
                }
                if (p.getRow() < row - 1 && p.getColum() < column - 1) {
                    numOfPanel[p.getRow() + 1][p.getColum() + 1].setBackground(Color.white);
                }
                if (p.getRow() > 0 && p.getColum() > 0) {
                    numOfPanel[p.getRow() - 1][p.getColum() - 1].setBackground(Color.white);
                }

                numOfPanel[p.getRow()][p.getColum()].setBackground(Color.white);
                if (p.getRow() < row - 1 && p.getColum() > 0) {
                    numOfPanel[p.getRow() + 1][p.getColum() - 1].setBackground(Color.white);
                }
                if (p.getRow() > 0 && p.getColum() < column - 1) {
                    numOfPanel[p.getRow() - 1][p.getColum() + 1].setBackground(Color.white);
                }
                for (int i = 0; i < 20; i++) {
                    goUpTheNull();

                }
                for (int i = 0; i < 20; i++) {

                    goRightTheNull();
                }
                fram.repaint();
                p.remove(b);
                isingrePresser = true;
            } catch (Exception ex) {
            }
        }
    };
    ActionListener im2Listener = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            JButton b = (JButton) ae.getSource();
            OnePanel p = (OnePanel) b.getParent();

            Random random = new Random();
            int randomColorForFullLine = 0;
            int countWhiteFirstLine = 0;
            score = score + column;
            for (int i = 0; i < column; i++) {

                if (numOfPanel[0][i].getBackground() == Color.white) {
                    countWhiteFirstLine++;

                } else {
                    return;
                }
            }
            if (countWhiteFirstLine == column) {


                for (int i = 0; i < column; i++) {
                    Color[] clr = numOfPanel[0][i].getClr();
                    randomColorForFullLine = random.nextInt(arxikaColors);
                    numOfPanel[0][i].setBackground(clr[randomColorForFullLine]);
                    for (int j = 0; j < 20; j++) {
                        goUpTheNull();

                    }
                }

                fram.repaint();


            }

            p.remove(b);
            isingrePresser = true;
        }
    };
    ActionListener im3Listener = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            if (CentralFrame.isMutte == false) {
                Sounds sound = new Sounds("Bomb.au");
                thread = new Thread(sound);
                thread.start();
            }
            isBomb = true;
            JButton b = (JButton) ae.getSource();
            OnePanel p = (OnePanel) b.getParent();
            boomRow = p.getX();
            boomColum = p.getY();
            repaint();


            if (p.getRow() < row - 1) {
                numOfPanel[p.getRow() + 1][p.getColum()].setBackground(Color.white);
            }
            if (p.getRow() > 0) {
                numOfPanel[p.getRow() - 1][p.getColum()].setBackground(Color.white);
            }
            if (p.getColum() < column - 1) {
                numOfPanel[p.getRow()][p.getColum() + 1].setBackground(Color.white);
            }
            if (p.getColum() > 0) {
                numOfPanel[p.getRow()][p.getColum() - 1].setBackground(Color.white);
            }

            if (p.getRow() > 0 && p.getColum() > 0) {
                numOfPanel[p.getRow() - 1][p.getColum() - 1].setBackground(Color.white);
            }

            numOfPanel[p.getRow()][p.getColum()].setBackground(Color.white);


            for (int i = 0; i < 20; i++) {
                goUpTheNull();

            }
            for (int i = 0; i < 20; i++) {

                goRightTheNull();
            }
            p.remove(b);
            p.repaint();
            isingrePresser = true;
        }
    };
    ActionListener im4Listener = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            if (CentralFrame.isMutte == false) {
                Sounds sound = new Sounds("mystery.au");
                thread = new Thread(sound);
                thread.start();
            }
            JButton b = (JButton) ae.getSource();
            OnePanel p = (OnePanel) b.getParent();
            kathePanel = new OnePanel(p.getRow(), p.getColum(), arxikaColors);
            numOfPanel[p.getRow()][p.getColum()].setBackground(kathePanel.getBackground());
            p.remove(b);
            p.repaint();
            isingrePresser = true;
        }
    };
    ActionListener im5Listener = new ActionListener() {

        int x = 0;
        int y = 0;

        public void actionPerformed(ActionEvent ae) {


            JButton b = (JButton) ae.getSource();
            OnePanel p = (OnePanel) b.getParent();
            if (p.getColum() - 1 > 0) {
                if (p.getColum() > 0 && p.getColum() < column - 1) {
                    clr = numOfPanel[p.getRow()][p.getColum() - 1].getBackground();
                    if (p.getColum() < column - 1 && clr == numOfPanel[p.getRow()][p.getColum() + 1].getBackground()) {

                        right(p.getRow(), p.getColum());
                        left(p.getRow(), p.getColum());
                        numOfPanel[p.getRow()][p.getColum()].setBackground(Color.white);

                        x++;
                    }
                }
            }


            if (p.getRow() > 0 && p.getRow() < row - 1) {
                clr = numOfPanel[p.getRow() - 1][p.getColum()].getBackground();
                if (p.getRow() < row - 1 && clr == numOfPanel[p.getRow() + 1][p.getColum()].getBackground()) {
                    up(p.getRow(), p.getColum());


                    down(p.getRow(), p.getColum());
                    numOfPanel[p.getRow()][p.getColum()].setBackground(Color.white);

                    y++;
                }
            }

            if (x == 1 || y == 1) {
                x = 0;
                y = 0;
                if (!CentralFrame.isMutte) {
                    Sounds sound = new Sounds("crash.au");
                    thread = new Thread(sound);
                    thread.start();
                }
                p.remove(b);
                p.repaint();

            } else {
                return;
            }


            for (int i = 0; i < 20; i++) {
                goUpTheNull();

            }
            for (int i = 0; i < 20; i++) {

                goRightTheNull();
            }
            isingrePresser = true;
        }
    };
    ActionListener details = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            f = new DetailsDialog();
            isDetailsPressed = true;
        }
    };
//    ActionListener closeDetails = new ActionListener() {
//
//        public void actionPerformed(ActionEvent ae) {
//            fram.remove(panelInfo);
//
//            if (isDetailsPressed) {
//                f.getDet().getMotion().stop();
//                f.getDet().setMotion(null);
//            }
//
//            panel.repaint();
//            fram.repaint();
//            fram.setSize(903, 800);
//        }
//    };
    ActionListener exScore = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {
            fram.remove(countScorePanel);
            fram.repaint();
            fram.setSize(902, 800);
        }
    };
    ActionListener retry = new ActionListener() {

        public void actionPerformed(ActionEvent ae) {

            arxikaColors--;
            score = 0;
            stathera--;
            minScore = minScore - stathera * 20;
            whatLevelIsNow--;
            nextLevel();
            if (fram.isHard) {
                time.resume();
            }


        }
    };

    public void paint(Graphics g) {
        super.paint(g);

        if (isBomb) {
            isBomb = false;
            Font f = new Font("Arial", Font.ITALIC, 30);
            g.setFont(f);
            try {
                Color colo = new Color(250, 220, 70);
                g.setColor(colo);
                if (boomColum - 50 > 100) {


                    g.drawString("BOOOM!!!!", boomRow, boomColum - 50);
                } else {
                    g.drawString("BOOOM!!!!", boomRow, boomColum + 50);
                }
                wait(1);

            } catch (Exception ex) {
            }
        }

    }

    public void update(java.awt.Graphics g) {
        System.out.println("up to date");
    }
}
