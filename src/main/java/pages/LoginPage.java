package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.Random;


public class LoginPage extends Base {

    private static final By loginLogoutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    WebDriver driver;
    By signUpUsernameField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    By signUpPasswordField = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    By signUpBtn = By.xpath("//button[descendant::text()='Signup']");
    By signUpPageTitle = By.cssSelector("div:nth-child(3) > div > form > input[name=\"email\"]");
    By chooseMrsSignUpForm = By.xpath("//*[@id=\"id_gender2\"]");
    By chooseMrSignUpForm = By.xpath("//*[@id=\"id_gender1\"]");
    By nameSignUpForm = By.xpath("//input[@name='name']");
    By emailSignUpForm = By.xpath("//input[@id='email']");
    By passwordSignUpForm = By.xpath("//input[@id='password']");
    By dayDropdownFieldSignUpForm = By.xpath("//select[@name='days']");
    By monthDropdownFieldSignUpForm = By.xpath("//select[@name='months']");
    By yearDropdownFieldSignUpForm = By.xpath("//select[@name='years']");
    By firstNameFieldSignUpForm = By.xpath("//input[@name='first_name']");
    By lastNameFieldSignUpForm = By.xpath("//input[@name='last_name']");
    By companyNameFieldSignUpForm = By.xpath("//input[@name='company']");
    By address1FieldSignUpForm = By.xpath("//input[@name='address1']");
    By address2FieldSignUpForm = By.xpath("//input[@name='address2']");
    By countryFieldSignUpForm = By.xpath("//select[@name='country']");
    By cityFieldSignUpForm = By.xpath("//input[@name='city']");
    By zipcodeNameFieldSignUpForm = By.xpath("//input[@name='zipcode']");
    By mobileNumberFieldSignUpForm = By.xpath("//input[@name='mobile_number']");
    By createAccountFieldSignUpForm = By.xpath("//button[descendant::text()='Create Account']");
    By emailAsAUsernameLoginField = By.xpath("(//*[contains(text(), 'Login')]/ancestor-or-self::*/INPUT[@type='email' and @name='email'])[1]");
    By passwordLoginField = By.xpath("//input[@placeholder='Password']");
    By loginButton = By.xpath("//button[descendant::text()='Login']");
    By logOutButton = By.xpath("//a[descendant::text()=' Logout']");
    By wrongCredentialsValidationMessage = By.xpath("//p[following-sibling::*[descendant::text()='Login']]");
    By loginSectionTitle = By.xpath("//h2[descendant::text()='Login to your account']");

    public LoginPage() {
        driver = driverCreate();
    }

    //TODO done - Test Case 1: Register User
    public void signUpFunctionality() {
        WebElement signInUpBtn = driver.findElement(loginLogoutButton);
        signInUpBtn.click();

        WebElement username = driver.findElement((signUpUsernameField));
        username.click();
        username.sendKeys("testik");
        String usernameText = username.getText();

        WebElement email = driver.findElement(signUpPasswordField);
        email.click();
        email.sendKeys("testi142@test.com");
        String emailText = email.getText();
        WebElement signUp = driver.findElement(signUpBtn);
        signUp.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));

//        WebElement signUpFormTitle = driver.findElement(signUpPageTitle);
//        explisityWait(signUpFormTitle);
//        System.out.println(signUpFormTitle.getText());

        WebElement mrsChoosing = driver.findElement(chooseMrsSignUpForm);
        mrsChoosing.click();
        WebElement name = driver.findElement(nameSignUpForm);
        Assert.assertEquals(name.getText(), usernameText);
        WebElement emailForm = driver.findElement(emailSignUpForm);
        Assert.assertEquals(emailForm.getText(), emailText);

        WebElement password = driver.findElement(passwordSignUpForm);
        password.click();
        password.sendKeys("Aa123456.");

        WebElement daySignUpForm = driver.findElement(dayDropdownFieldSignUpForm);
        daySignUpForm.click();
        Select day = new Select(driver.findElement(dayDropdownFieldSignUpForm));
        day.selectByIndex(new Random().nextInt(day.getOptions().size()));

        WebElement monthSignUpForm = driver.findElement(monthDropdownFieldSignUpForm);
        monthSignUpForm.click();
        Select month = new Select(driver.findElement(monthDropdownFieldSignUpForm));
        month.selectByIndex(new Random().nextInt(month.getOptions().size()));

        WebElement yearSignUpForm = driver.findElement(yearDropdownFieldSignUpForm);
        yearSignUpForm.click();
        Select year = new Select(driver.findElement(yearDropdownFieldSignUpForm));
        year.selectByIndex(new Random().nextInt(year.getOptions().size()));

        WebElement firstName = driver.findElement(firstNameFieldSignUpForm);
        scrollPageDownTillTheElement(driver, firstName);
        waitElementLocatedBecomeClickable(driver, firstName);
        firstName.click();
        firstName.sendKeys("first name");

        WebElement lastname = driver.findElement(lastNameFieldSignUpForm);
        lastname.click();
        lastname.sendKeys("last name");

        WebElement company = driver.findElement(companyNameFieldSignUpForm);
        company.click();
        company.sendKeys("company");

        WebElement address1 = driver.findElement(address1FieldSignUpForm);
        address1.click();
        address1.sendKeys("address 1");

        WebElement address2 = driver.findElement(address2FieldSignUpForm);
        address2.click();
        address2.sendKeys("address2");

        WebElement countryField = driver.findElement(countryFieldSignUpForm);
        countryField.click();
        Select country = new Select(driver.findElement(countryFieldSignUpForm));
        country.selectByIndex(new Random().nextInt(country.getOptions().size()));

        WebElement city = driver.findElement(cityFieldSignUpForm);
        city.click();
        city.sendKeys("city");

        WebElement zipcode = driver.findElement(zipcodeNameFieldSignUpForm);
        zipcode.click();
        zipcode.sendKeys("zip code");

        WebElement mobileNumber = driver.findElement(mobileNumberFieldSignUpForm);
        mobileNumber.click();
        mobileNumber.sendKeys("+37412131415");

        WebElement createAccount = driver.findElement(createAccountFieldSignUpForm);
        createAccount.click();
    }

    //TODO Test Case 2: Login User with correct email and password
    public void loginWithCorrectCredentials() {
        WebElement signInUpBtn = driver.findElement(loginLogoutButton);
        signInUpBtn.click();

        WebElement login = driver.findElement((emailAsAUsernameLoginField));
        login.click();
        login.sendKeys("testik@test.com");

        WebElement password = driver.findElement(passwordLoginField);
        password.click();
        password.sendKeys("Aa123456.");

        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        WebElement logOutBtn = driver.findElement(logOutButton);
        if (logOutBtn.isDisplayed()) {
            System.out.println("The User logged in successfully");
        } else {
            System.out.println("Something was wrong");
        }
    }

    //TODO Test Case 3: Login User with incorrect email and password
    public void loginWithWrongCredentials() {
        WebElement signInUpBtn = driver.findElement(loginLogoutButton);
        signInUpBtn.click();

        WebElement login = driver.findElement((emailAsAUsernameLoginField));
        login.click();
        login.sendKeys("testik@test.com");

        WebElement password = driver.findElement(passwordLoginField);
        password.click();
        password.sendKeys("wrongPassword");

        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));

        WebElement validationMessage = driver.findElement(wrongCredentialsValidationMessage);
        if (validationMessage.isDisplayed()) {
            System.out.println("The User inputs wrong credentials");
        } else {
            System.out.println("The Username and password is correct");
        }
    }

    //TODO Test Case 4: Logout User
    public void logOutUserFunctionality() {
        WebElement signInUpBtn = driver.findElement(loginLogoutButton);
        signInUpBtn.click();

        WebElement login = driver.findElement((emailAsAUsernameLoginField));
        login.click();
        login.sendKeys("testik@test.com");

        WebElement password = driver.findElement(passwordLoginField);
        password.click();
        password.sendKeys("Aa123456.");

        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        WebElement logOutBtn = driver.findElement(logOutButton);
        logOutBtn.click();
        WebElement loginTitle = driver.findElement(loginSectionTitle);
        if (loginTitle.isDisplayed()) {
            System.out.println("The User logged out successfully");
        } else {
            System.out.println("Something went wrong");
        }

    }
}
    /*
Test Case 5: Register User with existing email
Test Case 6: Contact Us Form
Test Case 7: Verify Test Cases Page
Test Case 8: Verify All Products and product detail page
Test Case 9: Search Product
Test Case 10: Verify Subscription in home page
Test Case 11: Verify Subscription in Cart page
Test Case 12: Add Products in Cart
Test Case 13: Verify Product quantity in Cart
Test Case 14: Place Order: Register while Checkout
Test Case 15: Place Order: Register before Checkout
Test Case 16: Place Order: Login before Checkout
Test Case 17: Remove Products From Cart
Test Case 18: View Category Products
Test Case 19: View & Cart Brand Products
Test Case 20: Search Products and Verify Cart After Login
Test Case 21: Add review on product
Test Case 22: Add to cart from Recommended items
Test Case 23: Verify address details in checkout page
Test Case 24: Download Invoice after purchase order
Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
     */



