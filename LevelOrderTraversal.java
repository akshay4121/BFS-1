/* Tc: O(n) n:no. of nodes  
 *  SC: O(n) n: no. of nodes
 * Approach: I will have a queue which would at any instance would have all the nodes on the same level. Also, i will keep track of level. As soon as i visit next level i will create my empty list for that particular level.And, at the end of the level i will add the List to the result List.
 * 
 */








/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */






class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;

        if(root == null) return res;
        q.add(root);

        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> levelResult = new ArrayList<>();

            for(int i = 0 ; i< len ; i++){
                TreeNode curr = q.poll();
                levelResult.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            res.add(levelResult);
            level++;
        }
    return res;  
    }
}




//Recursive Solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);

        return res;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> res){

        if(root == null) return;

        if(res.size() == level) res.add(new ArrayList<>());

        res.get(level).add(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res); 
    }
}
