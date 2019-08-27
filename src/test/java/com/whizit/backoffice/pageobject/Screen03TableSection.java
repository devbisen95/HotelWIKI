package com.whizit.backoffice.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Screen03TableSection extends AbstractStepBackOffice {

    public Screen03TableSection(WebDriver driver, TimeHelper timeHelper) {
        super(driver, timeHelper);
        this.timeHelper = timeHelper;
    }

    @Override
    public String getScreenId() {
        return "TableSection";
    }

    @Override
    public int getScreenNumber() {
        return 3;
    }

    public void openTableSectionScreen(){

        WebElement tableSection = driver.findElement(By.xpath("(//*[@class='nav-link nav-dropdown-toggle'])[3]"));
        tableSection.click();
        waitForScreenReady(6000);
    }

    public void openSection(){

        WebElement clickSection = driver.findElement(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-dropdown[3]/app-sidebar-nav-items/app-sidebar-nav-link[1]/a"));
        clickSection.click();
        waitForScreenReady(6000);
    }

    public void addTableSection(){

        WebElement enterTableSectionName = driver.findElement(By.id("tableSectionName"));
        enterTableSectionName.sendKeys("indoor");
        waitForScreenReady(3000);

        submitButton();
    }

    public void searchTableSection(){

        WebElement searchCriteria = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/app-router-outlet/app-section/div[1]/div/div[1]/div/div[1]/a"));
        searchCriteria.click();
        waitForScreenReady(5000);
        
        WebElement enterTableSectionToSearch = driver.findElement(By.id("searchTableSectionName"));
        enterTableSectionToSearch.sendKeys("indoor");
        waitForScreenReady(6000);

        searchButton();
    }

    public void openCategory(){

        WebElement tableCategory = driver.findElement(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-dropdown[3]/app-sidebar-nav-items/app-sidebar-nav-link[2]/a"));
        tableCategory.click();
        waitForScreenReady(6000);
    }
    
    public void addTableCategory(){

        WebElement clickAddCategory = driver.findElement(By.xpath("//*[@id=\"addCategory\"]"));
        clickAddCategory.click();
        waitForScreenReady(3000);

        WebElement enterCategoryName = driver.findElement(By.id("tableCategoryName"));
        enterCategoryName.sendKeys("NON-VEG");
        waitForScreenReady(3000);

        submitButton();
    }

    public void openTables(){

        WebElement clickTable = driver.findElement(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-dropdown[3]/app-sidebar-nav-items/app-sidebar-nav-link[3]/a"));
        clickTable.click();
        waitForScreenReady(3000);
    }
    
    public void addTables(){

        WebElement clickAddTables = driver.findElement(By.xpath("//*[@id=\"addTables\"]"));
        clickAddTables.click();
        waitForScreenReady(3000);

        WebElement enterNumberOfTables = driver.findElement(By.id("noOfTables"));
        enterNumberOfTables.sendKeys("5");
        waitForScreenReady(6000);

        WebElement tableTypeDrop = driver.findElement(By.id("tableType"));
        Select selectTableType = new Select(tableTypeDrop);
        selectTableType.selectByIndex(2);
        waitForScreenReady(6000);

        WebElement tableSectionDrop = driver.findElement(By.id("tableSection"));
        Select selectTableSection = new Select(tableSectionDrop);
        selectTableSection.selectByIndex(2);
        waitForScreenReady(3000);

        WebElement enterNumberOfChairs = driver.findElement(By.id("noOfChair"));
        enterNumberOfChairs.sendKeys("4");
        waitForScreenReady(3000);

        WebElement enterTableInitial = driver.findElement(By.id("initials"));
        enterTableInitial.sendKeys("T-");
        waitForScreenReady(3000);

        submitButton();
    }

    public void searchTables(){

        WebElement clickSearchCriteria = driver.findElement(By.xpath("/html/body/app-dashboard/div/main/div/app-router-outlet/app-tables/div[1]/div/div[1]/div/div[1]/a"));
        clickSearchCriteria.click();
        waitForScreenReady(3000);

        WebElement enterTableNumber = driver.findElement(By.id("searchTableNumber"));
        enterTableNumber.sendKeys("T-1");
        waitForScreenReady(3000);

       searchButton();
    }

}
