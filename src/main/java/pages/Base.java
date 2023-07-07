package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Properties;

public class Base {
    WebDriver driver;
    static Duration TIMEOUT = Duration.ofSeconds(10);
    Properties properties;

    public Base() {
        this.driver = driver;
    }

    public WebDriver driverCreate() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://automationexercise.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            return driver;
        }
        return driver;
    }

    public void explisityWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementLocatedBecomeClickable(WebDriver driver, WebElement by) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) by));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void scrollPageDown (WebDriver driver){
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public static void scrollPageDownTillTheElement (WebDriver driver, WebElement element){
        Actions a = new Actions(driver);
        a.moveToElement(element);
    }

    public static void scrollPageUp (WebDriver driver){
        Actions a = new Actions(driver);
        a.sendKeys(Keys.PAGE_UP).build().perform();
    }

    public static void pageZoomOut() throws AWTException {
        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_MINUS);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_MINUS);
    }
}