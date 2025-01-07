class Solution {
    public String interpret(String command) {
        String s=command.replace("()","o").replace("(al)","al");
        return s;
    }
}