class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                dfs(next, adj, visited);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] visited = new boolean[n];
        dfs(k, adj, visited);
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            if (!visited[u] && visited[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}