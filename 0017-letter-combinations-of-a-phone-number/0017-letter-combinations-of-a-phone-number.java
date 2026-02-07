class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result= new ArrayList<>();
        HashMap<Character, String> map= new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        combinations(0, digits, result, "", map);
        return result;
    }

    private void combinations(int index, String digits, List<String> result, String temp, HashMap<Character, String> map){
        if(index==digits.length()){
            result.add(temp);
            return;
        }

        String s=map.get(digits.charAt(index));
        for(int i=0;i<s.length();i++){
            combinations(index+1, digits, result, temp+s.charAt(i), map);
        }
    }
}