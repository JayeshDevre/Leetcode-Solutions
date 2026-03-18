class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n= intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));

        int lastEndTime=intervals[0][1];
        int cnt=1;

        for(int i=1;i<n;i++){
            if(lastEndTime<=intervals[i][0]){
                lastEndTime=intervals[i][1];
                cnt++;
            }
        }

        return n-cnt;
    }
}