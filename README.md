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
Let d[i, j] indicates the distance between cities i and j. Function C[x, V – { x }]is the cost of the path starting from city x. V is the set of cities/vertices in given graph. The aim of TSP is to minimize the cost function. 

*
Step 2:
Assume that graph contains n vertices V1, V2, ..., Vn. TSP finds a path covering all vertices exactly once, and the same time it tries to minimize the overall traveling distance.

*
Step 3:
Mathematical formula to find minimum distance is stated below:
C(i, V) = min { d[i, j] + C(j, V – { j }) }, j ∈ V and i ∉ V.

TSP problem possesses the principle of optimality, i.e. for d[V1, Vn] to be minimum, any intermediate path (Vi, Vj) must be minimum.



## 💼 Language Used
 
![](https://img.shields.io/badge/Java-informational?style=flat&logo=react&color=61DAFB)

## 💼 IDE Used

![](https://img.shields.io/badge/IDE-Eclipse-informational?style=flat&logo=react&color=61DAFB)

