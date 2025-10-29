class Solution {
    public int bestClosingTime(String customers) {
        int penalty=0;
        int minPenalty=0;
        int hour=0;

        for(Character c:customers.toCharArray()){
            if(c=='Y'){
                penalty++;
            }
        }

        minPenalty=penalty;
        for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='Y'){
                penalty--;
            }else{
                penalty++;
            }

            if(minPenalty>penalty){
                minPenalty=penalty;
                hour=i+1;
            }
        }
        return hour;
    }
}