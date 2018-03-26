package steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.IndexPage;
import runners.CucumberTestRunner;

import static runners.CucumberTestRunner.*;

public class SimplePageObjectTestSteps{

    private IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

    @Given("^user open site(.*)$")
    public void openSite(String link){
        driver.manage().window().maximize();
        indexPage.open(driver);
    }

    @Given("^user login as (.*) with password (.*)$")
    public void logitToSite(String login, String password){
        indexPage.login(login, password);
    }

    @Given("^page title equals to \"Home Page\"$")
    public void checkPageTitle(){
        indexPage.checkPageTitle(driver);
    }
}
