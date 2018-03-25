import java.util.Comparator;

public class Point2D {
    public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();


    private final double x;
    private final double y;
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    private class PolarOrder implements Comparator<Point2D> {
        public int compare(Point2D q1, Point2D q2){
            double dx1 = q1.x - x;
            double dx2 = q2.y - y;

//            if (dy1 == 0 && dy2)
            //TODO not finished
            return 0;
        }
    }

    public int counterClockWise(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x - a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
        if      (area2 < 0) return -1; // clockwise
        else if (area2 > 0) return 1;  // counter-clockwise
        else return 0; // collinear

    }
}

