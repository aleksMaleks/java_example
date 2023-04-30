package addressbook.tests;


import org.testng.annotations.Test;


public class ContactDeletionTests extends TestBase {
//    private WebDriver driver;

    @Test
    public void testContactDeletion() throws Exception {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
//        driver.get("http://localhost/addressbook/");
    }


}
