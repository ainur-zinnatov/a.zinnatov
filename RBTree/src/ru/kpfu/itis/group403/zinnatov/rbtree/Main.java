package ru.kpfu.itis.group403.zinnatov.rbtree;

public class Main {

    public static void main(String[] args) {

     RBTree<Integer,String> rbTree = new RBTree();
        rbTree.put(12,"a");
        rbTree.put(10,"b");
        rbTree.put(11,"c");
        rbTree.put(13,"d");
        rbTree.put(15,"e");
        System.out.printf(rbTree.get(11));
        System.out.printf(rbTree.get(12));
        System.out.printf(rbTree.get(13));
        System.out.printf(rbTree.get(15));

    }
}
