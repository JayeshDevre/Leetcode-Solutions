class Solution {
    public int maxRepeating(String sequence, String word) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        str.append(word);
        while(sequence.contains(str) == true) {
            count++;
            str.append(word);
        }
        return count;
    }
}