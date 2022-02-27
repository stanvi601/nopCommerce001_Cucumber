package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)   //constructor
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);	
	}
	
	@FindBy(name="Email")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="Password")
	WebElement txtPassword;

	@FindBy(xpath="//button[@value='Log in']")
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	WebElement lnkLogout;
	
	public void setUsername(String uname)
	{
		txtUserName.clear();
		txtUserName.sendKeys(uname);	
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);	
	}
	
	public void clickSubmit()
	{
		btnLogin.click();	
	}

	public void clickLogout()
	{
		lnkLogout.click();	
	}
}
