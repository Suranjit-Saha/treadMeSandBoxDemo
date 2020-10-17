import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PropertyPage {
    private WebDriver driver;
    private WaitForElement waitForElement;
    private ExcelRead excelRead = new ExcelRead();

    public PropertyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForElement = new WaitForElement(driver);
    }

    @FindBy(id = "SearchTabs1_PropertyAnchor")
    private WebElement propertyTab;

    @FindBy (css = "#listingTitleBarSelect option[selected='selected']")
    WebElement sort;

    @FindBy(id="forRentButton")
    private WebElement search;

    public void clickPropertyTab() {
        propertyTab.click();
    }

    public void clickToRent() {
        WebElement toRent = waitForElement.findActiveElement(By.id("PropertyToRentToggle"), 5);
        toRent.click();
    }

    public void provideRegion(String regionName) {
        WebElement element = driver.findElement(By.id("PropertyRegionSelect"));
        Select regionList = new Select(element);
        regionList.selectByVisibleText(regionName);
    }

    public void provideDistrict(String district) throws InterruptedException {
        Thread.sleep(500);
        WebElement element = driver.findElement(By.id("PropertyDistrictSelect"));
        //WebElement element = waitForElement.findActiveElement(By.id("PropertyDistrictSelect"),3);
        element.sendKeys(district);
        WebElement suburbTab = waitForElement.findActiveElement(By.id("PropertySuburbDiv"),3);
        suburbTab.click();
    }

    public void provideSuburb (String suburbValue) throws InterruptedException {
        Thread.sleep(1000);
        WebElement suburb = driver.findElement(By.xpath("//div[@id='PropertySuburbDiv']//ul[@style='max-height: 250px;']//label[contains(text(),'" + suburbValue +"')]"));
        suburb.click();
    }

    public void searchRental() {
        search.click();
    }

}