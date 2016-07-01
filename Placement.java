/**
 * Created by swathugala on 6/30/16.
 */

import java.util.*;

public class Placement {
    Set watched;

    // Set by private variables StdDraw.width and StdDraw.height
    // Tempted to change StdDraw to make these adjustable.
    int SCREEN_END_x = 502;
    int SCREEN_END_y = 600;

    int INTERNAL_BORDER = 2;
    int EXTERNAL_BORDER = 10;

    int moving_x;
    int moving_y;
    int max_height;

    public Placement(Set watched) {
        this.watched = watched;
    }

    public void draw() {

        StdDraw.setCanvasSize(SCREEN_END_x + EXTERNAL_BORDER, SCREEN_END_y + EXTERNAL_BORDER);

        this.moving_x = EXTERNAL_BORDER;
        this.moving_y = EXTERNAL_BORDER;
        this.max_height = 0;
        for (Object o : watched) {
            draw(o);
        }
    }

    private boolean draw(Object o) {

        Drawable d = Drawable.toDrawable(o, INTERNAL_BORDER);
        int pixelWidth = toPixels(d.getWidth());
        int pixelHeight = toPixels(d.getHeight());
        int end_x = moving_x + pixelWidth;

        int temp_y = moving_y + pixelHeight;

        if (pixelWidth > SCREEN_END_x || temp_y > SCREEN_END_y) {
//            throw new UnsupportedOperationException("Object " + o.toString() + " too large to print.");
            System.out.println("Object " + o.toString() + " will not fit in screen.");
            return false;
        }

        if (end_x <= SCREEN_END_x) {
            d.draw(toFraction(moving_x), toFraction(moving_y));
            moving_x = end_x + EXTERNAL_BORDER;
            max_height = Integer.max(max_height, pixelHeight);
            return true;
        } else {
            moving_x = EXTERNAL_BORDER;
            moving_y += max_height + EXTERNAL_BORDER;
            max_height = EXTERNAL_BORDER;
            return draw(o);
        }

    }

    private int toPixels(double f) {
        return (int) (f * 512);
    }

    private double toFraction(int p) {
        return p / 512.0;
    }

    public static void main(String[] args) {


        ArrayList<Integer> al = new ArrayList<Integer>();
        LinkedList<Integer> ll = new LinkedList<Integer>() ;
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < 10; ++i) {
            s.push(i);
            al.add(i);
            ll.add(i);
        }

        ArrayList<List> w = new ArrayList<List>();
        w.add(s);
        w.add(al);

        boolean lulz = true;
        Integer[] lulz2 = {1, 2, 3};

        HashSet woo = new HashSet();
        woo.add(al);
        woo.add(ll);
        woo.add(s);
        woo.add(w);
        woo.add(lulz);
        woo.add(lulz2);
        woo.add("Hello world");
        woo.add('!');

        ArrayList<Object> big = new ArrayList<>();
        big.add(w);
        big.add(lulz);
        big.add(lulz2);
        big.add("Hello world");
        big.add('!');
        woo.add(big);

        HashSet set = new HashSet<Integer>();
        set.add("Hey");
        set.add("Jude");
        woo.add(set);


        Map vehicles = new HashMap();
        vehicles.put("BMW", 5);
        vehicles.put("Mercedes", 3);
        vehicles.put("Audi", 4);
        vehicles.put("Ford", 10);
        vehicles.put(lulz2, set);

        woo.add(vehicles);


        Queue myQueue = new ArrayDeque();
        myQueue.offer("Monday");
        myQueue.offer("Thusday");
        myQueue.offer("Wednesday");
        woo.add(myQueue);

        Placement p = new Placement(woo);
        p.draw();

//        System.out.println("Total vehicles: " + vehicles.size());

    }
}
