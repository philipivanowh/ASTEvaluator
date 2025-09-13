import java.util.ArrayList;
import java.util.List;

public class Lexer {


    private List<Token> tokens = new ArrayList<>();
    public Lexer(String lexeme){
        System.out.println("Evaluating: (" + lexeme + ").....");
        Tokenize(lexeme);
    }

    public List<Token> getTokens(){
        return tokens;
    }

    public void Tokenize(String lexeme){

        int current = 0;

        while(current < lexeme.length()) {
            switch(lexeme.charAt(current)){
                case '+':
                    tokens.add(new Token(TokenType.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(TokenType.MINUS,"-"));
                    break;
                case '*':
                    tokens.add(new Token(TokenType.MULTIPLY,"*"));
                    break;
                case '^':
                    tokens.add(new Token(TokenType.POWER,"^"));
                    break;
                case '/':
                    tokens.add(new Token(TokenType.DIVIDE,"/"));
                    break;
                case '(':
                    tokens.add(new Token(TokenType.PARENTHESIS_OPEN,"("));
                    break;
                case ')':
                    tokens.add(new Token(TokenType.PARENTHESIS_CLOSE,")"));
                    break;
                default:
                    if (Character.isDigit(lexeme.charAt(current))) {
                        StringBuilder number = new StringBuilder();
                        while (current < lexeme.length() && Character.isDigit(lexeme.charAt(current))) {
                            number.append(lexeme.charAt(current));
                            current++;
                        }

                        tokens.add(new Token(TokenType.NUMBER,number.toString()));
                        continue;
                    }else{
                        tokens.add(new Token(TokenType.ILLEGAL, ""));
                    }
                    break;
            }
            current++;

    }

    tokens.reversed();

    displayTokens(tokens);
}

    public Token nextToken(){

        //when there is nothing left
        if(tokens.size()==0)
            return new Token(TokenType.EOF,"");

        //Access and remove the last element
        Token token = tokens.remove(tokens.size()-1);
        return token;
    }

    public Token peekToken(){

        if(tokens.size()==0)
            return new Token(TokenType.EOF,"");

        //Access the last element
        return tokens.get(tokens.size()-1);
    }

    private void displayTokens(List<Token> tokens){
        System.out.println(tokens.toString());
    }
}