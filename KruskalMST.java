import java.util.*;
public class KruskalMST {
	int n;
	int graph[][];
	int parent[];
	
	KruskalMST(int n) {
		this.n = n;
		graph = new int[n][n];
		parent = new int[n];
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
	
	//finds the representative of a given element
	int find(int x) {
		while(parent[x] != x)
			x = parent[x];
		return x;
	}
	
	// unions 2 subsets(here subgraphs)
	void union(int v, int u) {
		parent[v] = u;
	}
	
	void kruskal() {
		getGraph();
		int v1 = 0, u1 = 0;
		int minCost = 0;
		
		for(int i = 0; i < n - 1; i++) 
			parent[i] = i;
		System.out.println("Edges:  ");
		for(int i = 0; i < n; i++) {
			int minWt = 9999;
			
			for(int v = 0; v < n; v++) {
				for(int u = 0; u < n; u++) {
					if(graph[v][u] < minWt) {
						minWt = graph[v][u];
						v1 = v;
						u1 = u;
					}
				}
			}
			int a = find(v1);
			int b = find(u1);
			if(a != b) {
				System.out.printf("(%d, %d) = %d\n", v1, u1, graph[v1][u1]);
				union(v1, u1);
				minCost += graph[v1][u1];
				graph[v1][u1] = graph[u1][v1] = 9999;
			}
		}
		System.out.println("Minimum Cost: " + minCost);
	}

	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int n = sc.nextInt();
		KruskalMST G = new KruskalMST(n);
		G.kruskal();
		
		
		sc.close();
	}
}

/*

0 7 3 12 0 
7 0 0 0 9
3 0 0 0 7
12 0 0 0 5
0 9 7 5 0 
 
 */
