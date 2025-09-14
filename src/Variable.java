public class Variable {
    public String var_name;
    public Expression exp;

    public Variable(String var_name, Expression exp){
        this.var_name = var_name;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Variable name:" + var_name + " =" + exp;
    }

    
}
