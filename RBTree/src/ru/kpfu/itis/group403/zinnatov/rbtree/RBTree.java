package ru.kpfu.itis.group403.zinnatov.rbtree;


public class RBTree<Key extends Comparable<Key>,Value>{

	private Node root;

	private static final boolean RED = true;
	private static final boolean BLACK = true;
	private class Node{
		Key key;
		Value value;
		Node left, right;

		boolean color;

		private Node(Key key, Value value,  boolean color) {
			this.key = key;
			this.value = value;
			this.color = color;
		}



	}
	private boolean isRed(Node x){
		if(x==null)return false;
		return x.color ==RED;
	}
	private Node rotateRight(Node h){
		Node x = h.left;
		h.left = h.right;
		x.right = h;
		x.color=h.color;
		h.color = RED;
		return x;
	}
	private Node rotateLeft(Node h){
		Node x = h.right;
		h.right = h.left;
		x.left = h;
		x.color=h.color;
		h.color = RED;
		return x;
	}

	private void flipColors(Node h){
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	public Value get(Key key){

		return get(root,key);
	}

	private Value get(Node node, Key key){

		if (node == null){
			return null;
		}

		int cmp = key.compareTo(node.key);

		if (cmp < 0){
			return get(node.left,key);
		}
		if (cmp > 0){
			return get(node.right,key);
		}
		return node.value;

	}

	public void put(Key key, Value value){
		root = put(root,key,value);
		root.color = BLACK;
	}

	private Node put(Node h,Key key,Value value){
		if(h == null){
			return new Node(key,value,RED);
		}
		int cpt = key.compareTo(h.key);
		if(cpt < 0)h.left = put(h.left,key,value);
		else if (cpt > 0)h.right = put(h.right,key,value);
		else h.value = value;

		if(isRed(h.right)&&isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left)&& isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.right) && isRed(h.left)) flipColors(h);
		return h;
	}


}
