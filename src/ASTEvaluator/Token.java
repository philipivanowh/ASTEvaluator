package ASTEvaluator;
//This class represents a Token which contains a token type and value
public class Token
{
    public TokenType type;
    public String value;
    
    public Token(TokenType type, String value)
    {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString(){
        return "" + type + "(" + value + ")";
    }
}