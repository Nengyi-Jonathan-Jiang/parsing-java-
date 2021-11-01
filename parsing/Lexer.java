package parsing;

import java.util.*;
import java.util.regex.*;
import util.*;

//Sample input:
//f := (($x,$y) -> (g(#x,#5) + h * [34,6][3] + (5,4) * 4 + 5))(8,9)

public class Lexer{
    private static class TokenRule{
        private String regex, tokenName;
        private boolean keepValue;
        private TokenRule(String tokenName, String regex, boolean keepValue){
            this.regex = regex; this.tokenName = tokenName; this.keepValue = keepValue;
        }
    }
    private final List<TokenRule> rules = new LinkedList<>();
    public void addRule(String regex, String tokenName, boolean keepValue){
        this.rules.add(new TokenRule(regex, tokenName, keepValue));
    }
    private Pattern re = Pattern.compile("");

    public Lexer(){
        //NUM
        addRule("NUM", "\\d*\\.\\d+|\\d+\\.?", true);
        //IDT
        addRule("IDT", "[a-zA-Z]+",            true);
        //ASGNEQ
        addRule("ASGNEQ", "[\\^*/%+\\-:]=",    true);
        addRule("ARROW", "->",    false);

        addRule("OTHER", "[^ ]", true);

        reCompilePattern();
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
        List<Token> tkList = new LinkedList<>();
        for(MatchResult m : Util.allMatches(re, s.strip())){
            TokenRule tkr = null;
            String group = "UNDEFINED_VALUE";
            for(int i = 0; i < rules.size(); i++){
                if((group = m.group(i + 1)) != null){
                    tkr = rules.get(i);
                    break;
                }
            }
            if(tkr == null) tkList.add(new Token(group,group));
            else if(tkr.keepValue) tkList.add(new Token(tkr.tokenName, group));
            else tkList.add(new Token(tkr.tokenName));
        }
        return tkList.toArray(new Token[]{});
    }
}