
public class stringcheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="keyboard_arrow_left" + "\n"
				+ "keyboard_arrow_right" + "\n"
				+ "OYO Premium KFC Fatehabad Road"+ "\n"
				+ "? 1049"+ "\n"
				+ "Behind Crystal Sarovar, Fatehabad Road, Agra"+ "\n"
				+ "per night"+ "\n"
				+ "PREMIUM ->";
		
		String[] s=str.split("\n");
		
		System.out.println(s.length);
		
		
		int n=0;
		
			
			while(n<7){
				if(n==2){
					System.out.println(s[n]);
				}
				n++;
			}
			
		
	

}
}
