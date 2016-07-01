import java.util.*;

/**
 * Created by swathugala on 7/1/16.
 * Will be like a list, but no lines between boxes.
 */
public class DrawableSet extends Drawable {

    Map<Drawable, Double> elements = new HashMap<Drawable, Double>();
    double height;
    double width;
    double border;

    public DrawableSet(Set set, int b) {
        height = 0;
        b = b * 10;
        this.border = b / 512.0;
        width = border;
        for (Object o : set) {
            Drawable d = Drawable.toDrawable(o, b);
            elements.put(d, width);
            width += d.getWidth() + border;
            height = Double.max(height, border + border + d.getHeight());
        }
    }

    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    public boolean draw(double x, double y) {
        for (Map.Entry<Drawable, Double> entry : elements.entrySet()) {
            Drawable d = entry.getKey();
            d.draw(x + entry.getValue(), y + border);
        }

        double half_width = width / 2.0;
        double half_height = height / 2.0;
        double center_x = x + (half_width);
        double center_y = y + (half_height);
        StdDraw.rectangle(center_x, center_y, half_width, half_height);


        return true;
    }

    public static void main (String[] args) {
    }
}
