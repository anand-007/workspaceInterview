package com.anand.test;

public class TreeTest {
	
	
	
	public static void main(String[] args){
		
		

		TreeNode child3 = new TreeNode(null, null, 4);
		TreeNode child4 = new TreeNode(null, null, 5);

		TreeNode child5 = new TreeNode(null, null, 6);
		TreeNode child6 = new TreeNode(null, null, 7);
		
		TreeNode child1 = new TreeNode(child4, child3, 2);
		TreeNode child2 = new TreeNode(child6, child5, 3);

		TreeNode root = new TreeNode(child2, child1, 1);
		
		System.out.println(root.heightOfTree(root));
		root.print(root);
		
	}
	
	
	

}
