class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int [n];
        int[] rank = new int [n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        int components = n;
        for(int[] edge : edges){
            int rootA = find(parent, edge[0]);
            int rootB = find(parent, edge[1]);

            if(rootA != rootB){
                if(rank[rootA] > rank[rootB]){
                    parent[rootB] = rootA;
                }else if(rank[rootA] < rank[rootB]){
                    parent[rootA] = rootB;
                }else{
                    parent[rootB] = rootA;
                    rank[rootA]++;
                }
                components--;
            }
        } 
        return components;
    }

    private int find(int[] parent, int node){
        if(parent[node] != node){
            if(parent[node] != node){
                parent[node] = find(parent, parent[node]);
            }
        }
        return parent[node];
    }
}
