import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    public WaitForElement(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findActiveElement(By locator, int waitTimeInSec) {

        wait = new WebDriverWait(driver,waitTimeInSec);

        try {
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println(locator.toString() + " : Element found");
        }
        catch (Exception e) {
            System.out.println(locator.toString() + " : Element not found");
        }
        return element;
    }
}
