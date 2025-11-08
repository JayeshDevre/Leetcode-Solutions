class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new ArrayList<>();
        int [] inIndex=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inIndex[pre[0]]++;
        }

        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inIndex[i]==0){
                queue.add(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            count++;
            for(int next: graph.get(curr)){
                inIndex[next]--;
                if(inIndex[next]==0){
                    queue.add(next);
                }
            }

        }
        return count==numCourses;
    }
}