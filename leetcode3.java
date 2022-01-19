import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.border.LineBorder;
import javax.swing.tree.TreeNode;

//Largest Values of Tree each row
public class Solution32 {
    public List<Integer> largestValues(TreeNode root){
        List<Integer> largest_vals = new ArrayList();

        helper_method(root,largest_vals,0);
        return largest_vals;
    }

    public void helper_method(TreeNode root, List<Integer> vals, int level){
        if(root==null){
            return;
        }
        if(level == vals.size()){
            vals.add(root);
        }else{
            vals.set(level, Math.max(vals.get(level),root.val));
        }

        helper_method(root.left, vals,level +1);
        helper_method(root.right, vals, level+1);
    }
    
}


//Binary Tree Pruning
//Remove every subtree that does not contain 1,
public class Solution33{
    public TreeNode pruneTree(TreeNode root){

        if(root==null){
            return null;
        }
        containsOne(root);
        return root;
    }
    public boolean containsOne(TreeNode node){
        if(node==null) return false;
        boolean left_contains = containsOne(node.left);
        boolean right_contains = containsOne(node.left);
        if(!left_contains){
            node.left = null;
        }
        if(!right_contains){
            node.right = null;
        }

        return node.val == 1 || left_contains || right_contains;
    }
}


//Hand of Straights
public class Solution34{
    public boolean isNStraightHand(int[] hand, int W){
        TreeMap<Integer, Integer> card_counts = new TreeMap();
        
        for(int card : hand){
            if(!card_counts.containsKey(card)){
                card_counts.put(card, 1);
            }else{
                card_counts.replace(card, card_counts.get(card) + 1);
            }
        }

        while (card_counts.size()>0){
            int first_card = card_counts.firstKey();
            for(int i=first_card;i<first_card+ W; i++){
                if(!card_counts.containsKey(i)){
                    return false;
                }
                int count = card_counts.get(i);
                if(count==1){
                    card_counts.remove(i);
                }else{
                    card_counts.replace(i, card_counts.get(i)-1);
                }
            }
        }

    }
}

//Swap Nodes in Pairs
class Solution35{
    public ListNode swapPairs(ListNode head){
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;

        while(current.next != null && current.next.next != null){
            ListNode first_node = current.next;
            ListNode second_node = current.next.next;
            first_node.next = second_node.next;
            current.next = second_node;
            current.next.next = first_node;
            current = current.next.next;
        }

        return temp.next;
    }
}

//Find Bottom Left Tree Value;
//Traverse Right side first
class Solution36{
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.right!= null){
                queue.offer(root.right);
            }
            if(root.left != null){
                queue.offer(root.left);
            }
        }
        return root.val;
    }
}

//Partition List
//Two pointer approach
class Solution37{
    public ListNode partition(ListNode head, int x){
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head!= null){
            if(head.val < x){
                before.next = head;
                before=before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }
}


//Range Sum of BST

class Solution38{
    public int rangeSumBST(TreeNode root, int L, int R){
        int range_sum = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                if (node.val >= L && node.val <= R){
                    range_sum += node.val;
                }
                if(node.val > L){
                    stack.push(node.left);
                }
                if(node.val < R){
                    stack.push(node.right);
                }
            }
        }

        return range_sum;
    }

    //recursive solution
    //range_sum = 0;
    //get_range_sum(root,L,R)
    //return range_sum
    public void get_range_sum(TreeNode root, int L, int R){
        if(root != null){
            if(root.val >= L && root.val <= R){
                range_sum += root.val;
            }
            if(node.val > L){
                get_range_sum(root.left,L,R);
                }
            if(node.val < R){
                get_range_sum(root.right,L,R);
                }
            }
        }
    }



//Univalued Binary Tree

class Solution39{
    public boolean isUnivalTree(TreeNode root){
        boolean left_univaled = root.left == null || root.left.val == root.val && isUnivalTree(root.left);
        boolean right_univaled = root.right == null || root.right.val == root.val && isUnivalTree(root.right);

        return left_univaled && right_univaled;
    }
}


