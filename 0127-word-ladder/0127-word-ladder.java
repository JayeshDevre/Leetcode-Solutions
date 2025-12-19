class Pair{
    String word;
    int count;

    Pair(String word, int count){
        this.word=word;
        this.count=count;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>();
        Queue<Pair> queue= new LinkedList<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        queue.add(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            String word=queue.peek().word;
            int count=queue.peek().count;
            queue.poll();
            if(word.equals(endWord)){
                return count;
            }
            for(int i=0;i<word.length();i++){
                char[] s= word.toCharArray();
                for(char ch='a';ch<='z';ch++){
                    s[i]=ch;
                    String newWord=new String(s);
                    if(set.contains(newWord)){
                        queue.add(new Pair(newWord,count+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
