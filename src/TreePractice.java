import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 学习JAVA
 *
 * @项目名称：
 * @计通2204李志杨
 * @Date：2023/5/13 - 05 - 13 - 15:52
 * @version： 1.0
 * @功能：
 */
public class TreePractice {
    public static void main(String [] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);
        root.left.right.left=new TreeNode(5);

        root.left.right.right=new TreeNode(6);

        root.right.left.left=new TreeNode(6);

        root.right.left.right=new TreeNode(5);
        System.out.println(isSymmetric(root));
    }
      public static class TreeNode {
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
    public int maxDepth(TreeNode root) {
          return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
      }
    public boolean isValidBST(TreeNode root,long leftMax,long rightMin) {
          if(root==null) return true;
          if(root.val>=leftMax||root.val<=rightMin) return false;
          return isValidBST(root.left,root.val,rightMin)&&isValidBST(root.right,leftMax,root.val);
    }
    TreeNode pre;
    public boolean isValidBSTZX(TreeNode root) {
          if(root==null )return true;
          if(!isValidBST(root.left)) return false;
          if(pre!=null&&pre.val>=root.val) return false;
          pre=root;
          if(!isValidBST(root.right)) return false;
          return true;
    }
    public static boolean isSymmetricLJ(TreeNode root) {
        if(root ==null) return true;
        String str1=isSymmetricL(root.left);
        String str2=isSymmetricR(root.right);
        System.out.println(str1+"\n"+str2);
        if(str1.length()!=str2.length()) return false;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)) return false;
        }
        return true;
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root ==null) return true;
        return isSymmetric(root.left,root.right);
    }
    public static boolean isSymmetric(TreeNode left,TreeNode right) {
        if(left==null&&right==null) return true;
        if(left==null||right==null||left.val!=right.val) return false;
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
    public static String isSymmetricL(TreeNode root) {
        if(root ==null) return "!";
        StringBuilder str1=new StringBuilder();
        str1.append(root.val);
        str1.append(isSymmetricL(root.left));
        str1.append(isSymmetricL(root.right));
        return str1.toString();
    }
    public static String isSymmetricR(TreeNode root) {
        if(root ==null) return "!";
        StringBuilder str1=new StringBuilder();
        str1.append(root.val);
        str1.append(isSymmetricR(root.right));
        str1.append(isSymmetricR(root.left));
        return str1.toString();
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int count=q.size();
            for(int i=0;i<count;i++){
                TreeNode cur=q.poll();
                temp.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            ans.add(temp);
        }
        return ans;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int L,int R) {
        TreeNode mid=new TreeNode(nums[L+(R-L)>>2]);
        if(R-L==0) return mid;
        mid.left=sortedArrayToBST(nums,L,(R-L)>>2);
        mid.right=sortedArrayToBST(nums,(R-L)>>2,R);
        return mid;
    }
}
