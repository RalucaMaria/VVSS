package Lab05.steps.serenity;

import Lab05.pages.AddStudentPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class AddSteps extends ScenarioSteps {
    AddStudentPage addStudentPage;

    @Step
    public void add(String nume, String prenume, Integer varsta) {
        addStudentPage.enter_nume(nume);
        addStudentPage.enter_prenume(prenume);
        addStudentPage.enter_varsta(varsta);
    }

    @Step
    public void pressAddS() {
        addStudentPage.pressAdd();
    }

    @Step
    public void is_the_home_page() {
        addStudentPage.open();
    }

    @Step
    public void pressAddStudent(String nume, String prenume, Integer varsta) {
        add(nume, prenume, varsta);
        pressAddS();
    }

    @Step
    public void check_if_added_in_success() {
        MatcherAssert.assertThat(addStudentPage.checkIfAdded(), is(true));
    }
    @Step
    public void check_if_added_in_error() {
        MatcherAssert.assertThat(addStudentPage.checkIfNotAdded(), is(true));
    }
}
