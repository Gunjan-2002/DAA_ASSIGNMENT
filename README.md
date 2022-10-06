<p align="center">
  <a href="https://www.yushi.dev/" target="_blank" rel="noreferrer"><img src="https://user-images.githubusercontent.com/103045206/194352037-cde3c1f3-4fe3-48c6-910b-685f0019f5c0.jpg" alt="my banner"></a>
</p>

## Problem Statement :
Implement the solution for Travelling Salesman Problem using Dynamic Programming approach in which salesman have to travel minimum Distance in optimal Time.

## Theory :
* Traveling salesman problem is stated as, “Given a set of n cities and distance and time to travel between each pair of cities, find the path through which Salesman will travel optimal distance with optimal time such that it covers each city exactly once and terminates the tour at starting city.”
* It is not difficult to show that this problem is NP complete problem. There exists n! paths, a search of the optimal path becomes very slow when n is considerably large.
* Each edge (u, v) in TSP graph is assigned some non-negative weight and time, which represents the distance and time to travel between city u and v. This problem can be solved by finding the Hamiltonian cycle of the graph.
* The distance between cities and time to travel is best described by the weighted graph, where edge (u, v) indicates the path from city u to v and w(u, v) , t(u,v) represents the distance between cities u and v and time to travel respectively.

## Approach : 
* Step 1:
Let cost[i, j].dis indicates the distance between cities i and j and cost[i, j].time indicates the time to travel between cities i and j. V is the set of cities/vertices in given graph. The aim of TSP is to minimize the function such that salesman will cover optimal distance in optimum time. 

* Step 2:
Assume that graph contains n vertices V1, V2, ..., Vn. TSP finds a path covering all vertices exactly once, and the same time it tries to minimize the overall traveling distance and time taken to travel.

* Step 3:
Mathematical formula to find minimum distance is stated below:
cost(i, V) = min { (cost[i, j].dis + C=cost(j, V – { j }).dis) * (cost[i, j].time + cost(j, V – { j }).time) }, j ∈ V and i ∉ V.

TSP problem possesses the principle of optimality, i.e. for any intermediate path (Vi, Vj) distance and time must be optimal.


## Source Code :
```
package DAA;

import java.util.*;

public class TSP_Modified 
{
	static class Pair
	{
		int dis;
		int time;
		
		public Pair(int dis , int time)
		{
			this.dis=dis;
			this.time=time;
		}
	}
	
	
	static Pair[][] cost = new Pair[100][100]; 
	static boolean[]  visited = new boolean[100];
	static int no_Vertices , current_vertex , total_Cost=0 , total_Time=0;
	
	
	public static int next_Vertex(int c_Vertex)
	{
		int min = Integer.MAX_VALUE;
		int cost_spent = 0 , nextVertex = Integer.MAX_VALUE , time_spent = 0;
		
		for(int i=0;i<no_Vertices;i++)
		{
			if(cost[c_Vertex-1][i].dis != 0  && visited[i] == false) //****
			{
				if((cost[c_Vertex-1][i].dis + cost[i][c_Vertex-1].dis)*(cost[c_Vertex-1][i].time + cost[i][c_Vertex-1].time) < min)//****
				{
					min = (cost[c_Vertex-1][i].dis + cost[i][c_Vertex-1].dis)*(cost[c_Vertex-1][i].time + cost[i][c_Vertex-1].time);
					cost_spent = cost[c_Vertex-1][i].dis;
					time_spent = cost[c_Vertex-1][i].time;
					nextVertex = i;
				}
			}
		}
		
		if(min != Integer.MAX_VALUE)
		{
			total_Cost += cost_spent;
			total_Time += time_spent;
		}
		
		return nextVertex + 1;
	}
	
	
	public static void shortest_Distance(int c_vertex)
	{
		visited[c_vertex-1] = true;
		
		System.out.print(c_vertex + " ---> ");
		
		int nxt_vertex = next_Vertex(c_vertex);
		
		if(nxt_vertex == Integer.MAX_VALUE +1)
		{
			System.out.println(current_vertex);
			total_Cost += cost[c_vertex-1][current_vertex-1].dis;
			total_Time += cost[c_vertex-1][current_vertex-1].time;
			return;
		}
		
		shortest_Distance(nxt_vertex);
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Number Of Cities");
		no_Vertices = sc.nextInt();
		
		System.out.println("Enter Starting City");
		current_vertex = sc.nextInt();
		
		for(int i=0;i<no_Vertices;i++)
		{
			for(int j=0;j<no_Vertices;j++)
			{
				if(i==j)
				{
					cost[i][j] = new Pair(0, 0);
				}
				else
				{
					System.out.println("Enter Cost & Time To Travel Between City : " + (i+1) + " --> " + (j+1));
					int dis = sc.nextInt();
					int time = sc.nextInt();
					cost[i][j] = new Pair(dis, time);
				}
			}
		}
		
		System.out.println("Cost Matrix Is :");
		
		for(int i=0;i<no_Vertices;i++)
		{
			for(int j=0;j<no_Vertices;j++)
			{
				System.out.print(cost[i][j].dis + "|" + cost[i][j].time + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\nPath That Salesman Will Follow While Having Minimum Distance Covered");
		shortest_Distance(current_vertex);
		System.out.println();
		System.out.println("Total Cost Is : " + total_Cost);
		System.out.println("Total Time Is : " + total_Time);
		
	}
}

```

## Output :

```
Enter Number Of Cities
4
Enter Starting City
1
Enter Cost & Time To Travel Between City : 1 --> 2
9 10
Enter Cost & Time To Travel Between City : 1 --> 3
4 3
Enter Cost & Time To Travel Between City : 1 --> 4
7 2
Enter Cost & Time To Travel Between City : 2 --> 1
7 5
Enter Cost & Time To Travel Between City : 2 --> 3
3 7
Enter Cost & Time To Travel Between City : 2 --> 4
2 6
Enter Cost & Time To Travel Between City : 3 --> 1
10 3
Enter Cost & Time To Travel Between City : 3 --> 2
6 4
Enter Cost & Time To Travel Between City : 3 --> 4
9 2
Enter Cost & Time To Travel Between City : 4 --> 1
12 8
Enter Cost & Time To Travel Between City : 4 --> 2
15 7
Enter Cost & Time To Travel Between City : 4 --> 3
6 3

Cost Matrix Is :
0|0	9|10	4|3	7|2	
7|5	0|0	3|7	2|6	
10|3	6|4	0|0	9|2	
12|8	15|7	6|3	0|0	

Path That Salesman Will Follow While Having Minimum Distance Covered
1 ---> 3 ---> 4 ---> 2 ---> 1

Total Cost Is : 35
Total Time Is : 17

```

## 💼 Language Used
 
![](https://img.shields.io/badge/Java-informational?style=flat&logo=react&color=61DAFB)

## 💼 IDE Used

![](https://img.shields.io/badge/IDE-Eclipse-informational?style=flat&logo=react&color=61DAFB)

