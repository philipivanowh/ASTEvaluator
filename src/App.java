import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print(">>");
        String lexeme = sc.nextLine();

        Lexer lexer = new Lexer(lexeme);


        Parser parser = new Parser(lexer);
        parser.ParseExpression(lexer);


        }
    }

