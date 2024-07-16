import java.util.*;
class Solution {
public int networkDelayTime(int[][] times, int n, int k) {
// Step 1: Create adjacency list for graph representation
List<int[]>[] graph = new List[n + 1];
for (int i = 1; i <= n; i++) {
graph[i] = new ArrayList<>();
}
for (int[] edge : times) {
graph[edge[0]].add(new int[]{edge[1], edge[2]});
}
// Step 2: Initialize distance array and priority queue for Dijkstra's algorithm
int[] distance = new int[n + 1];
Arrays.fill(distance, Integer.MAX_VALUE);
distance[k] = 0;
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
pq.offer(new int[]{k, 0});
// Step 3: Apply Dijkstra's algorithm to find shortest paths
while (!pq.isEmpty()) {
int[] curr = pq.poll();
int u = curr[0];
int dist = curr[1];
if (dist > distance[u]) {
continue; // Skip if this node has already been processed with a shorter distance
}
for (int[] neighbor : graph[u]) {
int v = neighbor[0];
int weight = neighbor[1];
if (distance[u] + weight < distance[v]) {
distance[v] = distance[u] + weight;
pq.offer(new int[]{v, distance[v]});
}
}
}
// Step 4: Find the maximum distance to any node from the source node k
int maxDelay = 0;
for (int i = 1; i <= n; i++) {
if (distance[i] == Integer.MAX_VALUE) {
return -1; // If there's a node that is not reachable
}
maxDelay = Math.max(maxDelay, distance[i]);
}
return maxDelay;
}
}
