class Solution {
    public int climbStairs(int n) {
        int result=0;

        if(n<=2){
            return n;
        }

        int prev=1;
        int latest=1;


        for(int i=2;i<=n;i++){
            int temp=latest;
            latest=prev+latest;
            prev=temp;
        }

        return latest;
    }
}