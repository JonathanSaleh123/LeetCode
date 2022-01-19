import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

//DISTRIBUTE COins in binary tree
//return num of moves to distribute the coins evenly
public class Solution40 {
    int num_moves = 0;
    public int distributeCoins(TreeNode root){
        give_coins(root);
        return num_moves;
    }

    public int give_coins(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = give_coins(node.left);
        int right = give_coins(node.right);
        num_moves += Math.abs(left) + Math.abs(right);
        return node.val + left + right -1;
    }
}

//check completenes of binary tree
//First null should be the last node we ever hit

class Solution41{
    public boolean isCompleteTree(TreeNode root){

        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode current_node = queue.poll();
            if(current_node == null){
                end = true;
            }else{
                if(end){
                    return false;
                }
                queue.offer(current_node.left);
                queue.offer(current_node.right);
            }

        }
        return true;
    }
}

//Maximum width of binary tree
//Null Nodes count
//Make the positions in each node, then subtract the right most with leftmost + 1;
class Solution42{
    int max_width;
    HashMap<Integer, Integer> leftmost_positions;
    public int widthOfBinaryTree(TreeNode root){
        max_width = 0;
        leftmost_positions = new HashMap<>();
        get_widths(root,0,0);
        return max_width;
    }

    public void get_widths(TreeNode root, int depth, int position){
        if(root == null){
            return;
        }
        leftmost_positions.computeIfAbsent(depth, x->position);
        //x-> is just a lambda, its the same as position
        max_width = Math.max(max_width, position-leftmost_positions.get(depth)+1);
        get_widths(root.left, depth+1, position*2);
        get_widths(root.right, depth+1, position*2+1);
    }
}