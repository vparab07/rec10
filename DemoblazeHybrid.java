package testcases;

import org.testng.annotations.Test;

import pages.TestCaseScreenshot;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class DemoblazeHybrid {
	TestCaseScreenshot ts;
	@BeforeMethod
	public void getscreen()
	{
		ts=new TestCaseScreenshot();
		
	}
	
  @Test(dataProvider = "dp",enabled=true)
  public void mobileautomate(String tid,String us,String pw,String samsg6,String nokl,String nx,String samsg7,String htc,String exe) {
	  if(!(tid.equals("test id"))&&exe.equals("yes"))
	  {
	  System.setProperty("webdriver.chrome.driver", "D:\\data\\st\\chromedriver.exe");
	  WebDriver w=new ChromeDriver();
	w.manage().window().maximize();
	  w.get("https://www.demoblaze.com/index.html");
	  Reporter.log("opened demoblaze site");
	  w.findElement(By.linkText("Log in")).click();
	try {
		Thread.sleep(3000);
	
	  w.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(us);
	  Reporter.log("entered user name");
	  w.findElement(By.id("loginpassword")).sendKeys(pw);
	  Reporter.log("entered user password");
	  
			  w.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
			  Reporter.log("logged in");
				Thread.sleep(3000);
				if(samsg6.equals("yes"))
				{
			  w.findElement(By.partialLinkText("Home")).click();
			  w.findElement(By.partialLinkText("Phones")).click();
			  Thread.sleep(3000);
			  w.findElement(By.linkText("Samsung galaxy s6")).click();
			  
			  Thread.sleep(3000);
			  w.findElement(By.linkText("Add to cart")).click();
			  Thread.sleep(2000);
			 
			  Alert alert = w.switchTo().alert();
			  
              alert.accept();
              ts.takescreen(w);
              Thread.sleep(1000);
              Reporter.log("added Samsung galaxy s6 to cart");
              
			  w.findElement(By.partialLinkText("Home")).click();
			  Thread.sleep(2000);
				}
				if(nokl.equals("yes"))
				{
			  w.findElement(By.partialLinkText("Home")).click();
			  w.findElement(By.partialLinkText("Phones")).click();
			  Thread.sleep(3000);
			  w.findElement(By.linkText("Nokia lumia 1520")).click();
			  Thread.sleep(2000);
			  w.findElement(By.linkText("Add to cart")).click();
			  Thread.sleep(2000);
			 
			  Alert alert = w.switchTo().alert();
			 
              alert.accept();
              ts.takescreen(w);
              Thread.sleep(1000);
              Reporter.log("added Nokia lumia 1520 to cart");
              
			  w.findElement(By.partialLinkText("Home")).click();
			  Thread.sleep(2000);
				}
				if(nx.equals("yes"))
				{
			  w.findElement(By.partialLinkText("Home")).click();
			  w.findElement(By.partialLinkText("Phones")).click();
			  Thread.sleep(3000);
			  w.findElement(By.linkText("Nexus 6")).click();
			  Thread.sleep(2000);
			  w.findElement(By.linkText("Add to cart")).click();
			  Thread.sleep(2000);
			 
			  Alert alert = w.switchTo().alert();
              alert.accept();
              ts.takescreen(w);
              Thread.sleep(1000);
              Reporter.log("added Nexus 6 to cart");
			  w.findElement(By.partialLinkText("Home")).click();
			  Thread.sleep(2000);
				}
				//Samsung galaxy s7
				if(samsg7.equals("yes"))
				{
			  w.findElement(By.partialLinkText("Home")).click();
			  w.findElement(By.partialLinkText("Phones")).click();
			  Thread.sleep(3000);
			  w.findElement(By.linkText("Samsung galaxy s7")).click();
			  Thread.sleep(2000);
			  w.findElement(By.linkText("Add to cart")).click();
			  Thread.sleep(2000);
			 
			  Alert alert = w.switchTo().alert();
              alert.accept();
              ts.takescreen(w);
              Thread.sleep(1000);
              Reporter.log("added Samsung galaxy s7 to cart");
			  w.findElement(By.partialLinkText("Home")).click();
			  Thread.sleep(2000);
				}
				
				//htc
				if(htc.equals("yes"))
				{
			  w.findElement(By.partialLinkText("Home")).click();
			  w.findElement(By.partialLinkText("Phones")).click();
			  Thread.sleep(3000);
			  w.findElement(By.linkText("HTC One M9")).click();
			  Thread.sleep(2000);
			  w.findElement(By.linkText("Add to cart")).click();
			  Thread.sleep(2000);
			 
			  Alert alert = w.switchTo().alert();
              alert.accept();
              ts.takescreen(w);
              Thread.sleep(1000);
              Reporter.log("added htc one to cart");
			  w.findElement(By.partialLinkText("Home")).click();
			  Thread.sleep(2000);
				}
				Thread.sleep(2000);
			  w.findElement(By.partialLinkText("Cart")).click();
			  
              Thread.sleep(3000);
              ts.takescreen(w);
			  
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	  }
  }
  @AfterMethod
  public void closebrowser() throws InterruptedException
  {
	  Thread.sleep(1000);
	  
  }

  @DataProvider
  public Object[][] dp() {
ReadExcelFile config = new ReadExcelFile("./testdata/testcase.xlsx");
	  
	  int rows = config.getRowCount(7); //change as per sheet number
	   
	  Object[][] credentials = new Object[rows][9];
	  
	 for(int i=0;i<rows;i++)
	  {
	  credentials[i][0] = config.getData(7, i, 0);
	  credentials[i][1] = config.getData(7, i, 1);
	  credentials[i][2] = config.getData(7, i, 2);
	  credentials[i][3] = config.getData(7, i, 3);
	  credentials[i][4] = config.getData(7, i, 4);
	  credentials[i][5] = config.getData(7, i, 5);
	  credentials[i][6] = config.getData(7, i, 6);
	  credentials[i][7] = config.getData(7, i, 7);
	  credentials[i][8] = config.getData(7, i, 8);
	  }
	   
	  return credentials;
  }
}
