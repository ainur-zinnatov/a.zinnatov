package ru.kpfu.itis.group403.zinnatov.MyArrayList;

public class Main  {

    public static void main(String[] args) {
	// write your c de here
	   DynamicList<String> list = new DynamicList<>(4);
	    System.out.println(list.size());
	    list.add("a");
	    list.add("f");
	    list.add("a");
	    list.add("f");
	    list.add("f");
	    list.add("a");
	    list.add(null);
	    System.out.println(list.isEmpty());
	    System.out.println();
	    list.clear();

	    System.out.println(list.toString());
    }
}
