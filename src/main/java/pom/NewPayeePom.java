package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPayeePom extends ParentClass{
    public NewPayeePom() {
        PageFactory.initElements(driver, this);
    }

    WebElement myElement;

    @FindBy (id="user_login")
    private WebElement usernameInput;

    @FindBy (id="user_password")
    private WebElement passwordInput;

    @FindBy (css="input[class='btn btn-primary']")
    private WebElement signButton;

    @FindBy (id="pay_bills_tab")
    private WebElement payBillsTab;

    @FindBy (linkText="Add New Payee")
    private WebElement addNewPayee;

    @FindBy (id="np_new_payee_name")
    private WebElement newPayeeNameInput;

    @FindBy (id="np_new_payee_address")
    private WebElement newPayeeAddressInput;

    @FindBy (id="np_new_payee_account")
    private WebElement newPayeeAccountInput;

    @FindBy (id="np_new_payee_details")
    private WebElement newPayeeDetailsInput;

    @FindBy (id="add_new_payee")
    private WebElement addNewPayeeButton;

    @FindBy (id="alert_content")
    private WebElement successfullyMessage;


    public void findElementAndSendKeyFunction(String ElementName, String text) {

        switch (ElementName) {
            case "usernameInput":
                myElement = usernameInput;
                break;
            case "passwordInput":
                myElement = passwordInput;
                break;
            case "newPayeeNameInput":
                myElement = newPayeeNameInput;
                break;
            case "newPayeeAddressInput":
                myElement = newPayeeAddressInput;
                break;

            case "newPayeeAccountInput":
                myElement = newPayeeAccountInput;
                break;

            case "newPayeeDetailsInput":
                myElement = newPayeeDetailsInput;
                break;


        }
        waitAndSendKeys(myElement, text);
    }

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {
            case "signButton":
                myElement = signButton;
                break;

            case "payBillsTab":
                myElement = payBillsTab;
                break;

            case "addNewPayee":
                myElement = addNewPayee;
                break;
            case "addNewPayeeButton":
                myElement= addNewPayeeButton;
                break;
        }
        waitAndClick(myElement);
    }

    public void findElementAndVerifyElementContainText(String elementName , String WhichText){

        switch (elementName){
            case "successfullyMessage":
                myElement=successfullyMessage;
                break;
            case "addNewPayeeButton":
                myElement=addNewPayeeButton;
                break;

           /* case "ErrorMessage":
                myElement=ErrorMessage;
                break;*/

        }
        ElementContainsText(myElement , WhichText);

    }

    public boolean findElement(String elementName) {

        try {

            switch (elementName) {
                case "addNewPayeeButton":
                    myElement = addNewPayeeButton;
                    break;

            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
