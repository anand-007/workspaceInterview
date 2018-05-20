package com.java.lcs;

public class LCS {
	
	public static int[][] findLCS(String firstInput, String secondInput){
		String result = new String();
		int m = firstInput.length();
		int n = secondInput.length();
		int[][] resultMatrix = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				
				if(firstInput.charAt(i-1)==secondInput.charAt(j-1)){
					resultMatrix[i][j]= 1 + resultMatrix[i-1][j-1];
				
				} else {
					resultMatrix[i][j]=0;
				}
				
			}
		}
		return resultMatrix;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstInput = "abcdefgh";
		String secondInput = "bcdg";
		
		int[][] value = findLCS(firstInput, secondInput);
		System.out.println(value);
	}

}
