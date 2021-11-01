package parsing.ast;

public class AST {
    public String type;
    public AST[] children;
    public AST(String type, AST ...children){
        this.type = type;
        this.children = children;
    }
    public static class Leaf<T> extends AST{
        public T value;
        public Leaf(String name, T value){
            super(name);
            this.value = value;
        }
    }
}
