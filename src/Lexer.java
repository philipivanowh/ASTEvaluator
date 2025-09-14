import java.util.ArrayList;
import java.util.List;

public class Lexer {


    private final static List<Token> tokens = new ArrayList<>();
    public Lexer(String lexeme){
        System.out.println("Evaluating: (" + lexeme + ").....");
        Tokenize(lexeme);
    }

    public List<Token> getTokens(){
        return tokens;
    }

    public static void Tokenize(String lexeme){

        int current = 0;

        while(current < lexeme.length()) {
            switch(lexeme.charAt(current)){
                case ' ' -> {
                }
                case '+' -> tokens.add(new Token(TokenType.PLUS, "+"));
                case '-' -> tokens.add(new Token(TokenType.MINUS,"-"));
                case '*' -> tokens.add(new Token(TokenType.MULTIPLY,"*"));
                case '^' -> tokens.add(new Token(TokenType.POWER,"^"));
                case '/' -> tokens.add(new Token(TokenType.DIVIDE,"/"));
                case '(' -> tokens.add(new Token(TokenType.PARENTHESIS_OPEN,"("));
                case ')' -> tokens.add(new Token(TokenType.PARENTHESIS_CLOSE,")"));
                case '=' -> tokens.add(new Token(TokenType.EQUAL,"="));
                default -> {
                    //Interpreting digits
                    if (Character.isDigit(lexeme.charAt(current))) {
                        StringBuilder number = new StringBuilder();
                        while (current < lexeme.length() && Character.isDigit(lexeme.charAt(current))) {
                            number.append(lexeme.charAt(current));
                            current++;
                        }

                        tokens.add(new Token(TokenType.NUMBER,number.toString()));
                        continue;
                    }
                    //Interpreting variables
                    else if (Character.isAlphabetic(lexeme.charAt(current))) {
                        tokens.add(new Token(TokenType.VARIABLE, String.valueOf(lexeme.charAt(current))));
                    }
                    
                    else {
                        tokens.add(new Token(TokenType.ILLEGAL, ""));
                    }
                }
            }
            current++;

    }

    tokens.reversed();

    displayTokens(tokens);
}

    public Token nextToken(){

        //when there is nothing left
        if(tokens.isEmpty())
            return new Token(TokenType.EOF,"");

        //Access and remove the last element
        Token token = tokens.remove(0);
        return token;
    }

    public Token peekToken(){

        if(tokens.isEmpty())
            return new Token(TokenType.EOF,"");

        //Access the last element
        return tokens.get(0);
    }

    private static void displayTokens(List<Token> tokens){
        System.out.println(tokens.toString());
    }
}