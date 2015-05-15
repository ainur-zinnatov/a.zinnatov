package ru.kpfu.itis.group403.zinnatov.binatyTree;


import java.util.Map;


public class BinaryTree<K,V>   {
	private Node root = null;
	private int size = 0;

	public void put(K key, V val){
		this.size++;
		if(root == null){
			root = new Node(key,val);
		}
		else {
			put(key, val, root);
		}
	}

	public Node getRoot() {
		return root;
	}

	public int getSize() {
		return size;
	}

	public void put(K key, V val,Node root1) {

		Node node = new Node(key,val);
		if(root == null){
		    root = root1;
		}
		else{
			int comparison = compare(root1.key, node.key);
			if (comparison >0) {
				if (root1.left != null) {
					put(key, val, root1.left);
				} else {
					root1.left = node;
				}
			} else {
				if (root1.right != null) {
					put(key, val, root1.right);
				} else {
					root1.right = node;
				}
			}
		}
	}

	public V get(K key) {
		Node node = this.root;
		while (true) {
			int comparison = compare(node.key, key);
			if (comparison == 0) {
				return node.val;
			} else if (comparison > 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
	}
	public V remove(K key){
		return remove(key,root);
	}
	public V remove(K key, Node r) {

			V val = null;
			int comparison = compare(r.key, key);
			if (comparison > 0) {
				if (r.left != null) {
				return remove(key, r.left);
				}
			}else if( comparison < 0 ){
				if (r.right != null) {
				return remove(key, r.right);
				}
			}else if( comparison == 0){
				val = r.val;
				Node rN = r.right;
				Node lN= r.left;
				r=null;
				if(rN!=null){
					r = rN;
					if(lN!=null){
						put(lN.key,lN.val,r);
					}
				}
				else if(lN!=null){
					r = lN;
				}
				else {
					r = null;
				}
				return val;
			}


		return null;
	}

	Map.Entry<K, V> iteratot() {
		return new Map.Entry<K, V>() {
			@Override
			public K getKey() {
				return null;
			}

			@Override
			public V getValue() {
				return null;
			}

			@Override
			public V setValue(V value) {
				return null;
			}
		};
	}


	public int compare(K k1, K k2) {
		Comparable<K> comparable = (Comparable<K>)k1;
		return comparable.compareTo(k2);
	}

	public class Node{
		K key;
		V val;

		Node right;
		Node left;

	    public Node(K key, V val) {
		    this.key = key;
		    this.val = val;
	    }
    }





}
