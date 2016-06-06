
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class webscrapperfinal1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.oyorooms.com/#all-cities");
		
		List<WebElement> citynames = driver.findElements(By.className("js-city-link"));
        int citycount = citynames.size();
		
        
        /*for(int p=0;p<citycount;p++){
        	System.out.println(citynames.get(p).getText());
        }*/
        
        //fetched city
        for(int citynameloop=0;citynameloop<citycount;citynameloop++){
       	 
         //System.out.print(cityname.get(i).getText()+"\t");       	        	 
       	 String city=citynames.get(citynameloop).getText();
       	 city=city.replaceAll("\\s+","-");       	 
       	 System.out.print(city+"\n");
       	 
       	driver.get("http://www.oyorooms.com/hotels-in-"+city);
       	 
       	 //visiting each city link       	 
       	 
       		 

    		int checkBoxCount=1;
    		
    		while(driver.findElements(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+checkBoxCount+"]")).size()>0){
    			
    			driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+checkBoxCount+"]")).click();
    			String checkBoxName = null;
    			checkBoxName=driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+checkBoxCount+"]")).getText();
    			//System.out.println(checkBoxName);
    			checkBoxCount++;
 			    			
   			
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
    					
    					System.out.println(city+"\t"+checkBoxName+"\t"+hotelname+"\t"+link);
    					/*System.out.print(hotelname+" ->"); 
    					System.out.println(link); */
    					System.out.println("\n"+"\n");
    					
    					
    					}
    				}
    			
    			Thread.sleep(10000);
    			
    			driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+(checkBoxCount-1)+"]")).click();
    			
    			
    		}
       		
        }

	}
}