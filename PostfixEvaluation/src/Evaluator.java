
public class Evaluator {
	
	private static Boolean operatorFlag = false;
	
	public static Integer evaluatePostFix(String[] postFixExpr){
		
		Integer finalResult = null;
		
		for(String str : postFixExpr){
			
			operatorFlag = isOperator(str);
			if(operatorFlag){
				int op2 = Integer.parseInt(Stack.pop());
				int op1 = Integer.parseInt(Stack.pop());
				try{
					int result = calculate(op1, op2, str);
					//System.out.println("--"+result);
					Stack.push(Integer.toString(result));
				}
				catch(ArithmeticException ae){
					System.out.println("Error evaluating Postfix expression");
					ae.printStackTrace();
				}
			}
			else{
				try {
					int op = Integer.parseInt(str);
					Stack.push(Integer.toString(op));
				} catch (NumberFormatException e) {
					System.out.println("Invalid operand");
					e.printStackTrace();
				}
			}
		}
		try {
			if(Stack.isEmpty()){
				System.out.println("Error evaluating Postfix expression");
				System.exit(0);
			}
			
			finalResult = Integer.parseInt(Stack.pop());
			
			if(!Stack.isEmpty()){
				System.out.println("Error evaluating Postfix expression");
				System.exit(0);
			}			
		} catch (NumberFormatException e) {
			System.out.println("Error evaluating Postfix expression");
			e.printStackTrace();
		}
		return finalResult;
	}
	
	private static Boolean isOperator(String str){
		
		switch(str){
		
			case "^":
			case "*":
			case "/":
			case "%":
			case "+":
			case "-":
				return true;
			default:
				return false;
		}
	}
	
	private static Integer calculate(int op1, int op2, String str) throws ArithmeticException{
		
		switch(str){
		
		case "^": {
			double d = Math.pow(op1, op2);
			int retValue = (int) d;
			return retValue;
		}			
		case "*":
			return (op1 * op2);
		case "/":
			return (op1 / op2);
		case "%":
			return (op1 % op2);
		case "+":
			return (op1 + op2);
		case "-":	
			return (op1 - op2);
		}
		return null;
	}
}
