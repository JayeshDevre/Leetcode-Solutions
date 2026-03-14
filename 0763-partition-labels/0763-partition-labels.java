class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list= new ArrayList<>();

        for(int i=0;i<s.length();i++){
            int startIndex=i;
            int endIndex=s.lastIndexOf(s.charAt(startIndex));

            for(int j=startIndex+1;j<=endIndex-1;j++){
                int lastIndexOfJ=s.lastIndexOf(s.charAt(j));
                if(lastIndexOfJ>endIndex){
                    endIndex=lastIndexOfJ;
                }
            }
            list.add(endIndex-startIndex+1);
            i=endIndex;
        }
        return list;
    }

}