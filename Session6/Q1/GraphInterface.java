package Session6.Q1;

import java.util.List;

public interface GraphInterface {
    boolean isConnected();
    List<Integer> reachable(int a);
    List<Edge> mst();
    List<Integer> shortestPath(int src, int dest);
}
