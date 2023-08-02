import java.util.*;
public class PrimMST {
	// uses 'visited' to keep track of the visited vertices
	int n;
	int graph[][];
	boolean visited[];
	
	PrimMST(int n) {
		this.n = n;
		graph = new int[n][n];
		visited = new boolean[n];
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
	
	void prim() {
		getGraph();
		int minCost = 0;
		int v1 = 0, u1 = 0;
		// for n - 1 edges
		visited[0] = true;
		System.out.println("Edges are: ");
		for(int i = 0; i < n - 1; i++) {
			int minWt = 9999;
			for(int v = 0; v < n; v++) {
				for(int u = 0; u < n; u++) {
					// 'v' has to be visited
					// 'u' has to not be visited
					// new min is found
					if(visited[v] && !visited[u] && graph[v][u] < minWt) {
						minWt = graph[v][u];
						v1 = v;
						u1 = u;
					}
				}
			}
			// set 'u1' as visited (fringe vertex)
			visited[u1] = true;
			System.out.printf("(%d, %d) = %d\n", v1, u1, graph[v1][u1]);
			minCost += graph[v1][u1];
		}
		System.out.println("Min cost: " + minCost);
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int n = sc.nextInt();
		PrimMST G = new PrimMST(n);
		G.prim();
		
		
		sc.close();
	}
}
