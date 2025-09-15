package ASTEvaluator;
//This class represents a Variable which contains a variable name and its corresponding expression
/* e.g
 * a = 10 + 3
 * a is var_name
 * expression is 10 + z3
 */

public class Variable {
    public final String varName;
    public final Expression expression;

    public Variable(String varName, Expression expression){
        this.varName = varName;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Variable name:" + varName + " =" + expression;
    }

    
}
