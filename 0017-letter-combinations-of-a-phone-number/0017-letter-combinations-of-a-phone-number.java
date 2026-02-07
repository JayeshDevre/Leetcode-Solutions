class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result= new ArrayList<>();
        if(digits.length()==0){
            return result;
        }

        String[] letters={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backTrack(0, digits, result, new StringBuilder(), letters);
        return result;
    }

    private void backTrack(int index, String digits, List<String> result, StringBuilder sb, String[] letters){
        if(index==digits.length()){
            result.add(sb.toString());
            return;
        }

        int digit=digits.charAt(index)-'0';
        String s=letters[digit];

        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            backTrack(index+1,digits, result, sb, letters);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}