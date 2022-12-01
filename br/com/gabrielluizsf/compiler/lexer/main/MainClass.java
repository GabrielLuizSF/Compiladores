package br.com.gabrielluizsf.compiler.lexer.main;

import br.com.gabrielluizsf.compiler.lexer.exceptions.EzLexicalException;
import br.com.gabrielluizsf.compiler.lexer.EdenZeroLexer;
import br.com.gabrielluizsf.compiler.lexer.tokens.Token;
import br.com.gabrielluizsf.compiler.syntactic.exceptions.SyntacticExceptions;
import br.com.gabrielluizsf.compiler.syntactic.parser.EzParser;

public class MainClass{
    public static void main(String[] args){
        try {
            
        	EdenZeroLexer ezl = new EdenZeroLexer("input.ezl");
            EzParser      ezp = new EzParser(ezl);
            
            ezp.E();
            System.out.println("Compilation Successfully");
        }
    catch(EzLexicalException ex){
        System.out.println("LEXICAL ERROR: "+ex.getMessage());
        
    }
   catch(SyntacticExceptions ex) {
	   System.out.println("SYNTAX ERROR:"+ex.getMessage());
   }
   catch(Exception ex){
        System.out.println("Generic ERROR: "+ex.getClass().getName());
   }
 
    }
}