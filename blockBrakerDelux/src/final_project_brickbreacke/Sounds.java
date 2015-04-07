package final_project_brickbreacke;


import java.applet.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Sounds extends Applet implements Runnable{
    String songName;
    boolean resume=false;
     Clip clip;
    public Sounds(String songName){
        try {
            if(songName!=null){
            this.songName=songName;
              
              AudioInputStream audio = null;
                  clip = AudioSystem.getClip();
            audio = AudioSystem.getAudioInputStream(new File(songName));
                   
                    clip.open(audio);
            }
        } catch (UnsupportedAudioFileException ex) {
          
        } catch (Exception ex) {
           
        }
            
    
    
    }

    @Override
    public void run() {
         if(songName!=null)
       clip.start();
      
    }   
       
       
    
    public void stopClip(){
     if(songName!=null)
    clip.stop();
   
    }
    
   
    
   
    
}
