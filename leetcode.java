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


//N-ary Tree Traversal
