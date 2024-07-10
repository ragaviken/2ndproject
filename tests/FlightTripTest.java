package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTripTest extends BaseTest {

    @Test
    public void toFlightTrip() throws InterruptedException {
        flightTrip.setOneTrip();
        flightTrip.setDeparture();
        flightTrip.setSelectDelhi();
        flightTrip.setDestination();
        flightTrip.setSelectMumbai();
        Thread.sleep(3000);
        flightTrip.setDepartureDate();
        flightTrip.setReturnDate();
        flightTrip.setReturnDay();
        flightTrip.setPassengers();
        flightTrip.setPassengers1();
        flightTrip.setSearchFlight();
        Thread.sleep(7000);
        flightTrip.setContinueButton();
        Thread.sleep(9000);
        bookingPage.setFirstName("raghavi");
        bookingPage.setLastName("avi");
        bookingPage.setMobileNumber("9756328846");
        bookingPage.setEmailId("raghavi1234@gmail.com");
        //bookingPage.setCountryMenu();
        bookingPage.setTownCity("thiruvannamalai");
        //Adding passenger details
        bookingPage.setF_Name("rag");
        bookingPage.setL_Name("ken");
        bookingPage.setM_Number("9525288469");
        //bookingPage.setClickNext();
        bookingPage.setContinue();
        Thread.sleep(3000);
        Thread.sleep(6000);
        //WebDriverWait wait = new  WebDriverWait (driver, Duration.ofSeconds(40));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img"))).click();
        String str = driver.getCurrentUrl();
        Assert.assertEquals(str,"https://www.spicejet.com/booking/addons");

    }

    @Test
    public void toFlightTrip1() throws InterruptedException {
        flightTrip.setRoundTrip();
        flightTrip.setDeparture();
        flightTrip.setSelectDelhi();
        flightTrip.setDestination();
        flightTrip.setSelectMumbai();
        Thread.sleep(3000);
        flightTrip.setDepartureDate();
        flightTrip.setReturnDate();
        flightTrip.setReturnDay();
        flightTrip.setPassengers();
        flightTrip.setPassengers1();
        flightTrip.setSearchFlight();
        Thread.sleep(7000);
        flightTrip.setContinueButton();
        Thread.sleep(9000);
        bookingPage.setFirstName("raghavi");
        bookingPage.setLastName("avi");
        bookingPage.setMobileNumber("9944765856");
        bookingPage.setEmailId("raghavi1234@gmail.com");
        //bookingPage.setCountryMenu();
        bookingPage.setTownCity("thiruvannamalai");
        //Adding passenger details
        bookingPage.setF_Name("raghavi");
        bookingPage.setL_Name("avi");
        bookingPage.setM_Number("9922884957");
        //bookingPage.setClickNext();
        bookingPage.setContinue();
        Thread.sleep(6000);
        //WebDriverWait wait = new  WebDriverWait (driver, Duration.ofSeconds(40));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("img"))).click();
        String str = driver.getCurrentUrl();
        Assert.assertEquals(str,"https://www.spicejet.com/booking/addons");


    }
    @Test
    public void validatingOneWayAndRoundWay(){
        String expectedValue = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
        String actualValue = driver.getTitle();
        Assert.assertEquals(actualValue,expectedValue);
    }
}
