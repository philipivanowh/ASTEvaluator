package ASTEvaluator;
import java.util.HashMap;

/*
 * This class takes  evaluates an expression recursively to output the final result
 */
public class Evaluator {
    

    //Evaluate the operation based on the given expression and variables
    public static float evaluate(Expression expression, HashMap<String, Float> variables){
        //This expression is an atom expression
        if(expression instanceof UnaryExpression atom)
        {
            //if it is variable get the corresponding value
            //if it is a number return the float number of the value
            switch(atom.getType()){
                case TokenType.VARIABLE -> {
                    return variables.get(atom.getValue());
                }
                case TokenType.NUMBER -> {
                    return Float.parseFloat(atom.getValue());
                }
                default -> System.err.println("Not a compatible atom");
                    
            }
            
        }
        //This expression is an Binary Expression
        if(expression instanceof BinaryExpression operation)
        {
            float lhs = evaluate(operation.getOperands().get(0),variables);
            
            float rhs = evaluate(operation.getOperands().get(1),variables);

            //Compute based on the corresponding operator
            switch (operation.getOperator().type){
                case TokenType.PLUS -> {
                    return lhs + rhs;
                }
                case TokenType.MINUS -> {
                    return lhs - rhs;
                }
                case TokenType.MULTIPLY -> {
                    return lhs * rhs;
                }
                case TokenType.DIVIDE -> {
                    return rhs / lhs;
                }
                case TokenType.POWER -> {
                    return (float)Math.pow(rhs,lhs);
                }
                default -> {
                    System.err.println("Not a valid operator");
                    System.exit(0);
                }
                
            }
        }
        return 0.0f;
    }
}
