
public class StringCalculator {

	public static int Add(String inString) {
		int sum = 0;								  //returning the sum
        String[] inS = new String[inString.length()]; //for delimiter split string
        String delimiter = ",";						  //Delimiter Element
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
            inS = inString.split(delimiter);		//Split the elements by delimiter
        }
        
        for (int i = 0; i < inS.length; i++) {
            sum += Integer.parseInt(inS[i]);
        }


		return sum;	}
}
