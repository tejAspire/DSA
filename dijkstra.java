import java.util.*;


public class Dijkstra {
	int graph[][];
	boolean s[];
	int dist[];
	int n;
	Dijkstra(int n) {
		graph = new int[n][n];
		dist = new int[n];
		s = new boolean[n];
		this.n = n;
	}
	Scanner sc = new Scanner(System.in);
	void getGraph() {
		System.out.println("Enter the cost matrix: ");
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int tmp = sc.nextInt();
				if(tmp == 0) 
					graph[i][j] = 9999;
				else
					graph[i][j] = tmp;
			}
		}
	}
	
	//to find the minimum vertex in the array 'dist[]' not in the list s
	//also adds the minimum index to the list 's[]'
	int getMin() {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		for(int i = 0; i < n; i++) {
			if(!s[i] && dist[i] < min){	//if 's[i]' is not considered yet && 'dist[i]' is the small
				minIndex = i;
				min = dist[i];
			}
		}
		return minIndex;
	}
	
	int min(int a, int b) {
		if(b < a)
			return b;
		else 
			return a;
	}
	
	//function for dijkstras algorithm
	void dijkstra(){
		getGraph();
		System.out.println("Enter Source: ");
		int src = sc.nextInt();
		for(int i = 0; i < n; i++) 
			dist[i] = graph[src][i];
		s[src] = true;
		dist[src] = 0;
		
		for(int i = 0; i < n; i++) {
			int w = getMin();
			s[w] = true;
			
			for(int v = 0; v < n; v++) {
				if(!s[v]) {
					dist[v] = min(dist[v], dist[w] + graph[w][v]);
				}
			}
		}
		
		//printing the array
		System.out.println(Arrays.toString(dist));
		//System.out.println(Arrays.toString(s));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Vertices: ");
		int n = sc.nextInt();
		Dijkstra G = new Dijkstra(n);
		G.dijkstra();
		sc.close();
	}
}

/*cost matrix


0 10 0 30 100
0 0 50 0 0 
0 0 0 0 10
0 0 20 0 60
0 0 0 0 0

0 10 40 0 55 0 
20 0 20 0 0 0 
0 0 0 0 5 0 
0 35 10 0 30 0 
0 0 0 35 0 0 
0 0 0 3 0 0 

*/
