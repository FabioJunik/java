public class MyPoint2D implements Comparable<MyPoint2D>{
        private double x;
        private double y;

        public MyPoint2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double distanceToOrigin() {
            return Math.sqrt(x*x + y*y);
        }

        @Override
        public String toString() {
            return "["+x +","+y+"]";
        }

        @Override
        public int compareTo(MyPoint2D o) {
            return Double.compare(this.distanceToOrigin(), o.distanceToOrigin());
        }


}
