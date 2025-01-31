package wipro.day7.junit;

import static org.junit.Assert.*;  
import org.junit.Test;  

public class JunitTesterModule1 {
	@Test  
    public void testFindMax(){  
        assertEquals(4,OperationClass.findMax(new int[]{1,3,4,2}));  
        assertEquals(-1,OperationClass.findMax(new int[]{-12,-1,-3,-4,-2}));  
        assertEquals(2,OperationClass.findMax(new int[]{-10,1,2,-4,-2}));  
    }  
}
