package com.hotelwikiTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BackOfficeTest {

	private final String OPENDERIVER = "webdriver.chrome.driver";
	private final String PATH = "D:\\MYPROJECT\\hotelwikiTest\\Drivers\\chromedriver.exe";
	private final String URL = "http://localhost:8081/hotelwiki";
	public static WebDriver driver;
	public WebDriverWait wait;

	@BeforeTest
	public void loginBackOffice() throws InterruptedException {

		System.setProperty(OPENDERIVER, PATH);
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		theamLeafLogin();
		Thread.sleep(2000);
		LoginToBackOffice();

	}

	@Test(priority = 1, enabled = true)
	public void Account() throws InterruptedException {
		driver.findElement(By.xpath("//*[text()='Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Financial']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addAccount")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("PNB");
		driver.findElement(By.id("openingBalance")).sendKeys("0");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='searchCode'])[2]")).sendKeys("PNB");
		Thread.sleep(2000);
		driver.findElement(By.id("alternateName")).sendKeys("PNB");
		Thread.sleep(2000);
		driver.findElement(By.id("businessLocation")).sendKeys("pune");
		Thread.sleep(2000);
		driver.findElement(By.id("description")).sendKeys("Financial Account for debit & credit");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Balance Sheet')]")).click();
		Thread.sleep(3000);
		dropdownValueById("accountGroupBalSheet", 1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@class='criteriatext mt-2']")).click();
		Thread.sleep(3000);
		WebElement test = driver.findElement(By.xpath("//*[@id=\"searchName\"]"));
		String s = test.getAttribute("id");
		if (s.equals("searchName")) {
			test.sendKeys("PNB");
		} else {
			System.out.print("Element not found");
		}

		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);

		// click on Bank
		driver.findElement(By.xpath("//*[text()='Bank']")).click();
		Thread.sleep(2000);
		// click on Add Bank Account
		driver.findElement(By.xpath("//*[@id=\"addSection\"]")).click();
		Thread.sleep(3000);
		// ADD NAME
		driver.findElement(By.id("name")).sendKeys("ICICI");
		driver.findElement(By.id("accountNumber")).sendKeys("99887766554433");
		driver.findElement(By.id("ifscCode")).sendKeys("PNB-998877");
		driver.findElement(By.id("swiftCode")).sendKeys("PNB-998877");
		driver.findElement(By.id("description")).sendKeys("Bank Account");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(5000);
		// click on search criteria
		driver.findElement(By.xpath(
				"/html/body/app-dashboard/div/main/div/app-router-outlet/app-bank/div[1]/div/div[1]/div/div[1]/a"))
				.click();
		Thread.sleep(3000);
		// searching by name
		driver.findElement(By.id("searchName")).sendKeys("ICICI");
		Thread.sleep(3000);
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(3000);

		// click on Transaction
		driver.findElement(By.xpath("//*[text()='Transaction']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addSection\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("transactionAmount")).sendKeys("5000");
		Thread.sleep(6000);
		dropdownValueById("financialAccToCredit", 4);
		Thread.sleep(6000);
		dropdownValueById("financialAccToDebit", 6);
		Thread.sleep(6000);
		dropdownValueById("paymentType", 2);
		Thread.sleep(3000);
		driver.findElement(By.id("accountNumber")).sendKeys("99887766554433");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);
		// click on Tenderaccount
		driver.findElement(By.xpath("//*[text()='Tender Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addSection")).click();
		Thread.sleep(4000);
		dropdownValueById("storeName", 3);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='financialAccount Section']")).click();
		driver.findElement(By.xpath("(//*[text()='PNB'])[1]")).click();
		driver.findElement(By.id("submit")).click();
		Thread.sleep(6000);
		// Bill Settlement
		driver.findElement(By.xpath("//*[text()='Bill Settlement']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/app-dashboard/div/main/div/app-router-outlet/app-bill-settlement/div[2]/div/div[2]/table/tbody/tr[1]/td[2]"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(
				"/html/body/app-dashboard/div/main/div/app-router-outlet/app-bill-settlement/div[2]/div/div[2]/table/tbody/tr[2]/td[2]"))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("settleBillSection")).click();
		Thread.sleep(6000);
		dropdownValueByXpath("//div/div/app-settle-bills/form/div[2]/div[1]/div/select", 3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Submit ']")).click();
		Thread.sleep(2000);
		// Bill Design
		driver.findElement(By.xpath("//*[text()='Bill Design']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addSection")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("billType")).sendKeys("opened");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Category Section']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Food']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 2, enabled = true)
	public void menuItem() throws InterruptedException, AWTException {
		driver.findElement(By.xpath("(//*[text()='Menu Items'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Menu Items'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addMenuItem\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("name")).sendKeys("Veg laziz");
		driver.findElement(By.id("menuItemCode")).sendKeys("1000");
		dropdownValueById("storeMenuItemStatus", 1);
		Thread.sleep(2000);
		driver.findElement(By.id("details")).sendKeys("Veg Food");
		dropdownValueById("mainParentCategoryId", 1);
		Thread.sleep(2000);
		dropdownValueById("subCategoryId", 1);
		Thread.sleep(2000);
		dropdownValueById("parentCategoryId", 1);
		Thread.sleep(2000);
		driver.findElement(By.id("menuItemCost")).sendKeys("180");
		driver.findElement(By.id("sellingPrice")).sendKeys("250");
		driver.findElement(By.id("menuItemMinCost")).sendKeys("200");
		driver.findElement(By.id("menuItemMaxCost")).sendKeys("300");
		driver.findElement(By.id("noOfPortionInRecipe")).sendKeys("4");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='mat-tab-label-content'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()=' Use Recipe ']")).click();
		Thread.sleep(3000);
		dropdownValueById("recipe", 1);
		Thread.sleep(3000);
		driver.findElement(By.id("menuItemOnlineSummary")).sendKeys("Receipe Ingredients");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(6000);

		// search criteria
		driver.findElement(By.xpath("(//*[@class='criteriatext mt-2'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchName1")).sendKeys("Veg laziz");
		Thread.sleep(3000);
		driver.findElement(By.id("search1")).click();
		Thread.sleep(3000);
		// ImportMenuItemExcelSheet();
		// Receipe
		driver.findElement(By.xpath("//*[text()='Recipes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addRecipe\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("name")).sendKeys("1 kg Jira Rice");
		driver.findElement(By.id("code")).sendKeys("1");
		dropdownValueById("category", 1);
		Thread.sleep(3000);
		driver.findElement(By.id("noOfServe")).sendKeys("4");
		driver.findElement(By.id("productionTime")).sendKeys("15");
		driver.findElement(By.id("description")).sendKeys("test");
		dropdownValueById("productId", 1);
		Thread.sleep(3000);
		dropdownValueById("unit", 1);
		driver.findElement(By.id("qty")).sendKeys("4");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Method']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Video']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Photo']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Ingredients']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("submitBtn")).click();
		Thread.sleep(4000);
		// search criteria
		driver.findElement(By.xpath("(//a[@class='criteriatext mt-2'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchName")).sendKeys("1 Kg Jira Rice");
		Thread.sleep(3000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(3000);
		// Add categories
		driver.findElement(By.xpath("//*[text()='Categories']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addCategories")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("closeBtn")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 3, enabled = true)
	public void createTables() throws InterruptedException {
		driver.findElement(By.xpath("(//*[text()='Table Section'])")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Section']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"addSection\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("tableSectionName")).sendKeys("Cave");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addCategory\"]")).click();
		Thread.sleep(3000);
		// add name
		driver.findElement(By.id("tableCategoryName")).sendKeys("Beverage");
		Thread.sleep(3000);
		// submit
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//*[text()='Tables'])")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"addTables\"]")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("noOfTables")).sendKeys("20");
		Thread.sleep(3000);
		dropdownValueById("tableType", 2);
		Thread.sleep(3000);
		dropdownValueById("tableSection", 3);
		Thread.sleep(3000);
		driver.findElement(By.id("noOfChair")).sendKeys("4");
		driver.findElement(By.id("initials")).sendKeys("T-");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);
		dropdownValueById("filterBills", 2);

	}

	@Test(priority = 4, enabled = true)
	public void Sales() throws Exception {
		driver.findElement(By.xpath("//*[text()='Sales']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Current Sales']")).click();
		Thread.sleep(5000);
		dropdownValueById("filterBills", 1);
		Thread.sleep(5000);
		dropdownValueById("filterBills", 2);
		Thread.sleep(5000);
		dropdownValueById("filterBills", 3);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Return Order Item']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"addReturnOrderItem\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"selectMenuItmBtn\"]")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"customerTable\"]/tbody/tr[2]/td[1]/input")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//*[@id='submit'])[2]")).click();
		// click on order item status
		Thread.sleep(3000);
		dropdownValueById("orderItemStatus", 1);
		Thread.sleep(3000);
		dropdownValueById("orderType", 1);
        driver.findElement(By.id("sellingPrice")).sendKeys("79");
		driver.findElement(By.id("orderId")).sendKeys("1");
		 driver.findElement(By.id("orderItemId")).sendKeys("1");
		 driver.findElement(By.id("storeMenuDiscountPrice")).sendKeys("100");
		 driver.findElement(By.id("subType")).sendKeys("Veg");
		 Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);
		// click on search criteria
		driver.findElement(By.xpath(
				"/html/body/app-dashboard/div/main/div/app-router-outlet/app-return-item/div[1]/div/div[1]/div/div[1]/a"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchName")).sendKeys("Tandoori Roti");
		Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
		Thread.sleep(6000);
	}

	@Test(priority = 5, enabled = true)
	public void deviceManagement() throws Exception {
		driver.findElement(By.xpath("//*[text()='Device Management']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Device List']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Manage Device']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addDevice")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("deviceNumber")).sendKeys("Device-1");
		Thread.sleep(4000);
    	dropdownValueByXpath("(//*[@id='deviceType'])[2]", 2);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000); 
		//click on search
		driver.findElement(By.xpath("//*[text()=' Show Search Criteria ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchDeviceName")).sendKeys("Device-1");
		Thread.sleep(3000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(6000);
		
	}
	

	@Test(priority = 5, enabled = true)
	public void resources() throws Exception {
		driver.findElement(By.xpath("//*[text()='Resources']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Customers']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addCustomer")).click();
	    driver.findElement(By.id("requiredName")).sendKeys("Dev Bisen");
		driver.findElement(By.id("requiredPhone")).sendKeys("8975615600");
		Thread.sleep(3000);
		dropdownValueById("requiredGender", 1);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Employees']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addEmployee")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("employeeCode")).sendKeys("EMP-1");
		Thread.sleep(1000);
		dropdownValueById("prefix", 1);
		Thread.sleep(3000);
		driver.findElement(By.id("firstName")).sendKeys("Deva");
		Thread.sleep(3000);
		driver.findElement(By.id("lastName")).sendKeys("Bisen");
		Thread.sleep(3000);
		dropdownValueById("modeOfEmployment", 2);
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("devbisen95@gmail.com");
		Thread.sleep(3000);
		dropdownValueById("department", 2);
		Thread.sleep(3000);
		dropdownValueById("storeName", 1);
		Thread.sleep(3000);
		dropdownValueById("position", 2);
		Thread.sleep(3000);
		dropdownValueById("employmentStatus", 2);
		driver.findElement(By.id("yearsOfExperience")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.id("workTelephoneNumber")).sendKeys("8899776655");
		driver.findElement(By.id("extension")).sendKeys("test");
		driver.findElement(By.id("fax")).sendKeys("123456");
		dropdownValueById("gender", 2);
		Thread.sleep(1000);
		dropdownValueById("tenderTypes", 1);
		Thread.sleep(1000);
		dropdownValueById("nationality", 2);
		Thread.sleep(1000);
		dropdownValueById("ethnicCode", 2);
		driver.findElement(By.id("dateOfBirth")).sendKeys("08/10/1995");
		driver.findElement(By.id("bloodGroup")).sendKeys("O+");
		driver.findElement(By.id("passport")).sendKeys("pass-1");
		driver.findElement(By.id("passportExpiryDate")).sendKeys("08/10/1995");
		driver.findElement(By.id("drivinglicence")).sendKeys("DLC-123111");
		driver.findElement(By.id("drivinglicenceExpiryDate")).sendKeys("08/10/1995");
		driver.findElement(By.name("accountNumber")).sendKeys("999999999");
		driver.findElement(By.name("ifscCode")).sendKeys("ICICI-123");
		driver.findElement(By.name("branch")).sendKeys("Pune");
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='contact']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("personalEmail")).sendKeys("devbisen95@gmail.com");
		driver.findElement(By.id("permanentStreetAddress")).sendKeys("8/9 dyandeep colony, karve nagar pune");
		driver.findElement(By.id("permanentCity")).sendKeys("Pune");
		driver.findElement(By.id("permanentState")).sendKeys("Maharashtra");
		driver.findElement(By.id("permanentCountry")).sendKeys("India");
		driver.findElement(By.id("permanentPostalCode")).sendKeys("411052");
		driver.findElement(By.id("permanentCheckIfpermanent")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("emergencyName")).sendKeys("Mahesh");
		driver.findElement(By.id("emergencyEmail")).sendKeys("mahesh@emeregency.com");
		driver.findElement(By.id("emergencyNumber")).sendKeys("9898956985");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Skills']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Experience']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Leave']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("allotLeaveLimit")).sendKeys("10");
		driver.findElement(By.id("leaveYear")).sendKeys("2019");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Holidays']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='contact']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[text()=' Show Search Criteria ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchName")).sendKeys("Dev Bisen");
		Thread.sleep(3000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Suppliers']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addSupplier")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("suppliersName")).sendKeys("Rhohit Sharma");
		Thread.sleep(3000);
		driver.findElement(By.id("suppliersEmail")).sendKeys("rohits@gamil.com");
		Thread.sleep(3000);
		driver.findElement(By.id("suppliersPhone")).sendKeys("9988776655");
		Thread.sleep(3000);
		driver.findElement(By.id("address1")).sendKeys("8/9 dyandeep colony, karve nagar pune");
	    driver.findElement(By.id("address2")).sendKeys("8/9 dyandeep colony, karve nagar pune");
	    driver.findElement(By.id("city1")).sendKeys("pune");
		driver.findElement(By.id("zip1")).sendKeys("411052");
	    driver.findElement(By.id("state1")).sendKeys("Maharashtra");
		driver.findElement(By.id("country1")).sendKeys("India");
	    driver.findElement(By.id("fax1")).sendKeys("543645");
		driver.findElement(By.id("customField1")).sendKeys("1");
	    driver.findElement(By.id("customField2")).sendKeys("2");
		Thread.sleep(3000);
		driver.findElement(By.id("submitClick")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[text()=' Show Search Criteria ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("searchName")).sendKeys("Rohit");
		Thread.sleep(6000);
		driver.findElement(By.id("search")).click();
		Thread.sleep(6000);
	}
	@Test(priority = 6, enabled = true)
	public void restaurantSettings() throws Exception {
		
		driver.findElement(By.xpath("(//*[text()='Restaurant Settings'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Restaurant List']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Restaurant Settings'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='App Setting']")).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Restaurant Backup']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Restaurant Configuration']")).click();
		Thread.sleep(2000);
		scrollDownR();
		driver.findElement(By.xpath("//*[text()='Kitchen Setting']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addSection")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("Bar");
		driver.findElement(By.id("kitchenDevices")).sendKeys("Kitchen-1");
		driver.findElement(By.id("kitchenManager")).sendKeys("Rohit");
		driver.findElement(By.id("location")).sendKeys("First floor");
		driver.findElement(By.id("type")).sendKeys("Bar");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Currency Details']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Sms Setting']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 7, enabled = true)
	public void systemFunction() throws Exception {
		driver.findElement(By.xpath("//*[text()='System Functions']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Hardware TS']")).click();
		Thread.sleep(2000);
		scrollDown();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Self Diagnosis']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Software TS']")).click();
		Thread.sleep(2000);
		
		
	}
	@Test(priority = 8, enabled = true)
	public void loyalty() throws Exception {
		scrollDown();
		driver.findElement(By.xpath("//*[text()='Event Log']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Loyalty']")).click();
		Thread.sleep(2000);
		scrollDownR();
		driver.findElement(By.xpath("//*[text()='Customer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addSection")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("requiredName")).sendKeys("Dev");
		driver.findElement(By.id("Lastname")).sendKeys("Bisen");
		driver.findElement(By.id("requiredEmail")).sendKeys("devbisen95@gmail.com");
		driver.findElement(By.id("requiredPhone")).sendKeys("8975615600");
		driver.findElement(By.id("accountNumber")).sendKeys("8975698545565");
		driver.findElement(By.id("points")).sendKeys("20");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Company']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addSection")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("companyName")).sendKeys("WhizIT Services");
		driver.findElement(By.id("Lastname")).sendKeys("Whiz-10101010");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Rules']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addRule")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("WIKI First Games");
		driver.findElement(By.id("points")).sendKeys("10");
		driver.findElement(By.id("currentAmountSpent")).sendKeys("100");
		driver.findElement(By.id("totalAmountSpent")).sendKeys("1000");
		driver.findElement(By.id("noOfVisits")).sendKeys("1");
		driver.findElement(By.id("description")).sendKeys("Test");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Transaction']")).click();
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority = 9, enabled = true)
	public void FandBServices() throws Exception {
		driver.findElement(By.xpath("//*[text()='F & B Service']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Table Attributes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("addTableAttribute")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("tableNumber")).sendKeys("T-01");
		driver.findElement(By.id("quantity")).sendKeys("8");
		driver.findElement(By.id("currentQuantity")).sendKeys("4");
		driver.findElement(By.id("requiredQuantity")).sendKeys("5");
		driver.findElement(By.id("managerId")).sendKeys("1010101010");
		dropdownValueById("tableAttributeStatus", 1);
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		
	}
	@Test(priority = 10, enabled = true)
	public void templates() throws Exception {
		driver.findElement(By.xpath("//*[text()='Template']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Mail Template']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='SMS Template']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Receipt Print Bill Customization']")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 11, enabled = true)
	public void inventory() throws Exception {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Device Management']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Device List']")).click();
		Thread.sleep(3000);
		scrollDownR();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()='Inventory'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()='Inventory'])[2]")).click();
		Thread.sleep(2000);
		ImportInventoryExcelSheet();
		Thread.sleep(5000);
		driver.findElement(By.id("addProduct")).click();
		driver.findElement(By.id("name")).sendKeys("milk");
		dropdownValueById("counutryCurrency", 1);
		driver.findElement(By.id("message")).sendKeys("Dhudh");
		driver.findElement(By.id("initialQty")).sendKeys("0");
		driver.findElement(By.id("minimumQty")).sendKeys("10");
		driver.findElement(By.id("maximumQty")).sendKeys("100");
		driver.findElement(By.id("unitCost")).sendKeys("0");
		Select unitmesurement = new Select(driver.findElement(By.id("unitMeasurement")));
		unitmesurement.selectByIndex(2);
		Select productItemType = new Select(driver.findElement(By.id("inventoryProductType")));
		productItemType.selectByIndex(2);
		Select demandType = new Select(driver.findElement(By.id("demandType")));
		demandType.selectByIndex(2);
		dropdownValueById("category", 1);
		driver.findElement(By.id("location")).sendKeys("pune");
		driver.findElement(By.id("externalProductBarCode")).sendKeys("0001");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Purchase']")).click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(By.id("new")).click();
		Thread.sleep(2000);
		dropdownValueById("purchaseOrderType", 1);
		driver.findElement(By.id("poRefNo")).sendKeys("pune");
		Thread.sleep(2000);
		dropdownValueById("supplierId", 1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' Email PO ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='PO Dates']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("dateOfPurchase")).click();
		Thread.sleep(2000);
		scrollDownR();
		driver.findElement(By.id("selectProducts")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#customerTable > tbody > tr:nth-child(1) > td:nth-child(2)")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#customerTable > tbody > tr:nth-child(2) > td:nth-child(2)")).click();
		Thread.sleep(2000);
		scrollDownR();
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("")).click();
		Thread.sleep(2000);
		

	}

	public void scrollUp() throws InterruptedException, AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(2000);

	}

	public void theamLeafLogin() throws InterruptedException {

		driver.findElement(By.name("usernameOrEmail")).sendKeys("superadmin");
		driver.findElement(By.name("password")).sendKeys("superadmin");
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']")).click();
		waitForScreen(3000);

	}

	public void waitForScreen(int n) throws InterruptedException {
		Thread.sleep(n);
	}

	public void changeToNewTab1() throws InterruptedException {

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(8000);

	}

	public void LoginToBackOffice() throws InterruptedException {

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

	}

	public void dropdownValueByXpath(String s1, int n) {
		Select s = new Select(driver.findElement(By.xpath(s1)));
		s.selectByIndex(n);
	}

	public void dropdownValueById(String s1, int n) {
		Select s = new Select(driver.findElement(By.id(s1)));
		s.selectByIndex(n);
	}

	public static void scrollDown1() throws InterruptedException, AWTException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	public static void ImportMenuItemExcelSheet() throws InterruptedException, AWTException {

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
		// driver.findElement(By.id("closeBtn")).click();
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
		// driver.findElement(By.id("closeBtn")).click();
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
		// driver.findElement(By.id("closeBtn")).click();
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
		// driver.findElement(By.id("closeBtn")).click();
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
		// driver.findElement(By.id("closeBtn")).click();
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

}
