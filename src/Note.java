import java.util.Arrays;

public enum Note {
    A0 (21),
    ASharp0 (22),
    B0 (23),
    C1 (24),
    CSharp1 ( 25),
    D1 ( 26),
    DSharp1 (27),
    E1 (28),
    F1 (29),
    FSharp1 (30),
    G1 (31),
    GSharp1 (32),
    A1 (33),
    ASharp1 (34),
    B1 (35),
    C2 (36),
    CSharp2 (37),
    D2 (38),
    DSharp2 (39),
    E2 (40),
    F2 (41),
    FSharp2 (42),
    G2 (43),
    GSharp2 (44),
    A2 (45),
    ASharp2 (46),
    B2 (47),
    C3 (48),
    CSharp3 (49),
    D3 (50),
    DSharp3 (51),
    E3 (52),
    F3 (53),
    FSharp3 (54),
    G3 (55),
    GSharp3 (56),
    A3 (57),
    ASharp3 (58),
    B3 (59),
    C4 (60),
    CSharp4 (61),
    D4 (62),
    DSharp4 (63),
    E4 (64),
    F4 (65),
    FSharp4 (66),
    G4 (67),
    GSharp4 (68),
    A4 (69),
    ASharp4 (70),
    B4 (71),
    C5 (72),
    CSharp5 (73),
    D5 (74),
    DSharp5 (75),
    E5 (76),
    F5 (77),
    FSharp5 (78),
    G5 (79),
    GSharp5 (80),
    A5 (81),
    ASharp5 (82),
    B5 (83),
    C6 (84),
    CSharp6 (85),
    D6 (86),
    DSharp6 (87),
    E6 (88),
    F6 (89),
    FSharp6 (90),
    G6 (91),
    GSharp6 (92),
    A6 (93),
    ASharp6 (94),
    B6 (95),
    C7 (96),
    CSharp7 (97),
    D7 (98),
    DSharp7 (99),
    E7 (100),
    F7 (101),
    FSharp7 (102),
    G7 (103),
    GSharp7 (104),
    A7 (105),
    ASharp7 (106),
    B7 (107),
    C8 (108)
    ;

    private int _value;

    private Note(int value){
        this._value = value;
    }

    public int getValue(){
        return this._value;
    }
    public Note third(){
        return toNote(_value + 4);
    }

    public Note fifth(){
        return toNote(_value + 7);
    }

    public Note toNote(int value){
        return Arrays.stream(Note.values()).filter(o -> o._value == value).findFirst().get();
    }
}
