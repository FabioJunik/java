public class AbsoluteValueComparator implements Comparable<MyPoint2D>{
    public int compareTo(MyPoint2D p1, MyPoint2D p2) {
        double absX1 = Math.abs(p1.getX());
        double absX2 = Math.abs(p2.getX());
        double absY1 = Math.abs(p1.getY());
        double absY2 = Math.abs(p2.getY());

        int compareX = Double.compare(absX1,absX2);
        if(compareX != 0){
            return compareX;
        }

        return Double.compare(absY1,absY2);
    }

    @Override
    public int compareTo(MyPoint2D o) {
        return 0;
    }
}
