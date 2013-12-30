import java.util.Scanner;
import java.util.ArrayList;

public class TreeNode {

    TreeNode left = null;
    TreeNode right = null;
    int value = -1;

    TreeNode(int v, TreeNode l, TreeNode r) {
        value = v;
        left  = l;
        right = r;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static boolean hasPathSum(TreeNode tn, int sum) {
        if (sum < 0) return false;
        if (sum == 0) {
            if (tn == null) return true;
            else return false;
        }
        if (tn == null) return false;

        sum -= tn.value;
        return hasPathSum(tn.left, sum) || hasPathSum(tn.right, sum);
    }

    public static void printPaths(TreeNode tn, ArrayList<TreeNode> preNodes) {
        if (tn == null) return;
        else {
            preNodes.add(tn);
            if (tn.left != null)
                printPaths(tn.left, new ArrayList<TreeNode>(preNodes));
            if (tn.right != null)
//                printPaths(tn.right, new ArrayList<TreeNode>(preNodes));
                printPaths(tn.right, (ArrayList<TreeNode>)preNodes.clone());
            if (tn.left == null && tn.right == null) {
                for (TreeNode n : preNodes) {
                    System.out.print(n + " -> ");
                }
                System.out.println();
            }
        }
    }

    public static void main (String[] args) {
        TreeNode tn1 = new TreeNode(7, null, null);
        TreeNode tn2 = new TreeNode(2, null, null);
        TreeNode tn3 = new TreeNode(13, null, null);
        TreeNode tn4 = new TreeNode(1, null, null);
        TreeNode tn5 = new TreeNode(11, tn1, tn2);
        TreeNode tn6 = new TreeNode(4, tn5, null);
        TreeNode tn7 = new TreeNode(4, null, tn4);
        TreeNode tn8 = new TreeNode(8, tn3, tn7);
        TreeNode tn9 = new TreeNode(5, tn6, tn8);

//        Scanner scan = new Scanner(System.in);
//        while (true) {
//            int input = scan.nextInt();
//            if (input == -1) return;
//            boolean result = TreeNode.hasPathSum(tn9, input);
//            System.out.println(result);
//        }
//
      TreeNode.printPaths(tn9, new ArrayList<TreeNode>());
    }
}

