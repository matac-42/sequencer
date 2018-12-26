package jp.ac.uryukyu.ie.e185742;

import java.io.File;

import javafx.scene.media.AudioClip;

public class Sequencer {

    /**
     * Play the sound road from the outside.
     * @param setName sound file name. ex) SoundSet/bassdrum.wav
     */
    public void SoundOutput(String setName){
        AudioClip bassDrum = new AudioClip(new File("SoundSet/"+setName).toURI().toString());
        bassDrum.play();
        try{
            Thread.sleep(30000);
        }catch (InterruptedException e){
        }
    }

}
