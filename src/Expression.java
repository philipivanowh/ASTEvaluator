import java.util.List;
// Base class
public class Expression {
}

// Single number in an AST node
class Atom extends Expression {
    private final Token number;

    public Atom(Token number) { 
        this.number = number;
    }

    public Token getNumber(){
        return this.number;
    }
}

// Expression with two sides (e.g. left and right numbers with an operator like +, -, *)
class Operation extends Expression{
    private final Token operator;
    private final List<Expression> operands;


    public Operation(Token operator, List<Expression> operands) { 
        this.operator = operator;
        this.operands = operands;
    }

    /*
     * Getter method for operator
     */
    public Token getOperator(){
        return operator;
    }

    /*
     * Getter method for operands
     */
    public List<Expression> getOperands(){
        return operands;
    }
}
