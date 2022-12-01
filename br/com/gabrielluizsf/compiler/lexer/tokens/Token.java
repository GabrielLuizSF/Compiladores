package br.com.gabrielluizsf.compiler.lexer.tokens;

public class Token{

    public static final int 	TK_IDENTIFIER  = 0;
    public static final int 	TK_NUMBER      = 1;
    public static final int 	TK_OPERATOR    = 2;
    public static final int 	TK_PONCTUATION = 3;
    public static final int 	TK_ASSIGN      = 4;
    public static final String 	TK_TEXT[] = {
    		"IDENTIFIER", "NUMBER", "OPERATOR", "PONCTUATION", "ASSIGN"
    };

    private int type;
    private int line;
    private int column;
    private String text;
    

    public Token( int type, String text){
        super();
        this.type = type;
        this.text = text;
    }
    public Token(){
        super();
    }

    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    public int getLine(){
        return line;
    }
    public void setLine(int line){
        this.line = line;
    }
    public int getColumn(){
        return column;
    }
    public void setColumn(int column){
        this.column = column;
    }
    public String getText(){
        return text;
    }
    public void setText(String term){
        this.text = term;
    }
    @Override
    public String toString() {
    	return "Token [type="+ type +",text="+ text +"]";
    }
}