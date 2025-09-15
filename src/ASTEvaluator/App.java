package ASTEvaluator;
import java.util.HashMap;
import java.util.Scanner;




public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Float> variables = new HashMap<>();

        while(true){
            //Takes input
            System.out.print(">>");
            String input = sc.nextLine();

            //Escape 
            if(input.equals("exit"))
                break;

        //Convert into tokens
        Lexer lexer = new Lexer(input);

        //Construct an Abstract Syntax Tree structure
        Expression expression = Parser.parseExpression(lexer,OperationPriority.LOWEST.getValue());

        //Display the Abstract Syntax Tree
        System.out.println(expression);

        //Create a variable if there is a variable declaration
        Variable var = expression.is_assign();

        //If variable was declared add to the variables table with its associated value
        if(var!=null){
            variables.put(var.varName, Evaluator.evaluate(var.expression,variables));
            continue;
        }

        float result = Evaluator.evaluate(expression,variables);

        System.out.println("Result:" + result);

        }

        }
    }

