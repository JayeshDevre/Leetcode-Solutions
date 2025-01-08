class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans  = 0 ;
        String add = word;
        while(sequence.contains(word)){
           ans++;
           word = word + add;
        }
        return ans;
    }
}