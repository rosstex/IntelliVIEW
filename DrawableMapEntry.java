/**
 * Created by swathugala on 7/1/16.
 */

import java.util.Map;

// Just draws them on top of each other.
// Box -- draws a drawable, then puts a rectangle around.
// But here, draw two drawables and then draw two rectangles... don't extend.
// But do use!
public class DrawableMapEntry extends Drawable{
    Box key;
    Box value;
    double height;
    double width;
    double border;



    public DrawableMapEntry(Map.Entry entry, int border) {
        key = new Box(entry.getKey(), border);
        value = new Box(entry.getValue(), border);

        height = key.getHeight() + value.getHeight();
        width = Double.max(key.getWidth(), value.getWidth());

        key.resetWidth(width);
        value.resetWidth(width);

        this.border = border / 512.0;
    }

    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    public boolean draw(double x, double y) {
        //Draw value:
        value.draw(x, y);
        //Draw key:
        key.draw(x, y + value.getHeight());
        return true;
    }
}
