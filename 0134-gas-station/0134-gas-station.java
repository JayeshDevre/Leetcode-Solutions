class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;

        for(int i=0; i<gas.length; i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }

        if(totalCost>totalGas){
            return -1;
        }

        int startIndex=0;
        int gasr=0;

        for(int i=0;i<gas.length;i++){
            gasr+=gas[i]-cost[i];

            if(gasr<0){
                startIndex=i+1;
                gasr=0;
            }
        }

        return startIndex;
    }
}