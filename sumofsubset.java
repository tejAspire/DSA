import java.util.*;
public class Hamiltonian {
static int MAX=25;
static int vertex[]=new int[MAX];
public static void main(String[] args) 
{
int i,j,v1,v2,edges,n;
int G[][]=new int[MAX][MAX];
System.out.println("\n\t program for Hamiltonian cycle");
System.out.println("enter the number of vertices of graph");
Scanner in =new Scanner(System.in);
n=in.nextInt();
for(i=1;i<=n;i++)
{
for(j=1;j<=n;j++)
{
G[i][j]=0;
vertex[i]=0;
}
}
System.out.println("\n enter the total number of edges:");
edges=in.nextInt();
for(i=1;i<=edges;i++)
{
System.out.println("enter the edge:");
v1=in.nextInt();
v2=in.nextInt();
G[v1][v2]=1;
G[v2][v1]=1;
}
vertex[1]=1;
System.out.println("Hamiltonian cycle");
H_cycle(G,n,2);
}
public static void next_vertex(int G[][],int n,int k)
{
int j;
while(true)
{
vertex[k]=(vertex[k]+1)%(n+1);
if(vertex[k]==0)
return;
if(G[vertex[k-1]][vertex[k]]!=0)
{
for(j=1;j<=k-1;j++)
{
if(vertex[j]==vertex[k])
break;
		}
if(j==k)
{
if((k<n)||((k==n) && (G[vertex[n]][vertex[1]]!=0)))
return;
}
}
}
}
public static void H_cycle(int G[][],int n,int k)
{
int i;
while(true)
{
next_vertex(G,n,k);
if(vertex[k]==0)
return;
if(k==n)
{
System.out.println("\n");
for(i=1;i<=n;i++)
System.out.print(vertex[i]+"-->");
System.out.println(" "+vertex[1]);
}
else
H_cycle(G,n,k+1);
}
}
}
