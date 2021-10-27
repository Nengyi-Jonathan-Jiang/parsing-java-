package parsing;

import java.util.*;
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
    private void addRule(String regex, String tokenName, boolean keepValue){
        this.rules.add(new TokenRule(regex, tokenName, keepValue);
    }

    public Lexer(){
        //Grouping
        addRule("LEFT_PARENTHESES",     "\\(",      false);
        addRule("RIGHT_PARENTHESES",    "\\)",      false);
        addRule("LEFT_BRACKET",         "\\[",      false);
        addRule("RIGHT_BRACKET",        "\\]",      false);

        //Comma
        addRule("COMMA", ",", false);
        
        //Numbers and variables
        addRule("NUMBER",     "\\d+|\\d*\\.\\d+",          true);
        addRule("IDENTIFIER", "[a-zA-Z]|[a-zA-Z]_[_\\w]*", false);
    }

    public Token[] parse(String s){
        return new Token[]{new Token("NOTHING")};
    }
}