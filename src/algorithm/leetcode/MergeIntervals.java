package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MergeIntervals {
	public class MyComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval arg0, Interval arg1) {
			return (int) Math.signum(arg0.start - arg1.start);
		}

	}

	public class Interval {
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
	}

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if (intervals.isEmpty()) {
			return res;
		}
		Collections.sort(intervals, new MyComparator());
		res.add(intervals.get(0));
		int j = 0;
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.start > res.get(j).end) {
				res.add(interval);
				j++;
			} else {
				res.get(j).end = interval.end;
			}
		}
		return res;
	}

}
