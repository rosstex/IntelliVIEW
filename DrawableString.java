/**
 * Created by swathugala on 6/30/16.
 */
import java.awt.*;


public class DrawableString extends Drawable {

    String str;

    private Font defaultFont = StdDraw.getFont();
    private FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(defaultFont);
    private double height = fontMetrics.getHeight() / 512.0;

    private double width = 0;

    public DrawableString(String s) {
        str = s;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        if (width == 0) {
            String s = str;
            this.width = fontMetrics.stringWidth(s) / 512.0;
        }
        return width;
    }

    public boolean draw(double x, double y) {
        y = y + ( height / 2.0 );
        StdDraw.textLeft(x, y, str);
        return true;
    }

    public static void main(String[] args) {
        new DrawableString("Hello world").draw(0.5, 0.5);
    }
}
