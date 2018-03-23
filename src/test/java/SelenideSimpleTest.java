import base.TestBaseSelenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import listeners.AllureAttachmentListener;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static com.codeborne.selenide.Condition.visible;

/**
 * Простой тест на Selenide. Размноженный, чтобы получилось 3 независимых теста
 * Запускать через testngSelenideParallel.xml - посмотреть параллельный запуск
 */

@Listeners(AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Login tests"})
public class SelenideSimpleTest extends TestBaseSelenide{

    @AfterMethod
    public void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void loginTest1() {
        open("https://epam.github.io/JDI/index.html");
        assertEquals(getWebDriver().getTitle(), "Home Page");

        $(".uui-profile-menu .dropdown-toggle").click();
        $("#Name").sendKeys("epam");
        $("#Password").sendKeys("1234");
        $(".form-horizontal [type='submit']").click();
        $("span[ui='label']").should(visible).should(text("Piter Chailovskii"));
    }

    @Test
    public void loginTest2() {
        open("https://epam.github.io/JDI/index.html");
        assertEquals(getWebDriver().getTitle(), "Home Page");

        $(".uui-profile-menu .dropdown-toggle").click();
        $("#Name").sendKeys("epam");
        $("#Password").sendKeys("1234");
        $(".form-horizontal [type='submit']").click();
        $("span[ui='label']").should(visible).should(text("Piter Chailovskii"));
    }

    @Test
    public void loginTest3() {
        open("https://epam.github.io/JDI/index.html");
        assertEquals(getWebDriver().getTitle(), "Home Page");

        $(".uui-profile-menu .dropdown-toggle").click();
        $("#Name").sendKeys("epam");
        $("#Password").sendKeys("1234");
        $(".form-horizontal [type='submit']").click();
        $("span[ui='label']").should(visible).should(text("Piter Chailovskii"));
    }
}
