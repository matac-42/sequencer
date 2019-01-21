package jp.ac.uryukyu.ie.e185742;

import java.io.File;
import java.util.Scanner;

import javafx.scene.media.AudioClip;

/**
 * Simple music sequencer that plays sound with a certain rhythm.
 */
public class Sequencer {

    private boolean representation = true;
    private int[] intBeatMapArray = new int[8];

    public boolean getRepresntation(){
        boolean representation = this.representation;
        return representation;
    }

    /**
     * Play the sound road from the outside.
     * @param instrument sound file name. ex) bassdrum.wav
     */
    private void SoundOutput(String instrument){
        AudioClip bassDrum = new AudioClip(new File("SoundSet/"+instrument).toURI().toString());
        bassDrum.play();
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
        }
    }

    /**
     * make a constant rhythm.
     * @param beatMap Array, constitute 0 & 1.
     * @param instrument sound file name. ex) bassdrum.wav
     */
    private void BeatMaker(int[] beatMap, String instrument){
        for(int mapElement : beatMap){
            if(mapElement == 1){
                SoundOutput(instrument);
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
     * @param beatMap Array, constitute 0 and 1.
     */
    public void BeatMapRepresentJudge(int[] beatMap){

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
     * @param instrument sound file name. ex) bassdrum.wav
     */
    public void sequencerApp(String instrument){

        BeatMap();
        BeatMapRepresentJudge(intBeatMapArray);

        if(representation){
            while(true){
                BeatMaker(intBeatMapArray, instrument);
            }
        }else{
            System.out.println("正しい値をいれてください");
            sequencerApp(instrument);
        }
    }
}
