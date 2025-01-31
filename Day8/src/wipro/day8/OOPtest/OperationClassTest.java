package wipro.day8.OOPtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
 
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 

public class OperationClassTest {
	
	private OperationClass operate;
	
	@BeforeEach
	void Setup() {
		operate = new OperationClass();
	}
	
	@Test
	void AdditionTest() {
		assertEquals(5, operate.Addition(2,3));
		assertEquals(9, operate.Addition(6,3));
	}
	
	@Test
	void SubtractionTest() {
		assertEquals(-1, operate.Subtraction(10, 11));
		assertEquals(0, operate.Subtraction(100, 100));
		assertEquals(10, operate.Subtraction(100, 90));
	}
	
	@Test
	void MultiplicationTest() {
		assertEquals(100, operate.Multiplication(10, 10));
	}
	
	@Test
	void QuotientTest() {
		assertEquals(2, operate.Quotient(10, 5));
	}
	
	@Test
	void RemainderTest() {
		assertEquals(0, operate.Remainder(10, 2));
	}
	
	@AfterEach
	void breakall() {
		operate = null;
	}

}
