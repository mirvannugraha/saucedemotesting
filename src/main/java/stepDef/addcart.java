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

public class addcart extends env_target {
    @Given("User is on login and home page")
    public void userIsOnLoginAndHomePage() {
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

    @When("fill username and password")
    public void fillUsernameAndPassword() {
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
    }

    @And("User click login buttons")
    public void userClickLoginButtons() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @And("User click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("User verify add to cart result")
    public void userVerifyAddToCartResult() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping_cart_container']/a/span"))
        );
        driver.quit();
    }
}
