//Contains Duplicate
class Solution{
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> numbers = new HashSet<>();

        for(int i = 0; i < nums.length;i++){
            if (numbers.contains(nums[i])){
                return true;
            }
            numbers.add(nums[i]);
        }
        return false
    }
}

class Solution2{
    public boolean containsDuplicate(int[] nums){
        Ararys.sort(nums);
        
        for(int i = 0;i< nums.length; i++){
            if(nums[i] ==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}

//Reverse Linked List

class Solution3{
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

//Two sum II, already sorted
class Solution4{
    public int[] twoSum(int[] numbers, int target){
        int a_ind = 0;
        int b_ind = numbers.length -1;

        while(a_ind <= b_ind){
            int sum = numbers[a_ind]+numbers[b_ind];

            if(sum >target){
                b_ind -= 1;
            }else if (sum < target){
                a_ind +=1;
            }else{
                return new int[] { a_ind+1, b_ind+1};
            }
            
        }
        return new int[] {a_ind+1, b_ind+1};
    }
}

//Palindrome linked list
class Solution5{
    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reversed(slow);
        fast = head;

        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast=fast.next;
        }
        return true;
    }

    public ListNode reversed(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next= head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
//This solution is to find the halfway point and see if it is good backwards.


//N-ary Tree Traversal Postorder (Bottom to top)
class Solution6{
    public List<Integer> postorder(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output_arr = new LinkedList<>();

        if (root == null){
            return output_arr;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            output_arr.addFirst(node.val);
            for (Node child : node.children){
                stack.add(child);
            }
        }
        return output_arr;
    }
}
//N-ary Tree Traversal Inorder (Left subtree to right)
class Solution7{
    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output_arr = new ArrayList<>();

        if(root == null){
            return output_arr;
        }

        TreeNode current = root;
        while (current != null || stack.isEmpty()){
            while(current!= null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            output_arr.add(current.val);
            current = current.right;
        }
        return output_arr;
    }
}

//N-ary Tree Traersal Pre-order (Top to bottom)
class Solution8{
    public List<Integer> preorder(Node root){
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> output_arr = new LinkedList<>();

        if (root==null){
            return output_arr;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pollLast();
            output_arr.add(node.val);
            Collections.reverse(node.children); 
            //Reverses the linked list as it usually goes from left to right
            for (Node child : node.children){
                stack.add(child);
            }
        }
        return output_arr;
    }
}


//Merge Two Binary Trees

class Solution9{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}

//Invert Binary Tree
//First Glance Solution make a stack and make a new tree
class Solution10{
    public TreeNode invertTree(TreeNode root){
        if (root == null){
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //swap
        root.right = left;
        root.left = right;

        return root;
    }
}

//
