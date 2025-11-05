class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map=new HashMap<>();
//  ["A","C","A","B","D","B"], n = 1          a:2  b:2  c:1  d:1
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
// 2,2,1,1
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(map.values());

        int ans=0;

        while(!pq.isEmpty()){
            List<Integer> list= new ArrayList<>();
            // ACA   : N+1= 2
            for(int i=0;i<n+1;i++){
                if(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }

            for(int freq:list){
                if(--freq>0){
                pq.add(freq);
                }
            }

            ans+=pq.isEmpty()?list.size():n+1;
        }

        return ans;
    }
}