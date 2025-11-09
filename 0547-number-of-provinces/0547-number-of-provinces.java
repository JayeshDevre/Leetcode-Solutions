class Solution {

    void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int u){
        if(visited.contains(u)){
            return ;
        }
        visited.add(u);
        List<Integer> list= map.getOrDefault(u,new ArrayList<>());
        for(int i=0;i<list.size();i++){
            if(!visited.contains(list.get(i))){
                dfs(map,visited,list.get(i));
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        Map<Integer, List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    map.putIfAbsent(i,new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }
        int count=0;
        Set<Integer> visited= new HashSet<>();
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(map,visited,i);
                count++;
            }
        }
        return count;
    }
}