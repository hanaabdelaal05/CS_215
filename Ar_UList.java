package ulist;

public class Ar_UList {
	private int length;
	private int[] listItems;
	private boolean indexFound;
	private static  final int MaxSize= 10;
	private int currentPos;
	public Ar_UList() {
		listItems = new int[MaxSize];
		length = 0;
		
		
	}
	public int  getLength() {
		return length;
	}
	public boolean isFull() {
		return length==MaxSize;
	}
	public void putItem(int pitem) throws Exception{
		if (length<MaxSize) {
			listItems[length]= pitem;
			length++;
		}
		
	}
	public void deleteItemSwap(int ditem)throws Exception {
		for(int i=0;i<length;++i) {
			if (listItems[i]==ditem){
				listItems[i]= listItems[length-1];
				length--;
				break;
			}
			
		}
	}
	public void deleteItemShift(int ditem)throws Exception{
		for(int i =0;i<length-1;i++) {
			if(listItems[i]==ditem) {
				indexFound=true;
			}
			if(indexFound ) {
				listItems[i]= listItems[i+1];
			}
		}
		length--;
	}
	public void makeEmpty() {
		length = 0;
		
	}
	public int getNextItem() throws Exception {
		 return listItems[currentPos++];
	}
	public void ResetList() {
		currentPos = 0;
	}
	public int getItem(int gitem) {
		for (int loc = 0; loc < length; loc++) {
	        if (listItems[loc] == gitem) {
	        	return listItems[loc];
	        }
	        
		}
		return-1;
	            
	        
	}
	public 	void printList() { 
		System.out.print("(");
		for (int loc=0; loc<length; loc++) {
		  	System.out.print(listItems[loc]);
			if (loc<length-1)
		             	  System.out.print(", ");
		}
		System.out.println(")");
	}

	
	
	
}
