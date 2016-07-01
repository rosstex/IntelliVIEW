import java.util.ArrayList;
import java.util.*;

/**
 * Created by rteixeira on 7/1/16.
 */
public class Runner {

    

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

        ArrayList<Object> big = new ArrayList<>();
        big.add(w);
        big.add(lulz);
        big.add(lulz2);
        big.add("Hello world");
        big.add('!');

        HashSet set = new HashSet<Integer>();
        set.add("Hey");
        set.add("Jude");

        Map vehicles = new HashMap();
        vehicles.put("BMW", 5);
        vehicles.put("Mercedes", 3);
        vehicles.put("Audi", 4);
        vehicles.put("Ford", 10);
        vehicles.put(lulz2, set);

        Queue myQueue = new ArrayDeque();
        myQueue.offer("Monday");
        myQueue.offer("Thursday");
        myQueue.offer("Wednesday");


    }
}
