package addressbook.tests;


import org.testng.annotations.Test;


public class ContactDeletionTests extends TestBase {
//    private WebDriver driver;

    @Test
    public void test2() throws Exception {
        app.selectContact();
        app.deleteSelectedContact();
//        driver.get("http://localhost/addressbook/");
    }


}
