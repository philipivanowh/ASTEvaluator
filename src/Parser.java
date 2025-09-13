
import java.beans.Expression;
import java.util.*;

public class Parser {

    private Lexer lexer;


    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public HashMap<TokenType, OperationPriority> precedences = new HashMap<TokenType, OperationPriority>(){
    {
            put(TokenType.PLUS, OperationPriority.SUM);
            put(TokenType.MINUS, OperationPriority.SUM);
            put(TokenType.MULTIPLY, OperationPriority.PRODUCT);
            put(TokenType.DIVIDE, OperationPriority.PRODUCT);
            put(TokenType.POWER, OperationPriority.POWER);
            put(TokenType.PARENTHESIS_OPEN, OperationPriority.GROUP);
    }

    public Expr ParseExpression(Lexer lexer){

        Expression lhs = null;
        Token currToken = lexer.nextToken();
        if(currToken.type == TokenType.NUMBER){
            lhs = new Atom(currToken);
        }

        
        while (lexer.peekToken().type != TokenType.EOF) { 
            //Check if it is an operator
            if(precedences.containsKey(lexer.peekToken().type)){

            }
        }
        
    }






};
    
    
}
