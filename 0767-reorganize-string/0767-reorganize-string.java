class Solution {
    public String reorganizeString(String s) {

        int [] hash= new int[26];
        // Count the frequency of each character
        for(int i=0;i<s.length();i++) {
            hash[s.charAt(i)-'a']++;
        }  


        int max=0;
        int letter=0;
        

        for(int i=0;i<hash.length;i++){
            if(hash[i]>max){
                max=hash[i];
                letter=i;
            }
        }

        if(max> (s.length()+1)/2){
            return "";
        }

        char result[]= new char[s.length()];

        int idx=0;
        while(hash[letter]--> 0){
            result[idx]= (char)(letter +'a');
            idx=idx+2;
        }

        for(int i=0;i<hash.length;i++){
            while(hash[i]-->0){
                if(idx>=result.length){
                    idx=1;
                }
                    result[idx]=(char)(i+'a');
                    idx+=2;

                
            }
        }

        return String.valueOf(result);


    }
}