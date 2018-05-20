package com.anand.test;

public class TreeNode {
	
	TreeNode right;
	TreeNode left;
	int data;
	
	TreeNode(TreeNode right, TreeNode left, int data){
		this.data = data;
		this.right = right;
		this.left = left;
	}
	
	int heightOfTree(TreeNode root){
		if(root == null)
			return -1;
		return 1+Math.max(heightOfTree(root.left), heightOfTree(root.right));
	}

	void print(TreeNode root){
		if(root == null)
			return;
		System.out.print(root.data + " -> ");

		print(root.left);
		print(root.right);

	}
}
