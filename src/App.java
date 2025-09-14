import java.util.HashMap;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Float> variables = new HashMap<>();
        while(true){
        System.out.print(">>");
        String lexeme = sc.nextLine();

        //Escape 
        if(lexeme.equals("exit"))
            break;

        Lexer lexer = new Lexer(lexeme);

        Parser parser = new Parser();
        Expression exp = parser.parseExpression(lexer,OperationPriority.LOWEST.getValue());
        System.err.println(exp);

        //Checking if the statement was a variable declaration or not
        Variable var = exp.is_assign();

        if(var!=null){
            variables.put(var.var_name, Evaluator.evaluate(var.exp,variables));
            continue;
        }

        float result = Evaluator.evaluate(exp,variables);
        System.err.println("Result:" + result);
        }

        }
    }

