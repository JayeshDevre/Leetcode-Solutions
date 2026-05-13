class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> current= new ArrayList<>();
        current.add(0);
        dfs(0, graph.length-1, graph, current, result);
        return result;
    }

    private void dfs(int start, int end, int[][] graph, List<Integer> current, List<List<Integer>> result){
        if(start==end){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int n: graph[start]){
            current.add(n);
            dfs(n,end,graph,current,result);
            current.remove(current.size()-1);
        }
    }
}