import java.util.*;
import java.util.regex.*;

public class Parsing {
    private static Pattern pattern = Pattern.compile("", 0);
    public static boolean exec(String s){
        if(s.equals("quit")) return true;

        for(MatchResult match : allMatches(pattern, s)){
            
        }

        System.out.println(s);
        return false;
    }

    public static Iterable<MatchResult> allMatches(final Pattern p, final CharSequence input) {
        return new Iterable<MatchResult>() {
            public Iterator<MatchResult> iterator() {
                return new Iterator<MatchResult>() {
                    final Matcher matcher = p.matcher(input);
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

                    @Override
                    public void remove(){throw new UnsupportedOperationException();}
                };
            }
        };
    }
}

class Token{
    public static final int LITERAL_TOKEN = 1;
    public static final int PRE_UNARY_OPERATOR_TOKEN = 2;
    public static final int POST_UNARY_OPERATOR_TOKEN = 4;
    public static final int BINARY_OPERATOR_TOKEN = 8;
    public static final int IDENTIFIER_TOKEN = 16;

    public String name;
    public String pattern;
    public Value value;

}

interface Value{}

class ValNumber implements Value{
    public final double val;
    public ValNumber(double val){this.val = val;}
}

class ValVector implements Value{
    public final Number[] vals;
    public ValVector(Number[] vals){
        this.vals = vals;
    }

    public ValVector(double ...vals){
        this.vals = new Number[vals.length];
        for(int i = 0; i < vals.length; i++) this.vals[i] = new Number(vals[i]);
    }
}

class ValList<T extends Value> implements Value{
    public final List<T> vals;
    public ValList(T[] vals){
        this.vals = new ArrayList<T>();
    }
}