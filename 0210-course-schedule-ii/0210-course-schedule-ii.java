class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int [] indegree = new int[numCourses];

        for(int [] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        int [] result= new int[numCourses];
        int j=0;
        
        while(!queue.isEmpty()){
            int node= queue.poll();
            result[j++]=node;

            for(int neigh: graph.get(node)){
                indegree[neigh]--;

                if(indegree[neigh]==0){
                    queue.offer(neigh);
                }
            }

        }

        return result;
    }
}