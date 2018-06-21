package SeleniumCucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class Stepdefs {

    private WebDriver driver;


    @Given("^The website of \"([^\"]*)\" is opened in Firefox$")
    public void the_website_of_is_opened_in_Firefox(String website) {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www." + website);
    }

    @Given("^The website of \"([^\"]*)\" is opened in Chrome$")
    public void the_website_of_is_opened_in_Chrome(String website) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www." + website);
    }

    @When("^enter \"([^\"]*)\" in the search bar$")
    public void enter_in_the_search_bar(String searchString) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(searchString);
        element.submit();
    }

    @Then("^the title of the page should say \"([^\"]*)\"$")
    public void the_title_of_the_page_should_say(String title) {
        Wait wait = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rhscol")));
        assertEquals("The actual title " + driver.getTitle() + " does not match the expected title " + title, title, driver.getTitle());
    }

    @Then("^close the website$")
    public void close_the_website() {
        driver.close();
    }

}
