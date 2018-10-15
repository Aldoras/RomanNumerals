public enum RomanEnum {
    //I=73,    V=86,    X=88,    L=76,    C=67,    D=68,    M=77,
    I(73, 1),
    V(86, 2),
    X(88, 3),
    L(76, 4),
    C(67, 5),
    D(68, 6),
    M(77, 7);

    public int numVal;
    private int level;
    private int intVal;

    RomanEnum(int numVal, int level) {
        this.numVal = numVal;
        this.level = level;
    }

    public int getNumVal() {
        return numVal;
    }

    public int getLevel() {
        return level;
    }
    public int getIntVal() {
        return intVal;
    }
}