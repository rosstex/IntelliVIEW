/**
 * Created by swathugala on 6/30/16.
 */
import java.util.List;
import java.util.ArrayList;

// Currently, can draw Lists and Arrays, and can otherwise convert things toString and draw their Strings.
// More complicated data structures perhaps could be better displayed by graphviz and the like...
// Update: graphviz can be called from java but outputs things into a file rather than into java.

public abstract class Drawable implements DrawableInterface{

    private static Drawable toDrawable(List l, int border) {
        return new DrawableList(l, border);
    }

    public static Drawable toDrawable(Object o) {
        return new DrawableString(o.toString());
    }

    public static Drawable toDrawable(Object o, int border) {
        if (o instanceof List) {
            return Drawable.toDrawable((List) o, border);
        } else if (o.getClass().isArray()) {
            return new DrawableList(convertToArrayList((Object[]) o), border);
        }
        else {
            System.out.println("I'm not iterable.");
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
    }
}