package algorithm.interview;

public class JumpRiver {

	public static void main(String[] args) {
		int[] river = {1,1,1,0,1,1,0,0};
		int res = new JumpRiver().jump(river);
		System.out.println(res);
	}
	
	public int jump(int[] river){
		return jump(river, 0, 1, 0);
	}

	private int jump(int[] river, int pos, int speed, int step) {
		if (pos >= river.length){
			return step; 
		}
		int min = Integer.MAX_VALUE;
		if ((pos + speed < river.length && river[pos + speed] == 1) || (pos + speed >= river.length)){
			int step1 = jump(river, pos + speed, speed, step + 1);
			min = Math.min(min, step1);
		}
		if ((pos + speed + 1< river.length &&river[pos + speed + 1] == 1) || (pos + speed + 1 >= river.length)){
			int step2 = jump(river, pos + speed + 1, speed + 1, step + 1);
			min = Math.min(min, step2);
		}
		return min;
	}

}
