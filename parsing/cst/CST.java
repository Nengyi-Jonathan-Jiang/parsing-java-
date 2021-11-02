package parsing.cst;

import value.*;
import value.Number;

public class CST {
    private static final String INDENT = "    ";

    public static CST make(String type, CST ...children){
        return new CST(type,children);
    }
    public static <T extends Value<?>> Leaf<T> make(T value){
        return new Leaf<>(value);
    }
    
    @SafeVarargs
    public static <T extends Value<?>> Leaf<List<T>> make(T ...value){
        return new Leaf<>(new List<>(value));
    }
    public static Leaf<Number> make(double value){
        return new Leaf<>(new Number(value));
    }
    public static Leaf<Vector> make(double ...value){
        return new Leaf<>(new Vector(value));
    }
    public static <T> Leaf<Value<T>> make(T value){
        return new Leaf<>(new Value<>(value));
    }

    private String type;
    private CST[] children;
    public CST(String type, CST ...children){
        this.type = type;
        this.children = children;
    }

    public String toString(){return this.toString(0);}

    public String toString(int depth){
        String indent = INDENT.repeat(depth);
        StringBuilder sb = new StringBuilder(indent + "{\n" + indent + INDENT + "type: " + type);
        for(CST c : children) sb.append("\n" + c.toString(depth + 1));
        sb.append("\n" + indent + "}");
        return sb.toString();
    }

    public static class Leaf<T extends Value<?>> extends CST{
        private T value;
        public Leaf(T value){
            super("");
            this.value = value;
        }

        @Override
        public String toString(int depth){
            return INDENT.repeat(depth) + "{" + this.value.toString() + "}";
        }

        public T value(){return this.value;}
    }
}