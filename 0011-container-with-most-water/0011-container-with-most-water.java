class Solution {
    public int maxArea(int[] height) {
        int ans=0;

        int left=0;
        int right=height.length-1;
        while(left<right){

            int area= Math.min(height[left],height[right]) * (right-left);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
            ans=Math.max(ans,area);

        }
        return ans;
    }
}