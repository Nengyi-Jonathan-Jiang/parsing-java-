package parsing;

import parsing.cst.CST;
import value.*;

public class Parser {
    public Parser(){
        //implememt parsing algorithm
    }

    @SuppressWarnings("unused")
    public CST parse(Token[] tokens){
        return CST.make("root",
            CST.make(new Value<String>("value1")),
            new CST("add",
                CST.make(2.5),
                CST.make(3.14,2.343)
            ),
            new CST("div",
                new CST("add",
                    CST.make(new Vector(0),new Vector(1,2),new Vector(1,2,3)),
                    CST.make(3.14,2.343)
                ),
                CST.make("Hmmm...")
            )
        );
    }
}
