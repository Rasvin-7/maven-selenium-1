package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utils.WebEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBases
{
    public static WebDriver driver;
    public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
    public static Properties prop;
    public static WebEventListener web_event;
    private static EventFiringWebDriver fire;

    public TestBases()
    {

        try {
            prop = new Properties();
            FileInputStream fin = new FileInputStream(new File("C:\\Users\\developer\\IdeaProjects\\TestSelenium\\src\\main\\java\\configs\\config.properties"));
            prop.load(fin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void init_driver()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\developer\\Desktop\\CMT\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/");
        String url = prop.getProperty("url");


        tDriver.set(driver);
//        driver.get(url);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver = getDriver();
        web_event = new WebEventListener();
        fire = new EventFiringWebDriver(driver);
        fire.register(web_event);
        driver = fire;

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
//    Synchronized driver
    public static synchronized WebDriver getDriver()
    {
        return tDriver.get();
    }

}
