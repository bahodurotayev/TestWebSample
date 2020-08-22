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

    @FindBy (css="input[class='btn-primary']")
    private WebElement signButton;

    public void findElementAndSendKeyFunction(String ElementName, String text) {

        switch (ElementName) {
            case "user_login":
                myElement = usernameInput;
                break;
            case "user_password":
                myElement = passwordInput;
                break;

        }
        waitAndSendKeys(myElement, text);
    }

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {
            case "signButton":
                myElement = signButton;
                break;
        }
        waitAndClick(myElement);
    }




}
