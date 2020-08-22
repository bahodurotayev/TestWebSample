package stepDef;

import baseDriver.BaseDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

    @Then("^logged successfully$")
    public void loggedsuccessfully() {

        String url ="http://zero.webappsecurity.com/bank/account-summary.html";
        Assert.assertEquals(driver.getCurrentUrl(), url );
    }

    @When("^click Payee Bills add new Payee$")
    public void clickPayeeBillsAddNewPayee() {

        newPayeePom.findElementAndClickFunction("payBillsTab");
        newPayeePom.findElementAndClickFunction("addNewPayee");

    }

    @And("^add Payee \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void addPayeeAnd(String name, String address, String account, String details) {

        newPayeePom.findElementAndSendKeyFunction("newPayeeNameInput", name);
        newPayeePom.findElementAndSendKeyFunction("newPayeeAddressInput", address);
        newPayeePom.findElementAndSendKeyFunction("newPayeeAccountInput", account);
        newPayeePom.findElementAndSendKeyFunction("newPayeeDetailsInput", details);

    }

    @And("^click Add Button$")
    public void clickAddButton() {

    newPayeePom.findElementAndClickFunction("addNewPayeeButton");

    }
/*
    @Then("^successful message should display$")
    public void successfulMessageShouldDisplay() {

        newPayeePom.findElementAndVerifyElementContainText("successfullyMessage", "successfully" );
    }*/




    @Then("^if the test \"([^\"]*)\"$")
    public void ifTheTest(String result) {

        if(result.equals("success")){

            newPayeePom.findElementAndVerifyElementContainText("successfullyMessage", "successfully" );


        }else{
            Assert.assertTrue( newPayeePom.findElement("addNewPayeeButton"));

        }



    }
}
