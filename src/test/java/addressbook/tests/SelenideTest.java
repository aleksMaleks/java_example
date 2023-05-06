package addressbook.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @Test(enabled = false)
    public void testSelenideExample() {
        open("http://localhost/addressbook/index.php");
        $(By.name("user")).setValue("admin");
        $(By.name("pass")).setValue("secret");
        $(By.xpath("//input[@type='submit']")).pressEnter();
        $(By.name("searchstring")).setValue("444").pressEnter();
        ElementsCollection resultElements = $$(By.xpath(
                "//tr[@name='entry' and not(contains(@style,'display: none'))]"))
                .shouldHave(size(2));
//        MatcherAssert.assertThat(resultElements.size(), equalTo(1));
        for (SelenideElement red : resultElements) {
            red.$(By.xpath("./td[2]")).shouldHave(text("444"));
        }
    }
}
