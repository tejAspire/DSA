import java.util.*;

class SelectionSort {
	
	static int ct;
	
	void countSwaps(int size) {
		int arr[] = randomArr(size);
		
		// Average case
		ct = 0;
		int aArr[] = sort(arr);
		System.out.println("Number of swaps(average case): " +ct);
		
		// Best case
		ct = 0;
		sort(aArr);				// print array if needed < int tempArr[] = sort(aArr) >
		System.out.println("Number of swaps(best case): " +ct);
		
		// Worst case
		ct = 0;
		int wArr[] = new int[size];
		// generating Descending array
		for(int i = 0; i < size; i++)
			wArr[i] = size - i;
		
		sort(wArr);				// print array if needed < int tempArr[] = sort(wArr) >
		System.out.println("Number of swaps(worst case): " +ct);
	}
	
	//Selection Sort
	int[] sort(int[] a){
		for(int i = 0; i < a.length - 1; i++) {
			int minPos = i;
			for(int j = i + 1; j < a.length; j++) {
				ct++;			// increment counter
				if(a[j] < a[minPos])
					minPos = j;
			}
			if(minPos != i) {
				int tmp = a[minPos];
				a[minPos] = a[i];
				a[i] = tmp;
			}
		}
		return a;
	}
	
	// generates random array
	int[] randomArr(int size) {
		int arr[] = new int[size];
		Random r = new Random();
		for(int i = 0; i < size; i++)
			arr[i] = r.nextInt(size) + 1;
		return arr;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of array elements: ");
		int size = sc.nextInt();
		SelectionSort obj = new SelectionSort();
		obj.countSwaps(size);
		sc.close();
	}
}
