import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Пример, в котором инициализация и закрытие драйвера вынесены в абстрактный класс
 */
public class SimpleTest2 extends TestBase {

    @Test
    public void simpleMediaTest(){
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
    }

}
