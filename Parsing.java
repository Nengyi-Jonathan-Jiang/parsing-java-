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

class Token{
    private int LITERAL_TOKEN = 1;
    private int PRE_UNARY_OPERATOR_TOKEN = 2;
    private int POST_UNARY_OPERATOR_TOKEN = 4;
    private int BINARY_OPERATOR_TOKEN = 8;
    private int IDENTIFIER_TOKEN = 16;
    
}