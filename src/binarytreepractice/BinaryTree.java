package binarytreepractice;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class BinaryTree {
    private Node root;

    BinaryTree() {
        Scanner sc = new Scanner(System.in);
        root = inputTreeFromUser(sc);
    }

    Node inputTreeFromUser(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node newNode = new Node(data);
        newNode.left = inputTreeFromUser(sc);
        newNode.right = inputTreeFromUser(sc);
        return newNode;
    }

    public void displayPreOrder() {
        System.out.println("PREORDER PRINT : ");
       preorderprint(root);

    }

    public void preorderprint(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorderprint(root.left);
        preorderprint(root.right);
    }
    public void displayInoreder(){
        System.out.println("INORDER PRINT : ");
        inorderprint(root);
    }
    public void inorderprint(Node root){
        if(root==null){
            return;
        }
        inorderprint(root.left);
        System.out.println(root.data);
        inorderprint(root.right);
    }
    public void displayPostorder(){
        System.out.println("POST ORDER : ");
        postorderPrint(root);
    }
    public void postorderPrint(Node root){
        if(root==null){
            return;
        }
        postorderPrint(root.left);
        postorderPrint(root.right);
        System.out.println(root.data);
    }
    public void displayLevelOrder(){
        System.out.println("LEVEL ORDER : ");
        levelOrderPrint(root);
    }
    public void levelOrderPrint(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node que=queue.poll();
            System.out.println(que.data);
            if(que.left!=null){
                queue.offer(que.left);
            }
            if(que.right!=null){
                queue.offer(que.right);
            }
        }
        return;
    }
}
