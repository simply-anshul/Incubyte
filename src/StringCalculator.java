
public class StringCalculator {

	public static int Add(String inString) throws Exception {
		//Sum to calculate
		int sum = 0;								  
		//For delimiter split string
		String[] inS = new String[inString.length()]; 
        //Delimiter Element
        String delimiter = ",";						  
		//For the Empty String return 0
		if(inString == "") {
			return 0;
		}
		else if(inString.length()==1) {
			return Integer.parseInt(inString);
		}
		
        if (inString.charAt(0) == '/' && inString.charAt(1) == '/'){
        	//We will identify the delimiter here
            delimiter = String.valueOf(inString.charAt(2));
            //Getting the true string with only numbers and delimiters
            inString = inString.substring(4);

        }

		
		inString = inString.replaceAll("\n",delimiter); 
        for (int i = 0; i < inString.length(); i++) {  
        	//Split the elements by delimiter
            inS = inString.split(delimiter);		
        }
        
        for (int i = 0; i < inS.length; i++) { 
        	try {
        		//To handle negative value events
        		if(Integer.parseInt(inS[i])<0) {
        			throw new Exception();
        		}
        	}
        		catch(Exception ex){
        			System.out.println("negatives not allowed " + inS[i]);
        			continue;
        		}
        	sum += Integer.parseInt(inS[i]);
        	}
        
        //The final sum value returned
		return sum;	
		}
}
