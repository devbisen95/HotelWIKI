package com.whizit.backoffice.pageobject;

import com.helper.TimeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Screen02MenuItems extends AbstractStepBackOffice {

    public Screen02MenuItems(WebDriver driver, TimeHelper timeHelper) {
        super(driver, timeHelper);
        this.timeHelper = timeHelper;
    }

    @Override
    public String getScreenId() {
        return "MenuItems";
    }

    @Override
    public int getScreenNumber() {
        return 2;
    }

    public void openMenuItemsSectionScreen(){

        WebElement menuItemSection = driver.findElement(By.xpath("(//*[@class='nav-link nav-dropdown-toggle'])[2]"));
        menuItemSection.click();
        waitForScreenReady(5000);
    }

    public void openMenuItems() {

        WebElement menuItemSection = driver.findElement(By.xpath("(//*[@class='nav-link nav-dropdown-toggle'])[2]"));
        menuItemSection.click();
        waitForScreenReady(5000);
    }

    public void importExportMenuItem(String exportFilePath){

        WebElement clickImportExport = driver.findElement(By.id("importExport"));
        clickImportExport.click();
        waitForScreenReady(6000);

        WebElement chooseFile = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[2]/div/div[1]/div/label"));
        chooseFile.click();
        waitForScreenReady(6000);

        try {
            Robot r = new Robot();
            StringSelection menuItem = new StringSelection(exportFilePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(menuItem, null);

            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
            waitForScreenReady(3000);
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);

        }catch (Exception e){
            e.getMessage();
            System.out.println("missing file");
        }

        submitButton();
    }

    public void addMenuItems(){

        WebElement clickAddMenu = driver.findElement(By.xpath("//*[@id=\"addMenuItem\"]"));
        clickAddMenu.click();
        waitForScreenReady(3000);

        WebElement enterMenuItemName = driver.findElement(By.id("name"));
        enterMenuItemName.sendKeys("Butter Roti");
        waitForScreenReady(3000);

        WebElement menuItemStatusDrop = driver.findElement(By.id("storeMenuItemStatus"));
        Select itemStatus = new Select(menuItemStatusDrop);
        itemStatus.selectByIndex(1);
        waitForScreenReady(3000);

        WebElement categoryDrop = driver.findElement(By.id("mainParentCategoryId"));
        Select categoryVal = new Select(categoryDrop);
        categoryVal.selectByIndex(1);
        waitForScreenReady(3000);

        WebElement subCategoryDrop = driver.findElement(By.id("subCategoryId"));
        Select subCategoryVal = new Select(subCategoryDrop);
        subCategoryVal.selectByIndex(1);
        waitForScreenReady(3000);

        WebElement typeDrop = driver.findElement(By.id("parentCategoryId"));
        Select typeVal = new Select(typeDrop);
        typeVal.selectByIndex(1);
        waitForScreenReady(3000);

        WebElement enterMenuItemCost = driver.findElement(By.id("menuItemCost"));
        enterMenuItemCost.sendKeys("180");
        waitForScreenReady(3000);

        WebElement enterMenuItemPrice = driver.findElement(By.id("sellingPrice"));
        enterMenuItemPrice.sendKeys("250");
        waitForScreenReady(3000);

        driver.findElement(By.xpath("//*[@id=\"waitForScreenReady\"]")).click();
        waitForScreenReady(6000);
    }

    public void searchMenuItems(){

        WebElement openSearchCriteria = driver.findElement(By.xpath("(//*[@class='criteriatext mt-2'])[1]"));
        openSearchCriteria.click();
        waitForScreenReady(3000);

        WebElement enterItemName = driver.findElement(By.id("searchName1"));
        enterItemName.sendKeys("Butter Roti");
        waitForScreenReady(3000);

        WebElement searchButton = driver.findElement(By.id("search1"));
        searchButton.click();
        waitForScreenReady(3000);
    }

    public void openRecipes(){

        WebElement openRecipes = driver.findElement(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-dropdown[2]/app-sidebar-nav-items/app-sidebar-nav-link[2]/a"));
        openRecipes.click();
        waitForScreenReady(5000);
    }

    public void addRecipes(){

        WebElement addRecipes = driver.findElement(By.xpath("//*[@id=\"addRecipe\"]"));
        addRecipes.click();
        waitForScreenReady(6000);

        WebElement enterRecipesName = driver.findElement(By.id("name"));
        enterRecipesName.sendKeys("Jira Rice");
        waitForScreenReady(3000);

        WebElement categoryDrop = driver.findElement(By.id("category"));
        Select categoryVal = new Select(categoryDrop);
        categoryVal.selectByIndex(1);
        waitForScreenReady(3000);

        WebElement enterNumberOfServe = driver.findElement(By.id("noOfServe"));
        enterNumberOfServe.sendKeys("4");
        waitForScreenReady(3000);

        try {
            WebElement productId = driver.findElement(By.id("productId"));
            Select drop17 = new Select(productId);
            drop17.selectByIndex(1);
            waitForScreenReady(3000);
        }catch (Exception e){
            e.getMessage();
        }

        WebElement enterQty = driver.findElement(By.id("qty"));
        enterQty.sendKeys("4");

        WebElement unitDrop = driver.findElement(By.id("unit"));
        Select selectUnit = new Select(unitDrop);
        selectUnit.selectByIndex(1);
        waitForScreenReady(3000);
        
        driver.findElement(By.id("submitBtn")).click();
    }
    
    public void searchRecipes(){

        WebElement openSearchCriteria = driver.findElement(By.xpath("(//a[@class='criteriatext mt-2'])[1]"));
        openSearchCriteria.click();
        waitForScreenReady(3000);

        WebElement enterRecipeName = driver.findElement(By.id("searchName"));
        enterRecipeName.sendKeys("Jira Rice");
        waitForScreenReady(3000);

        searchButton();

    }

    public void openCategory(){

        WebElement openCategory = driver.findElement(By.xpath("/html/body/app-dashboard/div/app-sidebar/app-sidebar-nav/app-sidebar-nav-items/app-sidebar-nav-dropdown[2]/app-sidebar-nav-items/app-sidebar-nav-link[3]/a"));
        openCategory.click();
        waitForScreenReady(3000);
    }

    public void addCategory(){

        WebElement addCategory = driver.findElement(By.id("addCategories"));
        addCategory.click();
        waitForScreenReady(3000);

        WebElement mainCategoryDrop = driver.findElement(By.id("categoryName"));
        Select mainCategoryVal = new Select(mainCategoryDrop);
        mainCategoryVal.selectByIndex(2);
        waitForScreenReady(6000);

        WebElement subCategoryDrop = driver.findElement(By.id("subCategory"));
        Select subCategoryVal = new Select(subCategoryDrop);
        subCategoryVal.selectByIndex(2);
        waitForScreenReady(6000);

        WebElement typeDrop = driver.findElement(By.id("type"));
        Select selectType = new Select(typeDrop);
        selectType.selectByIndex(2);
        waitForScreenReady(3000);

        driver.findElement(By.id("closeBtn")).click();
        waitForScreenReady(6000);
    }
}
