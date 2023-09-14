import java.util.Scanner; 
class TSP 
{ 
static int cost = 0; 
public static void main(String[] args)
 { 
int a[][] = new int[10][10]; 
int visited[] = new int[10]; 
int n; 
System.out.println("Enter number of cities: "); 
Scanner s = new Scanner(System.in); 
n = s.nextInt(); 
create(a,visited,n); 
System.out.println("\n\npath is"); 
mincost(a,n,0,visited); 
display(); 
	} 
public static void display() 
{ 
// TODO Auto-generated method stub 
System.out.println("\n total cost of tour=" + cost); 
} 
public static void mincost(int[][] a, int n, int city, int[] visited) 
{ 
int i,city_no; 
visited[city]=1; 
System.out.print((city+1)+"--> "); 
city_no = least(a,visited,n,city); 
if(city_no==999)
{ 
city_no=0; 
System.out.print(" "+(city_no+1)); 
cost+=a[city][city_no]; 
return; 
} 
mincost(a,n,city_no,visited); 
} 
public static int least(int[][] a, int[] visited, int n, int c) 
//returns the city which is reachable from source in minimum cost 
{ 
int i,min_node=999; 
int min=999; 
int new_min=0; 
for(i=0;i<n;i++)
{ 
if((a[c][i]!=0)&&visited[i]==0)//if path exist and next city to reach is not yet visited (minimum distance city nerer to source i.e 0) 
if(a[c][i]<min)
{ 
min = a[i][0]+a[c][i]; 
new_min = a[c][i]; 
min_node = i; 
} 
} 
if(min!=999) 
cost+=new_min; 
return min_node; 
} 
public static void create(int[][] a, int[] visited, int n) 
{ 
System.out.println("\n enter the cost matrix:"); 
for(int i=0;i<n;i++)
{ 
System.out.println("row:" + (i+1)); 
for(int j=0;j<n;j++) 
{ 
Scanner scan = new Scanner(System.in); 
a[i][j] = scan.nextInt(); 
} 
visited[i]=0; 
} 
System.out.println("\n\nThe cost matrix"); 
for(int i=0;i<n;i++)
{ 
System.out.println("\n"); 
for(int j=0;j<n;j++)
{ 
System.out.print(" "+a[i][j]); 
} 
} 
} 
}
// Enter number of cities: 
// 4 
// enter the cost matrix: 
// row:1 
// 0 
// 10 
// 15 
// 20 
// row:2 
// 5 
// 0 
// 9 
// 10 
// row:3 
// 6 
// 13 
// 0 
// 12 
// row:4 
// 8 
// 8 
// 9 
// 0 
// The cost matrix 
// 0 10 15 20 
// 5 0 9 10 
// 6 13 0 12 
// 8 8 9 0 
// path is 
// 1--> 2--> 4--> 3--> 1 
// total cost of tour=35


