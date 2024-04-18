package binarytreepractice;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTreeOperations bst = new BinaryTreeOperations();
        bst.displayInorder();
        bst.removeKey(7);
//        bst.preorderPrint();
        bst.displayInorder();
        bst.displayPostorder();
        System.out.println(bst.search(200));
        System.out.println(bst.search(470));


    }
}
