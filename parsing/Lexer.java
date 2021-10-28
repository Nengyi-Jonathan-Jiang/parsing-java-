package parsing;

import java.util.*;
import java.util.regex.*;
import util.*;

public class Lexer{
    private static class TokenRule{
        public String regex, tokenName;
        public boolean keepValue;
        private TokenRule(String regex, String tokenName, boolean keepValue){
            this.regex = regex; this.tokenName = tokenName; this.keepValue = keepValue;
        }
    }
    private final Vector<TokenRule> rules = new Vector<>();
    public void addRule(String regex, String tokenName, boolean keepValue){
        this.rules.add(new TokenRule(regex, tokenName, keepValue));
    }
    private Pattern re = Pattern.compile("");

    public Lexer(){
        //Grouping
        addRule("L_PARENTHESES", "\\(", false);
        addRule("R_PARENTHESES", "\\)", false);
        addRule("L_BRACKET",     "\\[", false);
        addRule("R_BRACKET",     "\\]", false);
        addRule("L_BRACE",       "\\{", false);
        addRule("R_BRACE",       "\\}", false);

        //Seperators
        addRule("COMMA",     ",", false);
        addRule("SEMICOLON", ";", false);

        //Operators
        addRule("ADD", "\\+", false);
        addRule("SUB", "-",   false);
        addRule("MUL", "\\*", false);
        addRule("DIV", "/",   false);
        addRule("POW", "\\^", false);
        addRule("MOD", "%",   false);
        addRule("EQL", "=",   false);
        // addRule("AND", "&",   false);
        // addRule("OR",  "|",   false);

        //Numbers and variables
        addRule("NUM", "\\d+\\.?|\\d*\\.\\d+",      true);
        addRule("IDT", "[a-zA-Z]+", true);
    }

    public void reCompilePattern(){
        StringBuilder sb = new StringBuilder();
        for(TokenRule tk : rules){
            sb.append("(" + tk.regex + ")|");
        }
        sb.deleteCharAt(sb.length() - 1);
        re = Pattern.compile(sb.toString());
    }

    public Token[] parse(String s){
        Vector<Token> tkList = new Vector<Token>();
        for(MatchResult m : Util.allMatches(re, s)){
            //Token
        }
        return new Token[]{new Token("NOTHING")};
    }
}