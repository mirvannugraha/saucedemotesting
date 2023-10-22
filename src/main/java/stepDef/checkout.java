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

public class checkout extends env_target{
    @Given("User is on login & home page")
    public void userIsOnLoginHomePage() {
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

    @When("User Fill username and password")
    public void userFillUsernameAndPassword() {
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
    }

    @And("User Click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("User Verify login result")
    public void userVerifyLoginResult() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='inventory_container']"))
        );
    }

    @When("User Click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @Then("User click cart")
    public void userClickCart() {
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();
    }

    @When("User click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.xpath("//*[@id='checkout']")).click();
    }

    @And("User fill first name, last name and postal code")
    public void userFillFirstNameLastNameAndPostalCode() {
        driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("Belajar");
        driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("Automation");
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("123456");
    }

    @And("User click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.xpath("//*[@id='continue']")).click();
    }

    @And("User click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.xpath("//*[@id='finish']")).click();
    }

    @Then("User verify checkout result")
    public void userVerifyCheckoutResult() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("complete-header"))
        );
        driver.quit();
    }
}
