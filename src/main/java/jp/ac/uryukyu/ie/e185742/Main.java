package jp.ac.uryukyu.ie.e185742;

public class Main {
    public static void main(String[] args){

        String bassDrumSet = "bassdrum.wav";//SoundSet内の音声ファイル名を入れる。
        Sequencer sequencer = new Sequencer();
        sequencer.sequencerApp(bassDrumSet);

    }
}
