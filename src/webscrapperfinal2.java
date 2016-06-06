import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.collections.CollectionUtils;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.logging.Level; 
import java.util.logging.Logger;

public class webscrapperfinal2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String dbURL = "jdbc:mysql://localhost:3306/hotel"; 
		String username ="root"; 
		String password = "9700"; 
		
		Connection dbCon = null; 
		Statement stmt = null; 
		String rs= null;
		
		String[] city = {"Agra","Ahmedabad","Ajmer","Alappuzha","Alibag","Allahabad","Alwar","Ambala","Amritsar","Anand","Ankleshwar","Aurangabad","Baddi","Bangalore","Baramati","Bareilly","Bathinda","Bharuch","Bhavnagar","Bhilai","Bhilwara","Bhiwadi","Bhopal","Bhubaneswar","Bikaner","Calicut","Chandigarh","Chennai","Chittorgarh","Coimbatore","Coonoor","Coorg","Corbett-Ramnagar","Cuttack","DIU","Dahej","Dalhousie","Daman","Darjeeling","Dehradun","Delhi","Deoghar","Dewas","Dharamshala","Digha","Dwarka","Faridabad","Gandhidham","Gandhinagar","Gangtok","Gaya-BodhGaya","Ghaziabad","Gir","Goa","Gurgaon","Guruvayur","Guwahati","Gwalior","Haldwani","Haridwar","Himatnagar","Hisar","Hubli-Dharwad","Hyderabad","Indore","Jabalpur","Jaipur","Jaisalmer","Jalandhar","Jammu","Jamnagar","Jamshedpur","Jhansi","Jodhpur","Kakinada","Kannur","Kanpur","Karnal","Karwar","Kasauli","Kashipur","Katra","Kaziranga","Khajuraho","Khandala","Kochi","Kodaikanal","Kolhapur","Kolkata","Kollam","Kota","Kovalam","Kuala-Lumpur","Kumarakom","Kumbakonam","Kurnool","Leh-Ladakh","Lonavala","Lucknow","Ludhiana","Madurai","Mahabaleshwar","Manali","Mandarmoni","Mangalore","Matheran","Mathura","Mcleod-Ganj","Meerut","Mirik","Mount-Abu","Mumbai","Mundra","Munnar","Mussoorie","Mysore","Nagpur","Nainital","Nashik","Nathdwara","Neemrana","Nellore","Noida","Ooty","Orchha","Pachmarhi","Panipat","Paradip","Patna","Pinjore","Pondicherry","Porbandar","Pune","Puri","Pushkar","Pushpagiri","Raipur","Rajahmundry","Rajkot","Ranchi","Ranthambore","Ratnagiri","Rewari","Rishikesh","Rohtak","Rudrapur","Salem","Sangli","Shantiniketan","Shillong","Shimla","Shirdi","Siliguri","Somnath","Srinagar","Surat","Talegaon","Thanjavur","Thekkady","Thrissur","Tirupati","Trichy","Trivandrum","Udaipur","Udupi-Manipal","Ujjain","Vadodara","Vapi","Varanasi","Varkala","Vellore","Vijayawada","Visakhapatnam","Vrindavan","Warangal","Wayanad"};
		
		for(int p=0;p<city.length;p++){
		
		driver.get("http://www.oyorooms.com/hotels-in-"+city[p]);
      	 
      	 //visiting each city link       	 
      	 
      		 

   		int checkBoxCount=1;
   		
   		while(driver.findElements(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+checkBoxCount+"]")).size()>0){
   			
   			driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+checkBoxCount+"]")).click();
   			String checkBoxName = null;
   			checkBoxName=driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+checkBoxCount+"]")).getText();
   			//System.out.println(checkBoxName);
   			checkBoxCount++;
			    			
  			Thread.sleep(2500);
   			
   			List<WebElement> linkList=driver.findElements(By.tagName("a")); 			
   			
   			int nooflinks = linkList.size(); 
   			//System.out.println(nooflinks); 
   			for (WebElement pagelink : linkList){
   				
   				String linktext = pagelink.getText().toString(); 
   				String link = pagelink.getAttribute("href"); 
   				
   				
   				String[] split=linktext.split("\n");
   				String hotelname = null;
   				int line=0;
   				if(linktext.contains("left")){
   					
   					while(line<7){
   						if(line==2){
   							hotelname=split[line];
   						}
   						line++;
   					}
   					
   					
   					System.out.println(city[p]+"\t"+checkBoxName+"\t"+hotelname+"\t"+link);
   					/*System.out.print(hotelname+" ->"); 
   					System.out.println(link); */
   					System.out.println("\n"+"\n");
   					String query="INSERT INTO data (city, collection, hotel_name, landing_url) VALUES (" + "\""+ city[p] + "\",\"" + checkBoxName + "\",\"" + hotelname + "\",\"" + link + "\")";
   					
   					try { 
   						//getting database connection to MySQL server 
   						dbCon = DriverManager.getConnection(dbURL, username, password); 
   						
   						//getting PreparedStatment to execute query 
   						stmt = dbCon.prepareStatement(query); 
   						
   						//Resultset returned by query 
   						stmt.executeUpdate(query); 
   						
   					}
   						
   					catch (SQLException ex) { 
   						Logger.getLogger(CollectionUtils.class.getName()).log(Level.SEVERE, null, ex); 
   						} 
   					finally{ 
   						//close connection ,stmt and resultset here 
   						}
   					}
   				}
   			
   			Thread.sleep(2500);
   			
   			driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+(checkBoxCount-1)+"]")).click();
   			
   			
   		}
		
		
		}
	}
}
