class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[i]>= temperatures[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                result[i]=0;
            }else{
                result[i]=stack.peek()-i;
            }

            stack.push(i);
        }

        return result;

    }
}