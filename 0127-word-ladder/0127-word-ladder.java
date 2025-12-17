class Pair{
    String first;
    int second;
    
    Pair(String first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>();
        Queue<Pair> queue= new LinkedList<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        queue.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!queue.isEmpty()){
            String word=queue.peek().first;
            int len=queue.peek().second;
            queue.poll();
            if(word.equals(endWord)){
                return len;
            }
            for(int i=0;i<word.length();i++){
                char [] arr= word.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    arr[i]=ch;
                    String s= new String(arr);
                    if(set.contains(s)){
                        queue.add(new Pair(s,len+1));
                        set.remove(s);
                    }
                }
            }
        }
        return 0;
    }
}