package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase
{
    public By uname = By.id("txtUsername");
    public By pswd = By.id("txtPassword");
    public By login = By.id("btnLogin");
    public By welcome = By.xpath("//a[@id='welcome']");

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void login(String username,String passwd)
    {
        enter(uname,username);
        enter(pswd,passwd);
        click_On(login);
    }
    public String getWelcome()
    {
        String welcomeTxt = getElementText(welcome);
        return welcomeTxt;
    }

}
