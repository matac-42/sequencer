package jp.ac.uryukyu.ie.e185742;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequencerTest {

    @Test
    void sequencerApp() {
        Sequencer sequencer = new Sequencer();
        int[] intBeatMapArray = {0, 1, 0, 1, 0, 1, 0, 1};
        sequencer.BeatMapRepresentJudge(intBeatMapArray);

        assertEquals(sequencer.getRepresntation(), true);

    }
}