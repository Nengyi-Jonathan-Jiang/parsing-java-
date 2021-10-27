package value;

public class Vector extends Value<Number[]>{
    public Vector(Number ...value){
        super(value);
    }
    public Vector(double ...value){
        super(new Number[value.length]);
        int i = 0;
        for(double v : value) this.value[i++] = new Number(v);
    }
    public Vector(Vector v){
        super(v.value.clone());
    }
    public Vector(List<Number> L){
        super((Number[]) L.value.clone());
    }

    public String toString(){
        StringBuilder s = new StringBuilder("(" + value[0]);
        for(int i = 1; i < value.length; i++) s.append(", " + value[i]);
        return s.toString() + ")";
    }
}