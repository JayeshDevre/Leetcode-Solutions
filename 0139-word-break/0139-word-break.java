class Solution {
    private HashSet<String> set;
    private Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        set= new HashSet<>(wordDict);
        dp=new Boolean[s.length()];
        return solve(0,s);
    }

    private boolean solve(int idx, String s){
        if(idx==s.length()){
            return true;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }

        for(int end=idx; end<s.length();end++){
            String split=s.substring(idx, end+1);
            if(set.contains(split) && solve(end+1,s)){
                return dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
}