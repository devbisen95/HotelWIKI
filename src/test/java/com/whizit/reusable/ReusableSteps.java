package com.whizit.reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class ReusableSteps extends BaseTest {

    protected static final String THEMELEAFUSERNAME = "superadmin";
    protected static final String THEMELEAFPASSWORD = "superadmin";
    protected static final String POSUSERNAME = "superadmin";
    protected static final String POSPASSWORD = "superadmin";
    protected static final String BOSUSERNAME = "superadmin";
    protected static final String BOSPASSWORD = "superadmin";
    protected static final String TABLEINITIAL = "O";

    public void maximizeWindow() {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void waitForScreenReady(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void changeToNewTab(int tabNumber) {

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        waitForScreenReady(2000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
        waitForScreenReady(5000);

    }

    public void themeLeafLogin() {

        WebElement themeLeafUsername = driver.findElement(By.name("usernameOrEmail"));
        themeLeafUsername.sendKeys(THEMELEAFUSERNAME);
        waitForScreenReady(2000);

        WebElement themeLeafPassword = driver.findElement(By.name("password"));
        themeLeafPassword.sendKeys(THEMELEAFPASSWORD);
        waitForScreenReady(2000);

        WebElement themeLeafLoginButton = driver.findElement(By.xpath("//*[@class='btn btn-primary btn-lg btn-block']"));
        themeLeafLoginButton.click();
        waitForScreenReady(4000);
    }

    public void selectStoreByXpath(String xpath, int index) {

        Select clickStore = new Select(driver.findElement(By.xpath(xpath)));
        clickStore.selectByIndex(index);

        WebElement oKButton = driver.findElement(By.xpath("//div/div/div[3]/button"));
        oKButton.click();
        waitForScreenReady(2000);
    }

    public void selectStoreById(String id, int n) {

        Select s = new Select(driver.findElement(By.id(id)));
        s.selectByIndex(n);

        WebElement oKButton = driver.findElement(By.xpath("//div/div/div[3]/button"));
        oKButton.click();
        waitForScreenReady(2000);
    }

    public void openPOS(){

        WebElement openPOS = driver.findElement(By.xpath("(//*[@class='username'])[1]"));
        openPOS.click();
        waitForScreenReady(3000);
    }
    public void loginPOS() {

        selectStoreByXpath("//div/div/div[2]/div/div[2]/select", 1);
        waitForScreenReady(2000);

        WebElement POSUsername = driver.findElement(By.id("username"));
        POSUsername.sendKeys(POSUSERNAME);
        waitForScreenReady(2000);

        WebElement POSPassword = driver.findElement(By.id("password"));
        POSPassword.sendKeys(POSPASSWORD);
        waitForScreenReady(2000);

        WebElement POSLoginButton = driver.findElement(By.xpath("//*[@id=\"signIn\"]"));
        POSLoginButton.click();
        waitForScreenReady(8000);

        try {
            selectStoreById("machineNumber", 1);
            waitForScreenReady(2000);
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public  void selectTable(String tableInitial, int tableNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tableInitial+""+tableNumber)));
        element.click();
        waitForScreenReady(3000);
    }

    public void selectMenuItemsAndPlaceOrder() {

        WebElement selectCategory = driver.findElement(By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[1]/div[3]/button"));
        selectCategory.click();
        waitForScreenReady(3000);

        WebElement selectSubCategory = driver.findElement(By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[2]/div[1]/button"));
        selectSubCategory.click();
        waitForScreenReady(3000);

        WebElement selectType = driver.findElement(By.xpath("//div/div/div[2]/app-order-section/div/app-item-categories/div/div[3]/div[1]/button"));
        selectType.click();
        waitForScreenReady(3000);

        menuItems();

        WebElement placeOrder = driver.findElement(By.xpath("//*[@id='Place Order']"));
        placeOrder.click();
        waitForScreenReady(5000);
    }

    public void menuItems(){

        for (int item = 1; item <= 4; item++) {

            WebElement selectMenuItems = driver.findElement(By.xpath("(//*[@class='item-name col-7'])[" + item + "]"));
            selectMenuItems.click();
            waitForScreenReady(3000);

            WebElement QuantityIncrement = driver.findElement(By.xpath("//*[text()='+']"));
            QuantityIncrement.click();
            waitForScreenReady(3000);

            WebElement submit = driver.findElement(By.xpath("//*[text()='Submit ']"));
            submit.click();
            waitForScreenReady(3000);
        }
    }

    public void itemListDataAlertHandler(){
        try {
            driver.switchTo().alert().accept();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void openBO(){

        WebElement openBO = driver.findElement(By.xpath("//*[@id=\"container\"]/header/div[3]/ul/li[2]/a/span"));
        openBO.click();
        waitForScreenReady(3000);
    }

    public void loginBackOffice() {

        selectStoreByXpath("//div/div/div[2]/div/div[2]/select", 1);
        waitForScreenReady(2000);

        WebElement enterBOUserName = driver.findElement(By.id("username"));
        enterBOUserName.sendKeys(BOSUSERNAME);
        waitForScreenReady(1000);

        WebElement enterBOPassword = driver.findElement(By.id("password"));
        enterBOPassword.sendKeys(BOSPASSWORD);
        waitForScreenReady(1000);

        WebElement BOLoginButton = driver.findElement(By.id("loginBtn"));
        BOLoginButton.click();
        waitForScreenReady(6000);

        try {
            selectStoreById("machineNumber", 1);
            waitForScreenReady(2000);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
