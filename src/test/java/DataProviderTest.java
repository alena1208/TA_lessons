import enums.IndexPageTextsEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.List;

import static enums.IndexPageTextsEnum.*;

/**
 * Запуск теста, используя DataProvider
 * Запускать можно через testng1.xml
 */
public class DataProviderTest {
    @DataProvider(parallel = true)
    public Object[][] menuItemsDP() {
        return new Object[][]{
                {0, TEXT_1.text},
                {1, TEXT_2.text},
                {2, TEXT_3.text},
                {3, TEXT_4.text}};
    }

    @Test(dataProvider = "menuItemsDP")
    public void menuItemsTest (int num, String text){
        System.setProperty("webdriver.chrome", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open main page
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //Check texts under pictures
        List<WebElement> textsUnderPictures = driver.findElements(By.className("benefit-txt"));
        WebElement textToCheck = textsUnderPictures.get(num);
        Assert.assertEquals(textToCheck.getText().toLowerCase(), text.toLowerCase());
        driver.close();
    }
}
