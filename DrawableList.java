/**
 * Created by swathugala on 6/30/16.
 */
import java.util.List;
import java.util.Map;
import java.util.HashMap;

//for main:
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class DrawableList extends Drawable {

    Map<Box, Double> boxes = new HashMap<Box, Double>();
    double height;
    double width;

    public DrawableList(List list, int border) {
        height = 0;
        width = 0;
        for (Object o : list) {
            Box b = new Box(o, border);
            boxes.put(b, width);
            width += b.getWidth();
            height = Double.max(height, b.getHeight());
        }
    }

    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    public boolean draw(double x, double y) {
        for (Map.Entry<Box, Double> entry : boxes.entrySet()) {
            Box b = entry.getKey();
            b.resetHeight(height);
            b.draw(x + entry.getValue(), y);
        }
        return true;
    }

    public static void main (String[] args) {

        ArrayList<Integer> al = new ArrayList<Integer>();
        LinkedList<Integer> ll = new LinkedList<Integer>() ;
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < 10; ++i) {
            s.push(i);
            al.add(i);
            ll.add(i);
        }

        s.push(100);

        DrawableList AL = new DrawableList(al, 2);
        DrawableList LL = new DrawableList(ll, 15);
        DrawableList S = new DrawableList(s, 10);

        AL.draw(0.1, 0.1);
        LL.draw(0.2, 0.2);
        S.draw(0.3, 0.3);

        ArrayList<List> w = new ArrayList<List>();
        w.add(s);
        w.add(al);
        DrawableList W = new DrawableList(w, 5);
        W.draw(0, 0.5);
    }

}
