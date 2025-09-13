public enum OperationPriority {
    LOWEST(0),
    SUM(1),        // + or -
    PRODUCT(2),    // * or /
    PREFIX(3),     // -X or +X
    POWER(4),      // ^
    GROUP(5);      //()

    private final int value;

    OperationPriority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}