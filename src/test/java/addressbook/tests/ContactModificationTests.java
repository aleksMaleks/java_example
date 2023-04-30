package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm
                (new ContactData("FirstNameM", "MiddleNameM", "LastNameM", null), false);
        app.getContactHelper().submitCroupModification();
//        returnHomePage();
    }
}
