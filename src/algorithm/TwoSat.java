package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TwoSat {
	Random r = new Random();
	public class Constrain {
		int v1;
		boolean p1;
		int v2;
		boolean p2;
		
		public Constrain(int v1, boolean p1, int v2, boolean p2){
			this.v1 = v1;
			this.p1 = p1;
			this.v2 = v2;
			this.p2 = p2;
		}
	}

	public static void main(String[] args) {
		TwoSat twoSat = new TwoSat();
		String file = "D:/2sat6.txt";
		twoSat.preprocess(file);
		
		Constrain[] constrains = twoSat.getConstrains(file);
		int n = 1000000;
		
		boolean res = twoSat.isSat(n, constrains);
		System.out.println(res);
	}

	private boolean isSat(int n, Constrain[] constrains) {
		for (int i = 0; i < Math.log(n) / Math.log(2); i++){
			boolean res = isSat1(n ,constrains);
			System.out.println(i + ": " + res);
			if (res){
				return true;
			}
		}
		
		return false;
	}

	private boolean isSat1(int n, Constrain[] constrains) {
		boolean[] assignments = getRandomAssignments(n);
		for (long i = 0; i < 2 * (long) n * n; i++){
			List<Integer> unsatisfiedAssignments = getUnsatisfiedAssignments(assignments, constrains);
			if (unsatisfiedAssignments.isEmpty()){
				return true;
			} else {
				int flipIndex = getRandomFlipIndex(unsatisfiedAssignments);
				assignments[flipIndex] = !assignments[flipIndex];
			}
		}
		
		return false;
	}

	private int getRandomFlipIndex(List<Integer> unsatisfiedAssignments) {
		int i = r.nextInt(unsatisfiedAssignments.size());
		return unsatisfiedAssignments.get(i);
	}


	private List<Integer> getUnsatisfiedAssignments(boolean[] assignments, Constrain[] constrains) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < constrains.length; i++){
			Constrain c = constrains[i];
			boolean r1 = assignments[c.v1];
			boolean r2 = assignments[c.v2];
			if (!c.p1){
				r1 = !r1;
			}
			if (!c.p2){
				r2 = !r2;
			}
			
			if (!r1 && !r2){
				res.add(c.v1);
				res.add(c.v2);
			}
		}
		return res;
	}

	private boolean[] getRandomAssignments(int n) {
		boolean[] res = new boolean[n];
		for (int i = 0; i < n; i++){
			res[i] = r.nextBoolean();
		}
		return res;
	}

	private Constrain[] getConstrains(String file) {
		Constrain[] res = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			res = new Constrain[Integer.parseInt(line)];
			int i = 0;
			while((line = br.readLine()) != null){
				String[] parts = line.split(" ");
				int a1 = Integer.parseInt(parts[0]);
				int a2 = Integer.parseInt(parts[1]);
				Constrain c = new Constrain(Math.abs(a1) - 1, a1 > 0 ? true: false, Math.abs(a2) - 1, a2 > 0? true: false );
				res[i] = c;
				i++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	

	private void preprocess(String file) {
		for (int i = 0; i < 100; i++){
			process(file);
		}
	}


	private void process(String file) {
		Set<Integer> set = new HashSet<Integer>();
		List<String> clauses = new ArrayList<>();
 		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while((line = br.readLine()) != null){
				clauses.add(line);
				String[] parts = line.split(" ");
				int a1 = Integer.parseInt(parts[0]);
				int a2 = Integer.parseInt(parts[1]);
				set.add(a1);
				set.add(a2);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 		
 		Set<Integer> singleVariables = new HashSet<>();
 		for (int i: set){
 			if (!set.contains(-i)){
 				singleVariables.add(i);
 			}
 		}
 		
 		for (Iterator<String> it = clauses.iterator(); it.hasNext(); ){
 			String line = it.next();
 			String[] parts = line.split(" ");
			int a1 = Integer.parseInt(parts[0]);
			int a2 = Integer.parseInt(parts[1]);
			
			if (singleVariables.contains(a1) || singleVariables.contains(a2)){
				it.remove();
			}
 		}
 		System.out.println("n=" + clauses.size());
 		
 		try {
			PrintWriter pw = new PrintWriter(file);
			pw.println(clauses.size());
			for(String clause: clauses){
				pw.println(clause);
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
 		
	}


}
