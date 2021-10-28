package parsing;

import value.*;

public class Parsing {
    private static Lexer lexer = new Lexer();

    public static boolean exec(String s){
        if(s.equals("quit")) return true;

        System.out.println(s);
        Token[] tokens = lexer.parse(s);
        System.out.println(List.toString(tokens));
        return false;
    }
}