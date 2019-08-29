package com.hotelwikiTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddStoreWithData {
	 static WebDriver driver;
	JavascriptExecutor jse;
	public static String password;

	@BeforeTest
	public void ImportExport() throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\MYPROJECT\\hotelwikiTest\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8081/hotelwiki");// http://demo.smartwiki.io
		Thread.sleep(3000);
		driver.manage().window().maximize();
		databaseConnect();
		Thread.sleep(6000);
		theamLeafLogin();
		Thread.sleep(3000);
		
	}

	@Test(priority = 1, enabled = false)
	public void createStore() throws InterruptedException, AWTException {
		// Add Store
		
		driver.findElement(By.xpath("//*[text()='Add Store']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("storeName")).sendKeys(" SMART WIKI");
		Thread.sleep(2000);
        dropdownValueById("storeType", 2);

		driver.findElement(By.id("defaultEmail")).sendKeys("test@gmail.com");

		driver.findElement(By.id("storeLogo")).sendKeys("logo");

		driver.findElement(By.id("openingDateTime")).sendKeys("1010AM");

		driver.findElement(By.id("closingDateTime")).sendKeys("0210PM");
		dropdownValueById("selectCurrency", 3);

		dropdownValueById("language", 3);

		driver.findElement(By.id("decimalQty")).sendKeys("0");

		driver.findElement(By.id("displayProductImage")).click();

		driver.findElement(By.id("overselling")).click();

		driver.findElement(By.id("multiStoreSelection")).click();

		driver.findElement(By.id("autoPrintReceipt")).click();

		driver.findElement(By.id("dateTimeFormat")).sendKeys("dd/mm/yyyy");

		jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		driver.findElement(By.id("storeEmail")).sendKeys("test@gmail.com");

		driver.findElement(By.id("storePassword")).sendKeys("WIKI");

		driver.findElement(By.id("storeConfirmPassword")).sendKeys("WIKI");

		Thread.sleep(2000);

		// click on Address

		driver.findElement(By.linkText("Address")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("storeCity")).sendKeys("pune");

		driver.findElement(By.id("storeState")).sendKeys("Maharashtra");

		driver.findElement(By.id("storeZip")).sendKeys("411052");

		dropdownValueById("storeCountry", 3);
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		driver.findElement(By.id("storePhone1")).sendKeys("8975615600");

		driver.findElement(By.id("storePhone2")).sendKeys("8975615600");

		driver.findElement(By.id("storeFax")).sendKeys("411052");

		driver.findElement(By.id("storeAddress")).sendKeys("8/9 dyandeep colony, karve nagar pune");
		Thread.sleep(3000);

		// click on Receipt
		driver.findElement(By.linkText("Receipt")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("storeReceiptHeader")).sendKeys("wiki");
		driver.findElement(By.id("storeReceiptFooter")).sendKeys("wiki");
		Thread.sleep(2000);

		// click on email
		driver.findElement(By.linkText("Emails")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("emailHost")).sendKeys("test@gmail.com");
		driver.findElement(By.id("userNmae")).sendKeys("wiki");
		driver.findElement(By.id("emailPassword")).sendKeys("wiki");
		driver.findElement(By.id("emailPort")).sendKeys("4100");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.id("emailFrom1")).sendKeys("test@gmail.com");

		driver.findElement(By.id("emailFrom2")).sendKeys("test@gmail.com");

		driver.findElement(By.id("emailFrom3")).sendKeys("test@gmail.com");

		driver.findElement(By.id("emailFrom4")).sendKeys("test@gmail.com");

		driver.findElement(By.id("emailFrom5")).sendKeys("test@gmail.com");
		Thread.sleep(3000);

		 driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

	}

	@Test(priority = 2, enabled = true)
	public void backOfficeLogin() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/header/div[3]/ul/li[2]/a/span")).click();
		Thread.sleep(5000);
		changeToNewTab1();
		Thread.sleep(3000);
		login();

	}
	@Test(priority = 3, enabled = true)
	public void importExcelSheets() throws Exception {
		ImportMenuItemExcelSheet();
		ImportReceipeExcelSheet();
		ImportInventoryExcelSheet();
		ImportAttributeExcelSheet();
		ImportTableAttributeExcelSheet();
	}

	@Test(priority = 4, enabled = true)
	public void createTables() throws InterruptedException {
		driver.findElement(By.xpath("(//*[text()='Table Section'])")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()='Tables'])")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"addTables\"]")).click();
		Thread.sleep(3000);
	
		driver.findElement(By.id("noOfTables")).sendKeys("20");
		Thread.sleep(6000);
	    WebElement value6 = driver.findElement(By.id("tableType"));
		Select drop6 = new Select(value6);
		drop6.selectByIndex(2);
		Thread.sleep(6000);
		WebElement value7 = driver.findElement(By.id("tableSection"));
		Select drop7 = new Select(value7);
		drop7.selectByIndex(2);
		Thread.sleep(3000);
		driver.findElement(By.id("noOfChair")).sendKeys("4");
		Thread.sleep(3000);
	    driver.findElement(By.id("initials")).sendKeys("T-");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);

	}


	
	public void databaseConnect() throws InterruptedException {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/hotelwiki","root","root");  
		    Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT password FROM hotelwiki.tb_users where user_name='superadmin';");  
			while (rs.next()){
		     password = rs.getString(1);
		    System.out.println(password);
			}
			}catch(Exception e){ System.out.println(e);}  
	
			}  
			
		
	
	public static void changeToNewTab1() throws InterruptedException {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(8000);

	}

	public static void scrollDown() throws InterruptedException, AWTException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public static void scrollDownR() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(2000);

	}

	public static void login() throws InterruptedException {
		WebElement value = driver.findElement(By.id("storeName"));
		Select drop = new Select(value);
		drop.selectByIndex(1);

		driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"login\"]/main/div/div/div/div/div/div/form/div[1]/input"))
				.sendKeys("superadmin");
		Thread.sleep(3000);
		try {
		driver.findElement(By.xpath("//*[@id=\"login\"]/main/div/div/div/div/div/div/form/div[2]/input"))
				.sendKeys(password);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
		Thread.sleep(3000);
		}catch(Exception e) {
			driver.findElement(By.xpath("//*[@id=\"login\"]/main/div/div/div/div/div/div/form/div[2]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"login\"]/main/div/div/div/div/div/div/form/div[2]/input"))
			.sendKeys("superadmin");
	         Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
			Thread.sleep(3000);
		}

	}

	public static void ImportMenuItemExcelSheet() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("(//*[text()='Menu Items'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Menu Items'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("importExport")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("files")).click();
		Thread.sleep(6000);
		Robot r = new Robot();
		StringSelection menuItem = new StringSelection("D:\\wiki-projects\\import\\store-menu-item.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(menuItem, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	    driver.findElement(By.id("Submit")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("closeBtn")).click();
	}

	public static void ImportReceipeExcelSheet() throws InterruptedException, AWTException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Recipes'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("importExport")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("files")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		StringSelection menuItem = new StringSelection("D:\\wiki-projects\\import\\recipe-import.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(menuItem, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("closeBtn")).click();
	}

	
	

	public static void ImportInventoryExcelSheet() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("(//*[text()='Sales'])[1]")).click();
		Thread.sleep(3000);
		scrollDownR();
		Thread.sleep(6000);
	
		driver.findElement(By.xpath("(//*[text()='Inventory'])[1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[text()='Inventory'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("importExport")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("files")).click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		StringSelection productInventory = new StringSelection("D:\\wiki-projects\\import\\product-inventory.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(productInventory, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("closeBtn")).click();
	}
	

	public static void ImportAttributeExcelSheet() throws InterruptedException, AWTException {
//		driver.findElement(By.xpath("(//*[text()='Menu Items'])[2]")).click();
//		Thread.sleep(3000);
//		scrollDownR();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//*[text()='Inventory'])[1]")).click();
		Thread.sleep(3000);
		
		scrollDownR();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Attribute']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("importExport")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("files")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		StringSelection menuItem = new StringSelection("D:\\wiki-projects\\import\\attribute.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(menuItem, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("closeBtn")).click();
	}

	public static void ImportTableAttributeExcelSheet() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("(//*[text()='Menu Items'])[2]")).click();
		Thread.sleep(3000);
		scrollDownR();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='F & B Service']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Table Attributes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("importExport")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("files")).click();
		Thread.sleep(3000);
		Robot r = new Robot();
		StringSelection menuItem = new StringSelection("D:\\wiki-projects\\import\\table-attribute.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(menuItem, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("Submit")).click();
		Thread.sleep(2000);
		//driver.findElement(By.id("closeBtn")).click();
	}
	public static void dropdownValueById(String s1, int n) {
		Select s = new Select(driver.findElement(By.id(s1)));
		s.selectByIndex(n);
	}

	public static void theamLeafLogin() throws InterruptedException {
		try {
		driver.findElement(By.xpath("//*[text()='Accept']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("usernameOrEmail")).sendKeys("superadmin");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[text()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Company'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Store']")).click();
		Thread.sleep(3000);
		}catch(Exception e){
			driver.findElement(By.name("usernameOrEmail")).sendKeys("superadmin");
			Thread.sleep(2000);
			driver.findElement(By.name("password")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[text()='Login']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[text()='Company'])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[text()='Store']")).click();
			Thread.sleep(3000);
		}

	}
}