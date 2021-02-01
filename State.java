public enum State {

    NORMAL(1.2),
    SLIGHTLY_FLAWED(0.95),
    HALF_FLAWED(0.55),
    ALMOST_ALL_FLAWED(0.25),
    ALL_FLAWED(0.1);
    ;

    public double getI() {
        return i;
    }

    private final double i;


    State(double i) {
        this.i = i;
    }
}