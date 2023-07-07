package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

import java.awt.*;

public class LoginPageTests {
    LoginPage loginPage;

    public LoginPageTests() {
        loginPage = new LoginPage();
    }

    @Test
    public void signUpFunctionality() throws AWTException {
        loginPage.signUpFunctionality();
    }

    @Test
    public void loginWithRightData() {
        loginPage.loginWithCorrectCredentials();
    }

    @Test
    public void loginWithWrongData(){
        loginPage.loginWithWrongCredentials();
    }

    @Test
    public void logOutUser(){
        loginPage.logOutUserFunctionality();
    }

}
