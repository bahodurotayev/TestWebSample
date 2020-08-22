package stepDef;

import baseDriver.BaseDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pom.NewPayeePom;
import utils.ThreadLocalBaseDriver;

public class TestNewPayee {

    NewPayeePom newPayeePom = new NewPayeePom();

    WebDriver driver;




    @When("^navigate to page login$")
    public void navigateToPageLogin() {

       driver = ThreadLocalBaseDriver.getDriver();
       driver.get("http://zero.webappsecurity.com/login.html");
       driver.manage().window().maximize();


    }

    @And("^enter username and password and sign in$")
    public void enterUsernameAndPasswordAndSignIn() {

        newPayeePom.findElementAndSendKeyFunction("usernameInput", "username");
        newPayeePom.findElementAndSendKeyFunction("passwordInput", "password");
        newPayeePom.findElementAndClickFunction("signButton");

    }

    @Then("^get successful message$")
    public void getSuccessfulMessage() {

    }
}
