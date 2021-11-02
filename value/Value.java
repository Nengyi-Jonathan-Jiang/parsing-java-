package value;

public class Value<T1>{
    public final T1 value;
    public Value(T1 value){this.value = value;}
    public String toString(){
        return "VALUE{" + value + "}";
    }
}