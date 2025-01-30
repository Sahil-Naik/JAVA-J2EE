package wipro.day6.funcinter;
import java.util.function.*;

public class ConsumerTest {
	// void accept(T t)
	public static void main(String[] args) {
		Consumer<String> cos = (x) -> System.out.println("String is: "+x);
		
		cos.accept("Hello World!");
	}

}
