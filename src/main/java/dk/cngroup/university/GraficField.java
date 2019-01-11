package dk.cngroup.university;

public enum GraficField {
    NEUTRAL("."),
    ROVER("*"),
    STONE("O"),
    DETECTEDSTONE("C"),
    INITIAL("@"),
    FINAL("%"),
    ROVERSTONE("$"),
    VICTORY("#");

    private final String symbol;
//    private static GraficField[][] graficFields;

    GraficField(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

}
