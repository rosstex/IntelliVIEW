/**
 * Created by swathugala on 6/30/16.
 */
public interface DrawableInterface {

    double getHeight();
    double getWidth();

    /* Return true if draw succeeds; false otherwise. */
    /* Needs to know location on canvas. */
    boolean draw(double x, double y);
}
