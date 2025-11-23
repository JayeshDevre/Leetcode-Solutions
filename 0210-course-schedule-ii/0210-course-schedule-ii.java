class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 0->1

        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        int [] inDegree=new int[numCourses];

        for(int [] pre: prerequisites){
            int a=pre[0];
            int b=pre[1];
            graph.get(b).add(a);
            inDegree[a]++;
        }

        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        int[] result=new int[numCourses];
        int i=0;

        while(!queue.isEmpty()){
            int top=queue.poll();
            result[i++]=top;
            for(int next: graph.get(top)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    queue.offer(next);
                }
            }
        }

        if(i==numCourses){
            return result;
        }
        return new int[]{};

    }
}