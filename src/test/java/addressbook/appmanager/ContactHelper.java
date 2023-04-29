package addressbook.appmanager;

import addressbook.model.ContactData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
    }

//    private void type(By locator, String text) {
//        click(locator);
//        wd.findElement(locator).clear();
//        wd.findElement(locator).sendKeys(text);
//    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

//    private void click(By locator) {
//        wd.findElement(locator).click();
//    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void selectContact() {
//        driver.findElement(By.id("1")).click();
        click(By.name("selected[]"));

    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        wd.get("http://localhost/addressbook/delete.php?part=1;");
    }

    private String closeAlertAndGetItsText() {
        boolean acceptNextAlert = true;
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
