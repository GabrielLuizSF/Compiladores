package br.com.gabrielluizsf.compiler.lexer;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import br.com.gabrielluizsf.compiler.lexer.exceptions.EzLexicalException;
import br.com.gabrielluizsf.compiler.lexer.tokens.Token;

public class EdenZeroLexer{

    private char[] content;
    private int    state;
    private int    position;
    private int    line;
    private int    column;
    public EdenZeroLexer(String filename){
        try{
            String txtConteudo;
            txtConteudo = new String(Files.readAllBytes(Paths.get(filename)),StandardCharsets.UTF_8);
            System.out.println("DEBUG --------");
			System.out.println(txtConteudo);
			System.out.println("--------------");
            content = txtConteudo.toCharArray();
            position = 0;
            line = 1;
            column = 0;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public Token nextToken(){
        char currentChar;
        String term = "";
        Token token;
        if(isEOF()){
            return null;
        }
        state = 0;
        while(true){
            currentChar = nextChar();
            column ++;
            switch(state){
                case 0:
                    if(isChar(currentChar)){
                        state = 1;
                        term += currentChar;
                    }else if(isDigit(currentChar)){
                        state = 2;
                        term += currentChar;
                    }else if(isSpace(currentChar)){
                        state = 0;
                    }else if(isOperator(currentChar)){
                        term += currentChar;
                        token = new Token();
                        token.setType(Token.TK_OPERATOR);
                        token.setText(term);
                        token.setLine(line);
                        token.setColumn(column - term.length());
                        return token;
                    }else{
                        throw new EzLexicalException("Unrecognized Symbol.");
                    }
                    	break;
                case 1:
                    if(isChar(currentChar) || isDigit(currentChar)){
                        state = 1;
                        term += currentChar;
                    }else if(isSpace(currentChar) || isOperator(currentChar) || isEOF(currentChar)){
                    		if(!isEOF())
                    			back();
                    		token = new Token();
                    		token.setType(Token.TK_IDENTIFIER);
                    		token.setText(term);
                    		token.setLine(line);
                    		token.setColumn(column - term.length());
                    		return token;
           
                    }else{
                        throw new EzLexicalException("Malformed Indentifier");
                    }
                    break;
                case 2:
                	if(isDigit(currentChar) || currentChar == '.') {
                		state = 2;
                		term += currentChar;
                	}else if(!isChar(currentChar) || isEOF(currentChar)){
                		if(!isEOF(currentChar))
                			back();
	                    token = new Token();
	                    token.setType(Token.TK_IDENTIFIER);
	                    token.setText(term);
	                    token.setLine(line);
	                    token.setColumn(column - term.length());
	                    return token;
	                }else {
	                	throw new EzLexicalException("Unrecognized Number");
	                }
                	break;
            }
        }
    }
    private boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
    private boolean isChar(char c){
        return (c >= 'a' && c <= 'z')||(c >='A' && c <='Z');
    }
    private boolean isOperator(char c){
        return c == '>' || c == '<' || c == '=' || c == '!' || c == '+' || c == '-' || c == '/' || c == '*';
    }
    private boolean isSpace(char c){
    	if(c == '\n' || c == '\r') {
    		line ++;
    		column = 0;
    	}
        return c == ' ' || c == '\t' || c == '\n' || c == '\r';
    }
    private char nextChar(){
    	if(isEOF()){return '\0';}
        return content[position ++];
    }
    private boolean isEOF(){
        return position >= content.length;
    }
    private void back(){
        position--;
    }
    private boolean isEOF(char c) {
    	return c == '\0';
    }
}