import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class SignUp {

    WebDriver driver;
    By myEmail = By.id("email");
    By userName = By.id("new_username");
    By passWord = By.id("new_password");
    private String result;

    public SignUp(WebDriver driver) {
        this.driver = driver;

    }

    public WebDriver CreateBrowser(String Browser) {
        WebDriver driver;

        if (Browser.equals("edge")) {

            System.setProperty("webdriver.edge.driver", "C:\\Selenium\u200B\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {

            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\u200B\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;


    }


    private static void sendKeys(WebDriver driver, By by, String text) {
        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys(text);
    }

    public void Email(String email) {
        sendKeys(driver, myEmail, email);
    }

    public void userName(String username) {
        sendKeys(driver, userName, username);
    }

    public void password(String myPassword) {
        sendKeys(driver, passWord, myPassword);

        scroll(driver);
    }


    private static void scroll(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }


    public void nonAcceptablyUser() {
        WebElement signUp = driver.findElement(By.id("create-account"));
        signUp.click();

        result = driver.getTitle();

    }

    public String getResult() {

        return result;

    }

    public String generateSessionKey(int length) {
        String alphabet = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");


        int n = alphabet.length();
        String result1 = new String();
        Random r = new Random();

        for (int i = 0; i < length; i++)
            result1 = result1 + alphabet.charAt(r.nextInt(n));

        return result1;
    }


}










