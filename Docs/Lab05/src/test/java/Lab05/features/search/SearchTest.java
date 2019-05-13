package Lab05.features.search;


import Lab05.steps.serenity.SearchSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.dictio.ro/dictionar-roman-german")
    public Pages pages;

    @Steps
    public SearchSteps endUser;

    @Test
    public void search_T() {
        endUser.is_the_home_page();
        endUser.looks_for("mare");
        endUser.should_see_title("Cuvantul tradus:\n" +
                "große");
    }
    @Test
    public void search_F() {
        endUser.is_the_home_page();
        endUser.looks_for("asdfghj");
        endUser.should_see_title("Cuvantul tradus:"); // which is seen when no result is found for the given search
    }

}
