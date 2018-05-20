package com.anand.interview.linkedlist;

public class LinkedListRunner {
	
	public static LinkedListNode reverseLinkedList(LinkedListNode head){
		
		LinkedListNode current = head;
		LinkedListNode temp = head;
		LinkedListNode previous = null;
		LinkedListNode next = head;
		
		while(current != null){
			
			 temp = current.next;
			 current.next = previous;
			 previous = current;
			 current = temp;
			
		}
		
		return previous;
		
	}
	
	public static LinkedListNode reverseLinkedListInChunks(LinkedListNode head, int k){
		
		LinkedListNode prev= null;
		LinkedListNode current = head;
		LinkedListNode temp = head;
		int count = 0;
		
		
		while(current!=null && count<k){
			
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
			count++;
			
		}
		
		if(temp != null){
			head.next = reverseLinkedListInChunks(temp, k);
		}
		
		return prev;
		
	}

	public static void main(String[] args) {
		
		LinkedListNode list1 = new LinkedListNode();
		list1.data= 10;
		LinkedListNode list2 = new LinkedListNode();
		list2.data= 20;
		LinkedListNode list3 = new LinkedListNode();
		list3.data= 30;
		LinkedListNode list4 = new LinkedListNode();
		list4.data = 40;
		LinkedListNode list5 = new LinkedListNode();
		list5.data = 50;
		
		list1.next = list2;
		list2.next = list3;
		list3.next = list4;
		list4.next = list5;
		list5.next = null;

		//LinkedListNode reversedList = reverseLinkedList(list1);
		
		LinkedListNode reversedList = reverseLinkedListInChunks(list1, 3);
		
		while(reversedList!=null){
			System.out.print(reversedList.data + "->");
			reversedList = reversedList.next;
		}
		
		// TODO Auto-generated method stub

	}

}
