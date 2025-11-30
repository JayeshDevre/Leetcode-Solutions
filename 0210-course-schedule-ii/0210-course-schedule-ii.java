class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new ArrayList<>();
        int [] inDegree= new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int [] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }

        int count=0;
        int [] result= new int[numCourses];
        int i=0;

        while(!queue.isEmpty()){
            int top = queue.peek();
            result[i++]=top;
            queue.poll();
            for(int freq: graph.get(top)){
                inDegree[freq]--;
                if(inDegree[freq]==0){
                    queue.offer(freq);
                }
            }
        }

        if(i==numCourses){
            return result;
        }

        return new int[]{};
    }
}