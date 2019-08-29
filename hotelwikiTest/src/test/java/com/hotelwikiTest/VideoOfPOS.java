package com.hotelwikiTest;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VideoOfPOS {
	
	private  final String OPENDERIVER = "webdriver.chrome.driver";
	private  final String PATH = "D:\\SeleniumProject\\chromedriver.exe";
	private  final String URL = "http://localhost:8081/hotelwiki/";
	public  WebDriver driver;
	public  WebDriverWait wait;
	 int i = 1;
	
	


	@BeforeTest
	public  void LoginPOS() throws InterruptedException, AWTException {

		System.setProperty(OPENDERIVER, PATH);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		waitForScreen();
		theamLeafLogin();
		waitForScreen();
		login();
	

	}
	@Test(priority = 1, enabled = false)
	public void openSales() throws InterruptedException {
		
		driver.findElement(By.id("sales")).click();
		waitForScreen();
		driver.findElement(By.id("openSale")).click();
		waitForScreen();
		WebElement enterAmount = driver.findElement(By.xpath("(//*[@id='mat-input-0'])"));
		enterAmount.sendKeys("0");
		waitForScreen();
		WebElement submit = driver.findElement(By.xpath("(//*[@class='btn light-green-color'])[2]"));
		submit.click();
		waitForScreen();
	}

	@Test(priority = 2, enabled = true)
	public void OrderOnTables() throws InterruptedException {

		waitAndClick("(//*[@class='col-lg-2 btn mr-1 table-btn-align TABLE-BUTTON FREE ng-star-inserted'])[1]");
		waitForScreen();
       
        waitForScreen();
		WebElement selectCategory = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
		selectCategory.click();
		waitForScreen();

		WebElement selectSubCategory = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
		selectSubCategory.click();
		Thread.sleep(3000);

		WebElement selectType = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
		selectType.click();
		waitForScreen();
		menuItems();

		WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
		placeOrder.click();
		waitForScreen();

		WebElement Payment = driver.findElement(By.xpath("//*[@id='paymentBtn']"));
		Payment.click();
		waitForScreen();

		WebElement SelectAccount = driver.findElement(By.xpath("//*[@id=\"account\"]/div/div[1]/span"));
		SelectAccount.click();
		waitForScreen();
		WebElement ClickOnAcc = driver.findElement(By.xpath("(//*[@class='mat-option-text'])[1]"));
		ClickOnAcc.click();
		try {
			waitForScreen();
			WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit']"));
			submitPayment.click();
			waitForScreen();
		} catch (Exception e) {
			waitForScreen();
			WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit ']"));
			submitPayment.click();
			waitForScreen();
		}
	}

	@Test(priority = 3, enabled = true)
	public void OrderOnTablesWithDiscount() throws InterruptedException {
		waitAndClick("(//*[@class='col-lg-2 btn mr-1 table-btn-align TABLE-BUTTON FREE ng-star-inserted'])[1]");
		waitForScreen();
		
		WebElement selectCategory = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
		selectCategory.click();
		waitForScreen();

		WebElement selectSubCategory = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
		selectSubCategory.click();
		Thread.sleep(3000);

		WebElement selectType = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
		selectType.click();
		waitForScreen();
		menuItems();

		WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
		placeOrder.click();
	

	
		waitForScreen();
		WebElement offers = driver.findElement(By.id("Offers"));
		offers.click();
		WebElement discount = driver.findElement(By.id("Disount"));
		discount.click();
		waitForScreen();
		driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[1]")).sendKeys("10");
		waitForScreen();
		driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[2]"))
				.sendKeys("Today's Discount");
		waitForScreen();
		driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[3]")).sendKeys("Cashier");
		waitForScreen();
		driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[4]")).click();
		waitForScreen();
		driver.findElement(By.xpath("//*[text() =' FLAT ']")).click();
		waitForScreen();
		driver.findElement(By.xpath("(//*[@class='mat-radio-outer-circle'])[1]")).click();
		waitForScreen();
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		waitForScreen();
		WebElement Payment = driver.findElement(By.xpath("//*[@id='paymentBtn']"));
		Payment.click();
		waitForScreen();
		WebElement SelectAccount = driver.findElement(By.xpath("//*[@id=\"account\"]/div/div[1]/span"));
		SelectAccount.click();
		waitForScreen();
		WebElement ClickOnAcc = driver.findElement(By.xpath("(//*[@class='mat-option-text'])[1]"));
		ClickOnAcc.click();
		try {
			waitForScreen();
			WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit']"));
			submitPayment.click();
			waitForScreen();
		} catch (Exception e) {
			waitForScreen();
			WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit ']"));
			submitPayment.click();
			waitForScreen();
		}
	}

	@Test(priority = 4, enabled = true)
	public void OrderOnTableswithBillAndCommission() throws InterruptedException {

	
		
			waitForScreen();
			waitAndClick("(//*[@class='col-lg-2 btn mr-1 table-btn-align TABLE-BUTTON FREE ng-star-inserted'])[3]");
			waitForScreen();
			
			WebElement selectCategory = driver.findElement(
					By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
			selectCategory.click();
			waitForScreen();

			WebElement selectSubCategory = driver.findElement(
					By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
			selectSubCategory.click();
			Thread.sleep(3000);

			WebElement selectType = driver.findElement(
					By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
			selectType.click();
			waitForScreen();
			menuItems();

			WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
			placeOrder.click();

			waitForScreen();
			WebElement Bill = driver.findElement(By.xpath("//*[@id='Bill']"));
			Bill.click();
			waitForScreen();
			WebElement Print_Bill = driver.findElement(By.xpath("//*[@id='Print Bill']"));
			Print_Bill.click();
			waitForScreen();
			WebElement Print = driver
					.findElement(By.xpath("//*[text()='Print']"));
			Print.click();
			waitForScreen();
			WebElement Commission = driver.findElement(By.xpath("//*[@id='Commission']"));
			Commission.click();
			waitForScreen();
			WebElement Enteramount = driver
					.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[1]"));
			Enteramount.sendKeys("10");
			WebElement note = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[2]"));
			note.sendKeys("Test");
			waitForScreen();
			WebElement Percent = driver.findElement(By.xpath("(//*[@class='mat-radio-outer-circle'])[1]"));
			Percent.click();
			waitForScreen();
			WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));
			submit.click();
			waitForScreen();

			WebElement Payment = driver.findElement(By.xpath("//*[@id='paymentBtn']"));
			Payment.click();
			waitForScreen();

			WebElement SelectAccount = driver.findElement(By.xpath("//*[@id=\"account\"]/div/div[1]/span"));
			SelectAccount.click();
			waitForScreen();
			WebElement ClickOnAcc = driver.findElement(By.xpath("(//*[@class='mat-option-text'])[1]"));
			ClickOnAcc.click();
			try {
				waitForScreen();
				WebElement submitPayment = driver.findElement(By.xpath("//*[text() ='Submit']"));
				submitPayment.click();
				waitForScreen();
			} catch (Exception e1) {
				waitForScreen();
				WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit ']"));
				submitPayment.click();
				waitForScreen();
			}
		}
	

	@Test(priority = 5, enabled = true)
	public void OrderOnTableswithTransaction() throws InterruptedException {
		waitAndClick("(//*[@class='col-lg-2 btn mr-1 table-btn-align TABLE-BUTTON FREE ng-star-inserted'])[4]");
		waitForScreen();
		
		WebElement selectCategory = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
		selectCategory.click();
		waitForScreen();

		WebElement selectSubCategory = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
		selectSubCategory.click();
		Thread.sleep(3000);

		WebElement selectType = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
		selectType.click();
		waitForScreen();
		menuItems();

		WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
		placeOrder.click();
		waitForScreen();
		WebElement clickOnTransaction = driver.findElement(By.xpath("//*[@id=\"Transactions\"]"));
		clickOnTransaction.click();
		waitForScreen();
		WebElement NCPAY = driver.findElement(By.xpath("//*[@id=\"NC Pay\"]"));
		NCPAY.click();
		waitForScreen();
		WebElement note = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])"));
		note.sendKeys("Test");
		try {
			waitForScreen();
			WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit']"));
			submitPayment.click();
			waitForScreen();
		} catch (Exception e) {
			waitForScreen();
			WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit ']"));
			submitPayment.click();
			waitForScreen();
		}
	}

	@Test(priority = 6, enabled = true)
	public void CancelBill() throws InterruptedException {
		waitAndClick("(//*[@class='col-lg-2 btn mr-1 table-btn-align TABLE-BUTTON FREE ng-star-inserted'])[5]");
		waitForScreen();
		
		WebElement selectCategory = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
		selectCategory.click();
		waitForScreen();

		WebElement selectSubCategory = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
		selectSubCategory.click();
		Thread.sleep(3000);

		WebElement selectType = driver.findElement(
				By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
		selectType.click();
		waitForScreen();
		menuItems();

		WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
		placeOrder.click();
		waitForScreen();
		WebElement clickOnTransaction = driver.findElement(By.xpath("//*[@id=\"Transactions\"]"));
		clickOnTransaction.click();
		waitForScreen();
		WebElement cancelBill = driver.findElement(By.xpath("//*[@id=\"NC Pay\"]"));
		cancelBill.click();
		waitForScreen();
		WebElement Referencenote = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])"));
		Referencenote.sendKeys("Test");
		try {
			waitForScreen();
			WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit']"));
			submitPayment.click();
			waitForScreen();
		} catch (Exception e) {
			waitForScreen();
			WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit ']"));
			submitPayment.click();
			waitForScreen();
		}
		
	}
		
		@Test(priority = 7, enabled = true)
		public void splitBill() throws InterruptedException {

		
			
				waitAndClick("(//*[@class='col-lg-2 btn mr-1 table-btn-align TABLE-BUTTON FREE ng-star-inserted'])[1]");
				waitForScreen();
				
				WebElement selectCategory = driver.findElement(
						By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
				selectCategory.click();
				waitForScreen();

				WebElement selectSubCategory = driver.findElement(
						By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
				selectSubCategory.click();
				Thread.sleep(3000);

				WebElement selectType = driver.findElement(
						By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
				selectType.click();
				waitForScreen();
				menuItems();

				WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
				placeOrder.click();

				waitForScreen();
				WebElement Bill = driver.findElement(By.xpath("//*[@id='Bill']"));
				Bill.click();
				waitForScreen();
				WebElement splitBill = driver.findElement(By.xpath("//*[@id ='Split Bill']"));
				splitBill.click();
				waitForScreen();
				WebElement selectQuantity = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[1]"));
				selectQuantity.click();
				
				waitForScreen();
			    WebElement clickOnQty = driver.findElement(By.xpath("(//*[@class ='mat-option ng-star-inserted'])[1]"));
			    clickOnQty.click();
			    waitForScreen();
			    WebElement selectQuantity2 = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[2]"));
				selectQuantity2.click();
				waitForScreen();
			    WebElement clickOnQty2 = driver.findElement(By.xpath("(//*[@class ='mat-option ng-star-inserted'])[1]"));
			    clickOnQty2.click();
			    waitForScreen();
			    WebElement submit = driver.findElement(By.xpath("//*[text() ='Submit']"));
				submit.click();
				waitForScreen();
				WebElement Payment = driver.findElement(By.xpath("//*[@id='paymentBtn']"));
				Payment.click();
				waitForScreen();
				WebElement SelectAccount = driver.findElement(By.xpath("//*[@id=\"account\"]/div/div[1]/span"));
				SelectAccount.click();
				waitForScreen();
				WebElement ClickOnAcc = driver.findElement(By.xpath("(//*[@class='mat-option-text'])[1]"));
				ClickOnAcc.click();
				try {
					waitForScreen();
					WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit']"));
					submitPayment.click();
					waitForScreen();
				} catch (Exception e1) {
					waitForScreen();
					WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit ']"));
					submitPayment.click();
					waitForScreen();
				}
				

			}
			
	
	
		@Test(priority = 8, enabled = true)
		public void OrderWithLiveItem() throws InterruptedException {
			waitForScreen();
			waitAndClick("(//*[@class='col-lg-2 btn mr-1 table-btn-align TABLE-BUTTON FREE ng-star-inserted'])[1]");
			waitForScreen();
			
			WebElement selectCategory = driver.findElement(
					By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
			selectCategory.click();
			waitForScreen();

			WebElement selectSubCategory = driver.findElement(
					By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
			selectSubCategory.click();
			Thread.sleep(3000);

			WebElement selectType = driver.findElement(
					By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
			selectType.click();
			waitForScreen();
			menuItems();

			WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
			placeOrder.click();
			waitForScreen();
			WebElement selectItem = driver.findElement(By.xpath("//*[@class='item-list-body']/child::*[1]"));
			selectItem.click();
			waitForScreen();
			WebElement clickOnLiveItem = driver.findElement(By.xpath("//*[@id='Live Items']"));
			clickOnLiveItem.click();
			waitForScreen();
			WebElement DeleteItem = driver.findElement(By.xpath("//*[text()=' Delete Item ']"));
			DeleteItem.click();
			waitForScreen();
		WebElement Quantity = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[1]"));
			Quantity.click();
			waitForScreen();
			WebElement selectQuantity = driver.findElement(By.xpath("(//*[@class='mat-option-text'])[1]"));
			selectQuantity.click();
			waitForScreen();
			
			WebElement note = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[2]"));
			note.sendKeys("Test");
			waitForScreen();
			WebElement submit = driver.findElement(By.xpath("//*[text()='Submit ']"));
			submit.click();
			WebElement selectItem2 = driver.findElement(By.xpath("//*[@class='item-list-body']/child::*[2]"));
			selectItem2.click();
			waitForScreen();
			WebElement MoveItem = driver.findElement(By.xpath("//*[@id='Move Item']"));
			MoveItem.click();
			waitForScreen();
			WebElement Note = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[1]"));
			Note.sendKeys("Test");
			waitForScreen();
			WebElement SelectTable = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[2]"));
			SelectTable.click();
			waitForScreen();
			WebElement clickonTable = driver.findElement(By.xpath("(//*[@class='mat-option ng-star-inserted'])[1]"));
			clickonTable.click();
			waitForScreen();
			WebElement ssubmit = driver.findElement(By.xpath("//*[text()='Submit ']"));
			ssubmit.click();
			waitForScreen();
			WebElement selectItem3 = driver.findElement(By.xpath("//*[@class='item-list-body']/child::*[1]"));
			selectItem3.click();
			waitForScreen();
			
					
		}

		@Test(priority = 9, enabled = true)
		public void takeawayOrder() throws InterruptedException {
			
			try {
			
                waitForScreen();
				WebElement takeaway = driver.findElement(By.xpath("//*[@class='btn active-background']"));
				takeaway.click();
				
				WebElement selectCategory = driver.findElement(
						By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
				selectCategory.click();
				waitForScreen();
                WebElement selectSubCategory = driver.findElement(
						By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
				selectSubCategory.click();
				Thread.sleep(3000);
                WebElement selectType = driver.findElement(
						By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
				selectType.click();
				waitForScreen();
				menuItems();

				WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
				placeOrder.click();

				waitForScreen();
				WebElement Bill = driver.findElement(By.xpath("//*[@id='Bill']"));
				Bill.click();
				waitForScreen();
				WebElement Print_Bill = driver.findElement(By.xpath("//*[@id='Print Bill']"));
				Print_Bill.click();
				waitForScreen();
				WebElement Print = driver
						.findElement(By.xpath("//*[text()='Print']"));
				Print.click();
				waitForScreen();
				WebElement Commission = driver.findElement(By.xpath("//*[@id='Commission']"));
				Commission.click();
				waitForScreen();
				WebElement Enteramount = driver
						.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[1]"));
				Enteramount.sendKeys("10");
				WebElement note = driver.findElement(By.xpath("(//*[@class='mat-form-field-infix']/child::*[1])[2]"));
				note.sendKeys("Test");
				waitForScreen();
				WebElement Percent = driver.findElement(By.xpath("(//*[@class='mat-radio-outer-circle'])[1]"));
				Percent.click();
				waitForScreen();
				WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));
				submit.click();
				waitForScreen();

				WebElement Payment = driver.findElement(By.xpath("//*[@id='paymentBtn']"));
				Payment.click();
				waitForScreen();

				WebElement SelectAccount = driver.findElement(By.xpath("//*[@id=\"account\"]/div/div[1]/span"));
				SelectAccount.click();
				waitForScreen();
				WebElement ClickOnAcc = driver.findElement(By.xpath("(//*[@class='mat-option-text'])[1]"));
				ClickOnAcc.click();
		
				try {
					waitForScreen();
					WebElement submitPayment = driver.findElement(By.xpath("//*[text() ='Submit']"));
					submitPayment.click();
					waitForScreen();
				} catch (Exception e1) {
					waitForScreen();
					WebElement submitPayment = driver.findElement(By.xpath("//*[text()='Submit ']"));
					submitPayment.click();
					waitForScreen();
				}
				
	} catch (Exception e) {
				
				
			}
			}
			
		
	
		
		
	public  void dropdownValueByXpath(String s1, int n) {
		Select s = new Select(driver.findElement(By.xpath(s1)));
		s.selectByIndex(n);
	}

	public  void dropdownValueById(String s1, int n) {
		Select s = new Select(driver.findElement(By.id(s1)));
		s.selectByIndex(n);
	}

	public  void waitForScreen() throws InterruptedException {
		//Thread.sleep(n);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public  void waitAndClick(String z) {
		wait = new WebDriverWait(driver, 20);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(z)));
		element.click();

	}

	public  void theamLeafLogin() throws InterruptedException {

		driver.findElement(By.name("usernameOrEmail")).sendKeys("superadmin");
		waitForScreen();
		driver.findElement(By.name("password")).sendKeys("superadmin");
		waitForScreen();
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']")).click();
		waitForScreen();
		driver.findElement(By.xpath("(//*[@class='username'])[1]")).click();
		waitForScreen();
		changeToNewTab1();
	}

	public  void changeToNewTab1() throws InterruptedException {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(8000);

	}

	public  void login() throws InterruptedException {

		waitForScreen();
		dropdownValueByXpath("//div/div/div[2]/div/div[2]/select", 1);
		waitForScreen();
		WebElement ok = driver.findElement(By.xpath("//div/div/div[3]/button"));
		ok.click();
		waitForScreen();
		// dropdownValueByXpath("//div/div/div[1]/div/div/form/div[3]/select", 0);
		// waitForScreen();

		driver.findElement(By.id("username")).sendKeys("superadmin");
		waitForScreen();
		driver.findElement(By.id("password")).sendKeys("superadmin");
		waitForScreen();
		try {
			dropdownValueById("machineNumber", 1);
			waitForScreen();
		} catch (Exception e) {

			WebElement login = driver.findElement(By.xpath("//*[@id=\"signIn\"]"));
			login.click();
			waitForScreen();
		}

	}

	public  void menuItems() throws InterruptedException   {
		for (int z = 1; z <= 4; z++) {
			WebElement selectMenuItems = driver.findElement(By.xpath("(//*[@class='item-name col-7'])[" + z + "]"));
			selectMenuItems.click();
			waitForScreen();
			WebElement QuantityIncrement = driver.findElement(By.xpath("//*[text()='+']"));
			QuantityIncrement.click();
			waitForScreen();
			WebElement submit = driver.findElement(By.xpath("//*[text()='Submit ']"));
			submit.click();
			Thread.sleep(5000);
		}
	}
	
}	