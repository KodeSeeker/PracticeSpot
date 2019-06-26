class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int i = 0; i<graph.length; i++) {
            if(colors[i]  == -1){
                if(!isBiPartite(i, graph, 0, colors)) {
                    return false;
                }
            }
        }
        return true;   
    }
    
    
boolean isBiPartite(int vertex , int[][] graph, int color, int[] colors){
        colors[vertex] = color; 
        for(int nei: graph[vertex]) {
            if (colors[nei] == -1) {
                //Food for thought - Why cant we return true here?
                //Because we're returning too early before inspective all of the potential neighbors of vertex.. Similar to N Queens!
                if(!isBiPartite(nei, graph, color ^ 1, colors))
                            return false;
            } else if(colors[nei] == colors[vertex]) {
                return false;
            }
        }
        return true;
    }
}

