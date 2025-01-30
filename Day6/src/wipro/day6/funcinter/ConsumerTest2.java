package wipro.day6.funcinter;

import java.util.function.Consumer;

public class ConsumerTest2 {
	// void accept(T t)
		public static void main(String[] args) {
			Consumer<Integer> cos = (x) -> System.out.println("Square is: "+ x*x);;
			
			cos.accept(5);
		}
}
