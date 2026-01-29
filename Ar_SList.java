package slist;

public class Ar_SList {
	public static final int MAXSIZE = 10;
	private int[] Listitems;
	private int length;
	private int currentPos = 0;
	
	public Ar_SList() {
		length = 0;
		Listitems = new int [MAXSIZE];
	}
	public void putItem(int pitem) {
		int aloc = 0;
		boolean moreToSearch=  aloc<length;
		while(moreToSearch) {
			if (pitem< Listitems[aloc]) {
				moreToSearch=false;
			}
			else {
				aloc++;
				moreToSearch=  aloc<length;
			}
		}
		for(int i =length; i>aloc;i--) {
			Listitems[i]=Listitems[i-1];
		}
		Listitems[aloc]= pitem;
		length++;
	}
	public void deleteItem(int ditem) {
		int aloc = 0;
		boolean moreToSearch = true;
		while(moreToSearch&& aloc<length) {
			if(ditem == Listitems[aloc]) {
				moreToSearch = false;
			}
			else {
				aloc++;
			}
		}
		for (int i =aloc;i<length;i++) {
			if(i<MAXSIZE-1) {
				Listitems[i]=Listitems[i+1];
			}
		}
		length --;
	}
	public int getItem(int gitem) {
		int midpoint = 0, first = 0, last = length 
				-1;
		boolean moreToSearch = first<=last;
		while(moreToSearch) {
			midpoint =(first+last)/2;
			if(gitem==Listitems[midpoint]) {
				return midpoint;
			}
			else if(gitem<Listitems[midpoint]) {
				last = midpoint-1;
			}
			else {
				first = midpoint+1;
			}
			moreToSearch = first<=last;

		}
		return -1;
		
	}
	public void makeEmpty() {
		length = 0;
	}
	public boolean isFull() {
		return length ==MAXSIZE;
	}
	public void resetList() {
		currentPos = 0;
	}
	public int getNextItem() {
		currentPos++;
		return Listitems[currentPos-1];
	}
	public void printList() {
		System.out.print("(");
		for(int loc=0;loc<length;loc++) {
			System.out.print(Listitems[loc]);
			if(loc<length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(")");
	}
	public int getLength() {
		return Listitems.length;
	}

}
