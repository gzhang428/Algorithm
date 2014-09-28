package algorithm.sort;


public class MergeSort extends Sort {

	public static void main(String[] args){
		int[] a = {2,1,5,7,3,8,9,0,4,6};
		MergeSort mergeSort=new MergeSort();
		mergeSort.sort(a);
		mergeSort.print(a);
		
	}
	@Override
	public void sort(int[] a){
		int[] t = new int[a.length];
		mergeSort(a, t, 0, a.length - 1);
	}

	private void mergeSort(int[] a, int[] t, int low, int high){
		if(low < high){
			int mid = (low + high) / 2;
			mergeSort(a, t, low, mid);
			mergeSort(a, t, mid + 1, high);
			merge(a, t, low, mid, high);
		}
		
	}

	private void merge(int[] a, int[] t, int low, int mid, int high) {
		for(int i = low; i <= high; i++){
			t[i] = a[i];
		}
		
		int i = low;
		int j = mid + 1;
		int k = low;
		
		
		while(i <= mid && j <= high){
			if(t[i] <= t[j]){
				a[k] = t[i];
				k++;
				i++;
			}
			else{
				a[k] = t[j];
				k++;
				j++;
			}
		}
		while(i <= mid){
			a[k] = t[i];
			k++;
			i++;
			
		}
		while(j <= high){
			a[k] = t[j];
			k++;
			j++;
		}
	}
}
