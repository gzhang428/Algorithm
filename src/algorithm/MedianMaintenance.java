package algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MedianMaintenance {
	private MinHeap<Integer> largeHalf;
	private MaxHeap<Integer> smallHalf;
	
	
	public MedianMaintenance(){
		largeHalf = new MinHeap<>();
		smallHalf = new MaxHeap<>();
	}
	
	
	public static void main(String[] args) {
		MedianMaintenance mm = new MedianMaintenance();
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/Median.txt"));
			String line = null;
			int sum = 0;
			while((line = br.readLine()) != null){
				int n = Integer.parseInt(line);
				try {
					System.out.println("insert: " + n);
					int median = mm.addAndGetMedian(n);
					System.out.println("median: " + median);
					System.out.println("======================");
					sum += median;
					
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			br.close();
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int addAndGetMedian(int n) throws Exception {
		if (smallHalf.isEmpty()) {
			smallHalf.insert(n);
		} else {
			int maxInSmallHalf = smallHalf.findMax();
			if (n < maxInSmallHalf) {
				smallHalf.insert(n);
			} else {
				largeHalf.insert(n);
			}
		}
		
		if (smallHalf.size() - 2 == largeHalf.size()){
			int maxInSmallHalf = smallHalf.extractMax();
			largeHalf.insert(maxInSmallHalf);
		} else if (largeHalf.size() - 2 == smallHalf.size()){
			int minInLargeHalf = largeHalf.extractMin();
			smallHalf.insert(minInLargeHalf);
		}
//		System.out.println("small half: ");
//		smallHalf.print();
//		System.out.println("large half: ");
//		largeHalf.print();
		if (smallHalf.size() >= largeHalf.size()){
			return smallHalf.findMax();
		} else {
			return largeHalf.findMin();
		} 
		
		
	}

}
