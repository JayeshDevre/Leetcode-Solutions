class Solution {
    public int numberOfSteps(int num) {
        int steps=0;
        steps=steps(num,0);
        return steps;

    }

    public int steps(int num,int s){

        if(num==0){
            return s;
        }

        if(num%2==0){
            
            return steps(num/2,s+1);
            
        }
       
        return steps(num-1,s+1);
    }


}