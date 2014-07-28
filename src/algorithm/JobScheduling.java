package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class JobScheduling {

	public class JobComparator implements Comparator<Job> {

		@Override
		public int compare(Job job0, Job job1) {
			double score0 = (double)job0.weight / job0.length;
			double score1 = (double)job1.weight / job1.length;
//			if (score1 < score0){
//				return -1;
//			} else if (score1 > score0){
//				return 1;
//			} else {
//				return job1.weight - job0.weight;
//			}
			return (int) Math.signum(score1 - score0);
		}

	}



	public static void main(String[] args) {
		JobScheduling jobScheduling  = new JobScheduling();
		jobScheduling.schedule("D:/jobs.txt");
		
	}
	
	
	
	private void schedule(String file) {
		List<Job> jobs = readJobs(file);
		Collections.sort(jobs, new JobComparator());
		System.out.println(jobs);
		long sum  = 0;
		int completionTime = 0;
		for (Job job: jobs){
			completionTime += job.length;
			sum += job.weight * completionTime;
		}
		System.out.println(sum);
	}



	private List<Job> readJobs(String file) {
		List<Job> jobs = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while( (line = br.readLine() ) != null){
				String[] pair = line.split(" ");
				int weight = Integer.parseInt(pair[0]);
				int length = Integer.parseInt(pair[1]);
				jobs.add(new Job(weight, length));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jobs;
	}



	class Job{
		public int weight;
		public int length;
		
		public Job(int weight, int length){
			this.weight = weight;
			this.length = length;
		}
		
		public String toString(){
			return String.valueOf((double)weight / length) + "/" + weight;
		}
	}

}
