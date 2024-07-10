package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {
        loginPage.setLoginButton();
        Thread.sleep(3000);
        loginPage.setEmailRadioButton();
        loginPage.setEmail("raghavi1234@gmail.com");
        loginPage.setPassword("rag@0707");
        loginPage.setSubmitButton();
        String expectedValue= "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
        String actualValue = driver.getTitle();
        Assert.assertEquals(expectedValue,actualValue);

    }
}
