import java.util.Scanner; 
public class Floyd 
{ 
private int dmat[][]; 
private int n; 
public static final int INFINITY = 999; 
public Floyd(int n) 
{ 
dmat = new int[n + 1][n + 1]; 
this.n = n; 
} 
public void floyd_compute(int adjmat[][]) 
{ 
for (int i = 1; i<= n; i++) 
{ 
for (int j = 1; j <= n; j++) 
{ 
dmat[i][j] = adjmat[i][j]; 
} 
} 
for (int k = 1; k <= n; k++) 
{ 
for (int i = 1; i<= n; i++) 
{ 
for (int j = 1; j <= n; j++) 
{ 
if (dmat[i][k] + dmat[k][j] <dmat[i][j]) 
dmat[i][j] = dmat[i][k] + dmat[k][j]; 
} 
} 
} 
for (int i = 1; i<= n; i++) 
System.out.print("\t" + i); 
System.out.println(); 
for (int i = 1; i<= n; i++) 
{ 
System.out.print(i + "\t"); 
for (int j = 1; j <= n; j++) 
{ 
System.out.print(dmat[i][j] + "\t");
			} 
			System.out.println(); 
		} 
	} 
public static void main(String[] arg) 
{ 
int adjmat[][]; 
int n; 
Scanner scan = new Scanner(System.in); 
System.out.println("Enter the number of vertices"); 
n = scan.nextInt(); 
adjmat = new int[n + 1][n + 1]; 
System.out.println("Enter the Weighted Matrix for the graph"); 
for (int i = 1; i<= n; i++) 
{ 
for (int j = 1; j <= n; j++) 
{ 
adjmat[i][j] = scan.nextInt(); 
if (i == j) 
{ 
adjmat[i][j] = 0; 
continue; 
} 
if (adjmat[i][j] == 0) 
{ 
adjmat[i][j] = INFINITY; 
} 
} 
} 
System.out.println("The All Pairs Shortest Distance of the Graph is: "); 
Floyd floydobj = new Floyd(n); 
floydobj.floyd_compute(adjmat); 
scan.close(); 
} 
}
