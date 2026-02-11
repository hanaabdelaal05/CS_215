
public class LL_SLIST {
	private class LNode
	{
		public int item;
	    public LNode prev;
	    public LNode next;

	    //--------------------------------------------------------------
	    //  Sets up the node
	    //--------------------------------------------------------------
	    public LNode(int newitem)
	    {
	    	item = newitem;
	    	 next = null;
	    	prev = null;
	    }
	}
	private LNode ListEnd;
		
	
	public  LL_SLIST() {
		ListEnd = new LNode(Integer.MAX_VALUE);
		ListEnd.next = ListEnd;
		ListEnd.prev= ListEnd;
		
	}
	boolean isEmpty() {
		return ListEnd.next == ListEnd;
	}
	
	boolean isFull()  {
		return false; //Assume the size of a linked-list based implementation is UNBOUNDED for simplicity		
	}
	
	int getLength() {
		
		
		if(isEmpty()) {
			return 0;
		}
		LNode iterPos = ListEnd.next;
		int length=0;
		while (iterPos != ListEnd) {
			iterPos = iterPos.next;
			length++;
		}
		return length;
	}
	private LNode findItemNode(int fitem,int[] position) {
		position[0]=0;
		LNode nodeIter = ListEnd.next;
		while((nodeIter!=ListEnd)&&(nodeIter.item <fitem)) {
			nodeIter = nodeIter.next;
			position[0]++;
		}
		if(nodeIter.item != fitem) {
			position[0]=-1;
			
		}
		return nodeIter;
	}
	
	int getItem(int gitem) {
		int[] position = new int[1];
		findItemNode( gitem,position);
		return position[0];

	}
	
	void makeEmpty() {
		ListEnd.next = ListEnd; //Garbage collector will take care of the rest!
		ListEnd.prev = ListEnd;
	}
	
	void putItem(int pitem) throws Exception {
		LNode newNode = new LNode(pitem);
		LNode nodeCur = findItemNode(pitem, new int[1]);
		newNode.prev = nodeCur.prev;
		newNode.next = nodeCur;
		nodeCur.prev.next = newNode;
		nodeCur.prev = newNode;
	}
		
	
	void deleteItem(int ditem) throws Exception { //Find the item in question, and "unlink" it		
		int testarr[] = new int[1];
		LNode CurNode = findItemNode(ditem,testarr);
		if (testarr[0]==-1) {
			throw new Exception("Item not in list");
		}
		CurNode.next.prev = CurNode.prev;
		CurNode.prev.next = CurNode.next;
			
	}
	
	

	void printList() { //simple function to print a list's items in stored order
		LNode iterPos = ListEnd.next;
		System.out.print("(");
		while (iterPos != ListEnd) {
			System.out.print(iterPos.item);
			if (iterPos.next != ListEnd)
				System.out.print(", ");
			iterPos = iterPos.next;
		}				
		System.out.println(")");
	}


}
