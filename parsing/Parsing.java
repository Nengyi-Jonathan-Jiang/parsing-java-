package parsing;

import value.*;

public class Parsing {
    private static Lexer lexer = new Lexer();

    public static boolean exec(String s){
        if(s.equals("quit")) return true;

        Token[] tokens = lexer.parse(s);
        if(tokens.length > 0) System.out.println(List.toString(tokens));
        else System.out.println(s);
        return false;
    }
}