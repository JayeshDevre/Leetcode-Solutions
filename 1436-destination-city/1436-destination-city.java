class Solution {
    public String destCity(List<List<String>> paths) {
        if(paths.size()==0){
            return null;
        }
        HashSet<String> cities= new HashSet<>();

        for(List<String> path: paths){
            cities.add(path.get(0));
        }

       

        for(List<String> path: paths){
            String ans=path.get(1);
            if(!cities.contains(ans)){
                return ans;
            }
        }
        return "";
    }
}