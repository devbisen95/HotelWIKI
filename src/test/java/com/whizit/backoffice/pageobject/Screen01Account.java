package com.whizit.backoffice.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Screen01Account extends AbstractStepBackOffice {

    public Screen01Account(WebDriver driver, TimeHelper timeHelper) {
        super(driver, timeHelper);
        this.timeHelper = timeHelper;
    }

    @Override
    public String getScreenId() {
        return "Account";
    }

    @Override
    public int getScreenNumber() {
        return 1;
    }

    public void openAccountSectionScreen() {

        WebElement clickAccountSection = driver.findElement(By.xpath("(//*[@class='nav-link nav-dropdown-toggle'])[1]"));
        clickAccountSection.click();
        waitForScreenReady(3000);
    }

    public void openFinancialAccount() {

        WebElement openFinancialAccount = driver.findElement(By.xpath("(//*[@class='nav-link'])[6]"));
        openFinancialAccount.click();
        waitForScreenReady(3000);
    }

    public void addFinancialAccount() {

        WebElement clickAddFinancialAccount = driver.findElement(By.id("addAccount"));
        clickAddFinancialAccount.click();
        waitForScreenReady(3000);

        WebElement enterFinancialAccountName = driver.findElement(By.id("name"));
        enterFinancialAccountName.sendKeys("PNB");
        waitForScreenReady(3000);

        WebElement enterOpeningBalance = driver.findElement(By.id("openingBalance"));
        enterOpeningBalance.sendKeys("0");
        waitForScreenReady(3000);

        WebElement selectBalanceSheetAccountType = driver.findElement(By.xpath("//*[contains(text(),'Balance Sheet')]"));
        selectBalanceSheetAccountType.click();
        waitForScreenReady(3000);

        WebElement accountGroup = driver.findElement(By.id("accountGroupBalSheet"));
        Select accountGroupBalSheetType = new Select(accountGroup);
        accountGroupBalSheetType.selectByIndex(2);
        waitForScreenReady(3000);

        submitButton();
    }

    public void searchFinancialAccount() {

        WebElement clickFinancialSearchCriteria = driver.findElement(By.xpath("//*[@class='criteriatext mt-2']"));
        clickFinancialSearchCriteria.click();
        waitForScreenReady(3000);

        WebElement test = driver.findElement(By.xpath("//*[@id=\"searchName\"]"));
        String s = test.getAttribute("id");
        if (s.equals("searchName")) {
            test.sendKeys("PNB");
        } else {
            System.out.print("not found");
        }

        driver.findElement(By.id("searchBtn")).click();
        waitForScreenReady(3000);

    }

    public void openBankAccount() {

        //click on Bank
        WebElement openBankAccount = driver.findElement(By.xpath("(//*[@class='nav-link'])[7]"));
        openBankAccount.click();
        waitForScreenReady(3000);
    }

    public void addBankAccount() {

        WebElement clickAddBankAccount = driver.findElement(By.id("addSection"));
        clickAddBankAccount.click();
        waitForScreenReady(1000);

        WebElement enterBankAccountName = driver.findElement(By.id("name"));
        enterBankAccountName.sendKeys("SBI");
        waitForScreenReady(1000);

        WebElement enterBankAccountNumber = driver.findElement(By.id("accountNumber"));
        enterBankAccountNumber.sendKeys("12345678945145");
        waitForScreenReady(1000);

        WebElement enterBankIFSCCode = driver.findElement(By.id("ifscCode"));
        enterBankIFSCCode.sendKeys("SBI000123");
        waitForScreenReady(1000);

        submitButton();
    }

    public void searchBankAccount() {

        WebElement clickBankSearchCriteria = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/app-router-outlet/app-bank/div[1]/div/div[1]/div/div[1]/a"));
        clickBankSearchCriteria.click();
        waitForScreenReady(3000);

        WebElement enterSearchBankAccountNumber = driver.findElement(By.id("searchName"));
        enterSearchBankAccountNumber.sendKeys("ICICI");
        waitForScreenReady(3000);

        WebElement clickSearchButton = driver.findElement(By.id("searchBtn"));
        clickSearchButton.click();
        waitForScreenReady(3000);
    }

    public void openTransaction() {

        WebElement openTransaction = driver.findElement(By.xpath("(//*[@class='nav-link'])[8]"));
        openTransaction.click();
        waitForScreenReady(3000);
    }

    public void addTransaction() {

        WebElement clickAddTransaction = driver.findElement(By.xpath("//*[@id=\"addSection\"]"));
        clickAddTransaction.click();
        waitForScreenReady(3000);

        WebElement enterTransactionAmount = driver.findElement(By.id("transactionAmount"));
        enterTransactionAmount.sendKeys("5000");
        waitForScreenReady(6000);

        WebElement financialAccToDebit = driver.findElement(By.id("financialAccToCredit"));
        Select financialAccDebitType = new Select(financialAccToDebit);
        financialAccDebitType.selectByIndex(2);
        waitForScreenReady(6000);

        WebElement financialAccToCredit = driver.findElement(By.id("financialAccToDebit"));
        Select financialAccCreditType = new Select(financialAccToCredit);
        financialAccCreditType.selectByIndex(2);
        waitForScreenReady(3000);

        WebElement tender = driver.findElement(By.id("paymentType"));
        Select tenderType = new Select(tender);
        tenderType.selectByIndex(2);
        waitForScreenReady(3000);

        WebElement enterTransactionAccNumber = driver.findElement(By.id("accountNumber"));
        enterTransactionAccNumber.sendKeys("99887766554433");
        waitForScreenReady(3000);

        submitButton();
    }

    public void openTenderAccount() {

        WebElement openTransaction = driver.findElement(By.xpath("(//*[@class='nav-link'])[9]"));
        openTransaction.click();
        waitForScreenReady(3000);
    }

    public void createTender() {

        WebElement clickCreateTender = driver.findElement(By.id("addSection"));
        clickCreateTender.click();
        waitForScreenReady(6000);

        WebElement tender = driver.findElement(By.id("storeName"));
        Select tenderType = new Select(tender);
        tenderType.selectByIndex(3);

        WebElement openTenderList = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-financial-tender-account/form/div[2]/div/div[2]/ng-multiselect-dropdown/div/div[1]/span/span[2]"));
        openTenderList.click();
        waitForScreenReady(2000);

        WebElement selectTender = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-financial-tender-account/form/div[2]/div/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[6]/div"));
        selectTender.click();

        submitButton();
    }

    public void openBillSettlement() {

        driver.findElement(By.xpath("(//*[@class='nav-link'])[10]")).click();
        waitForScreenReady(6000);
    }

    public void settleBill() {

        try {
            WebElement selectBill = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/app-router-outlet/app-bill-settlement/div[2]/div/div[2]/table/tbody/tr[1]/td[2]"));
            selectBill.click();
            waitForScreenReady(6000);

            WebElement clickSettleBill = driver.findElement(By.id("settleBillSection"));
            clickSettleBill.click();
            waitForScreenReady(6000);

            WebElement storeMenuItemDropdown = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-settle-bills/form/div[2]/div[1]/div/select"));
            Select storeMenuItem = new Select(storeMenuItemDropdown);
            storeMenuItem.selectByIndex(3);

            WebElement submitButton = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-settle-bills/form/div[1]/div[2]/div/button"));
            submitButton.click();
            waitForScreenReady(6000);

        } catch (Exception r) {
            System.out.println("========= No bill found for settlement, please generate bill and try again ===========");
            }
    }

    public void openBillDesign() {

        driver.findElement(By.xpath("(//*[@class='nav-link'])[11]")).click();
        waitForScreenReady(3000);
    }

    public void addBillDesign() {

        WebElement clickAddBillDesign = driver.findElement(By.id("addSection"));
        clickAddBillDesign.click();
        waitForScreenReady(3000);

        WebElement enterBillType = driver.findElement(By.id("billType"));
        enterBillType.sendKeys("opened");
        waitForScreenReady(3000);

        WebElement clickCategorySection = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-bill-design/form/div[2]/div/div[2]/ng-multiselect-dropdown/div/div[1]/span"));
        clickCategorySection.click();
        waitForScreenReady(3000);

        WebElement selectCategory = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/app-add-bill-design/form/div[2]/div/div[2]/ng-multiselect-dropdown/div/div[2]/ul[2]/li[3]"));
        selectCategory.click();
        waitForScreenReady(3000);

        driver.findElement(By.id("submit")).click();
        waitForScreenReady(3000);
    }

}



