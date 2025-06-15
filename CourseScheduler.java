/* Tc: O(V+E) v:no. of vertices, E: no. of edges. 
 *  SC: O(V+E) v:no. of vertices, E: no. of edges.
 *  Approach: Initially i will be creating adjacency list and simultaneously fill my inDegree[], HashMap would be used to store my PreRequisites so that i can access in O(1). At first, i will add all the nodes with inDegree = 0.  Loop though my queue, iterate though the prerequisite for that particular course
 * and decrease my inDegree by 1 each time.Also, if at anytime my inDegree becommes 0 for any course, i will add it to my queue. At each poll() i will increment my count. At the end if my count equals courses, then i will return true else false
 */


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        HashMap<Integer, List<Integer>> hmap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        //create adjacency list and fill indegree []
        for(int[] p : prerequisites){
            int independent = p[1];  //independent
            int dependent = p[0]; 
            inDegree[dependent]++;

            if(!hmap.containsKey(independent)){
                hmap.put(independent, new ArrayList<>());
            }
            hmap.get(independent).add(dependent);
        }

         for(int i = 0; i< inDegree.length; i++){
            if(inDegree[i] == 0) {
                q.add(i);
                count++;
         }}

         while(!q.isEmpty()){
            int current = q.poll();
            if(hmap.get(current) != null){
            for(int i : hmap.get(current)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    q.add(i);
                    count++;
                } 
            }
            }
            
         if(count == numCourses) return true; 
        }
    return false; 
    }
}