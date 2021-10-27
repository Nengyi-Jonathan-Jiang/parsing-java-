package parsing;

import value.*;

public class Parsing {
    public static Parser parser = new Parser();

    public static boolean exec(String s){
        if(s.equals("quit")) return true;

        System.out.println(s);
        Token[] tokens = parser.parse(s);
        System.out.println(List.toString(tokens));
        return false;
    }
}