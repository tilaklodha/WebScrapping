
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
public class webscrapper2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.oyorooms.com/hotels-in-delhi");
		
		List<WebElement> boxes = driver.findElements(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]"));
		int numberOfBoxes = boxes.size();
		System.out.println(numberOfBoxes);
		
		List<WebElement> hlinks=driver.findElements(By.xpath("//*[@id=\"ember1032\"]"));
		
		/*for(int i=0;i<hlinks.size();i++){
			String s=hlinks.get(i).getText();
			System.out.println(hlinks.get(i).getAttribute("href"));
			System.out.println(s+"\n"+"\n"+"\n"+"\n"+"\n");
			
			
		}
		*/
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		//System.out.println(numberOfBoxes);
		driver.findElement(By.xpath("//*[@id=\"ember656\"]/div[1]/ul[5]/li[1]")).click();
		
List<WebElement> hlinks1=driver.findElements(By.xpath("//*[@id=\"ember1032\"]"));
System.out.println(hlinks1.size());
		for(int i=0;i<hlinks1.size();i++){
			String s1=hlinks1.get(i).getAttribute("href");
			System.out.println(s1);
		}
	}

}
