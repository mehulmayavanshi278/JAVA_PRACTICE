import com.sun.source.tree.Tree;

import java.awt.geom.QuadCurve2D;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.lang.String;


 class TreeNode{
    int data;
    TreeNode left,right , next;
    TreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}



public class TreeQuestion {

    public static void PrintIntList(List<Integer> list){
        for(int elm : list){
            System.out.print(elm + " ");
        }
        System.out.println("");
    }

    public static void PrintIntdoublList(List<List<Integer>> list){

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println("");
        }


    }

    public static TreeNode createBinaryTree(int[] a, int index) {

        TreeNode root = null;

        if (index < a.length && a[index] != 0) {
            root = new TreeNode(a[index]);
            root.left = createBinaryTree(a, 2 * index + 1);
            root.right = createBinaryTree(a, 2 * index + 2);
        }

        return root;

    }

    public static TreeNode createBinarySrhTree(int[] a , int i){
        if(i==a.length-1){
            return new TreeNode(a[i]);
        }
        TreeNode root = new TreeNode(a[i]);
        if(i<a.length){
           if(a[i]>a[i+1]){
              root.left = createBinarySrhTree(a , i+1);
           }else {
               root.right=createBinarySrhTree(a , i+1);
           }
        }
        return root;
    }

    public  static int findDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);
        return 1 + Math.max(leftDepth  , rightDepth);

    }




    public  static boolean CheckIsBalenceBinaryTree(TreeNode root){   //balance factor between -1 and 1.   -1>=lefthright-rightheight=<1
         if(root==null){
             return true;
         }
         // height = depth-1 that's why we passed left or right not directly root;
         int leftHeight = findDepth(root.left);
         int rightHeight = findDepth(root.right);

         return (leftHeight-rightHeight >=-1 && leftHeight-rightHeight<=1 ) && CheckIsBalenceBinaryTree(root.left) && CheckIsBalenceBinaryTree(root.right);
    }


    public static void isValidBSTHLPR(TreeNode l1 , List<Integer> list){
        if(l1==null){
            return;
        }
        isValidBSTHLPR(l1.left  , list);
        list.add(l1.data);
        isValidBSTHLPR(l1.right , list);
    }

    public static  boolean isValidBST(TreeNode l1){
        List<Integer> list = new ArrayList<>();
        isValidBSTHLPR(l1 , list);
//        PrintIntList(list);
        boolean isValid =  true;
        for(int i=1;i<list.size();i++){
            if(list.get(i)<list.get(i-1)){
                isValid=false;
            }
        }
        return  isValid;
    }

    public static TreeNode CreateSortedArrayToBST(int[] a, int start, int end) {

        if (a.length == 0) {
            return null;
        }
        if (a.length == 1) {
            return new TreeNode(a[0]);
        }

        TreeNode root = null;
        if (start <= end) {
            int mid = (start + end) / 2;
            root = new TreeNode(a[mid]);
            root.left = CreateSortedArrayToBST(a, start, mid - 1);
            root.right = CreateSortedArrayToBST(a, mid + 1, end);
        }
        return root;
    }

    public static void InorderTreeTraversal(TreeNode root) {
        if (root != null) {
            InorderTreeTraversal(root.left);
            System.out.println(root.data);
            InorderTreeTraversal(root.right);
        }
    }

    public static void PreOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }

    public static void PostOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
    }

//    public static List<String> getBinaryTreePath(TreeNode root , List<String> list){
//
//    }

    public Boolean IsSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return IsSameTree(root1.left, root2.left) && IsSameTree(root1.right, root2.right);
    }

    public Boolean isSymatricTree(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private Boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    public int maxDepth(TreeNode root) {
        int counter = 0;
        counter = countMaxDepth(root, counter);
        System.out.println(counter);
        return counter;
    }

    public int countMaxDepth(TreeNode root, int counter) {
        if (root != null) {
            counter++;
            return Math.max(countMaxDepth(root.left, counter), countMaxDepth(root.right, counter));
        }
        return counter;
    }

    public static int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int leftDepth = root.left==null ? 65535 : minDepth(root.left);
        int rightDepth = root.right==null ? 65535 : minDepth(root.right);

        return 1 +  Math.min(leftDepth , rightDepth);
    }


    public  static boolean checkHasSumPath(TreeNode root , int targetsum){
        if(root==null){
            return false;
        }
        targetsum = targetsum-root.data;

        if(root.left==null && root.right==null && targetsum==0){
            return true;
        }

        return checkHasSumPath(root.left , targetsum) || checkHasSumPath(root.right , targetsum);
    }

    public static String createStringFromBT(TreeNode root , String s1){
        if(root==null){
            return s1;
        }
        if(root.left==null && root.right==null){
            return s1+root.data+")";
        }
        s1=s1+root.data+"(";
        if(root.left==null){
            s1=s1+")";
        }
        s1 =  createStringFromBT(root.left , s1);

        if(root.right==null){
            return s1+")";

        }
        s1=s1+"(";

        s1= createStringFromBT(root.right , s1);
        s1=s1+")";
      return s1;
    }


    public static int amountOfTime(TreeNode root, int start) {

     return 0;


    }

    List<Integer> leftViewHlpr(TreeNode t1 , List<Integer> l1){
        l1.add(t1.data);
        if(t1.left==null){
            return l1;
        }

        return leftViewHlpr(t1.left , l1);
    }

    List<Integer> leftView(TreeNode l1){
        List<Integer> rs = new ArrayList<>();
        return leftViewHlpr(l1 , rs);
    }


    void levelOrderHlpr(TreeNode t1 , Map<Integer , List<Integer>> hashmap , int i){
      if(t1==null){
          return;
      }

        levelOrderHlpr(t1.left , hashmap , i+1);
        if(hashmap.get(i)==null){
          List<Integer> l1 = new ArrayList<>();
          l1.add(t1.data);
          hashmap.put(i , l1);
        }else {
            List<Integer> l1 = hashmap.get(i);
            l1.add(t1.data);
            hashmap.put(i , l1);
        }

        levelOrderHlpr(t1.right , hashmap , i+1);


    }

    List<List<Integer>> levelOrder(TreeNode t1){
        Map<Integer , List<Integer>> hashmap = new HashMap<>();
         levelOrderHlpr(t1 , hashmap , 0);
          List<List<Integer>> list = new ArrayList<>();
          for(Map.Entry<Integer , List<Integer>> entry : hashmap.entrySet()){
              list.add(entry.getValue());
              System.out.println(entry.getValue());
              entry.getValue().get(entry.getValue().size()-1);
          }
        return list;
    }



       int diameterOfBinaryTreeHlpr(TreeNode t1){
       if(t1==null){
           return Integer.MIN_VALUE;
       }

       int lh = findDepth(t1.left);
       int rh = findDepth(t1.right);

       int lll = diameterOfBinaryTreeHlpr(t1.left);
       int rrr = diameterOfBinaryTreeHlpr(t1.right);

       return  Math.max(lh+rh , Math.max(lll , rrr));



    }
    int diameterOfBinaryTree(TreeNode t1){
      int max=0;
      max=diameterOfBinaryTreeHlpr(t1);
      return max;
    }



    public static int findMaxSum(TreeNode t1){
        if(t1==null){
            return 0;
        }



        int max1 = findMaxSum(t1.left);
        int max2 = findMaxSum(t1.right);

       return t1.data +  Math.max(max1 , max2);



    }



     int maxPathSumHlpr(TreeNode t1 , int max){
        if(t1==null){
            return max;
        }
        int m =   findMaxSum(t1);
        System.out.println(m);
        max=Math.max(max , m);
        int l1  = maxPathSumHlpr(t1.left,max);
        System.out.println("l1 is " + l1);
        int l2 =  maxPathSumHlpr(t1.right,max);
         System.out.println("l2 is " + l2);

         max = Math.max(max , t1.data+l1+l2);

//        max = Math.max()

      return max;
    }

    int maxPathSum(TreeNode t1){
        int max=0;
        max = maxPathSumHlpr(t1 , 0);
        return max;
    }



    TreeNode flatten(TreeNode l1){
         if(l1.left==null && l1.right==null){
             return null;
         }
         if(l1.right==null || l1.left==null){
             return null;
         }
        flatten(l1.right);
        flatten(l1.left);
        TreeNode x = l1.right;
        l1.right=l1.left;
        l1.left=null;
        TreeNode l2=l1;
        while (l2.right!=null){
            l2=l2.right;
        }
        l2.right=x;
        return l1;
    }

    TreeNode connect(TreeNode l1 , int i){
        if(l1==null){
            return null;
        }
        connect(l1.left , i+1);
        System.out.println( "i " + i + " " + l1.data);
        l1.next=l1.right;
        connect(l1.right , i+1);
        return null;
    }



    public static  int kthSmallestHLPR(TreeNode l1 , int k , int x , TreeNode ans){
       if(l1==null){
           return 0;
       }

       int p= kthSmallestHLPR(l1.left , k , x , ans);
        System.out.println("ara"+ l1.data);

       int q=kthSmallestHLPR(l1.right , k , x, ans);


       return 1+p+q;
    }
    TreeNode kthSmallest(TreeNode l1 , int k){
      int x=0;
      TreeNode ans = null;
      int p =  kthSmallestHLPR(l1 , k  , x , ans);
//      System.out.println(ans.data);
      return l1;
    }

    void verticalTraversalHLPR(TreeNode l1 , Map<Integer , List<Integer>> hashmap , int i){
      if(l1==null){
          return;
      }
        List<Integer> list1 = new ArrayList<>();


        verticalTraversalHLPR(l1.left , hashmap , i-1);

        if(hashmap.size()==0){
            list1.add(l1.data);
            hashmap.put(i , list1);
        }else {

            if(hashmap.get(i)==null){
                list1.add(l1.data);
                hashmap.put(i , list1);
            }else {
                list1=hashmap.get(i);
                list1.add(l1.data);
                hashmap.put(i , list1);
            }

        }

        verticalTraversalHLPR(l1.right , hashmap , i+1);


    }

    List<List<Integer>> verticalTraversal(TreeNode l1){

        Map<Integer  , List<Integer>> hashmap = new HashMap<>();
        List<List<Integer>> tmp = new ArrayList<>();
         verticalTraversalHLPR(l1,hashmap , 0);
         for(Map.Entry<Integer , List<Integer>> entry : hashmap.entrySet()){
//             System.out.println(entry.getValue());
             tmp.add(entry.getValue());
         }
        return tmp;
    }



    void widthOfBinaryTreeHLPR(TreeNode l1 , Map<Integer , List<Integer>> hashmap , int i){


        if(l1==null){
            return;
        }
        List<Integer> tmp = hashmap.getOrDefault(i , new ArrayList<>());
        tmp.add(tmp.size()+1);
        hashmap.put(i , tmp);

        widthOfBinaryTreeHLPR(l1.left , hashmap , i+1);
        widthOfBinaryTreeHLPR(l1.right , hashmap , i+1);

    }
    int widthOfBinaryTree(TreeNode l1){
        int rs = 0;
        Map<Integer , List<Integer>> hashmap = new HashMap<>();
        widthOfBinaryTreeHLPR(l1 , hashmap , 0);
        for(Map.Entry<Integer , List<Integer>> entry : hashmap.entrySet()){
             System.out.println(entry.getValue());
//            tmp.add(entry.getValue());
        }
        return rs;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permute(nums, used, tempList, result);
        return result;
    }

    private static void permute(int[] nums, boolean[] used, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                tempList.add(nums[i]);
                used[i] = true;
                permute(nums, used, tempList, result);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {


//        94  binary tree inorder traversel
//           int[] a = {1 , 2 , 3 , 4 , 5 ,6 , 7};
//           TreeNode root = createBinaryTree(a,0);
//           InorderTreeTraversal(root);

//        100  same tree

//            int[] a  = {1,2,3,4,5,6,7};
//            int[] b  = {1,2,3,4,5,6,7};
//
//            TreeNode root1 = createBinaryTree(a,0);
//            TreeNode root2 = createBinaryTree(b,0);
//            TreeQuestion T1 = new TreeQuestion();
//            Boolean result = T1.IsSameTree(root1 , root2);
//            System.out.println(result);

//        101  is symatric tree
//             int[] a = {1,2,2,3,4,4,3};
//             int[] a = {1,2,2,0 ,3 , 0 , 3};
//             TreeNode root = createBinaryTree(a,0);
//             TreeQuestion T1 = new TreeQuestion();
//             Boolean result = T1.isSymatricTree(root);
//             System.out.println(result);


//    104  maximum depth of binary tree
//             int[] a = {3,9,20,0,0,15,7};
//             TreeNode root = createBinaryTree(a,0);
//             TreeQuestion T1 = new TreeQuestion();

//     108  convert sorted array to binary search tree (BST)
//        int[] a = {1, 2, 3, 4, 5, 6, 7};
//        TreeNode root = CreateSortedArrayToBST(a, 0, 6);
//        InorderTreeTraversal(root);

//        110  balance binary tree
//         int[] a = {3,9,20,0,0,15,7};
////         int[] a = {1,2,2,3,3,0,0,4,4};
//         TreeNode root = createBinaryTree(a , 0);
//         boolean isBalence = CheckIsBalenceBinaryTree(root);
//         System.out.println(isBalence);


//        111 minimum depth of binary tree
//           int[] a = {3,9,20,0,0,15,7};
//           int[] a = {2,0,3,0,4,0,5,0,6};
//           TreeNode root = createBinaryTree(a , 0);
//           int result = minDepth(root);
//           System.out.println(result);


//           int[] a = {5,4,8,11,0,13,4,7,2,0,0,0,1};
//           int[] a = {1,2,3};
////           int targetSum=22;
//           int targetSum=5;
//           TreeNode root = createBinaryTree(a , 0);
//           boolean hasSumPath = checkHasSumPath(root , targetSum);
//           System.out.println(hasSumPath);

//         144. Binary Tree Preorder Traversal
//            int[] a = {1 , 0 , 2 , 3};
//            TreeNode l1 = createBinaryTree(a , 0);
//            PreOrderTraversal(l1);
////            InorderTreeTraversal(l1);
//            PostOrderTraversal(l1);


//         606. Construct String from Binary Tree

//            int[] a = { 1 , 2 , 3  , 4};
//            TreeNode l1=createBinaryTree(a,0);
//            String s1="";
//            s1 = createStringFromBT(l1 , s1);
//            System.out.println();


//        257. Binary Tree Paths
//        int[] a = {1,2,3,0,5};
//        TreeNode l1 = createBinaryTree(a,0);
//        List<String> list = new ArrayList<>();
//        list = getBinaryTreePath();
//        PrintList(list);

//        2385. Amount of Time for Binary Tree to Be Infected
//          int[] a = {1,5,3,0,4,10,6,9,2};
//          TreeNode l1 = createBinaryTree(a);
//          int result = amountOfTime(l1 , 3);
//          System.out.println(result);


//         Left View of Binary Tree
//              int[] a = {10,20,30,40,60};
//              TreeNode l1 = createBinaryTree(a , 0);
//              TreeQuestion t1 = new TreeQuestion();
//              List<Integer> result = t1.leftView(l1);
//              PrintIntList(result);


//      102  Level Order Traversal of a Binary Tree
//        int[] a = {1,3,2,5,0,0,9,6,0,7};
//        TreeNode l1 = createBinaryTree(a , 0);
//        TreeQuestion t1 = new TreeQuestion();
//        List<List<Integer>> result = t1.levelOrder(l1);
//        PrintIntdoublList(result);



//        543. Diameter of Binary Tree
//        int[] a = {1,3,2,5,0,0,9,6,0,7};
//        int[] a = {1,2,3,4,5};
//        int[] a = {1,2};
//        int[] a = {4,-7,-3,0,0,-9,-3,9,-7,-4,0,6,0,-6,-6,0,0,0,6,5,0,9,0,0,-1,-4,0,0,0,-2};
//        TreeNode l1 = createBinaryTree(a , 0);
//        TreeQuestion t1 = new TreeQuestion();
//        int result = t1.diameterOfBinaryTree(l1);
//        System.out.println(result);

//        124. Binary Tree Maximum Path Sum
//            int[] a = {-10,9,20,0,0,15,7};
////            int[] a = {2,-1};
//            TreeQuestion T1 = new TreeQuestion();
//            TreeNode l1 = createBinaryTree(a , 0);
//            int sum = T1.maxPathSum(l1);
//            System.out.println(sum);


//        114. Flatten Binary Tree to Linked List
//               int[] a = {1,2,5,3,4,0,6};
//               TreeQuestion T1 = new TreeQuestion();
//               TreeNode l1 = createBinaryTree(a , 0);
//               TreeNode l2 = T1.flatten(l1);
//               InorderTreeTraversal(l2);

        //        116 populating next right pointrs in each noDe
//                    int[] a = {1,2,3,4,5,6,7};
//                    TreeQuestion t1 = new TreeQuestion();
//                    TreeNode l1 = createBinaryTree(a , 0);
//                    l1 = t1.connect(l1 , 0);
//                    InorderTreeTraversal(l1);



//        1008. Construct Binary Search Tree from Preorder Traversal

//           int[] a = {8,5,1,7,10,12};
//           TreeQuestion t1 = new TreeQuestion();
//           TreeNode l1 = createBinarySrhTree(a,0);
//           InorderTreeTraversal(l1);

//        98. Validate Binary Search Tree
//            int[] a = {5,1,4,0,0,3,6};
//            TreeQuestion t1 = new TreeQuestion();
//            TreeNode l1 = createBinaryTree(a,0);
//            boolean isvali = t1.isValidBST(l1);
//            System.out.println(isvali);

//        ninjas


//        230. Kth Smallest Element in a BST
//             int[] a = {5,3,6,2,4,0,0,1};
//             int k=3;
//             TreeQuestion t1 = new TreeQuestion();
//             TreeNode l1=createBinaryTree(a,0);
//              l1 = t1.kthSmallest(l1,k);
//              System.out.println(l1.data);

//        987. Vertical Order Traversal of a Binary Tree
////            int[] a = {3,9,20,0,0,15,7};
//            int[] a = {1,2,3,4,5,6,7};
//            TreeQuestion t1 = new TreeQuestion();
//            TreeNode l1 = createBinaryTree(a,0);
//            List<List<Integer>> list = t1.verticalTraversal(l1);
//            PrintIntdoublList(list);

////        236. Lowest Common Ancestor of a Binary Tree
//               int[] a = {3,5,1,6,2,0,8,0,0,7,4};
//               TreeQuestion t1 = new TreeQuestion();
//               TreeNode l1 = createBinaryTree(a,0);
//               int rs = t1.lowestCommonAncestor()


//        662. Maximum Width of Binary Tree
//              int[] a = {1,3,2,5,0,0,9,6,0,7};
////              int[] a = {1,3,2,5,3,0,9};
//              TreeQuestion t1 = new TreeQuestion();
//              TreeNode l1 = createBinaryTree(a , 0);
//              int rs = t1.widthOfBinaryTree(l1);
//              System.out.println(rs);



//        96. Unique Binary Search Trees

















    }
}







