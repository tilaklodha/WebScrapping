
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class webscrapper {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.oyorooms.com/#all-cities");
		
		
		/*List<WebElement> txtfields = driver.findElements(By.xpath("//*[@id=" + "js-country-name" + "]/div[1]/div[3]")); //for loop to send text In all text box one by one. 
		for(int a=0; a<txtfields.size();a++){ txtfields.get(a).sendKeys("Text"+(a+1)); System.out.println(txtfields.get(a)); } 
		*/
		
		
		//String pageText = driver.findElement(By.xpath("//*[@id=" + "js-country-name" + "]/div[1]/div[3]")).getAttribute("content");
		//List links = driver.findElements(By.className("megadropdown__citiesList"));
		
		//driver.xGetAllLinks();
		
		 List<WebElement> links = driver.findElements(By.className("js-city-link"));
	        int linkcount = links.size(); 
	        List<String> city=Arrays.asList(new String[linkcount]);
	         System.out.println(links.size()); 
	         for(int i=0;i<linkcount;i++){
	        	 //System.out.print(links.get(i).getText()+"\t");
	        	 
	        	 //System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
	        	 //WebDriver driver1= new ChromeDriver();
	        	 
	        	 String s=links.get(i).getText();
	        	 s=s.replaceAll("\\s+","-");
	        	 //city.add(s);//links.get(i).replaceAll("\\s+","-");
	        	 System.out.print(s+"\n");
	        	 
	        	   	 
	        	 //driver1.get("http://www.oyorooms.com/hotels-in-"+s);
	        	 
	        	 //System.out.println(driver1.getCurrentUrl());
	        	 //links.get(i).click();
	        	 //Thread.sleep(5000);
	        	 //driver.navigate().back();
	        	 //Thread.sleep(10000);
	         }
	         
		System.out.println("");
		/*System.out.println(links.size());
		
		for(int i=0;i<links.size();i++){
			System.out.println(links.get(i));
		}*/
		

		driver.quit();
	}

}

/*
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import selenium.practice.BdJobsQARelatdJobsHtmlUnitDriver.m;


public class webscrapper {



    static List<WebElement> mainurl, suburl;
    static List<String> uniqueurl;

    public static void main(String[] a) throws InterruptedException {
        // Initialize Firefox driver 
    	System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        
        //Maximize browser window 
        driver.manage().window().maximize();

        String websiteaddress = "http://www.oyorooms.com/#all-cities";
        //Go to website  
        uniqueurl = new ArrayList();
        driver.get(websiteaddress);
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //get all url of page
        mainurl = driver.findElements(By.tagName("a"));

        System.out.println(mainurl);
for (int k = 0; k < mainurl.size(); k++) {
            // check url not null, empty and only current website 
            if (!(mainurl.get(k).getText().trim().equals("")) &&  !(mainurl.get(k).getAttribute("href").trim().equals("")) && (mainurl.get(k).getAttribute("href").contains("oyorooms.com")) && !(mainurl.get(k).getAttribute("href").contains("@"))) {

       if (!(uniqueurl.contains(mainurl.get(k).getAttribute("href").trim()))) {
   uniqueurl.add(mainurl.get(k).getAttribute("href").trim());
//Print urls
 System.out.println(mainurl.get(k).getAttribute("href"));

                    // Open new tab
  driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
  driver.get(mainurl.get(k).getAttribute("href").trim());
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// get all sub page url
     suburl = driver.findElements(By.tagName("a"));

      //get all sub page url
      for (int m = 0; m < suburl.size(); m++) {
        if (!(suburl.get(m).getText().trim().equals("")) && !(suburl.get(m).getText().trim() == null) && !(suburl.get(m).getAttribute("href").equals("")) && !(suburl.get(m).getAttribute("href") == null)) {

     if (!(uniqueurl.contains(suburl.get(m).getAttribute("href").trim()))) {
  uniqueurl.add(suburl.get(k).getAttribute("href").trim());
       //Print urls
System.out.println(suburl.get(m).getAttribute("href"));
                            }

                        }
                    }
  // close open tab
driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
// Move default window
driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
driver.switchTo().defaultContent();
                    Thread.sleep(7000);

                }
            }
        }
        driver.quit();
    }

}*/