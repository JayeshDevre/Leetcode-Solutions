class Solution {
    public String reorganizeString(String s) {
        int [] hash= new int[26];

        // count the frequency of each character in string

        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }

        // variable max and letter to store occurences and letter 
        int max=0;
        int letter=0;

        // find and store max occurence and letter in hash array
        for(int i=0;i<hash.length;i++){
            if(hash[i]>max){
                max=hash[i];
                letter=i;
            }
        }

        if(max>(s.length()+1)/2){
            return "";
        }

        char [] answer= new char[s.length()];
        int idx=0;

        while(hash[letter]-->0){
            answer[idx]=(char)(letter+'a');
            idx+=2;
        }

        for(int i=0;i<hash.length;i++){
            while(hash[i]-->0){
                if(idx>=answer.length){
                    idx=1;
                }
                answer[idx]=(char) (i+'a');
                idx+=2;
            }
        }

        return String.valueOf(answer);



    }
}