package ASTEvaluator;

//This enum gives the priority of the operation
public enum OperationPriority {
    LOWEST(0.0f),
    SUM(1.0f),        // + or -
    PRODUCT(2.0f),    // * or /
    PREFIX(3.0f),     // -X or +X
    POWER(4.0f),      // ^
    GROUP(5.0f);      //()

    private final float value;

    OperationPriority(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}