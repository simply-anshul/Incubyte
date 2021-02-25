import java.util.regex.Pattern;
public class StringCalculator {
	private int callCount=0;
	public int calculateCount() {
		return callCount;
	}

	public int Add(String inString) throws Exception {
		++callCount;
		
		
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
        	 String delimiters = inString.split("\n")[0];
             String secondDelimiter = null;
             //Find delimiter
             delimiter = delimiters.substring(3, inString.indexOf("]"));
             delimiters = delimiters.substring(inString.indexOf("]") + 1);
             // Multiple delimiter
             inString = inString.substring(inString.indexOf("\n") + 1);
             // Next delimiter
             if (delimiters.charAt(0) == '[')
                 secondDelimiter = delimiters.substring(1, delimiters.length() - 1);

             if (secondDelimiter != null)
                 inString = inString.replaceAll(Pattern.quote(secondDelimiter), delimiter);
            delimiter = Pattern.quote(delimiter);
        }
		
		inString = inString.replaceAll("\n",delimiter); 
        	//Split the elements by delimiter
            inS = inString.split(delimiter);		
        
        try {
        	//To handle negative value events
        for (int i = 0; i < inS.length; i++) {         		
        		if(Integer.parseInt(inS[i])<0) {
        			throw new Exception();
        		}
        		if(Integer.parseInt(inS[i])>=1000) {
        			//Ignore if the number is greater than 1000
        			continue;
        		}
        		sum += Integer.parseInt(inS[i]);
        		}
        	}catch(Exception ex){
        		String errMsg = "negatives not allowed ";
        			for(int i=0;i<inS.length;i++) {        				
                        if (Integer.parseInt(inS[i]) < 0) {
                        	errMsg += inS[i] + " ";
                        }
        			}
        			//This will print all the present negative values
        			System.out.println(errMsg);
        	}
        
        //The final sum value returned
		return sum;	
		}
		
}
