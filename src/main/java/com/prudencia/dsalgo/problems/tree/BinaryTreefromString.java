package com.prudencia.dsalgo.problems.tree;

public class BinaryTreefromString {

    public int i=0;
    public TreeNode str2tree(String s) {
        if(s.equals(""))
            return null;
        return dfs(s);
    }

    public TreeNode dfs(String s){
        TreeNode node = null;

        if(s.charAt(i) != '(')  {
            node = new TreeNode(getInteger(s));
        }

        TreeNode leftNode = null, rightNode = null;
        if (i < s.length() && s.charAt(i) == '(') { // for the possible leftNode, if '(' met.
            i++;
            leftNode = dfs(s);
        }
        if (i < s.length() && s.charAt(i) == '(') { // for the possible rightNode, if '(' met.
            i++ ;
            rightNode = dfs(s);
        }
        // if not '(' it must be ')' or i==s.length()
        // so we return the current stack
        node.left = leftNode;
        node.right = rightNode;
        i++;
        return node;

    }

    private int getInteger(String s) {
        StringBuilder sb = new StringBuilder();
        // Extract the numbers. Break if character contains only "(" ")"
        // else increment the global variable
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')')
                break;
            sb.append(s.charAt(i));
            i++;
        }
        int val = Integer.valueOf(sb.toString());
        return val;
    }

    public static void main(String[] args) {
        BinaryTreefromString binaryTreefromString = new BinaryTreefromString();
        binaryTreefromString.str2tree("4(2(3)(1))(6(5))");
        //http://buttercola.blogspot.com/2019/01/leetcode-536-construct-binary-tree-from.html

    }
}

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

/*

 public TreeNode str2tree(String s) {

        if (s.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        for (int index = 0; index < s.length();) {

            TreeNode node = stack.pop();
            int val =0;

            // NOT_STARTED
            if (Character.isDigit(s.charAt(index)) || s.charAt(index) == '-') {

                Pair<Integer, Integer> numberData = this.getNumber(s, index);
                int value = numberData.getKey();
                index = numberData.getValue();

                node.val = value;

                // Next, if there is any data left, we check for the first subtree
                // which according to the problem statement will always be the left child.
                if (index < s.length() && s.charAt(index) == '(') {

                    stack.add(node);

                    node.left = new TreeNode();
                    stack.add(node.left);
                }
            } else if (s.charAt(index) == '(' && node.left != null) { // LEFT_DONE

                stack.add(node);

                node.right = new TreeNode();
                stack.add(node.right);
            }

            ++index;
        }

        return stack.empty() ? root : stack.pop();

    }

    public Pair<Integer, Integer> getNumber(String s, int index) {

        boolean isNegative = false;

        // A negative number
        if (s.charAt(index) == '-') {
            isNegative = true;
            index++;
        }

        int number = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            number = number * 10 + (s.charAt(index) - '0');
            index++;
        }

        return new Pair<Integer, Integer>(isNegative ? -number : number, index);
    }
}
 */