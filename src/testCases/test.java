package testCases;
import ASTEvaluator.Parser;
import ASTEvaluator.OperationPriority;
import ASTEvaluator.Lexer;
import ASTEvaluator.Expression;

//Unit testing with all types of patterns
public class test {


public boolean test1(){
    String str = "1";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("1");
}

public boolean test2(){
    String str = "1 + 2 * 3";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("(+ 1 (* 2 3))");
}

public boolean test3(){
    String str = "a * 2 * b";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("(* (* a 2) b)");
}

public boolean test4(){
    String str = "a + b * 2 * c + a / 4";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("(+ (+ a (* (* b 2) c)) (/ a 4))");
}


public boolean test5(){
    String str = "2 + b * 5 - 3 / 5 + 5 -3";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("(- (+ (- (+ 2 (* b 5)) (/ 3 5)) 5) 3)");
}


public boolean test6(){

    String str = "(2 + b) * 5 3";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("(* (+ 2 b) 5)");
}

public boolean test7(){
    String str = "((a)))";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("a");
}


public boolean test8(){
    String str = "a + b * 2 * (c + a) / 4";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("(+ a (/ (* (* b 2) (+ c a)) 4))");
}


public boolean test9(){
    String str = "a + b * c ^ 4";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("(+ a (* b (^ c 4)))");
}

public boolean test10(){
    String str = "a ^ b ^ 2";
    Expression s = Parser.parseExpression(new Lexer(str),OperationPriority.LOWEST.getValue());
    String result = s.toString();
    return result.equals("(^ a (^ b 2))");
}

}
