package com.concept.pojo;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ListNode {
	
	public int value;
	public ListNode next;
	
	public ListNode() {
		super();
	}

	public ListNode(int value) {
		super();
		this.value = value;
	}

	public ListNode(int value, ListNode next) {
		super();
		this.value = value;
		this.next = next;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
	
	public static LinkedList<ListNode> buildListNode() {
		LinkedList<ListNode> llist = new LinkedList<>();
		 
        // create a list 10->20->30->40->50->60
        for (int i = 60; i >= 10; i -= 10)
            llist.push(new ListNode(i));
		
		return llist;
	}
	
	public static void printList(ListNode head) {
		ListNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}