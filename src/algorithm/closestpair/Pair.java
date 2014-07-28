package algorithm.closestpair;

public class Pair {
	public Point start;
	public Point end;
	public double distance;
	
	
	public Pair(Point start, Point end){
		this.start = start;
		this.end = end;
	}
	
	public void updateDistance(){
		if (start == null || end == null){
			distance = Double.MAX_VALUE;
		} else {
			distance =  Math.sqrt((start.x - end.x) * (start.x - end.x) + (start.y - end.y) * (start.y - end.y));
		}
	}

	public String toString(){
		return String.format("start=%s end=%s distance=%f", start, end, distance);
	}
}