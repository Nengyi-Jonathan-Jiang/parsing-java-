package value;

public class List<T extends Value<?>> extends Value<T[]>{
    public List(T[] value){
        super(value);
    }
    
    @SuppressWarnings("unchecked")
    public List(Vector v){
        super((T[]) v.value.clone());
    }
    
    @SuppressWarnings("unchecked")
    public List(List<?> L){

        super((T[]) L.value.clone());
    }

    public String toString(){
        StringBuilder s = new StringBuilder("[" + value[0]);
        for(int i = 1; i < value.length; i++) s.append(", " + value[i]);
        return s.toString() + "]";
    }

    public static <V> String toString(V[] arr){
        StringBuilder s = new StringBuilder("[" + arr[0]);
        for(int i = 1; i < arr.length; i++) s.append(", " + arr[i]);
        return s.toString() + "]";
    }
}
