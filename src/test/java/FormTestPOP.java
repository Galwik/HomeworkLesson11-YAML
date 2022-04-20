import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;

public class FormTestPOP extends TestBase {

    @Test
    void fillForm() {

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(System.getProperty("firstName"))
                .setLastName(System.getProperty("lastName"))
                .setEmail(System.getProperty("email"))
                .setRandomGender()
                .setAge(System.getProperty("age"))
                .setRandomYearsOfExperience()
                .setProfessionToAutomationTester()
                .setRandomContinent()
                .setSwitchAndWaitSeleniumCommand(driver)
                .uploadFile(System.getProperty("filepath"))
                .signIn();

        assertThat("Incorrect text", driver.findElement(By.cssSelector("#validator-message"))
                .getText().equals(System.getProperty("formMessage")));
    }
}