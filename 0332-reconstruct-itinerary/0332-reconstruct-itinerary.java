class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph= new HashMap<>();
        for(List<String> cities: tickets){
            String from=cities.get(0);
            String to=cities.get(1);
            graph.computeIfAbsent(from, k->new ArrayList<>()).add(to);
        }

        for(List<String> destinations: graph.values()){
            Collections.sort(destinations);
        }
        LinkedList<String> iternaries= new LinkedList<>();
        dfs("JFK",graph,iternaries);
        return iternaries;
    }

    private static void dfs(String airport,Map<String, List<String>> graph,LinkedList<String> iternaries){
        List<String> destinations=graph.get(airport);
        while(destinations!=null && !destinations.isEmpty()){
            String next= destinations.remove(0);
            dfs(next,graph,iternaries);
        }
        iternaries.addFirst(airport);
    }
}