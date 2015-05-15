package ru.kpfu.itis.group403.zinnatov.horse;

import java.util.ArrayList;

/**
 * Created by hp on 11.05.2015.
 */
public class Alg {

	Node root = new Node();

	public Node[] horse(int x,int y,char board [][]){
		char m[][] = board;
		Node [] node = new Node[8];
		int i = 0;
		if(x+1<m.length && y+2<m.length && x+1>=0 && y+2>=0) {
			if (m[x + 1][y + 2] != '0'){
				node[i]=new Node();

				node[i].x = x + 1;
				node[i].y = y + 2;
				i++;
			}

		}
		if(x-1<m.length && y+2<m.length && x-1>=0 && y+2>=0) {
			if (m[x- 1][y + 2] != '0'){
				node[i]=new Node();

				node[i].x = x - 1;
				node[i].y = y + 2;
				i++;
			}

		}
		if(x+1<m.length && y-2<m[0].length && x+1>=0 && y-2>=0) {
			if (m[x + 1][y - 2] != '0'){
				node[i]=new Node();

				node[i].x = x + 1;
				node[i].y = y - 2;
				i++;
			}

		}
		if(x-1<m.length && y-2<m.length && x-1>=0 && y-2>=0) {
			if (m[x - 1][y - 2] != '0'){
				node[i]=new Node();

				node[i].x = x - 1;
				node[i].y = y - 2;
				i++;
			}

		}

		if(x+2<m.length && y+1<m.length && x+2>=0 && y+1>=0) {
			if (m[x + 2][y + 1] != '0'){
				node[i]=new Node();

				node[i].x = x + 2;
				node[i].y = y + 1;
				i++;
			}

		}
		if(x-2<m.length && y+1<m.length && x-2>=0 && y+1>=0) {
			if (m[x- 2][y + 1] != '0'){
				node[i]=new Node();

				node[i].x = x - 2;
				node[i].y = y + 1;
				i++;
			}

		}
		if(x+2<m.length && y-1<m.length && x+2>=0 && y-1>=0) {
			if (m[x + 2][y - 1] != '0'){
				node[i]=new Node();

				node[i].x = x + 2;
				node[i].y = y - 1;
				i++;
			}

		}
		if(x-2<m.length && y-1<m.length && x-2>=0 && y-1>=0) {
			if (m[x - 2][y - 1] != '0'){
				node[i]=new Node();

				node[i].x = x - 2;
				node[i].y = y - 1;
				i++;
			}

		}

		Node[] nodes = new Node[i+1];
		for (int j = 0; j <i ; j++) {
			nodes[j]=node[j];
		}
		return nodes;
	}

	public Node search (int x1,int y1,int x2, int y2,char array[][]){
		this.root.x = x1;
		this.root.y = y1;
		this.root.array = horse(x1,y1,array);
		for (int i = 0; i <this.root.array.length-1 ; i++) {
			root.array[i].parrent = new Node();
			root.array[i].parrent = root;
			if(root.array[i].x == x2 && root.array[i].y == y2 ) return root.array[i];
		}


		Node [] node = root.array;
		ArrayList<Node> nodeList = new ArrayList<Node>();

		while(true){
		for (int i = 0; i <node.length-1 ; i++) {
			node[i].array=horse(node[i].x,node[i].y,array);

		}

		for (int i = 0; i < node.length-1; i++) {
			for (int j = 0; j < node[i].array.length-1; j++) {

				nodeList.add(node[i].array[j]);
				node[i].array[j].parrent=node[i];
			}
		}

		Node n;
		for (int i = 0; i < nodeList.size()-1; i++) {
			n=nodeList.get(i);
			if(n.x == x2 && n.y == y2 ) return n;
		}
			Node[] n1 = new Node[nodeList.size()-1];
			for (int i = 0; i < nodeList.size()-1 ; i++) {
				n1[i]=nodeList.get(i);
			}
		node = n1;
		nodeList.clear();
		}


	}

}
