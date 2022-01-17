//Backspace String Compare
public class Solution20 {
    public boolean backspaceCompare(String S, String T){
        int S_pointer = S.length() -1;
        int T_pointer = T.length()-1;

        int S_skips=0;
        int T_skips = 0;

        while (S_pointer >= 0 || T_pointer >= 0){

            while (S_pointer >= 0){
                if (S.charAt(S_pointer) == '#'){
                    S_skips +=1;
                    S_pointer -= 1;
                    
                }else if(S_skips > 0){
                    S_pointer -=1;
                    S_skips -= 1;
                }else{
                    break;
                }
            }
            while (T_pointer >= 0){
                if (S.charAt(T_pointer) == '#'){
                    T_skips +=1;
                    T_pointer -= 1;
                    
                }else if(T_skips > 0){
                    T_pointer -=1;
                    T_skips -= 1;
                }else{
                    break;
                }
            }

            if (S_pointer >= 0 && T_pointer >= 0 && S.charAt(S_pointer) != T.charAt(T_pointer)){
                return false;
            }

            if ((S_pointer >= 0) != (T_pointer >= 0)){
                return false;
            }
            
            S_pointer -=1;
            T_pointer -=1;
        }
        return true;
    }
}

//Linked List Cycle
//If we dont hit the end, we will cycle and eventually will colide.
public class Solution21{
    public boolean hasCycle(ListNode head){

        if (head==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast){

            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

//Reverse String
class Solution22{
    public void reverseString(char[] s){

        int a_pointer = 0;
        int b_pointer = s.length -1;

        while (a_pointer <= b_pointer){
            char temp = s[a_pointer];
            s[a_pointer] = s[b_pointer];
            s[b_pointer]=temp;

            a_pointer +=1;
            b_pointer -=1;
        }
    }
}

//Valid Palindrom
//Use 2 pointers 1 at begin and 1 at end
class Solution23{
    public boolean isPalindrome(String s){
        String fixString = "";
        for(char c : s.toCharArray()){
            if (Character.isDigit(c) || Character.isLetter(c)){
                fixString += c;
            }
        }

        fixString = fixString.toLowerCase();
        int a_pointer = 0;
        int b_pointer =fixString.length() -1;

        while (a_pointer <= b_pointer){
            if (fixString.charAt(a_pointer) != fixString.charAt(b_pointer)){
                return false;
            }
            a_pointer +=1;
            b_pointer -=1;
        }
        return true;

    }
}

//Middle of Linked List

class Solution24{
    public ListNode middleNode(ListNode head){
        ListNode a_pointer = head;
        ListNode b_pointer = head;
        while (b_pointer != null && b_pointer != null){
            a_pointer = a_pointer.next;
            b_pointer = b_pointer.next.next;
        }
        return a_pointer;
    }
}

//Merge Two Sorted Lists;
class Solution25{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode temp_node = new ListNode(0);
        ListNode curr_node = temp_node;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr_node.next = l1;
                l1 = l1.next;
            }else{
                curr_node.next = l2;
                l2 = l2.next;
            }
            curr_node = curr_node.next;
        }
        if (l1!= null){
            curr_node.next = l1;
            l1 = l1.next;
        }
        if (l1 != null){
            curr_node.next = l2;
            l2 = l2.next;
        }
        return temp_node.next;
    }
}

//Robot return to origin
class Solution25{
    public boolean judgeCircle(String moves){
        int x = 0;
        int y = 0;

        for (char move : moves.toCharArray()){
            if (move == 'U'){
                y += 1;
            }else if (move == 'D'){
                y -=1;
            }
            else if (move == 'L'){
                x -=1;
            }else if (move == 'R'){
                x -=1;
            }
        }
        return (x == 0 && y == 0);
    }
}

//Keys and Rooms

class Solution26{
    public boolean canVisitAllRooms(List<list<Integer>> rooms){
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> keys = new Stack();
        keys.add(0);

        while(!keys.isEmpty()){
            int current_key = keys.pop();
            for(int new_key : rooms.get(current_key)){
                if (!seen[new_key]){
                    seen[new_key] = true;
                    keys.add(new_key);
                }
            }
        }


        for (boolean visited:seen){
            if (!visited) return false;
        }
    }
}


//Squares of a Sorted Array
//Easier in Python
//Take note of negative elements and their squares
class Solution{
    public int[] sortedSquares(int[] A){

        int N = A.length;
        int positive_pointer = 0;
        while(positive_pointer < N && A[positive_pointer] < 0){
            positive_pointer += 1;
        }

        int negative_pointer = positive_pointer -1;

        int[] sorted_squares = new int[N];
        int counter = 0;

        while (negative_pointer >= 0 && positive_pointer < N){
            if (A[negative_pointer] * A[negative_pointer] < A[positive_pointer] * A[positive_pointer]){
                sorted_squares[counter] = A[negative_pointer] * A[negative_pointer];
                counter += 1;
                negative_pointer -=1;
            }else {
                sorted_squares[counter] = A[positive_pointer] * A[positive_pointer]
                counter += 1;
                positive_pointer +=1;
            }
        }

        while (negative_pointer >= 0){
            sorted_squares[counter] = A[negative_pointer] * A[negative_pointer];
            counter += 1;
            negative_pointer -=1;
        }

        while(positive_pointer <= N){
            sorted_squares[counter] = A[positive_pointer] * A[positive_pointer]
            counter += 1;
            positive_pointer +=1;
        }
        return sorted_squares;
    }
}

//Container with Most Water

class Solution27{
    public int maxArea(int[] height){
        int max_area = 0;
        int a_pointer = 0;
        int b_pointer = height.length -1;

        while (a_pointer < b_pointer){
            if (height[a_pointer] < height[b_pointer]){
                max_area = Math.max(max_area, height[a_pointer]*(b_pointer -a_pointer));
                a_pointer +=1;
            }else{
                max_area = Math.max(max_area, height[b_pointer]*(b_pointer -a_pointer));
                b_pointer -=1;
            }
        }
        return max_area;
    }
}

//3sum closest

class Solution28{
    public int threeSumClosest(int[] nums,int target){
        int result = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);

        for(int i=0; i< nums.length-2; i++){
            int a_pointer=i+1;
            int b_pointer = nums.length-1;

            while(a_pointer<b_pointer){
                int current_sum = nums[i] + nums[a_pointer]+nums[b_pointer];
                if (current_sum>target){
                    b_pointer-=1;
                }else{
                    a_pointer+=1;
                }
                if(Math.abs(current_sum-target)< Math.abs(result-target)){
                    result = current_sum;
                }
            }

        }
        return result;
    }
}

