import java.util.List;
// Base class
public class Expression {

    public Variable is_assign(){

        //If the expression is a unaryExpression
        if(this instanceof UnaryExpression){
            return null;
        }
        else if(this instanceof BinaryExpression operation){
            String variableNam = null;
            if(operation.getOperator().type == TokenType.EQUAL){


                /*
                 * e.g
                 * a = 5
                 * List is reveresed
                 * 5 = a
                 * it is checking operands index of 0 to check the assigned name
                 */
                //Check if this token can be the variable name
                if(operation.getOperands().get(1) instanceof UnaryExpression atom)
                {
                   if(Character.isAlphabetic((atom.getValue()).charAt(0))){
                        variableNam = atom.getValue();
                   }else{
                    System.err.println("Invalid variable name");
                   }

                   return new Variable(variableNam, operation.getOperands().get(0));
                }
            }
            

        }
        return null;
    }


}


// Single number in an AST node
class UnaryExpression extends Expression {
    private final Token atom;

    public UnaryExpression(Token atom) { 
        this.atom = atom;
    }

    public TokenType getType(){
        return atom.type;
    }

    public String getValue(){
            return atom.value;
    }

    @Override
    public String toString(){
        return atom.value ;
    }

    
    
}

// Expression with two sides (e.g. left and right numbers with an operator like +, -, *)
class BinaryExpression extends Expression{
    private final Token operator;
    private final List<Expression> operands;


    public BinaryExpression(Token operator, List<Expression> operands) { 
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

    @Override
    public String toString() {
        String a =  "("+operator.value;
        for( Expression s : operands) {
            a += " " + s;
        }
        a += ")";
        return a;
    }
}
