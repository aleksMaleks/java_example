package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm
                (new ContactData("FirstName", "MiddleName", "LastName", "test1"), true);
        app.getContactHelper().submitContactCreation();
//        returnHomePage();
    }

}
