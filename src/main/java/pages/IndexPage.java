package pages;

import com.codeborne.selenide.SelenideElement;
import enums.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Главная страница сайта.
 * Логин
 */
public class IndexPage {
        @FindBy(css = ".uui-profile-menu .dropdown-toggle")
        private WebElement loginFormButton;

        @FindBy(css = "#Name")
        private WebElement loginInput;

        @FindBy(css = "#Password")
        private WebElement passordInput;

        @FindBy(css = ".form-horizontal [type='submit']")
        private WebElement submitButton;

        @Step
        public void open(WebDriver driver) {
            driver.navigate().to("https://epam.github.io/JDI/index.html");
        }

        @Step
        public void login(String name, String password) {
            loginFormButton.click();
            loginInput.sendKeys(name);
            passordInput.sendKeys(password);
            submitButton.click();
        }

        @Step
        public void checkPageTitle(WebDriver driver) {
            assertEquals(driver.getTitle(),"Home Page");
        }
}
