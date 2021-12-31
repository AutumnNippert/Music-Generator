import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

class MidiPlayer{



    public void play(Sequence sequence)
    {

        try{
            Sequencer sequencer= MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);
            sequencer.setTempoInBPM(120);
            sequencer.start();

            boolean isRunning = true;
            while(isRunning){

                // Exit the program when sequencer has stopped playing.
                if(!sequencer.isRunning()){
                    sequencer.close();
                    isRunning = false;
                }
            }
            System.out.println("Sequence played");
        }
        catch(Exception ex){

            ex.printStackTrace();
        }
    }
}
