package binarytreepractice;

import java.util.Scanner;
public class BinaryTree {
    Node root;

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

    public void display() {
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
}
