/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package final_project_brickbreacke;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author gaitanesnikos
 */
public class DetailsDialog extends JDialog{
 private DetailsPanel det;
    public DetailsDialog(){

  ScrollPane b= new ScrollPane();
        this.setSize(1300,360);
     
       det= new DetailsPanel();
        

        this.add(det);
        this.setVisible(true);


    }

    public DetailsPanel getDet() {
        return det;
    }

    public void setDet(DetailsPanel det) {
        this.det = det;
    }

}
