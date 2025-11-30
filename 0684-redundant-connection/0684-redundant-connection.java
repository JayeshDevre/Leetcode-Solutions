class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int [] parent= new int[n+1];

        // parent : [1,2,3]
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        // [1,2]
        for(int [] edge: edges){
            int node1=edge[0]; // 1
            int node2=edge[1]; // 2

            int rootA=find(parent,node1);
            int rootB=find(parent,node2);

            if(rootA==rootB){
                return edge;
            }

            // parent : [1,1,1]
            parent[rootB]=rootA;
        }
        return null;
    }

    public int find(int [] parent, int node){
        while(node!=parent[node]){
            parent[node]=parent[parent[node]];
            node=parent[node];
        }
        return node;
    }

}