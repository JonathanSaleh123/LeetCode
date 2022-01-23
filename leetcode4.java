import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

//Flaten Binary Tree to Linked List
class Solution43{
    public void flatten(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode current_node = stack.pop();
            if(current_node.right != null){
                stack.push(current_node.right);
            }
            if(current_node.left !- null){
                stack.push(current_node.left);
            }
            if(!stack.isEmpty()){
                current_node.right = stack.peek();
            }

            current_node.left = null;
        }
    }   
}

//Binary Tree Right Side View
class Solution44{
    public List<Integer> rightSideView(TreeNode root){ 
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return result;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode current_node = queue.poll();
                if(i==0){
                    result.add(current_node.val);
                }
                if(current_node.right != null){
                    queue.offer(current_node.right);
                }
                if(current_node.left != null){
                    queue.offer(current_node.left);
                }
            }
        }
        return result;

    }
}

//Jewels and Stones
class Solution45{
    public int numJewelsIsInStones(String J, String S){
        int num_jewels = 0;

        for(int i = 0; i < S.length(); i++){
            if(J.indexOf(S.charAt(i)) > -1){
                num_jewels +=1;
            }
        }
        return num_jewels;
    }
}

//Sort Linked List (n log n)
//Merge Sort
class Solution46{
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp =head;
        ListNode slow = head;
        listNode fast = head;

        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = null;
        ListNode left_side = sortList(head);
        ListNode right_side = sortList(slow);

        return merge(left_side, right_side);
    }
    public ListNode merge(ListNode l1, ListNode l2){

        ListNode sorted_temp = ListNode(0);
        ListNode current_node = sorted_temp;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                current_node.next = l1;
                l1 = l1.next;
            }else{
                current_node.next = l2;
                l2 = l2.next;
            }
            current_node = current_node.next;
        }

        if(l1 != null){
            current_node.next = l1;
            l1 = l1.next;
        }

        if(l2 != null){
            current_node.next = l2;
            l2 = l2.next;
        }
    }
}

//Search in a binary search tree
class Solution47{
    public TreeNode searchBST(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }

        if(val < root.val){
            return searchBST(root.left, val);

        }else{
            return searchBST(root.right, val);
        }
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] A){
        int left = 0;
        int right = A.length -1;
        while(left < right){
            int midpoint = (left + (right-left)) /2;
            if (A[midpoint] < A[midpoint]){
                left = midpoint + 1;
            }else{
                right = midpoint;
            }
        }

        return right;
    }
}

