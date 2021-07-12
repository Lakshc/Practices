import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};
public class LevelOrderTraversal {
  
  
  public LevelOrderTraversal() {
    super();
  }

  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>>result=new ArrayList<List<Integer>>();
    List<Integer>currentLevel=new ArrayList<Integer>();
    int level=0;
    Queue<TreeNode> q=new LinkedList<TreeNode>();
    q.offer(root);
    level=1;
    while(!q.isEmpty()){
      ArrayList<Integer> currentList=new ArrayList<Integer>();
      for(int i=0;i<level;i++){
        TreeNode current=q.poll();
        if(current.left!=null)
          q.offer(current.left);
        if(current.right!=null)
          q.offer(current.right);
        currentList.add(current.val);
      }
      level=q.size();
      result.add(currentList);
    }
      
    return result;
    }
  public static void main(String[] args) {
      TreeNode root = new TreeNode(12);
      root.left = new TreeNode(7);
      root.right = new TreeNode(1);
      root.left.left = new TreeNode(9);
      root.right.left = new TreeNode(10);
      root.right.right = new TreeNode(5);
      List<List<Integer>> result =Tester.traverse(root);
      System.out.println("Level order traversal: " + result);
    }
}
