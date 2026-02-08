class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min=0;
        int max=0;

        for(int w: weights){
            min=Math.max(w,min);
            max=max+w;
        }

        while(min<max){
            int mid=min+(max-min)/2;

            int sum=0;
            int day=1;
            for(int weight : weights){
                if(sum+weight> mid){
                    day++;
                    sum=0;
                }
                sum=sum+weight;
            }

            if(day>days){
                min=mid+1;
            }else{
                max=mid;
            }
        }
        return min;
    }
}