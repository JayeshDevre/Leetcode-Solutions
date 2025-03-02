class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> list=new ArrayList<>();
        int i=0,j=0;

        while(i<nums1.length && j<nums2.length){
            int id1=nums1[i][0];
            int val1=nums1[i][1];

            int id2= nums2[j][0];
            int val2=nums2[j][1];

            if(id1==id2){
                int sum=val1+val2;
                list.add(new int[]{id1,sum});
                i++;
                j++;
            }else if(id1<id2){
                list.add(new int []{id1,val1});
                i++;
            }else{
                list.add(new int[]{id2,val2});
                j++;
            }
        }

        while(i<nums1.length){
            list.add(nums1[i]);
            i++;
        }

        while(j<nums2.length){
            list.add(nums2[j]);
            j++;
        }


       int [][] result= new int[list.size()][2];
       for(int k=0;k<list.size();k++){
        result[k]=list.get(k);
       }
       return result;

    }
}