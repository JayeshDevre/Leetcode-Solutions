class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       if(edges.length==0){
        return new int[]{};
       } 
// we are using disjoint set(union find here) 
       int [] parent=new int[edges.length+1];
       for(int i=1;i<=edges.length;i++){
        parent[i]=i;
       }

       for(int[] edge: edges){
        int node1=edge[0];
        int node2=edge[1];

        int root1=find(parent,node1);
        int root2=find(parent,node2);

        if(root1==root2){
            return edge;
        }

        parent[root2]=root1;

       }
       return new int[]{};
    }

    public int find(int[] parent,int node){
        while(parent[node]!=node){
            parent[node]=parent[parent[node]];
            node=parent[node];
        }
        return node;
    }
}