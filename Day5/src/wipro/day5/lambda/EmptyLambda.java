package wipro.day5.lambda;

interface NoParameter {
	void show();
}

public class EmptyLambda {
	
	public static void main(String[] args) {
		NoParameter NoParameterLambda = () -> System.out.println("No parameters?");
		
		NoParameterLambda.show();
	}

}
