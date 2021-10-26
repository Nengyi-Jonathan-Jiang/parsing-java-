import java.util.*;
import java.util.regex.*;

public class Parsing {
    public static Parser parser = new Parser();
    public static void init(){

    }

    public static boolean exec(String s){
        if(s.equals("quit")) return true;



        System.out.println(s);
        return false;
    }

    public static Iterable<MatchResult> allMatches(final Pattern p, final CharSequence input) {
        return new Iterable<MatchResult>() {
            public Iterator<MatchResult> iterator() {
                return new Iterator<MatchResult>() {
                    // Use a matcher internally.
                    final Matcher matcher = p.matcher(input);
                    // Keep a match around that supports any interleaving of hasNext/next calls.
                    MatchResult pending;

                    public boolean hasNext() {
                        if (pending == null && matcher.find()) pending = matcher.toMatchResult();
                        return pending != null;
                    }

                    public MatchResult next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        MatchResult next = pending;
                        pending = null;
                        return next;
                    }

                    public void remove(){throw new UnsupportedOperationException();}
                };
            }
        };
    }
}

class Parser{

}

class Token{
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
        return "TOKEN<" + name + (value != null ? " " + value : "") + ">";
    }
}

abstract class Value<T1>{
    public final T1 value;
    public Value(T1 value){this.value = value;}
    public T1 value(){return this.value;}

    public static class Number extends Value<Double>{
        public Number(double value){
            super(value);
        }
        public Number(Number n){
            super(n.value());
        }

        public String toString(){
            return value.toString();
        }
    }
    public static class Vector extends Value<Number[]>{
        public Vector(Number ...value){
            super(value);
        }
        public Vector(double ...value){
            super(new Number[value.length]);
            int i = 0;
            for(double v : value) this.value[i++] = new Number(v);
        }
        public Vector(Vector v){
            super(v.value().clone());
        }
        public Vector(List<Number> L){
            super((Number[]) L.value().clone());
        }

        public String toString(){
            StringBuilder s = new StringBuilder("(" + value[0]);
            for(int i = 1; i < value.length; i++) s.append(", " + value[i]);
            return s.toString() + ")";
        }
    }
    public static class List<T extends Value<?>> extends Value<T[]>{
        public List(T[] value){
            super(value);
        }
        public List(Vector v){
            super((T[]) v.value().clone());
        }
        public List(List<?> L){
            super((T[]) L.value().clone());
        }

        public String toString(){
            StringBuilder s = new StringBuilder("[" + value[0]);
            for(int i = 1; i < value.length; i++) s.append(", " + value[i]);
            return s.toString() + "]";
        }
    }
}