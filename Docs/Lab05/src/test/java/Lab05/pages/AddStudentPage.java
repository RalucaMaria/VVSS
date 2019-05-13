package Lab05.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://localhost/VVSS/addStudent.php")
public class AddStudentPage extends PageObject {

    @FindBy(id="nume")
    private WebElementFacade nume;

    @FindBy(id="prenume")
    private WebElementFacade prenume;

    @FindBy(id="varsta")
    private WebElementFacade varsta;
    @FindBy(name="submit")
    private WebElementFacade submit;




    public void enter_nume(String nume) {
        this.nume.type(nume);
    }

    public void enter_prenume(String prenume) {
        this.prenume.type(prenume);
    }

    public void enter_varsta(Integer varsta) {
        this.varsta.type(String.valueOf(varsta));
    }

    public void pressAdd() {
        submit.click();
    }
    public boolean checkIfAdded() {
        return getDriver().getCurrentUrl().equals("http://localhost/VVSS/succes.php");
    }
    public boolean checkIfNotAdded() {
        return getDriver().getCurrentUrl().equals("http://localhost/VVSS/eroare.php");
    }
}
