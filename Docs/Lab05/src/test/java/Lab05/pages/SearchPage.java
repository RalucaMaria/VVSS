package Lab05.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://www.dictio.ro/dictionar-roman-german")
public class SearchPage extends PageObject {

    @FindBy(id="sursa")
    private WebElementFacade searchTerms;

    @FindBy(id="btn_search")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public String getTitle() {
        WebElement articleTitle = find(By.id("cuvant_tradus"));
        String title= articleTitle.getText();

        return title;
    }
}
