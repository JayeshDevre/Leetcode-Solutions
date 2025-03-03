class Solution {
    public boolean isHappy(int n) {
        int fast=n;
        int slow=n;

        do{
            slow=Happy(slow);
            fast=Happy(Happy(fast));

        }while(fast!=slow);

        if(slow==1){
            return true;
        }
        return false;
    }

    public int Happy(int n){
        int ans=0;
        while(n>0){
            int rem=n%10;
            ans+=rem*rem;
            n=n/10;
        }
        return ans;
    }
}