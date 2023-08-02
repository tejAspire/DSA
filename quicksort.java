import java.util.*;

class QuickSort {
	
	static int ct;
	
	void countSwaps(int size) {
		int arr[] = randomArr(size);
		
		// Average case
		ct = 0;
		sort(arr, 0, arr.length - 1);
		System.out.println("Number of swaps(average case): " +ct);
		
		// Worst case
		ct = 0;
		int aArr[] = new int[size];
		// generating Ascending array
		for(int i = 0; i < size; i++)
			aArr[i] = i;
		sort(aArr, 0, aArr.length - 1);
		System.out.println("Number of swaps(worst case): " +ct);
	}
	
	//Quick Sort
	static void sort(int a[], int low, int high) {
		if (low >= high)
			return;
		int j = partition(a, low, high);
		sort(a, low, j - 1);
		sort(a, j + 1, high);
	}

	static int partition(int a[], int low, int high) {
		int i = low + 1, j = high, p = a[low];
		while (true) {
			while (a[i] <= p && i < high) {
				i++;
				ct++;
			}
			while (a[j] > p && j > low) {
				j--;
				ct++;
			}
			if (i < j) {				// when both 'i' and 'j' stop, and dont cross each other
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			} else {					// final swap of 'j' with pivot <p>
				int temp = a[low];
				a[low] = a[j];
				a[j] = temp;
				return j;
			}
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
		System.out.println("Enter the number of array elements: ");
		int size = sc.nextInt();
		QuickSort obj = new QuickSort();
		obj.countSwaps(size);
		sc.close();
	}
}
