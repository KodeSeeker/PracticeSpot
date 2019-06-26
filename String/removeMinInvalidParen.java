class Solution {
    
    //Inspired by https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution/207533
    //Idea is BFS. 
    // Why BFS? We want to remove the minimal number of parens that make it invalid
    // Perform an operation where we remove every paren and try to see if the remainder is valid or 
    //not. If yes. add to output list and only explore other options at the same level.
    // since we dont want to remove any more parens!
    
    //Complexity. checking if the string is valid O(n), this is performed 2^N times. N^2^n
    public List<String> removeInvalidParentheses(String s) {
        List<String>  out = new ArrayList<>();
        if(s == null){
            return out;
        }
        Set<String> v = new HashSet<>(); // dont repeat invalid ones
        Queue<String> q = new LinkedList<>();
        v.add(s);
        q.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            int sz = q.size();
            for( int i = 0; i< sz; i++) {
                String curr = q.remove();
                if(isValid(curr)){
                    out.add(curr);
                    found = true;
                }
                if(!found){// ecplore further.
                    for( int j = 0; j < curr.length(); j++){
                        if(Character.isLetter(curr.charAt(j)))
                            continue; // ignore chars
                        String cand = curr.substring(0,j) + curr.substring(j+1); // exclude 
                        if(v.add(cand))
                            q.add(cand);
                    }
                }
            
            }
        }
        return out;
    }
   
    private boolean isValid(String s){
        if( s== null) return false;
        char[] ch = s.toCharArray();
        int count = 0;
        for( char c: ch){
            if(c == '(') count++;
            else if( c == ')') {
                count--;
                if(count < 0)
                    return false;
                
            } 
            //else continue;
        }
        return count == 0;// if left and right are balanced properly . This is an invariant no matter what the string is - as long as it is valid!
    }
}
