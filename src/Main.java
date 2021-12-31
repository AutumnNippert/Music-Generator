import javax.sound.midi.InvalidMidiDataException;

public class Main {
    public static void main(String[] args) throws InvalidMidiDataException {
        MidiPlayer player  = new MidiPlayer();
        MusicGenerator generator = new MusicGenerator();

        player.play(generator.generateMelody(Key.C));
    }
}