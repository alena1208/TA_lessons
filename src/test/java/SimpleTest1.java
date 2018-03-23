import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Простой тест. Инициализируем драйвер до тестового метода, используя аннтотации tesng
 * После тестового метода закрываем драйвер
 * В тестовом методе инициализируем элементы и взаимодействуем с ними
 */
public class SimpleTest1 {

    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    @Test(groups = {"smoke"})
    public void simpleMediaTest() {
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
