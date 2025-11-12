class Solution {
    public int calculate(String s) {
        Stack<Integer> stack= new Stack<>();
        int number=0;
        char operator='+';

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(Character.isDigit(ch)){
                number=(number*10)+(ch-'0');
            }

            if(!Character.isDigit(ch) && ch!=' ' || (i == s.length()-1)){
                if(operator=='+'){
                    stack.push(number);
                }else if(operator=='-'){
                    stack.push(number*-1);
                }else if(operator=='*'){
                    stack.push(number*stack.pop());
                }else if(operator=='/'){
                    stack.push(stack.pop()/number);
                }

                number=0;
                operator=ch;
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum=sum+stack.pop();
        }
        return sum;

    }
}