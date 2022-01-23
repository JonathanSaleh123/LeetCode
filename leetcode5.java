//Sumof left leaves only
class Solution49 {
    public int sumOfLeftLeaves(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum_of_left = 0;

        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                sum_of_left += root.left.val;
            }else{
                sum_of_left += sumOfLeftLeaves(root.left);
            }
        }

        if(root.right != null){
            if(root.right.left != null || root.right.right != null) {
                sum_of_left += sumOfLeftLeaves(root.right);
            }
        }
        return sum_of_left;
    }

    public int sumOfLeftLeaves2(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum_of_left = 0;

        Stack<TreeNode> stack = new Stack();
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.left != null){
                if(node.left.left == null && node.left.right == null){
                    sum_of_left += node.left.val;
                }else{
                    stack.add(node.left);
                }
            }
            if(node.right != null )

        }
        return sum_of_left
    }
}


//Reverse Only letters
class Solution50{
    public String reverseOnlyLetters(String S){

        Stack<Character> letters = new Stack();
        for(int i = 0; i < S.length();i++){
            if(Character.isLetter(S.charAt(i))){
                letters.push(S.charAt(i));
            }
        }

        StringBuilder reversed_string = new StringBuilder();

        for(int i = 0; i < S.length(); i++){
                if(Charcter.isLetter(S.charAt(i))){
                    reversed_string.append(letters.pop());
                }else{
                    reversed_string.append(S.charAt(i));
                }
        }

        return reversed_string.toString();
    }

    public String reverseOnlyletters(String S){
        StringBuilder reversed_string = new StringBuilder();
        int j = S.length()-1;

        for(int i = 0; i< S.length();i++){
            if(Character.isLetter(S.charAt(i))){
                while(!Character.isLetter(S.charAt(j))){
                j--;
                }
                reversed_string.append(S.charAt(j));
                j--;
            }else{
                reversed_string.append(S.charAt(i));
            }
        }
        return reversed_string;
    }
}


//Spiral Matrix

class Solution51{
    public List<Integer> spiralOrder(int[][] matrix){

        List<Integer> res = new ArrayList();
        if(matrix.length == 0){
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length -1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && columnBegin <= columnEnd){
            for(int i=columnBegin; i <= columnEnd ; i++ ){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin ++;

            for(int i=rowBegin;i<rowEnd; i++){
                res.add(matrix[i][columnEnd]);
            }
            columnEnd--;
            if(rowBegin <= rowEnd){
                for(int i =columnEnd; i >= columnBegin; i--){
                    res.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            if(columnBegin <= columnEnd){
                for(int i=rowEnd; i>= rowBegin;i--){
                    res.add(matrix[i][columnBegin]);
                }
            }
            columnBegin++;
        }

        return res;
    }
}