import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Postfix expression");
		String[] postFixExpr = (scanner.nextLine()).split(" ");
		
		Integer value = Evaluator.evaluatePostFix(postFixExpr);
		if(value == null){
			System.out.println("Postfix expression was not evaluated");
		}
		else{
			System.out.println("Result = "+value);
		}		
		
		scanner.close();
	}
}
