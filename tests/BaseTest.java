package tests;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import page.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

   public static WebDriver driver;
   public BookingPage bookingPage;
   public CreateAccountPage createAccountPage;
   public FlightTrip flightTrip;
   public LoginPage loginPage;
   public CheckInPage checkInPage;
   public FlightStatusPage flightStatusPage;
   public ManageBookingPage manageBookingPage;

   @Parameters("browser")
   @BeforeMethod
   public void setUp(String browser){
       if(browser.equalsIgnoreCase("chrome")) {
           ChromeOptions options = new ChromeOptions();
          options.addArguments("--disable-notification");
           driver = new ChromeDriver();
      }else if (browser.equalsIgnoreCase("firefox")){
           FirefoxOptions options = new FirefoxOptions();
           options.addArguments("--disable-notification");
           driver = new FirefoxDriver(options);
       }
       driver.get("https://www.spicejet.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       bookingPage = new BookingPage(driver);
       createAccountPage = new CreateAccountPage(driver);
       flightTrip = new FlightTrip(driver);
       loginPage = new LoginPage(driver);
       checkInPage = new CheckInPage(driver);
       flightStatusPage = new FlightStatusPage(driver);
       manageBookingPage = new ManageBookingPage(driver);
   }

   @AfterMethod
    public void tearDown(){
       driver.quit();
   }

   public static String takeScreenshots(String testCaseName){
       TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
       File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

       File destinationFile = new File("Screenshots/"+ testCaseName + ".png");
       try {
           FileUtils.copyFile(srcFile,destinationFile);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       String path = "<img src = " + destinationFile.getAbsolutePath() + "width = 200px height = 200px/>";
       Reporter.log(path);
       return destinationFile.getAbsolutePath();
   }

    public static class CheckInPageTest extends BaseTest {

        @Test
        public void testCheckInPage(){
            checkInPage.setCheckInButton();
            checkInPage.setPnrNum("975656368");
            checkInPage.setEmailId("raghavi1234@gmail.com");
            checkInPage.setSearchButton();
            String str = driver.findElement(By.xpath("//div[@class='css-76zvg2 css-cens5h r-jwli3a']")).getText();
            System.out.println(str);
            Assert.assertEquals(str,"Unable to fetch your booking. Please check the inputs \n" +
                    " you have provided and try again.");
        }
    }
}
