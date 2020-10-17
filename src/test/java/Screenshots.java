import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    private WebDriver driver;

    public Screenshots(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot () throws IOException {
      String fileName = generateRandomValue(7) + ".png";
      String directory = System.getProperty("user.dir") + "//Screenshot//";
      File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(screenShot,new File(directory+fileName));
    }

    private String generateRandomValue(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i=0; i < length; i++) {
        int index = (int)(Math.random()*characters.length());
        sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

}
