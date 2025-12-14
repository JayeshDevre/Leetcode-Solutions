class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed=1;
        int maxSpeed=0;
        for(int i: piles){
            maxSpeed=Math.max(i,maxSpeed);
        }

        while(minSpeed<maxSpeed){
            int mid=minSpeed+(maxSpeed-minSpeed)/2;

            if(canEatInTime(piles,h,mid)){
                maxSpeed=mid;
            }else{
                minSpeed=mid+1;
            }
        }
        return minSpeed;
    }

    private boolean canEatInTime(int[] piles, int h, int mid){
        int hour=0;

        for(int pile: piles){
            hour += (int)Math.ceil((double)pile / mid);
        }

        return hour<=h;
    }
}