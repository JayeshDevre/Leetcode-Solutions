class Solution {
    public String reverseWords(String s) {
      
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        // System.out.println(sb);    

        String s1="";
        String s2=sb.toString();
    // System.out.println(s2);

        String [] st=s2.split(" ");


        for(int i=st.length-1;i>=0;i--){
             s1=s1+" "+st[i];

         }
        return s1.trim();

    }
   
}