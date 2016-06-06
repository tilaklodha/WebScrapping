import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class burgerKingData {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		int offsetCount=38000;
		String order = null, oname = null, name = null, mobile = null, source = null, time = null, amount = null, ostatus = null, dstatus = null, mongoquery = null; 
		
		while(offsetCount<100000){
			
			System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/chromedriver_win32/chromedriver.exe");
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("--disable-javascript");
			
			
			WebDriver driver = new ChromeDriver(opts);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get("http://52.76.84.73:3001/?offset="+offsetCount);
			
			offsetCount=offsetCount+50;
			int queryCount=1;
			//Thread.sleep(20000);
			
			
			try{
				
				for(int changeRow=1;changeRow<=50;changeRow++){
					
					for(int changeColumn=1;changeColumn<=9;changeColumn++){
						
						List<WebElement> data=driver.findElements(By.xpath("/html/body/div[2]/table/tbody/tr["+changeRow+"]"+"/td["+changeColumn+"]"));
						
						for(WebElement entry : data){
							
							switch(queryCount){
							case 1:
								//System.out.print("db.orders.insert({OrderID: "+"\""+entry.getText()+"\",");
								order=entry.getText();
								queryCount++;
								break;
							case 2:
								//System.out.print("Outlet Name: "+"\""+entry.getText()+"\",");
								oname=entry.getText();
								queryCount++;
								break;
							case 3:
								//System.out.print("Name: "+"\""+entry.getText()+"\",");
								name=entry.getText();
								queryCount++;
								break;
							case 4:
								//System.out.print("Mobile: "+"\""+entry.getText()+"\",");
								mobile=entry.getText();
								queryCount++;
								break;
							case 5:
								//System.out.print("Source: "+"\""+entry.getText()+"\",");
								source=entry.getText();
								queryCount++;
								break;
							case 6:
								//System.out.print("Time: "+"\""+entry.getText()+"\",");
								time=entry.getText();
								queryCount++;
								break;
							case 7:
								//System.out.print("Amount: "+"\""+entry.getText()+"\",");
								amount=entry.getText();
								queryCount++;
								break;
							case 8:
								//System.out.print("Order Status: "+"\""+entry.getText()+"\",");
								ostatus=entry.getText();
								queryCount++;
								break;
							case 9:
								//System.out.print("Delivery Status: "+"\""+entry.getText()+"\",})");
								dstatus=entry.getText();
								queryCount=1;
								break;
							default:
								break;
								
							}
							
						}
						
						
					}
					System.out.println("db.orders.insert({OrderID: "+"\""+order+"\","+"Outlet Name: "+"\""+oname+"\","+"Name: "+"\""+name+"\","+"Mobile: "+"\""+mobile+"\","+"Source: "+"\""+source+"\","+"Time: "+"\""+time+"\","+"Amount: "+"\""+amount+"\","+"Order Status: "+"\""+ostatus+"\","+"Delivery Status: "+"\""+dstatus+"\",})");
					BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/hp1/Desktop/output.txt", true));
					mongoquery= "db.orders.insert({OrderID: "+"\""+order+"\","+"Outlet Name: "+"\""+oname+"\","+"Name: "+"\""+name+"\","+"Mobile: "+"\""+mobile+"\","+"Source: "+"\""+source+"\","+"Time: "+"\""+time+"\","+"Amount: "+"\""+amount+"\","+"Order Status: "+"\""+ostatus+"\","+"Delivery Status: "+"\""+dstatus+"\",})";
				    writer.append(mongoquery+"\n");
				    writer.close();
					System.out.println("\n");
					
				}
			}catch(StaleElementReferenceException elementHasDisappeared){
				
		        queryCount=1;
		        //System.out.println("cjsbdjcdhcvdshgvgcshcvhgsdvgvchdgvchgdsssssssssssssssssssssssssssvcjsdvjsdjhdsvbjhdsjvbdsjvjdsjsdjvjvdsj");
		    }
			
			driver.quit();
			System.out.println("\n");
			
		}
		
	}

}





