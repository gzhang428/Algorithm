package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class InsertInterval {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
		
		public String toString(){
			return String.format("[%d, %d]", start, end);
		}
	}

	public static void main(String[] args) {
		Interval newInterval = new Interval(2, 3);;
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		new InsertInterval().insert(intervals , newInterval );
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		for (Iterator<Interval> it = intervals.iterator(); it.hasNext();) {
			Interval p = it.next();
			if (newInterval.end < p.start) {
				break;
			}
			if (newInterval.start > p.end) {
				i++;
				continue;
			}
			if (newInterval.start >= p.start && newInterval.start <= p.end) {
				newInterval.start = p.start;
			}
			if (newInterval.end >= p.start && newInterval.end <= p.end) {
				newInterval.end = p.end;
			}
			it.remove();
		}
		intervals.add(i, newInterval);
		return intervals;
	}
}
