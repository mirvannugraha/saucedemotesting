package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class logout extends env_target{
    @Given("User is on login and home pages")
    public void userIsOnLoginAndHomePages() {
        //Set drivelocation path
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //Maximize driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(sauceDemo);
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-button']"))
        );
    }

    @When("User fills username and password")
    public void userFillsUsernameAndPassword() {
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
    }

    @And("User click Login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @And("User click navigation")
    public void userClickNavigation() {
        driver.findElement(By.xpath("//*[@id='react-burger-menu-btn']")).click();
    }

    @Then("User click logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
        driver.quit();
    }
}
