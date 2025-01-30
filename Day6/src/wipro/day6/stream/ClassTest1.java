package wipro.day6.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class ClassTest1 {
	
	public static void main(String[] args) {
		
		List<String> names= Arrays.asList("alice","bob","charlie","david");
		
		//creating a stream
		Stream<String> nameStream = names.stream();
		
		
		nameStream.forEach(x->System.out.println(x));
		
		
		List<Integer> numbers = Arrays.asList(20,15,10,25,30,43,12,77);
		
		//numbers.stream().filter(x->x%2!=0).forEach(x->System.out.println(x));
		List<Integer> evenNumbers = numbers.stream().filter(x->x%2==0).collect(Collectors.toList());
	    System.out.println(evenNumbers);
	    
	    //R apply(T t);
	    //converting to uppercase
	    
	    names.stream().map(x->x.toUpperCase()).forEach(x->System.out.println(x));
	    
	    //sorting the numbers
	    
	    numbers.stream().sorted().forEach(x->System.out.println(x));
	    System.out.println("======================");
	    numbers.stream().sorted((x,y)->y.compareTo(x)).forEach(x->System.out.println(x));
	
	    System.out.println("======================");
	    //List<Integer> nmbrs = Arrays.asList(10,20,10,30,20,40);
	    
	    //removing duplicates
	    //nmbrs.stream().distinct().forEach(x->System.out.println(x));
	    
	    //limit(n) and skip(n)
	    
	    List<Integer> nmbrs = Arrays.asList(1,2,3,4,5,6,7);
	    
	    //limit to first 3 numbers
	    
	    nmbrs.stream().limit(3).forEach(x->System.out.println(x));
	
	    System.out.println("====================");
	    nmbrs.stream().skip(3).forEach(x->System.out.println(x));
	    
	    System.out.println("====================");
	    //reduce()-aggregating elements
	    //sum of all numbers
	    
	    int sum = nmbrs.stream().reduce(0,(a,b)->a+b);
	    System.out.println("sum:" + sum);
	    
	    //flatMap()-flattens nested structures
	    
	    
	    List<List<String>> nestedList = Arrays.asList(
	    		Arrays.asList("java","spring"),
	    		Arrays.asList("Microservices","Docker")
	    		
	    		);
	    
	    System.out.println("===========================");
	    System.out.println(nestedList.stream().flatMap(x-> x.stream()).collect(Collectors.toList()));
	    		
	    		
//forEach(),map(),sorted(),filter(),reduce(),collect(),distinct(),limit(),skip(),flatMap(),asList(),stream()
	    
	    
	}
 
}
