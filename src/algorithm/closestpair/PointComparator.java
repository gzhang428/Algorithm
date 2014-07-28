package algorithm.closestpair;

import java.util.Comparator;

public class PointComparator implements Comparator<Point> {
	String sortDimension;

	public PointComparator(String sortDimension) {
		this.sortDimension = sortDimension;
	}

	@Override
	public int compare(Point p0, Point p1) {
		if (sortDimension.equals("x")){
			return (int) Math.signum(p0.x - p1.x);
		} else {
			return (int) Math.signum(p0.y - p1.y);
		}
	}

}
