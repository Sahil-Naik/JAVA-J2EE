package wipro.day3.access1;

class Data {
    // private variable
    private String userName;
    
    // Only accessible within same class
}

public class Private_variable {
	public static void main(String[] main){

        Data d = new Data();
        
        // d.userName = "WE PRO";        
        // This will throw an error, we cannot modify/access private variable of other class
    }
}
