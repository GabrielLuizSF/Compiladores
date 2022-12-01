package br.com.gabrielluizsf.compiler.syntactic.parser;

import br.com.gabrielluizsf.compiler.lexer.EdenZeroLexer;
import br.com.gabrielluizsf.compiler.lexer.tokens.Token;
import br.com.gabrielluizsf.compiler.syntactic.exceptions.SyntacticExceptions;

public class EzParser {
	
	private EdenZeroLexer lexer;
	private Token         token;
	
	public  EzParser(EdenZeroLexer lexer) {
		this.lexer = lexer;
	}
	public void E() {
		T();
		El();
		
	}
	public void El() {
		token = lexer.nextToken();
		if(token != null) {
		   OP();
		   T();
		   El();
		}
	}
	public void T() {
		token = lexer.nextToken();
		if(token.getType() != Token.TK_IDENTIFIER && token.getType() != Token.TK_NUMBER) {
			throw new SyntacticExceptions("ID or Number Expected!, found "+Token.TK_TEXT[token.getType()]+" ("+token.getText()+") at line "+token.getLine()+" and column "+token.getColumn());
		}
	}
	public void OP() {
		if(token.getType() != Token.TK_OPERATOR) {
			throw new SyntacticExceptions("Operator Expected, found "+Token.TK_TEXT[token.getType()]+" ("+token.getText()+") at line "+token.getLine()+" and column "+token.getColumn());
		}
	}
	
}
