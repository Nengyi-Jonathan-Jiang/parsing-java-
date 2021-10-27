package util;
import java.util.*;
import java.util.regex.*;

public class Util{
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