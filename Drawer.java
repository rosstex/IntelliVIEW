import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by rteixeira on 6/30/16.
 */
public class Drawer {

    public static Set<Object> watched = new HashSet<>();

    public static void watch(Object obj) {
        watched.add(obj);
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
                Thread.sleep(5);
                for (Object obj : watched) {
                    draw(obj);
                }
            }
        } catch (Exception e) {}
    }

    public static void draw(Object obj) {
        String objType = obj.getClass().getSimpleName();
        switch (objType) {
            case "List":
                drawList((List) obj);
        }
    }

    public static void drawInt(Integer i) {
        System.out.println(i);
    }

    public static void drawString(String i) {

    }

    public static void drawChar(Character i) {

    }

    public static void drawList(List i) {

    }

    public static void main(String[] args) {
    }

    public class Pair {
        Object objectReference;
        String fieldName;
    }
}
