package value;

public abstract class Value<T1>{
    public final T1 value;
    protected Value(T1 value){this.value = value;}
    public abstract String toString();
}