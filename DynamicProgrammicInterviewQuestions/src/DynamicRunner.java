
public class DynamicRunner {
	
	
	public static int longestPalindromicSubstring(String inputString){
		return 0;
	}
	
	public static Pair optimizeGame(int[] inputArray){
		
		Pair[][] result = new Pair[inputArray.length][inputArray.length];
		
		return result[0][inputArray.length-1];
 		
	}
	
	public static int minOperations(char[] str1, char[] str2){
		int temp[][] = new int[str1.length+1][str2.length+1];

        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }

        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }
        
        int maxOperations = Integer.MIN_VALUE;

        for(int i=1;i <=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + Math.min(Math.min(temp[i-1][j-1], temp[i-1][j]), temp[i][j-1]);
                }
                
              
            }
        }
        return maxOperations;
		
	}
	
	public static int minimumNumberOfOperations(String input1, String input2){
		
		
		
		
		int[][] minimumNumberOfOperations = new int[input1.length()+1][input2.length()+1];
		
		for(int i=0; i<input1.length()+1;i++){
			minimumNumberOfOperations[i][0] = i;
		}
		
		for(int j=0; j<input2.length()+1;j++){
			minimumNumberOfOperations[0][j] = j;
		}
		
		int minimumOperations = Integer.MIN_VALUE;
		
		for(int i=1;i<=input1.length();i++){
			for(int j=1;j<=input2.length();j++){
				if(input1.charAt(i-1)== input2.charAt(j-1)){
					minimumNumberOfOperations[i][j] = minimumNumberOfOperations[i-1][j-1];
				} else {
					minimumNumberOfOperations[i][j] = 1+ Math.min(Math.min(minimumNumberOfOperations[i-1][j], minimumNumberOfOperations[i][j-1]),minimumNumberOfOperations[i-1][j-1]);
				}
				
				if(minimumOperations < minimumNumberOfOperations[i][j]){
					minimumOperations = minimumNumberOfOperations[i][j];
				}
			}
		}
		
		return minimumNumberOfOperations[input1.length()][input2.length()];
		
	}
	
	public static int longestCommonSubsequence(String input1, String input2){
		
		int[][] lcs = new int[input1.length()+1][input2.length()+1];
//		for(int j=0;j<input2.length();j++){
//			lcs[0][j] =0;
//		}
//		for(int i=0;i<input2.length();i++){
//			lcs[i][0] =0;
//		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<input1.length()+1;i++){
			for(int j=1;j<input2.length()+1;j++){
				if(input1.charAt(i-1) == input2.charAt(j-1)){
					lcs[i][j] = lcs[i-1][j-1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
				if(lcs[i][j]>max){
					max = lcs[i][j];
				}
			}
		}
		
		return max;
		
//		   int temp[][] = new int[str1.length + 1][str2.length + 1];
//	        int max = 0;
//	        for(int i=1; i < temp.length; i++){
//	            for(int j=1; j < temp[i].length; j++){
//	                if(str1[i-1] == str2[j-1]) {
//	                    temp[i][j] = temp[i - 1][j - 1] + 1;
//	                }
//	                else
//	                {
//	                    temp[i][j] = Math.max(temp[i][j-1],temp[i-1][j]);
//	                }
//	                if(temp[i][j] > max){
//	                    max = temp[i][j];
//	                }
//	            }
//	        }
//	        return max;
		
	}
	
	public static int longestIncreasingSubsequence(int[] inputArray){
		int[] lcs = new int[inputArray.length];
		
		for(int k=0;k<inputArray.length;k++){
			lcs[k]=1;
		}
		
		for(int i=1;i<inputArray.length;i++){
			for(int j=0;j<i;j++){
				if(inputArray[i]>inputArray[j]){
					lcs[i] = Math.max(lcs[i],lcs[j]+1);
				}
				
			}
		}
		
		System.out.println(lcs.toString());
		
		int max = Integer.MIN_VALUE;
		
		for(int l=0;l<lcs.length;l++){
			
			if(lcs[l]>max){
				max = lcs[l];
			}
			
		}
		
		
		return max;
	}
	
	public static int minimumNumberOfJumps(int[] inputArray){
		
		if(inputArray[0]==0)
			return 0;
		
		int[] jumps = new int[inputArray.length];
		jumps[0] = 0;
		
		for(int i=1;i<inputArray.length;i++){
			jumps[i] = Integer.MAX_VALUE;
			for(int j=0;j<=i;j++){
				if(i<=j+inputArray[j]){
					jumps[i] = Math.min(jumps[i], jumps[j]+1);
				}
			}
			
		}
		return jumps[inputArray.length -1 ];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 int arr[] = {1,3,5,3,2,2,6,1,6,8,9};
		// System.out.println(minimumNumberOfJumps(arr));
		 
		 int[] inputArray = {3,1,4,7,2,8,5,9};
		// System.out.println(longestIncreasingSubsequence(inputArray));
		 
		// System.out.println(longestCommonSubsequence("ABCDGHLQR", "AEDPHR"));
		
		 System.out.println(minimumNumberOfOperations("ABCDFR", "ABCDE"));
		 
		 System.out.println(minOperations("ABCDFR".toCharArray(), "ABCDE".toCharArray()));

	}

}
