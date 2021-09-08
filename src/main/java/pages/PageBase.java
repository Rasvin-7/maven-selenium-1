package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase
{
    public static WebDriver driver;

    public PageBase(WebDriver driver)
    {
        PageBase.driver = driver;

    }


    public void enter(By locator, String text)
    {
        driver.findElement(locator).sendKeys(text);

    }

    public void click_On(By locator)
    {
        driver.findElement(locator).click();
    }

    public String getElementText(By locator)
    {
        return driver.findElement(locator).getText();

    }



}
