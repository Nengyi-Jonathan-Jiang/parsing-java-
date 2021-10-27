package parsing;

public class Token{
    public final String name;
    public final String value;

    public Token(String name){
        this.name = name;
        this.value = null;
    }
    public Token(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String toString(){
        return "<" + name + (value != null ? " " + value : "") + ">";
    }
}