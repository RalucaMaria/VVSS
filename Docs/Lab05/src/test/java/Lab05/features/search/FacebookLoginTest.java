package Lab05.features.search;

import Lab05.steps.serenity.FacebookLoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class FacebookLoginTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.facebook.com/login")
    public Pages pages;

    @Steps
    public FacebookLoginSteps endUser;

    @Test
    public void successfully_log_in() {
        endUser.is_the_home_page();
        endUser.logs_in("raluca.maria29@yahoo.com", "xXQTMfgGSA5JfDj");
        endUser.check_if_logged_in_success();
    }

    @Test
    public void failed_log_in() {
        endUser.is_the_home_page();
        endUser.logs_in("blabla@yahoo.com", "blabla");
        endUser.check_if_logged_in_fail();
    }
}
