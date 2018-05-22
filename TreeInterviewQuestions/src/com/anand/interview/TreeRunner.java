package com.anand.interview;
import java.util.*;

public class TreeRunner {
	
	TreeNode deepNode = null;
	static int level=0;
	static int maxLevel = -1;
	
	static HashMap<String,Integer> m = new HashMap<String,Integer>();
	
	public static TreeNode findInorderSuccessor(TreeNode root, TreeNode inputNode){
		
		TreeNode resultNode = null;
		
		return resultNode;
		
	}
	
	public static TreeNode findLowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2){
		
		if(root==null){
			return null;
		}
		
		
		if((root == node1) || (root==node2))
			return root;
		
		TreeNode leftNode = findLowestCommonAncestor(root.left, node1, node2);
		TreeNode rightNode = findLowestCommonAncestor(root.right, node1, node2);
		
		if(leftNode!=null && rightNode !=null){
			return root;
		}
		
		if(leftNode==null && rightNode ==null){
			return null;
		}
		
		return leftNode!=null?leftNode:rightNode;
	
	}
	
	
	//      20
	//     /  \
	//    10   30
	public static boolean checkIfBST(TreeNode root, int minimum, int maximum){
	
			if(root == null)
				return true;
			
//			if(root.data>maximum){
//				return false;
//			}
//			
//			if(root.data<minimum){
//				return false;
//			}
			
			if (root.data<maximum && root.data>minimum && checkIfBST(root.left,minimum, root.data-1) && checkIfBST(root.right,root.data+1,maximum))
				return true;
			else 
				return false;
	
	}
	
	public static int[] randomize(int[] inputArray){
		
		Random r = new Random();
		
		for(int i=inputArray.length-1;i>0;i--){
			int j = r.nextInt(i);
			int temp = inputArray[i];
			inputArray[i] = inputArray[j];
			inputArray[j] = temp;
		}
		
		return inputArray;
		
	}
	
	public static void findNextLargestNumber(int[] inputArray){
		
	}
	
	public static String findDuplicateSubTrees(TreeNode root){
		
		if(root == null)
			return "";
		
		String str = "(";
		str+= findDuplicateSubTrees(root.left);
		str+= root.data;
		str+= findDuplicateSubTrees(root.right);
		str+= ")";
		
		System.out.println(str);
		
		if(m.get(str)!=null && m.get(str)==1){
			System.out.println("Hosico"+str);
		} 
		
		if(m.get(str)!=null){
			m.put(str, m.get(str)+1);
		} else {
			m.put(str, 1);
		}
		
		return str;
		
		
	}
	
	public static void inOrderDepth(int level, int maxLevel, TreeNode root){
		if(root==null)
			return;
		inOrderDepth(level++, maxLevel, root.left);
		if(level>maxLevel){
			maxLevel = level;
			System.out.println(root.data);
		}
		inOrderDepth(level, maxLevel, root.right);

		
	}
	
	public static int height(TreeNode root){
		if(root == null){
			return 0;
		}
		
		return 1+ Math.max(height(root.left),height(root.right));	
	}
	
	public static void deepNode(TreeNode root, int levels){
		if(levels == 1){
			System.out.println(root.data);
		} else {
			deepNode(root.left, levels-1);
			deepNode(root.right, levels-1);
		}
	}
	
	public static TreeNode findDeepestNode(TreeNode root){
		TreeNode resultNode = null;
		
		int levels = height(root);
		deepNode(root,levels);
		
			
		return resultNode;
	}
	
	public static void reverseTree(TreeNode root){
		
		if(root == null)
			return;
		
		if(root !=null){
			TreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		
		 reverseTree(root.left);
		 reverseTree(root.right);
	}
	
	public static void printKthNode(TreeNode root, int k){
		if(root == null)
			return;
		if(k==0){
			System.out.println(root.data);
		}
		printKthNode(root.left, k-1);
		printKthNode(root.right, k-1);
	}
	
	public static boolean hasSum(TreeNode root, int sum){
		
		if(root == null){
			return false;
		}
		
		boolean result = false;
		
		sum = sum - root.data;
		if(sum==0){
				return true;
			
		}
		
		if(root.left!=null){
			result = result || hasSum(root.left, sum); 
		}
		
		if(root.right!=null){
			result = result || hasSum(root.right, sum); 
		}
		
		return result;
		
	}
	
	public static int findDistancefromRoot(TreeNode root, TreeNode x){
		if(root == null){
			return -1;
		}
		int distance = -1;
		if((root.data == x.data ) || ((distance = findDistancefromRoot(root.left, x)) >=0) ||((distance = findDistancefromRoot(root.left, x)) >=0) ){
			return distance+1;
		}
		return distance;
	}
	
	
	public static boolean areIdentical(TreeNode node1, TreeNode node2){
		if(node1==null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null)
			return false;
		
		return (node1.data == node2.data) && (areIdentical(node1.left,node2.left) && areIdentical(node1.right, node2.right));
	       /* base cases */
	       /* base cases */

	}
	
	public static void inOrderTraversal(TreeNode root){
		
		if(root == null){
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data+ "->");
		inOrderTraversal(root.right);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode bottom6 = new TreeNode(12, null, null);

		TreeNode bottom1 = new TreeNode(20, bottom6, null);
		TreeNode bottom2 = new TreeNode(35, null, null);
		TreeNode bottom3 = new TreeNode(45, null, null);
		TreeNode bottom4 = new TreeNode(55, null, null);
		
		TreeNode mid1 = new TreeNode(30, bottom1, bottom2);
		TreeNode mid2 = new TreeNode(50, bottom3, bottom4);
		
		TreeNode root = new TreeNode(40, mid1, mid2);
		
		//findDuplicateSubTrees(root);
		
		System.out.println(findDistancefromRoot(root, mid1));
		
//		int[] outputArray = randomize(new int[] {1,2,3,4,5});
//		
//		for(int k=0;k<outputArray.length;k++){
//			System.out.println(outputArray[k]);
//		}
		
		TreeNode mid11 = new TreeNode(30, null, null);
		TreeNode mid22 = new TreeNode(50, null, null);
		
		TreeNode root1 = new TreeNode(40, mid11, mid22);
		
		//System.out.println(checkIfBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		//System.out.println("Hosico is here ---"+findLowestCommonAncestor(root,bottom3,bottom4).data);
		//findDeepestNode(root);
		
		//TreeNode mid3 = new TreeNode(20, bottom1, bottom2);
		//TreeNode root2 = new TreeNode(10, mid3, null);
		
		//System.out.println(areIdentical(root, root));
		
		//inOrderDepth(level, maxLevel,root);
		
		//printKthNode(root, 1);
		//inOrderTraversal(root);

		
		//reverseTree(root);
		
		//System.out.println(root.data);
		//inOrderTraversal(root);
		
		
	}

}
