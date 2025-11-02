import java.lang.Math;
public class Practice {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Height of a Binary Tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        return Math.max(leftH,rightH) + 1;
    }

    //Total nodes in a Binary Tree
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int leftN = count(root.left);
        int rightN = count(root.right);
        return leftN + rightN + 1;
    }

    //PreOrder Traversal
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //InOrder Traversal
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //PostOrder Traversal
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //Sum of all nodes in a Binary Tree 
    public static int sum(Node root){
        if(root == null){
            return 0;
        }
        int lf = sum(root.left);
        int rt = sum(root.right);
        return lf + rt + root.data;
    }

    //Diameter of a Binary Tree
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        int leftD = diameter(root.left);
        int rightD = diameter(root.right);
        int selfD = leftH + rightH + 1;
        return Math.max(selfD,Math.max(leftD,rightD));
    }

    public static boolean isIdentical(Node node, Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }
        else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    //SubTree exists or not 
    public static boolean isSubTree(Node root, Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    //Approach 2 for Diameter
    //TC -> O(n)
    static class Info{
        int diam;
        int ht;
        Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    public static Info diameter2(Node root){
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int selfD = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(selfD, ht);
    }


    //Kth level in BinaryTree
    public static void Klevel(Node root, int level, int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        Klevel(root.left, level + 1, k);
        Klevel(root.right, level + 1, k);
    }

    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(diameter2(root).diam);
        
        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);
        // System.out.println(isSubTree(root, subRoot));
    }
}
