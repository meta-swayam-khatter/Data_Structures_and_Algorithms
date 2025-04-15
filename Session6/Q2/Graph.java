package Session6.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import Session6.Q1.Edge;
import Session6.Q1.GraphInterface;

public class Graph implements GraphInterface {
    int vertices;
    List<Edge> edgeList = new ArrayList<>();
    Map<Integer, List<int[]>> adj = new HashMap<>();

    Graph(int v) {
        vertices = v;
        for (int i = 0; i < v; i++)
            adj.put(i, new ArrayList<>());
    }

    void addEdge(int src, int dest, int weight) {
        edgeList.add(new Edge(src, dest, weight));
        adj.get(src).add(new int[]{dest, weight});
        adj.get(dest).add(new int[]{src, weight});
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int[] neighbor : adj.get(node)) {
                if (!visited[neighbor[0]]) {
                    visited[neighbor[0]] = true;
                    stack.push(neighbor[0]);
                }
            }
        }

        for (boolean v : visited)
            if (!v) return false;
        return true;
    }

    public List<Integer> reachable(int a) {
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        visited[a] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            result.add(node);
            for (int[] neighbor : adj.get(node)) {
                if (!visited[neighbor[0]]) {
                    visited[neighbor[0]] = true;
                    stack.push(neighbor[0]);
                }
            }
        }

        return result;
    }

    public List<Edge> mst() {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edgeList, Comparator.comparingInt(e -> e.weight));
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) parent[i] = i;

        for (Edge edge : edgeList) {
            int x = find(parent, edge.src);
            int y = find(parent, edge.dest);
            if (x != y) {
                result.add(edge);
                union(parent, x, y);
            }
        }
        return result;
    }

    int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }

    public List<Integer> shortestPath(int src, int dest) {
        int[] dist = new int[vertices];
        int[] prev = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0], weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int at = dest; at != -1; at = prev[at])
            path.add(0, at);
        if (path.get(0) != src) path.clear();
        return path;
    }
}