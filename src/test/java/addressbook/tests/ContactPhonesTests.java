package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesTests extends TestBase {

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
//        String result = "";
//        if (contact.getHomePhone() != null) {
//            result = result + contact.getHomePhone(); // плюс разделитель строки
//            // ...
//        }
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter(s -> ! s.equals(""))
                .map(ContactPhonesTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phones) {
        return phones.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
