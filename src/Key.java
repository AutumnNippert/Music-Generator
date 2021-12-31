public enum Key {
    C (new Note[] {Note.C4, Note.D4, Note.E4, Note.F4, Note.G4, Note.A4, Note.B4});

    private Note[] _notes;

    private Key(Note[] notes) {
        _notes = notes;
    }

    public Note[] get_notes() {
        return _notes;
    }
}