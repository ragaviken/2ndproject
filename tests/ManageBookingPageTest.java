package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageBookingPageTest extends BaseTest {

    @Test
    public void testManageBooking() throws InterruptedException {
        manageBookingPage.setManageBooking();
        manageBookingPage.setPNRNum("77656558");
        manageBookingPage.setEmailId("raghavi1234@gmail.com");
        manageBookingPage.setSearchButton();
        Thread.sleep(3000);
        String str = driver.findElement(By.xpath("//div[@class='css-76zvg2 css-cens5h r-jwli3a']")).getText();
        System.out.println(str);
        Assert.assertEquals(str, "Unable to fetch your booking. Please check the inputs \n" +
                " you have provided and try again.");
    }
}