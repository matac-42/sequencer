package jp.ac.uryukyu.ie.e185742;

import java.io.File;
import java.util.Scanner;

import javafx.scene.media.AudioClip;

public class Sequencer {

    /**
     * Play the sound road from the outside.
     * @param setName sound file name. ex) bassdrum.wav
     */
    public void SoundOutput(String setName){
        AudioClip bassDrum = new AudioClip(new File("SoundSet/"+setName).toURI().toString());
        bassDrum.play();
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
        }

    }

    /**
     * make a constant rhythm.
     * @param beatMap Array, constitute 0 & 1.
     * @param setName sound file name. ex) bassdrum.wav
     */
    public void BeatMaker(int[] beatMap, String setName){
        for(int i = 0; i < beatMap.length; i++){
            if(beatMap[i] == 1){
                SoundOutput(setName);
            }else{
                try{
                   Thread.sleep(500);
                }catch (InterruptedException e){
                }
            }
        }

    }

    /**
     * make a beatmap by user input.
     * @return Beat map int array constitute 0 & 1. The number of elements in the array is eight.
     */
    public int[] BeatMap(){

        Scanner userInBeat = new Scanner(System.in);

        System.out.println("0と1を合わせて8つ入力");
        String test = userInBeat.next() ;
        String[] StringBeatMapArray = test.split("");

        int[] intBeatMapArray = new int[StringBeatMapArray.length];

        for(int i = 0; i < StringBeatMapArray.length; i++){
            intBeatMapArray[i] = Integer.parseInt(StringBeatMapArray[i]);
        }

        return intBeatMapArray;
    }

}
