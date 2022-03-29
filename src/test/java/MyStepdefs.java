import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MyStepdefs {

    WebDriver driver;
    SignUp sign;
    String userEmail;
    String newUser;

    @Given("User has started browser{string}")
    public void UserInLoginPage(String browser) throws InterruptedException {
        System.out.println("I'm here");
        sign = new SignUp(driver);

        //  DriveCreator create= new DriveCreator();
        driver = sign.CreateBrowser(browser);

        driver.get("https://login.mailchimp.com/signup/");

        Thread.sleep(3000);
        WebElement cookie = driver.findElement(By.id("onetrust-reject-all-handler"));
        cookie.click();

    }

    @And("User Enter email{string}")
    public void Email(String email) throws InterruptedException {

        sign = new SignUp(driver);
        Thread.sleep(5000);
        if (email.equals("NewEmail")) {

            userEmail = sign.generateSessionKey(10);
            userEmail = userEmail + "@hotmail.com";

            sign.Email(userEmail);
        } else if (email.equals("normalEmail")) {
            userEmail = sign.generateSessionKey(10);
            userEmail = userEmail + "@hotmail.com";
            sign.Email(userEmail);
        } else if (email.equals("existEmail")) {
            email = "eng.suzanne@hotmail.com";
            sign.Email(email);
        } else if (email.equals("empty")) {
            email = "";
            sign.Email(email);
        } else {
            sign.Email(email);
        }


    }

    @And("Enter username{string}")
    public void UserName(String username) {


        if (username.equals("NewUser")) {

            newUser = sign.generateSessionKey(10);
            newUser = newUser + "@hotmail.com";

            sign.userName(newUser);
        } else if (username.equals("longUserName")) {

            newUser = sign.generateSessionKey(102);
            newUser = newUser + "@hotmail.com";

            sign.userName(newUser);
        } else if (username.equals("existUsername")) {
            username = "eng.suzanne@hotmail.com";
            sign.userName(username);

        } else if (username.equals("normalUser")) {

            newUser = sign.generateSessionKey(10);
            newUser = newUser + "@hotmail.com";

            sign.userName(newUser);
        }


    }

    @And("Enter password")
    public void Password() {

        System.out.println("User enter th password");

        sign.password("Salma2712!");

    }

    @When("Clicks on sign up {string}")
    public void clicks_on_sign_up_entered_valid_user_button(String button) throws InterruptedException {

        sign.nonAcceptablyUser();
        Thread.sleep(4000);
    }

    @Then("The user will get the result{string}")
    public void theUserWillGetTheResult(String result) {
        String actual = sign.getResult();
        if (actual.equals("Success | Mailchimp")) {
            WebElement success = driver.findElement(By.xpath("//*[@id=\"signup-content\"]/div/div/div/h1"));
            actual = success.getText();
            // System.out.println(actual);
            assertEquals(result, actual);
        } else {
            WebElement felInput = driver.findElement(By.className("invalid-error"));
            actual = felInput.getText();

            assertEquals(result, actual);

        }


        driver.quit();
    }


}








