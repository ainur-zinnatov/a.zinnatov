package ru.kpfu.itis.group403.zinnatov.binatyTree;



public class Main {

    public static void main(String[] args) {


        BinaryTree bt = new BinaryTree();

        bt.put(5,3);
        bt.put(2,3);
        bt.put(3,24);
        bt.put(1,25);
        bt.put(11,443);
        bt.put(13,2);
        System.out.println(bt.remove(11));
        System.out.println(bt.getSize());
        System.out.println(bt.getRoot().right.key);
        System.out.println(bt.get(11));
        System.out.println(bt.get(5));
        System.out.println(bt.get(2));
        System.out.println(bt.get(3));
        System.out.println(bt.get(1));
        System.out.println(bt.get(11));
        System.out.println(bt.get(13));

    }
}