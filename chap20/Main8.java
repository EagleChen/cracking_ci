import java.util.ArrayList;
import java.util.HashMap;
public class Main8 {
    public static void main (String[] args) {
        String test = "mississippi";
        String[] strList = {"is", "sip", "hi", "sis"};
        SuffixTrieTree tree = new SuffixTrieTree(test);
        for (String str: strList) {
            ArrayList<Integer> indexes = tree.search(str);
            if (indexes != null)
                System.out.println("found " + str + " : " + indexes.toString());
        }
    }
}

class SuffixTrieTree {
    private SuffixTrieTreeNode root = new SuffixTrieTreeNode();

    SuffixTrieTree(String str) {
        for (int i = 0; i < str.length(); i++) {
            root.insert(str.substring(i), i);
        }
    }

    ArrayList<Integer> search(String str) {
        return root.search(str);
    }
}

class SuffixTrieTreeNode {
    HashMap<Character, SuffixTrieTreeNode> children = new
        HashMap<Character, SuffixTrieTreeNode>();
    ArrayList<Integer> indexes = new ArrayList<Integer>();

    void insert(String str, int index) {
        if (str == null || str.length() == 0) return;
        indexes.add(index);

        char v = str.charAt(0);
        String sub = str.substring(1);
        if (children.containsKey(v)) {
            children.get(v).insert(sub, index);
        } else {
            SuffixTrieTreeNode node = new SuffixTrieTreeNode();
            children.put(v, node);
            node.insert(sub, index);
        }
    }

    ArrayList<Integer> search(String str) {
        if (str == null) return null;
        if (str.length() == 0) return indexes;

        char v = str.charAt(0);
        if (children.containsKey(v)) {
            return children.get(v).search(str.substring(1));
        } else return null;
    }
}
