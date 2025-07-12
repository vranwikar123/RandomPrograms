package Graph;

import java.util.*;

public class Graph
{
    private HashMap<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a new vertex to the graph.
    public void addVertex(int vertex)
    {
        if(!adjacencyList.containsKey(vertex))
        {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    // Remove a vertex from the graph.
    public void removeVertex(int vertex)
    {
        if(!adjacencyList.containsKey(vertex))
            return;
        else
        {
            adjacencyList.remove(vertex);
            for(List<Integer> neighbours : adjacencyList.values())
            {
                neighbours.removeIf(v -> v == vertex);
            }
        }
    }

    // Add an edge between two vertices.
    public void addEdge(int vertex1, int vertex2)
    {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    // Remove an edge between two vertices.
    public void removeEdge(int vertex1, int vertex2)
    {
        adjacencyList.get(vertex1).removeIf(v -> v == vertex2);
        adjacencyList.get(vertex2).removeIf(v -> v == vertex1);
    }

    // Get a list of all vertices.
    public ArrayList<Integer> getVertices()
    {
        return new ArrayList<>(adjacencyList.keySet());
    }

    // Check if two vertices are adjacent.
    public boolean isAdjacent(int vertex1, int vertex2)
    {
        return adjacencyList.get(vertex1).contains(vertex2);
    }

    // Get the total number of vertices.
    public int getVertexCount()
    {
        return adjacencyList.keySet().size();
    }

    // Get the total number of edges.
    public int getEdgeCount()
    {
        int count = 0;
        for(List<Integer> neighbours : adjacencyList.values())
        {
            count += neighbours.size();
        }
        return count/2;
    }


    public List<Pair<Integer, Integer>> getEdges()
    {
        List<Pair<Integer, Integer>> edges = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            int vertex1 = entry.getKey();
            for (int neighbor : entry.getValue()) {
                int vertex2 = neighbor;
                if (vertex1 < vertex2) {
                    edges.add(new Pair<>(vertex1, vertex2));
                }
            }
        }
        return edges;
    }
    // Get a list of all edges.

    public ArrayList<Integer> getNeighbors(int vertex)
    {
        return new ArrayList<>(adjacencyList.getOrDefault(vertex, new ArrayList<>()));
    }
    // Get a list of neighbors of a given vertex.

    public void DFS(int startId)
    {
        boolean[] visited = new boolean[getVertexCount()];
        Stack<Integer> stack = new Stack<>();

        stack.push(startId);
        visited[startId] = true;

        while(!stack.isEmpty())
        {
            int current = stack.pop(); // Pop a vertex from the stack

            if (!visited[current]) {
                System.out.print(current + " "); // Process the current node
                visited[current] = true; // Mark it as visited
            }

            // Push all unvisited neighbors onto the stack
            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}