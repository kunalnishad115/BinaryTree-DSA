package binarytreepractice;


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
    }
}
