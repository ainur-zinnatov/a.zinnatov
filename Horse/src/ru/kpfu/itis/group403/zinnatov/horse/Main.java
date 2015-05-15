package ru.kpfu.itis.group403.zinnatov.horse;

public class Main {

    public static void main(String[] args) {
		Alg a =new Alg();
	    char m [][] = new char[][]{
			    {'0','0',' ','0','0'},
			    {' ','0',' ',' ',' '},
			    {'0','*','-',' ',' '},
			    {' ','*',' ','0',' '},
			    {'0','0','0',' ',' '},
	    };
	   Node node = a.search(3, 1, 2, 1, m);
	    while(node.parrent != null){
		    System.out.println(node.x+"-"+node.y);
		    node = node.parrent;
	    }
	    System.out.println(node.x+"-"+node.y);
	}
}
