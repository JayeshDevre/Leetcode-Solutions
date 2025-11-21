class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new ArrayList<>();
        int [] inComingFreq= new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

// 0->1
// 1->
        for(int [] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inComingFreq[pre[0]]++;
        }
        // 0 1 at first inComingFreq[0 0]
        //inComingFreq = [0 1]

        Queue<Integer> queue=new LinkedList<>();
        // add all 0 incoming in queue
        for(int i=0;i<numCourses;i++){
            if(inComingFreq[i]==0){
                queue.offer(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int next=queue.poll();
            count++;
            for(int freq:graph.get(next)){
                inComingFreq[freq]--;
                if(inComingFreq[freq]==0){
                    queue.offer(freq);
                }
            }

        }
        return count==numCourses;

    }

}