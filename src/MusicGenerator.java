import javax.sound.midi.*;
import javax.sound.midi.spi.MidiFileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MusicGenerator {
    private Key _key;

    MusicGenerator(Key key) {
        this._key = key;
    }

    MusicGenerator() {
        this._key = Key.C;
    }

    private Note generateRandomNote(Key key) {
        Note[] notes = key.get_notes();

        int rnd = new Random().nextInt(notes.length);
        return notes[rnd];
    }

    private int generateRandomDuration(int resolution) {

        int min = 2;
        int max = 4;
        int duration = ThreadLocalRandom.current().nextInt(min, max + 1);

        return duration * resolution;
    }


    public Sequence generateMelody(Key key) throws InvalidMidiDataException {

        final int noteOn = 144;
        final int noteOff = 128;
        final int changeInstrument = 192;
        final int controlChange = 176;
        final int pitchBend = 224;

        Sequence sequence = new Sequence(Sequence.PPQ, 1);
        Track track = sequence.createTrack();

        int notesWanted = 5;
        for (int i = 0; i <= notesWanted; i++) {
            int duration = generateRandomDuration(1);
            int endDurtaion = duration + generateRandomDuration(1);
            Note note = generateRandomNote(_key);
            track.add(makeEvent(noteOn, 1, note.fifth(), 100, i+duration));
            track.add(makeEvent(noteOff, 1, note.fifth(), 100, i+endDurtaion));
        }


        return sequence;
    }

    private MidiEvent makeEvent(int command, int channel,
                               Note note, int velocity, int tick)
    {

        MidiEvent event = null;

        try {

            // ShortMessage stores a note as command type, channel,
            // instrument it has to be played on and its speed.
            ShortMessage a = new ShortMessage();
            a.setMessage(command, channel, note.getValue(), velocity);

            // A midi event is comprised of a short message(representing
            // a note) and the tick at which that note has to be played
            event = new MidiEvent(a, tick);
        }
        catch (Exception ex) {

            ex.printStackTrace();
        }
        return event;
    }
}
