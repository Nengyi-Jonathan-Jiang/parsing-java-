package value;

public class Number extends Value<Double>{
    public Number(double value){
        super(value);
    }
    public Number(Number n){
        super(n.value);
    }

    public String toString(){
        return value.toString();
    }
}