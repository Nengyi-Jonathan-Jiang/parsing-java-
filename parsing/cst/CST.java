package parsing.cst;

public class CST {
    public String type;
    public CST[] children;
    public CST(String type, CST ...children){
        this.type = type;
        this.children = children;
    }

    public String toString(){
        return this.toString(0);
    }
    public String toString(int depth){
        String indent = "  ".repeat(depth);
        String[] m = (String[])java.util.Arrays.stream(children).map(e -> e.toString(depth + 1)).toArray();
        return indent + "{\n" + indent + "type: " + type + "\n" + String.join("\n", m) + indent + "\n}";
    }

    public static class Leaf<T> extends CST{
        private T value;
        public Leaf(String name, T value){
            super(name);
            this.value = value;
        }

        @Override
        public String toString(int depth){
            return "  ".repeat(depth) + this.value.toString();
        }

        public T value(){return this.value;}
    }
}
