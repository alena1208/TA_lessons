import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Параллельный запуск тест
 */
public class SimpleTest3 {

    @Test(invocationCount = 3, threadPoolSize = 3)
    public void SimpleMediaTest() {
        WebDriver driver = new ChromeDriver();

        //распахнуть окно
        driver.manage().window().maximize();
        //открыть сайт
        driver.navigate().to("https://epam.github.io/JDI/index.html");
        //проверить название окна
        Assert.assertEquals(driver.getTitle(), "Home Page");

        //Инициализация элементов
        WebElement loginFormButton = driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle"));
        WebElement loginInput = driver.findElement(By.cssSelector("#Name"));
        WebElement passwordInput =  driver.findElement(By.cssSelector("#Password"));
        WebElement submitButton = driver.findElement(By.cssSelector(".form-horizontal [type='submit']"));
        WebElement nameText = driver.findElement(By.cssSelector("span[ui='label']"));

        //Шаги теста
        loginFormButton.click();
        loginInput.sendKeys("epam");
        passwordInput.sendKeys("1234");
        submitButton.click();
        Assert.assertEquals(nameText.getText(), "PITER CHAILOVSKII");

        driver.close();
    }
}
