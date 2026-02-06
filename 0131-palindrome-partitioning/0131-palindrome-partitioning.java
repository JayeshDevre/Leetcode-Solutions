class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        List<String> temp= new ArrayList<>();

        backTrack(0,s,result,temp);
        return result;
    }

    private void backTrack(int index, String s, List<List<String>> result, List<String> temp){
        if(index==s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                backTrack(i+1,s,result,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}