
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.pagefactory.ByChained;


public class webscrapper3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.oyorooms.com/hotels-in-agra");
		
		
		int c=1;
		
		while(driver.findElements(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+c+"]")).size()>0){
			
			driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+c+"]")).click();
			String text = driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+c+"]")).getText();
			System.out.println(text);
			c++;
			
			
			/*List<WebElement> urls= driver.findElements(By.partialLinkText("delhi"));
			
			for(int k=0;k<urls.size();k++){
				String a=urls.get(k).getText();
				System.out.println(a);
			}*/
			
			List<WebElement> linkList=driver.findElements(By.tagName("a"));

			//now traverse over the list and check
			/*for(int i=0 ; i<linkList.size() ; i++)
			{
			    if(linkList.get(i).getAttribute("href").contains("Delhi"))
			    {
			        System.out.println(linkList.get(i).getText());
			        
			    }
			}
			System.out.println(linkList);
			System.out.println(linkList.size());
			*/
			
			
			int nooflinks = linkList.size(); 
			System.out.println(nooflinks); 
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
					
					System.out.println(hotelname+" ->"); 
					System.out.println(link); 
					System.out.println("\n"+"\n");
					
					
				}
				}
			
			Thread.sleep(10000);
			
			driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li["+(c-1)+"]")).click();
			
			
		}
		
		driver.quit();
		
	}

}
