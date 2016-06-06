import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class checkTrainPNR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		while(true){
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.trainspnrstatus.com/pnrformcheck.php");
		
		
		long number = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		String pNR=Long.toString(number);
		driver.findElement(By.xpath("//*[@id=\"fullname\"]")).sendKeys("2546843785");
		
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/div/button")).click();
		List<WebElement> linkList=driver.findElements(By.xpath("//*[@id=\"menu-1\"]/div/div/div[1]/div[2]"));
		
		for(int i=0;i<linkList.size();i++){
			System.out.println(linkList.get(i).getText()+"\t"+ pNR);
		}
		
		driver.quit();
		break;
		}
	}

}
