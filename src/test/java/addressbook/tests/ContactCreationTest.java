package addressbook.tests;


import addressbook.model.ContactData;
import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() throws Exception {
//        gotoHomePage();
        app.initContactCreation();
        app.fillContactForm(new ContactData("FirstName", "MiddleName", "LastName"));
        app.submitContactCreation();
//        gotoHomePage();
    }

}
