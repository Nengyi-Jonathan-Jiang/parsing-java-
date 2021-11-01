package parsing;

import parsing.cst.CST;

public class Parser {
    public Parser(){
        //
    }
    public CST parse(Token[] tokens){
        return new CST("root", new CST.Leaf<String>("String","value1"));
    }
}
