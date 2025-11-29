class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent= new int[edges.length+1];
        for(int i=1;i<=edges.length;i++){
            parent[i]=i;
        }

        for(int [] edge: edges){
            int rootA=find(parent,edge[0]);
            int rootB=find(parent,edge[1]);

            if(rootA==rootB){
                return edge;
            }

            parent[rootB]=rootA;
        }
        return null;
    }

    public int find(int[] parent, int node){
        while(node!=parent[node]){
            parent[node]=parent[parent[node]];
            node=parent[node];
        }
        return node;
    }
}