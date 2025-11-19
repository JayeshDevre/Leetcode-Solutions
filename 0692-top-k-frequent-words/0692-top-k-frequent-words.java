class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }



        PriorityQueue<String> maxHeap=new PriorityQueue<>(
            (a,b)->{
            int freqA=map.get(a);
            int freqB=map.get(b);
            if(freqA==freqB){
                return a.compareTo(b);
            }
            return freqB-freqA;
        });

        for(String word: map.keySet()){
            maxHeap.offer(word);
        }

        List<String> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(maxHeap.poll());
        }
        return list;
    }
}