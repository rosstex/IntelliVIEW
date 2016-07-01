/**
 * Created by swathugala on 6/30/16.
 */
class Box extends Drawable {

        Drawable ant;

        double height;
        double width;
        double border;

        public Box(Object o, int border) {
            this(Drawable.toDrawable(o, border), border);
        }


        private Box(Drawable d, int border) {
            this.ant = d;
            double extra = ( 2 * border ) / 512.0;
            this.height = ant.getHeight() + extra;
            this.width = ant.getWidth() + extra;

            this.border = border / 512.0;
        }

        // For use in lists!
        public void resetHeight(double newHeight) {
            assert newHeight >= height;
            height = newHeight;
        }

        // For use in maps!
        public void resetWidth(double newWidth) {
            assert newWidth >= width;
            width = newWidth;
        }

        public double getHeight() {
            return height;
        }
        public double getWidth() {
            return width;
        }

        public boolean draw(double x, double y) {
            double half_width = width / 2.0;
            double half_height = height / 2.0;
            double center_x = x + (half_width);
            double center_y = y + (half_height);

            ant.draw(x + border, y + border);

            StdDraw.rectangle(center_x, center_y, half_width, half_height);

            return true;
        }

        public static void main (String[] args) {
            Box test = new Box(new DrawableString("hello"), 5);
            test.draw(0.3,0.3);
            test = new Box(new DrawableString("hello"), 15);
            test.draw(0.3,0.2);
            test = new Box(new DrawableString("world"), 10);
            test.draw(0.2,0.5);
            test = new Box((3), 10);
            test.draw(0.1,0.5);

            test = new Box((3), 10);
            test.draw(0,0);

            test = new Box(('!'), 22);
            test.draw(0.9,0.9);
        }

    }
