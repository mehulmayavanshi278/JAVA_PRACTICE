//import com.sun.source.tree.Tree;
//
//import java.sql.Array;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.*;
//import java.lang.String;
//
//
// class TreeNode{
//    int data;
//    TreeNode left,right;
//    TreeNode(int data){
//        this.data=data;
//        this.left=null;
//        this.right=null;
//    }
//}
//
//
//
//public class TreeQuestion {
//
//    public static TreeNode createBinaryTree(int[] a, int index) {
//
//        TreeNode root = null;
//
//        if (index < a.length && a[index] != 0) {
//            root = new TreeNode(a[index]);
//            root.left = createBinaryTree(a, 2 * index + 1);
//            root.right = createBinaryTree(a, 2 * index + 2);
//        }
//
//        return root;
//
//    }
//
//    public  static int findDepth(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        int leftDepth = findDepth(root.left);
//        int rightDepth = findDepth(root.right);
//        return 1 + Math.max(leftDepth  , rightDepth);
//
//    }
//
//
//
//
//    public  static boolean CheckIsBalenceBinaryTree(TreeNode root){   //balance factor between -1 and 1.   -1>=lefthright-rightheight=<1
//         if(root==null){
//             return true;
//         }
//         // height = depth-1 that's why we passed left or right not directly root;
//         int leftHeight = findDepth(root.left);
//         int rightHeight = findDepth(root.right);
//
//         return (leftHeight-rightHeight >=-1 && leftHeight-rightHeight<=1 ) && CheckIsBalenceBinaryTree(root.left) && CheckIsBalenceBinaryTree(root.right);
//    }
//
//    public static TreeNode CreateSortedArrayToBST(int[] a, int start, int end) {
//
//        if (a.length == 0) {
//            return null;
//        }
//        if (a.length == 1) {
//            return new TreeNode(a[0]);
//        }
//
//        TreeNode root = null;
//        if (start <= end) {
//            int mid = (start + end) / 2;
//            root = new TreeNode(a[mid]);
//            root.left = CreateSortedArrayToBST(a, start, mid - 1);
//            root.right = CreateSortedArrayToBST(a, mid + 1, end);
//        }
//        return root;
//    }
//
//    public static void InorderTreeTraversal(TreeNode root) {
//        if (root != null) {
//            InorderTreeTraversal(root.left);
//            System.out.println(root.data);
//            InorderTreeTraversal(root.right);
//        }
//    }
//
//    public static void PreOrderTraversal(TreeNode root){
//        if(root==null){
//            return;
//        }
//        System.out.println(root.data);
//        PreOrderTraversal(root.left);
//        PreOrderTraversal(root.right);
//    }
//
//    public static void PostOrderTraversal(TreeNode root){
//        if(root==null){
//            return;
//        }
//        PostOrderTraversal(root.left);
//        PostOrderTraversal(root.right);
//    }
//
////    public static List<String> getBinaryTreePath(TreeNode root , List<String> list){
////
////    }
//
//    public Boolean IsSameTree(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) {
//            return true;
//        }
//        if (root1 == null || root2 == null) {
//            return false;
//        }
//        if (root1.data != root2.data) {
//            return false;
//        }
//        return IsSameTree(root1.left, root2.left) && IsSameTree(root1.right, root2.right);
//    }
//
//    public Boolean isSymatricTree(TreeNode root) {
//        return isMirror(root.left, root.right);
//    }
//
//    private Boolean isMirror(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) {
//            return true;
//        }
//        if (root1 == null || root2 == null) {
//            return false;
//        }
//        if (root1.data != root2.data) {
//            return false;
//        }
//        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
//    }
//
//    public int maxDepth(TreeNode root) {
//        int counter = 0;
//        counter = countMaxDepth(root, counter);
//        System.out.println(counter);
//        return counter;
//    }
//
//    public int countMaxDepth(TreeNode root, int counter) {
//        if (root != null) {
//            counter++;
//            return Math.max(countMaxDepth(root.left, counter), countMaxDepth(root.right, counter));
//        }
//        return counter;
//    }
//
//    public static int minDepth(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        if(root.left==null && root.right==null){
//            return 1;
//        }
//        int leftDepth = root.left==null ? 65535 : minDepth(root.left);
//        int rightDepth = root.right==null ? 65535 : minDepth(root.right);
//
//        return 1 +  Math.min(leftDepth , rightDepth);
//    }
//
//
//    public  static boolean checkHasSumPath(TreeNode root , int targetsum){
//        if(root==null){
//            return false;
//        }
//        targetsum = targetsum-root.data;
//
//        if(root.left==null && root.right==null && targetsum==0){
//            return true;
//        }
//
//        return checkHasSumPath(root.left , targetsum) || checkHasSumPath(root.right , targetsum);
//    }
//
//    public static String createStringFromBT(TreeNode root , String s1){
//        if(root==null){
//            return s1;
//        }
//        if(root.left==null && root.right==null){
//            return s1+root.data+")";
//        }
//        s1=s1+root.data+"(";
//        if(root.left==null){
//            s1=s1+")";
//        }
//        s1 =  createStringFromBT(root.left , s1);
//
//        if(root.right==null){
//            return s1+")";
//
//        }
//        s1=s1+"(";
//
//        s1= createStringFromBT(root.right , s1);
//        s1=s1+")";
//      return s1;
//    }
//
//
//    public static int amountOfTime(TreeNode root, int start) {
//
//     return 0;
//
//
//    }
//
//    public static void main(String[] args) {
//
//
////        94  binary tree inorder traversel
////           int[] a = {1 , 2 , 3 , 4 , 5 ,6 , 7};
////           TreeNode root = createBinaryTree(a,0);
////           InorderTreeTraversal(root);
//
////        100  same tree
//
////            int[] a  = {1,2,3,4,5,6,7};
////            int[] b  = {1,2,3,4,5,6,7};
////
////            TreeNode root1 = createBinaryTree(a,0);
////            TreeNode root2 = createBinaryTree(b,0);
////            TreeQuestion T1 = new TreeQuestion();
////            Boolean result = T1.IsSameTree(root1 , root2);
////            System.out.println(result);
//
////        101  is symatric tree
////             int[] a = {1,2,2,3,4,4,3};
////             int[] a = {1,2,2,0 ,3 , 0 , 3};
////             TreeNode root = createBinaryTree(a,0);
////             TreeQuestion T1 = new TreeQuestion();
////             Boolean result = T1.isSymatricTree(root);
////             System.out.println(result);
//
//
////    104  maximum depth of binary tree
////             int[] a = {3,9,20,0,0,15,7};
////             TreeNode root = createBinaryTree(a,0);
////             TreeQuestion T1 = new TreeQuestion();
//
////     108  convert sorted array to binary search tree (BST)
////        int[] a = {1, 2, 3, 4, 5, 6, 7};
////        TreeNode root = CreateSortedArrayToBST(a, 0, 6);
////        InorderTreeTraversal(root);
//
////        110  balance binary tree
////         int[] a = {3,9,20,0,0,15,7};
//////         int[] a = {1,2,2,3,3,0,0,4,4};
////         TreeNode root = createBinaryTree(a , 0);
////         boolean isBalence = CheckIsBalenceBinaryTree(root);
////         System.out.println(isBalence);
//
//
////        111 minimum depth of binary tree
////           int[] a = {3,9,20,0,0,15,7};
////           int[] a = {2,0,3,0,4,0,5,0,6};
////           TreeNode root = createBinaryTree(a , 0);
////           int result = minDepth(root);
////           System.out.println(result);
//
//
////           int[] a = {5,4,8,11,0,13,4,7,2,0,0,0,1};
////           int[] a = {1,2,3};
//////           int targetSum=22;
////           int targetSum=5;
////           TreeNode root = createBinaryTree(a , 0);
////           boolean hasSumPath = checkHasSumPath(root , targetSum);
////           System.out.println(hasSumPath);
//
////         144. Binary Tree Preorder Traversal
////            int[] a = {1 , 0 , 2 , 3};
////            TreeNode l1 = createBinaryTree(a , 0);
////            PreOrderTraversal(l1);
//////            InorderTreeTraversal(l1);
////            PostOrderTraversal(l1);
//
//
////         606. Construct String from Binary Tree
//
////            int[] a = { 1 , 2 , 3  , 4};
////            TreeNode l1=createBinaryTree(a,0);
////            String s1="";
////            s1 = createStringFromBT(l1 , s1);
////            System.out.println();
//
//
////        257. Binary Tree Paths
////        int[] a = {1,2,3,0,5};
////        TreeNode l1 = createBinaryTree(a,0);
////        List<String> list = new ArrayList<>();
////        list = getBinaryTreePath();
////        PrintList(list);
//
////        2385. Amount of Time for Binary Tree to Be Infected
////          int[] a = {1,5,3,0,4,10,6,9,2};
////          TreeNode l1 = createBinaryTree(a);
////          int result = amountOfTime(l1 , 3);
////          System.out.println(result);
//
//
//
//
//
//
//
//
//
//    }
//}





import java.util.HashSet;

public class TreeQuestion {
    // jug1 and jug2 contain the value
    // for max capacity in respective jugs
    // and aim is the amount of water to be measured.
    static int jug1 = 4;
    static int jug2 = 3;
    static int aim = 2;
    // Initialize HashSet with
    // default value as false.
    static HashSet<String> visited = new HashSet<>();

    // Recursive function which prints the
    // intermediate steps to reach the final
    // solution and return boolean value
    // (True if solution is possible, otherwise False).
    // amt1 and amt2 are the amount of water present
    // in both jugs at a certain point of time.
    static boolean waterJugSolver(int amt1, int amt2)
    {

        // Checks for our goal and
        // returns true if achieved.
        if ((amt1 == aim && amt2 == 0)
                || (amt2 == aim && amt1 == 0)) {
            System.out.println(amt1 + " " + amt2);
            return true;
        }

        // Checks if we have already visited the
        // combination or not. If not, then it proceeds
        // further.
        String state = amt1 + " " + amt2;
        if (!visited.contains(state)) {
            System.out.println(state);

            // Changes the boolean value of
            // the combination as it is visited.
            visited.add(state);

            // Check for all the 6 possibilities and
            // see if a solution is found in any one of
            // them.
            return (
                    waterJugSolver(0, amt2)
                            || waterJugSolver(amt1, 0)
                            || waterJugSolver(jug1, amt2)
                            || waterJugSolver(amt1, jug2)
                            || waterJugSolver(
                            amt1 + Math.min(amt2, (jug1 - amt1)),
                            amt2 - Math.min(amt2, (jug1 - amt1)))
                            || waterJugSolver(
                            amt1 - Math.min(amt1, (jug2 - amt2)),+
                            amt2 + Math.min(amt1, (jug2 - amt2))));
        }

        // Return False if the combination is
        // already visited to avoid repetition otherwise
        // recursion will enter an infinite loop.
        else {
            return false;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Steps: ");

        // Call the function and pass the
        // initial amount of water present in both jugs.
        waterJugSolver(0, 0);
    }
}

