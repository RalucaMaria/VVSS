package Lab05.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.facebook.com/login")
public class FacebookLoginPage extends PageObject {

    @FindBy(id = "pass")
    private WebElementFacade password;

    @FindBy(id = "email")
    private WebElementFacade email;

    @FindBy(id = "loginbutton")
    private WebElementFacade loginButton;


    public FacebookLoginPage() {
    }

    public void enter_email(String email) {
        this.email.type(email);
    }

    public void enter_password(String password) {
        this.password.type(password);
    }

    public void click_login() {
        loginButton.click();
    }

    public boolean checkIfLogged() {
        return getDriver().getCurrentUrl().equals("https://www.facebook.com/?sk=welcome");
    }
}