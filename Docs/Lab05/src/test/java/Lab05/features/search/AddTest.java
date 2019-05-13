package Lab05.features.search;

import Lab05.steps.serenity.AddSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertTrue;

@RunWith(SerenityRunner.class)
public class AddTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

   // @ManagedPages(defaultUrl = "http://localhost/VVSS/addStudent.php")

    public Pages pages;

    @Steps
    public AddSteps endUser;

    @Test
    public void addSucces() {
        endUser.is_the_home_page();
        endUser.pressAddStudent("Cristian","Matei",19);
        endUser.check_if_added_in_success();

    }

    @Test
    public void addFailed() {
        endUser.is_the_home_page();
        endUser.pressAddStudent("Timotei","Maria",10);
        endUser.check_if_added_in_error();
    }
}
