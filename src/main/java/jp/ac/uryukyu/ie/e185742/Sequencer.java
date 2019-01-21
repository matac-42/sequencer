package jp.ac.uryukyu.ie.e185742;

import java.io.File;
import java.util.Scanner;

import javafx.scene.media.AudioClip;

public class Sequencer {

    private boolean representation = true;
    private int[] intBeatMapArray = new int[8];

    /**
     * Play the sound road from the outside.
     * @param setName sound file name. ex) bassdrum.wav
     */
    private void SoundOutput(String setName){
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
    private void BeatMaker(int[] beatMap, String setName){
        for(int mapElement : beatMap){
            if(mapElement == 1){
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
     */
    private void BeatMap(){

        Scanner userInBeat = new Scanner(System.in);

        System.out.print("0と1を合わせて8つ入力>");
        String test = userInBeat.next() ;
        String[] StringBeatMapArray = test.split("");
        try{
            for(int i = 0; i < StringBeatMapArray.length; i++){
                intBeatMapArray[i] = Integer.parseInt(StringBeatMapArray[i]);
            }

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("正しい長さで入力してください");
            BeatMap();
        }
    }

    /**
     * Determine whether the expression of a beatMap is correct.
     * @param beatMap Array, constitute 0 & 1.
     */
    private void BeatMapRepresentJudge(int[] beatMap){

        for(int mapElement : beatMap){
            if(mapElement == 0 || mapElement == 1){
                representation = true;
            }else {
                representation = false;
            }
        }
    }

    /**
     * Application, make a constant 8 beat.
     */
    public void sequencerApp(String setName){

        BeatMap();
        BeatMapRepresentJudge(intBeatMapArray);

        if(representation){
            while(true){
                BeatMaker(intBeatMapArray, setName);
            }
        }else{
            System.out.println("正しい値をいれてください");
            sequencerApp(setName);
        }
    }
}
