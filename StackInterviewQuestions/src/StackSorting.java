import java.util.Stack;


public class StackSorting {
	
	public static Stack<Integer> sortStack(Stack<Integer> inputStack){
		Stack<Integer> resultStack = new Stack<Integer>();
		
		while(!inputStack.isEmpty()){
			Integer item = inputStack.pop();
			if(resultStack.isEmpty()){
				resultStack.push(item);
			}else if(resultStack.peek() < item){
				resultStack.push(item);
			}else if(!resultStack.isEmpty()){
				while(!resultStack.isEmpty() || (!resultStack.isEmpty() && resultStack.peek() >item)){
					Integer resultItem = resultStack.pop();
					if(resultItem > item){
						inputStack.push(resultItem);
						resultStack.push(item);
					}else {
						inputStack.push(resultItem);
					}
				}
			}
		}
		
	
		return resultStack;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> inputStack = new Stack<Integer>();
		inputStack.push(new Integer(10));
		inputStack.push(new Integer(7));
		inputStack.push(new Integer(13));
		inputStack.push(new Integer(8));
		inputStack.push(new Integer(4));
		inputStack.push(new Integer(9));

		Stack<Integer> outputStack = sortStack(inputStack);
		System.out.println(outputStack);
	}

}
