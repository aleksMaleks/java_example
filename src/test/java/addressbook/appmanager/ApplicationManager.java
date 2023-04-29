package addressbook.appmanager;

import addressbook.model.ContactData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class ApplicationManager extends GroupHelper {
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        login("admin", "secret");
    }

    public void login(String userName, String password) {
        driver.get("http://localhost/addressbook/index.php");
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(userName);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void fillContactForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(contactData.getMiddleName());
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
    }

    public void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
//        driver.get("http://localhost/addressbook/group.php");
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public void submitContactCreation() {
        driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void gotoHomePage() {
//        driver.findElement(By.linkText("home page")).click();
        driver.findElement(By.linkText("home")).click();
    }


    public void selectContact() {
//        driver.findElement(By.id("1")).click();
        driver.findElement(By.name("selected[]")).click();

    }


    public void deleteSelectedContact() {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        driver.get("http://localhost/addressbook/delete.php?part=1;");
    }
    private String closeAlertAndGetItsText() {
        boolean acceptNextAlert = true;
        try {
            Alert alert = driver.switchTo().alert();
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
