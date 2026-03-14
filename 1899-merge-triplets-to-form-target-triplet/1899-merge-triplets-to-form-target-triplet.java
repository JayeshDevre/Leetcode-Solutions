class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int [] ans= new int[3];

        for(int [] triplet: triplets){
            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){
                ans[0]= Math.max(ans[0], triplet[0]);
                ans[1]= Math.max(ans[1], triplet[1]);
                ans[2]= Math.max(ans[2], triplet[2]);
            }
        }

        return ans[0]==target[0] && ans[1]==target[1] && ans[2]==target[2];
    }
}