package ASTEvaluator;

import java.util.*;

//Organize tokens into an Abstract Syntax Tree Data Structurr
public class Parser {

    //Mapping the priority of the operator tokens
    private static final Map<TokenType, OperationPriority> precedences = Map.of(

            TokenType.EQUAL, OperationPriority.LOWEST,
            TokenType.PLUS, OperationPriority.SUM,
            TokenType.MINUS, OperationPriority.SUM,
            TokenType.MULTIPLY, OperationPriority.PRODUCT,
            TokenType.DIVIDE, OperationPriority.PRODUCT,
            TokenType.POWER, OperationPriority.POWER,
            TokenType.PARENTHESIS_OPEN, OperationPriority.GROUP);

    //Main metheod used to recursivly construct an expression based on the Tokens
    public static Expression parseExpression(Lexer lexer, float minPrecedence) {
        Token curr = lexer.nextToken();
        Expression lhs;

        //Handles the left hand side
        switch (curr.type) {
            case NUMBER,VARIABLE -> lhs = new UnaryExpression(curr);
            case PARENTHESIS_OPEN -> {
                lhs = parseExpression(lexer, 0.0f); // store the inner expression
                if (lexer.peekToken().type == TokenType.PARENTHESIS_CLOSE) {
                    lexer.nextToken(); // consume )
                } else {
                    System.err.println("Error: missing closing parenthesis");
                }
            }

            default -> {
                System.out.println("Could find it");
                return null;
            }
        }

        // parse operators and right-hand sides
        while (true) {
            Token next = lexer.peekToken();
            if (next.type == TokenType.EOF || next.type == TokenType.PARENTHESIS_CLOSE) {
                break;
            }

            // must be operator
            if (!precedences.containsKey(next.type)) {
                System.err.println("Unexpected token: " + next);
                break;
            }

            float opPrec = precedences.get(next.type).getValue();
            if (opPrec < minPrecedence) {
                break;
            }

            Token op = lexer.nextToken(); // consume operator

            // parse RHS with higher precedence
            Expression rhs = parseExpression(lexer, opPrec + 0.1f);

            lhs = new BinaryExpression(op, new ArrayList<>(List.of(rhs, lhs)));
        }
        return lhs;
    }
}
