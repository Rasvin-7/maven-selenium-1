package testcases;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
//import pages.LoginPage;
import org.testng.log4testng.Logger;
import pages.LoginPage;
import utils.AllureListener;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

@Listeners(AllureListener.class)
public class TestLogin extends TestBases

{
//    public WebDriver driver;
    public static Logger log = Logger.getLogger(TestLogin.class);
    public TestLogin()
    {
        super();
    }
    //public static WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        log.info("Initializing driver");
        init_driver();
//        driver.get(prop.getProperty("url"));
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

    }

    @DataProvider
    public Object[][] getData(){
        log.info("Data provider");
        TestUtils tu = new TestUtils();
        return tu.getSheetData("Login");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Login Test")
    @Test(priority = 1,dataProvider = "getData" )
    public void testLoginPage(String user,String pass)
    {
        LoginPage lp = new LoginPage(driver);
        lp.login(user, pass);
        String title = driver.getTitle();
        Assert.assertEquals("OrangeHRM",title,"Not Equal");


    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Check Dashboard Presence After Login")
    @Test(priority = 2)
    public void checkDashboard()
    {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin","admin123");
        String welcome = lp.getWelcome();
        Assert.assertTrue(welcome.contains("welcome") || welcome.contains("Welcome"));

    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }

}
