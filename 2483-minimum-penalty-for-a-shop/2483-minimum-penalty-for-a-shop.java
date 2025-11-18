class Solution {
    public int bestClosingTime(String customers) {
        int bestTime=0;
        int penalty=0;
        int minPenalty=0;
        for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='Y'){
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
            if(penalty<minPenalty){
                minPenalty=penalty;
                bestTime=i+1;
            }
        }
        return bestTime;

        
    }
}