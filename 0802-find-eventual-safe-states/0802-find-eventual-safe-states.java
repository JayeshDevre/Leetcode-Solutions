class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj= new ArrayList<>();

        int indegree[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j: graph[i]){
                adj.get(j).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        boolean [] safe= new boolean[graph.length];
        while(!queue.isEmpty()){
            int node=queue.poll();
            safe[node]=true;

            for(int nei: adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    queue.offer(nei);
                }
            }
        }

        List<Integer> list= new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(safe[i]){
                list.add(i);
            }
        }
        return list;
    }
}