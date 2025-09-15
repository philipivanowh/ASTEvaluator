package ASTEvaluator;
//This enum represents the types of tokens
public enum TokenType {
    PLUS,
    MINUS,
    MULTIPLY,
    DIVIDE,
    POWER,
    NUMBER, // numbers are handled separately
    PARENTHESIS_OPEN,
    PARENTHESIS_CLOSE,
    VARIABLE,
    EQUAL,
    EOF,
    ILLEGAL
}
