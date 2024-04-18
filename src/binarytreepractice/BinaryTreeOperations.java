package binarytreepractice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeOperations {
    private Node root;
    BinaryTreeOperations(){
        this.root=buildTree();
//        this.root=null;
    }
    public Node buildTree(){
        Scanner sc=new Scanner(System.in);
        int data= sc.nextInt();
        Node root=null;
        while(data!=-1){
            root=insert(root,data);
            data= sc.nextInt();
        }
       return root;
    }
    Node insert(Node root ,int key){
        if(root==null){
            return new Node(key);
        }
        if(key<=root.data){
            root.left=insert(root.left,key);
        }else{
            root.right=insert(root.right,key);
        }
        return root;
    }
  String search(int key){

        return searchFunction(this.root,key);
    }
    public String searchFunction(Node root,int key){
        if(root==null){
            System.out.print(key+" : ");
            return "Not Present in Binary Tree";
        }
        if(root.data==key){
            System.out.print(key+" : ");
            return "Present in Binary Tree";
        }
        if(root.data>=key){
            return searchFunction(root.left,key);
        }else{
            return searchFunction(root.right,key);
        }

    }
    void removeKey(int key){
        remove(this.root,key);
    }
    // first case here delete only leaf nodes
    Node remove(Node root,int key){
        if(root==null){
            return null;
        }
        if(root.data>key){
            root.left=remove(root.left,key);
        }else if (root.data<key){
            root.right=remove(root.right,key);
        }
        if(root.left==null && root.right==null){
            return null;
        }
        // case 2 if root have one child
        else if (root.left==null) {
            return root.right;
        } else if (root.right==null) {
            return root.left;
        }
        // case 3 if node have two children
        else {
            //find the max node in leftsubtree
            Node temp=root.left;
            while(temp.right!=null){
                temp=temp.right;
            }
            root.data= temp.data;
            root.left=remove(root.left,temp.data);
        }
        return root;

    }
     void displayInorder(){
        System.out.println("INORDER PRINT : ");
        inorderPrint(root);
    }
    public void inorderPrint(Node root){
        if(root==null){
            return;
        }
        inorderPrint(root.left);
        System.out.println(root.data);
        inorderPrint(root.right);
    }
    public void displayPreOrder() {
        System.out.println("PREORDER PRINT : ");
        preorderPrint(root);

    }

    public void preorderPrint(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorderPrint(root.left);
        preorderPrint(root.right);
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
