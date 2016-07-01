import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by rteixeira on 6/30/16.
 */
public class Drawer {

//    public static Set<Object> watched = new HashSet<>();
    public static DrawerHelper p = new DrawerHelper(new HashSet<>());

    public static void watch(Object obj) {
        p.watched.add(obj);
    }

    static {
        try {
            Thread x = new Thread(new Runnable() {
                @Override
                public void run() {
                    Drawer.continuousWatching();
                }
            });
            x.start();
        } catch (Exception e) {

        }
    }

    public static void continuousWatching() {
        try {
            while (true) {
                Thread.sleep(1000);
                p.draw();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {


        ArrayList a = new ArrayList();
        for (int i = 0; i < 5; i++) {
            a.add(i);
        }

        /*

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

        ArrayList<Object> big = new ArrayList<>();
        big.add(w);
        big.add(lulz);
        big.add(lulz2);
        big.add("Hello world");
        big.add('!');

        HashSet set = new HashSet<Integer>();
        set.add("Hey");
        set.add("Jude");

        Map vehicles = new TreeMap();
        vehicles.put("BMW", 5);
        vehicles.put("Mercedes", 3);
        vehicles.put("Audi", 4);
        vehicles.put("Ford", 10);
//        vehicles.put(lulz2, set);

        Queue myQueue = new ArrayDeque();
        myQueue.offer("Monday");
        myQueue.offer("Thursday");
        myQueue.offer("Wednesday");

        HashSet woo = new HashSet();

        woo.add(set);

        woo.add(al);
        woo.add(ll);
        woo.add(s);
        woo.add(w);
        woo.add(lulz);
        woo.add(lulz2);
        woo.add("Hello world");
        woo.add('!');

        woo.add(big);

        woo.add(myQueue);

        woo.add(vehicles);*/

//        for (Object hm : woo) {
//            watch(hm);
//        }
    }
}
