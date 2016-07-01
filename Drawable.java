/**
 * Created by swathugala on 6/30/16.
 */
import groovy.util.MapEntry;

import java.util.*;

// Currently, can draw Lists and Arrays, and can otherwise convert things toString and draw their Strings.
// More complicated data structures perhaps could be better displayed by graphviz and the like...
// Update: graphviz can be called from java but outputs things into a file rather than into java.

public abstract class Drawable implements DrawableInterface{

    private static Drawable toDrawable(List l, int border) {
        return new DrawableList(l, border);
    }

    private static Drawable toDrawable(Object o) {
        return new DrawableString(o.toString());
    }

    public static Drawable toDrawable(Object o, int border) {
        if (o instanceof List) {
            return Drawable.toDrawable((List) o, border);
//        } else if (o.getClass().isArray()) {

        } else if (o instanceof Map.Entry) {
            return new DrawableMapEntry((Map.Entry) o, border);
        } else if (o instanceof Map) {
            return new DrawableList(new ArrayList<Map.Entry>(((Map) o).entrySet()), border);
        } else if (o instanceof Set) {
            return new DrawableSet((Set) o, border);
        } else if (o instanceof Queue) {
            return new DrawableList(new ArrayList((Queue) o), border);
        } else if (o instanceof Object[]) {
            return new DrawableList(convertToArrayList((Object[]) o), border);
        }
        else {
            return Drawable.toDrawable(o);
        }
    }

    private static ArrayList convertToArrayList(Object[] it) {
        ArrayList toReturn = new ArrayList();
        for (Object o : it) {
            toReturn.add(o);
        }
        return toReturn;
    }

    public static void main(String[] args) {
        boolean lulz = true;
        Integer[] lulz2 = {1, 2, 3};
        toDrawable(lulz).draw(0.4,0.4);
        toDrawable(lulz2, 1).draw(0.5,0.5);

        // So far I can't figure out how to make this work because
        // 0) even though o.getClass().isArray() returns true, I
        // 1) can't cast int[] as Object[]
        // 2) can't cast int[] as Iterable
        // 3) can't iterate through something that isn't iterable.
        int[] yo = {1, 2, 4};
        toDrawable(yo, 3).draw(0.7,0.4);
    }
}