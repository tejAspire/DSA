import java.util.*;

class MergeSort {
	
	static int ct;
	
	// function that displays the number of swaps
	void countSwaps(int size){
		int arr[] = randomArr(size);
		
		//Best case, worst case, average  same for Merge Sort
		ct = 0;
		sort(arr);
		System.out.println("Number of swaps(best, avg and worst case): " +ct);
	}
	
	//Merge Sort function (NOT a in-place Merge Sort)
	void sort(int a[]) {
		if(a.length > 1) {
			int b[] = Arrays.copyOfRange(a, 0, a.length/2);
			int c[] = Arrays.copyOfRange(a, a.length/2, a.length);
			sort(b);
			sort(c);
			merge(b, c, a);
		}
	}
	void merge(int b[], int c[], int a[]) {
		int i = 0, j = 0, k = 0;
		while(i < b.length && j < c.length) {
			ct++;				//increment counter
			if(b[i] < c[j]) {
				a[k++] = b[i++];
			} else {
				a[k++] = c[j++];
			}
		}
		while(i < b.length) {
			a[k++] = b[i++];
		}
		while(j < c.length) {
			a[k++] = c[j++];
		}
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
		System.out.print("Enter the number of array elements: ");
		int size = sc.nextInt();
		MergeSort obj = new MergeSort();
		obj.countSwaps(size);
		sc.close();
	}
}
