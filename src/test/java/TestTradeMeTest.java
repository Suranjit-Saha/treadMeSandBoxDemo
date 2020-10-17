import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestTradeMeTest {

    private WebDriver driver;
    private ExcelRead excelRead = new ExcelRead();
    private String url = excelRead.readFromExcel(1,1);
    private PropertyPage propertyPage;
    private Screenshots screenshots;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        propertyPage = new PropertyPage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        screenshots = new Screenshots(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws InterruptedException, IOException {

        if (testResult.isSuccess()){
            System.out.println("Passed " + testResult.getMethod().getMethodName());
        }
        else {
            System.out.println("Failed " + testResult.getMethod().getMethodName());
            screenshots.takeScreenshot();
        }
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void testRentalPropertyAdvDefaultOrder() throws InterruptedException, IOException {
        propertyPage.clickPropertyTab();
        propertyPage.clickToRent();
        propertyPage.provideRegion("Wellington");
        propertyPage.provideDistrict("Wellington");
        propertyPage.provideSuburb("Brooklyn");
        propertyPage.provideSuburb("Kelburn");
        propertyPage.searchRental();
        Assert.assertEquals(propertyPage.sort.getText(),"Featured first","Checking the default sort order");
    }
}