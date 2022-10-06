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
			if(cost[c_Vertex-1][i].dis != 0  && visited[i] == false) 
			{
				if((cost[c_Vertex-1][i].dis + cost[i][c_Vertex-1].dis)*(cost[c_Vertex-1][i].time + cost[i][c_Vertex-1].time) < min)
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
		
		System.out.println("\nCost Matrix Is :");
		
		for(int i=0;i<no_Vertices;i++)
		{
			for(int j=0;j<no_Vertices;j++)
			{
				System.out.print(cost[i][j].dis + "|" + cost[i][j].time + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\nPath That Salesman Will Follow While Having Optimal Distance Covered in Optimal Time");
		shortest_Distance(current_vertex);
		System.out.println();
		System.out.println("Total Cost Is : " + total_Cost);
		System.out.println("Total Time Is : " + total_Time);
		
	}
}
