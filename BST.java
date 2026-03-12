package bst;

public class BST {
	private class TNode{
		public int item;
		TNode left;
		TNode right;
		public TNode(int newitem) {
			this.item = newitem;
			left = null;
			right = null;
		}
	}
	TNode root;
	public BST() {
		root = null;
	}
	private TNode insert(TNode curnode, int newitem) {
		if (curnode==null) {
			curnode = new TNode(newitem);
		}
		else if(newitem < curnode.item) {
			curnode.left=insert(curnode.left,newitem);
		}
		else {
			curnode.right=insert(curnode.right,newitem);
		}
		return curnode;
	}
	public void putItem(int newitem) {
		root = insert(root,newitem);
	}
	void printNodes(TNode curnode) {
		if(curnode!= null) {
			printNodes(curnode.left);
			System.out.print(curnode.item+", ");
			printNodes(curnode.right);
		}
	}
	boolean isEmpty(){
		return root ==null;
	}
	void printTree() {
		if(isEmpty()) {
			System.out.println("Empty Tree");
		}
		else {
				printNodes(root);
		}
	}
	private int findItem(TNode curnode, int gitem){
		if (curnode==null) {
			return -1;
		}
		else if (curnode.item == gitem) {
			return curnode.item;
		}
			
		else if (curnode.item > gitem) {
			return findItem(curnode.left, gitem);
		}
						
				
		else {
			return findItem(curnode.right, gitem);
		}
		
	}
	
	public int getItem(int gitem) {
		return findItem(root,gitem);
	}
	
	
}

	




