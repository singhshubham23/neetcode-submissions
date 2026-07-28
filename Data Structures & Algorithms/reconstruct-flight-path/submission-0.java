class Solution {
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private LinkedList<String> it = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0), k-> new PriorityQueue<>()).offer(ticket.get(1));
        }
        dfs("JFK");
        return it;
    }
    private void dfs(String airport){
        PriorityQueue<String> next = graph.get(airport);

        while(next != null && !next.isEmpty()){
            dfs(next.poll());
        }
        it.addFirst(airport);
    }
}
