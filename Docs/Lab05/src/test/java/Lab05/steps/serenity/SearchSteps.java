package Lab05.steps.serenity;

import Lab05.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

public class SearchSteps extends ScenarioSteps {

    SearchPage mainPage;

    @Step
    public void enters(String keyword) {
        mainPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        mainPage.lookup_terms();
    }

    @Step
    public void should_see_title(String title) {
        assertThat(mainPage.getTitle(), is(title));
    }
    @Step
    public void should_see_title1(String title) {
        assertThat(mainPage.getTitle(), not(title));
    }
    @Step
    public void is_the_home_page() {
        mainPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

}
