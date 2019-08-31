package demo;

public class ExeptionHandlingDemo {

	public static void main(String[] args) throws Exception {

		demo();
		demo2();
	}
	
	public static void demo2() throws Exception{
		System.out.println("Hello this is Java");
		throw new ArithmeticException("not valid operation");

	}
	
	public static void demo() {
		try {
		System.out.println("Hello World...!");
		int i = 1/0;
		System.out.println("Completed");
		
		}catch(Exception exp) {
			System.out.println("I am inside catch block");
			System.out.println("Message is :"+exp.getMessage());
			System.out.println("Cause is :"+exp.getCause());
			//exp.printStackTrace();

		}finally {
		System.out.println("I am inside finnally block");
		}
	}

}
