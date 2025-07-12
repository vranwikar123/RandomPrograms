package Graph;

class UnionFind {
    int[] parent;
    int[] rank;

    // Initialize Union-Find structure with parent and rank arrays.
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        // Initially, each element is its own parent (self loop).
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find the root representative of the set containing x with path compression.
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression.
        }
        return parent[x];
    }

    // Union two sets containing x and y using union by rank.
    public void union_set(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // If they are in the same set, do nothing.
        if (rootX == rootY) {
            return;
        }

        // Union by rank.
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

class Solution {
    // Function to find the number of provinces (connected components) in the graph.
    public int findProvinces(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        int numberOfProvinces = n;

        // Iterate over each pair of nodes and union the sets if there is a connection.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && uf.find(i) != uf.find(j)) {
                    numberOfProvinces--;
                    uf.union_set(i, j);
                }
            }
        }

        return numberOfProvinces;
    }

    // Main method for testing.
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1:
        int[][] example1 = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution.findProvinces(example1)); // Expected Output: 2

        // Example 2:
        int[][] example2 = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(solution.findProvinces(example2)); // Expected Output: 3

        // Example 3:
        int[][] example3 = {{1,0,0,1},{0,1,1,0},{0,1,1,0},{1,0,0,1}};
        System.out.println(solution.findProvinces(example3)); // Expected Output: 2
    }
}
