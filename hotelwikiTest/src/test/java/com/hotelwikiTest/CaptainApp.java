package com.hotelwikiTest;

import java.awt.AWTException;
import java.awt.Robot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptainApp {

	private final String OPENDERIVER = "webdriver.chrome.driver";
	private final String PATH = "D:\\MYPROJECT\\hotelwikiTest\\Drivers\\chromedriver.exe";
	private final String URL = "http://localhost:8100/";
	public WebDriver driver;
	public WebDriverWait wait;
	JavascriptExecutor js;
	Actions actions;
	Robot robot;

	@BeforeTest
	public void captainLogin() throws Exception {
		System.setProperty(OPENDERIVER, PATH);
	    Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Nexus 5");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get(URL);

		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@name='serverIp']/input")).sendKeys("192.168.100.23");
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement Register = driver.findElement(By.xpath("//*[@id='register-button']"));
		actions.click(Register).perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='login-name']/input")).sendKeys("test@gmail.com");

		Thread.sleep(5000);
		WebElement password = driver.findElement(By.xpath("(//*[@name='name'])[4]"));
		actions.click(password).build().perform();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@name='name'])[4]")).sendKeys("WIKI");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='submit-button']")).click();
		Thread.sleep(3000);

		try {
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement loginButtonElement = driver.findElement(By.xpath("//*[text()='Login']"));
			js.executeScript("arguments[0].scrollIntoView(true);", loginButtonElement);
			Thread.sleep(3000);
			WebElement loginButton = driver.findElement(By.xpath("//*[text()='Login']"));
			loginButton.click();
			Thread.sleep(3000);

		} catch (Exception e) {
			driver.switchTo().alert().accept();
			Thread.sleep(6000);
			LoginToBackOffice();
			changeToPreviousTab();
			driver.findElement(By.xpath("//*[text()='Verify Status']")).click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement loginButtonElement = driver.findElement(By.xpath("//*[text()='Login']"));
			js.executeScript("arguments[0].scrollIntoView(true);", loginButtonElement);
			Thread.sleep(3000);
			WebElement loginButton = driver.findElement(By.xpath("//*[text()='Login']"));
			loginButton.click();
			// Resize();
		}

	}

	@Test(priority = 1, enabled = true)
	public void placeOrder() throws InterruptedException {
		driver.findElement(
				By.xpath("(//*[@class='button table-button FREE button-md button-outline button-outline-md'])[1]"))
				.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='newOrder']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='searchBar'])[1]")).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='new-order-button'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("")).click();
		Thread.sleep(3000);

	}


	public void LoginToBackOffice() throws Exception {
		Thread.sleep(3000);
		

	   WebDriver driver = new ChromeDriver();
	    driver.get("http://localhost:8081/hotelwiki/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.name("usernameOrEmail")).sendKeys("superadmin");
		driver.findElement(By.name("password")).sendKeys("superadmin");
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[text()='Back office']")).click();
		Thread.sleep(2000);
		changeToNewTab1();
		WebElement value = driver.findElement(By.id("storeName"));
		Select drop = new Select(value);
		drop.selectByIndex(1);

		driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"login\"]/main/div/div/div/div/div/div/form/div[1]/input"))
				.sendKeys("superadmin");
		driver.findElement(By.xpath("//*[@id=\"login\"]/main/div/div/div/div/div/div/form/div[2]/input"))
				.sendKeys("superadmin");
		driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"approve\"]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Yes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='tableToDevice'])[1]")).click();
		Thread.sleep(3000);
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.xpath("(//*[@id='selectAvailabelTb'])/child::*[" + i + "]")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='submit']")).click();
		Thread.sleep(3000);
	}

	public void theamLeafLogin() throws InterruptedException {

		driver.findElement(By.name("usernameOrEmail")).sendKeys("superadmin");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("superadmin");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[@class='username'])[2]")).click();
		Thread.sleep(2000);
		changeToNewTab1();
	}

	public void changeToNewTab1() throws InterruptedException {

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		Thread.sleep(6000);

	}

	public void changeToNewTab() throws InterruptedException, AWTException {
		System.out.println("In Change to ne tab window");
		   
		
		 WebDriver driver = new ChromeDriver();
	        driver.get("http://localhost:8081/hotelwiki/");
	        Set<String> windows = driver.getWindowHandles();
	        String adminToolHandle = driver.getWindowHandle();
	        ((JavascriptExecutor) driver).executeScript("window.open();");
	        Set<String> customerWindow = driver.getWindowHandles();
	        customerWindow.removeAll(windows);
	        String customerSiteHandle = ((String) customerWindow.toArray()[0]);
	        driver.switchTo().window(customerSiteHandle);
	        driver.get("http://localhost:8100/");
	        driver.switchTo().window(adminToolHandle);

//   ((JavascriptExecutor) driver).executeScript("window.open()");
//		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());	
//	    System.out.println(tabs.size());
//		driver.switchTo().window(tabs.get(0));	
//     	Thread.sleep(3000);
	
//		
//	robot = new Robot();
//	robot.keyPress(KeyEvent.VK_CONTROL);
//	robot.keyPress(KeyEvent.VK_T);
//	robot.keyRelease(KeyEvent.VK_T);
//	robot.keyRelease(KeyEvent.VK_CONTROL);
//	Thread.sleep(5000);  
//    driver.switchTo().defaultContent();
//    Thread.sleep(5000); 
//    changeToPreviousTab() ;
	
	
	
	
	}

	public void changeToPreviousTab() throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);
	}

	
}