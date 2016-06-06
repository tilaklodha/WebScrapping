
public class stringCity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sentence="Book from Bangalore to Hyderabad";
		
		int index0fStart=sentence.indexOf("from");
		int indexOfEnd=sentence.indexOf("to");
		
		
		
		
		System.out.println(sentence.substring(index0fStart+5, indexOfEnd-1));
		
		System.out.println(sentence.substring(indexOfEnd+3, sentence.length()));
		
		System.out.println(sentence.contains("eto"));
		
		
	}

}
