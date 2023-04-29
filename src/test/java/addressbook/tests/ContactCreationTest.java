package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
//        gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("FirstName", "MiddleName", "LastName"));
        app.getContactHelper().submitContactCreation();
//        gotoHomePage();
    }

}
