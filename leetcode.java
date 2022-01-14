import java.util.LinkedList;

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

//Palindrome Number
class Solution11{
    public boolean isPalindrome (int x){
        if (x == 0){
            return true;
        }
        if (x < 0 || x % 10 == 0){
            return false;
        }

        int reversed = 0;
        while (x > reversed){
            int pop = x % 10;
            x /= 10;

            reversed = (reversed * 10)+ pop;
        }
        if (x == reversed || x == (reversed/10)){
            return true;
        }else{
            return false;
        }
    }
}


// Reverse Integer
//Stack
class Solution12{
    public int reverse(int x){

        int reversed = 0;
        int pop;
        while (x != 0){
            pop = x %10;
            x /= 10;
            reversed = (reversed * 10)+ pop;
        }
        return reversed;
    }
}

//Maximum Depth of Binary Tree 
//Height of tree

class Solution13{
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int left_depth = maxDepth(root.left)
        int right_depth  = maxDepth(root.right)
        return Math.max(left_depth, right_depth)+1
    }
}

//isSymetric Tree 
class Solution14{
    public boolean isSymmetric (TreeNode root){
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 ==null){
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }
        return (t1.val == t2.val) && isMirror (t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

//Path Sum Trees
class Solution15{
    public boolean hasPathSum(TreeNode root, int sum){
        if (root==null){
            return false;
        }
        Stack<TreeNode> node_stack = new Stack();
        Stack<Integers> sum_stack = new Stack();

        node_stack.add(root);
        sum_stack.add(sum-root.val);

        while(!node_stack.isEmpty()){
            TreeNode current_node = node_stack.pop();
            int current_sum = sum_stack.pop();

            if (current_node.left == null && current_node.right == null &&current_sum ==0){
                return true;
            }
            if (current_node.left != null){
                node_stack.add(current_node.left);
                sum_stack.add(current_sum - current_node.left.val);
            }
            if (current_node.right != null){
                node_stack.add(current_node.right);
                sum_stack.add(current_sum - current_node.right.val);
            }
        }
        return false;
    }
}

//Binary Search
class Solution16{
    public int search(int[] nums, int target){
        if (nums.length == 0)return -1;

        int left = 0;
        int right = nums.length -1;

        while (left <= right){
            int midpoint = left +(right -left) /2;
            if(nums[midpoint]==target){
                return midpoint;
            }
            else if (nums[midpoint]> target){
                right = midpoint -1;

            }else {
                left = midpoint + 1;

            }
        }
        return -1;
    }

}


//To Lower Case
class Soltion17{
    public String toLowerCase(String str){
        String result = "";
        for (Char c : str.toCharArray()){
            if (Character.isUpperCase(c)){
                result = result + (char)(c+32);
            }
            else {
                result = result + c;
            }
        }
        return result;
    }
}

// Odd Even Linked list (medium)
//1-2-3-4-5
// output : 1-3-5-2-4
//2-1-3-5-6-4-7
//out : 2-3-6-7-1-5-4

class Solution18{
    public ListNode oddEvenList(ListNode head){

        if (head==null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}

//First Bad Version
//Binary Search

class Solution19{
    public int firstBadVersion(int n){

        int left = 0;
        int right = n;

        while (left < right){
            int midPoint = left + (right-left) /2;
            if (isBadVersion(midPoint)){
                right = midPoint;
            }else{
                left = midPoint + 1;
            }
        }
        if (left == right && isBadVersion(left)){
            return left;
        }
        return -1;
    }
    
    
}

