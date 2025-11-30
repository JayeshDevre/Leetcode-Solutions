class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result= new ArrayList<>();
        int n= graph.length;

        int [] visited= new int[n];
        int [] pathVisited= new int[n];
        int [] check= new int [n];

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i, graph, visited, pathVisited, check);
            }
        }

        for(int i=0;i<n;i++){
            if(check[i]==1){
                result.add(i);
            }
        }
        return result;
    }

    public boolean dfs(int node, int [][] graph, int [] visited, int[] pathVisited, int[] check){
        visited[node]=1;
        pathVisited[node]=1;

        for(int nei: graph[node]){
            if(visited[nei]==0){
                if(dfs(nei, graph,visited,pathVisited,check)){
                    return true;
                }
            }else if(pathVisited[nei]==1){
                return true;
            }
        }
        check[node]=1;
        pathVisited[node]=0;
        return false;
    }
}