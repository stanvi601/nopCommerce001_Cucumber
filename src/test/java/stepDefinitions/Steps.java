package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.LoginPage;

public class Steps {

	WebDriver driver;
	public LoginPage lp;
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\TASAWANT\\eclipse-workspace\\nopCommerce001_Cucumber\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
	    lp=new LoginPage(driver);
		
	}

	@When("user open URL {string}")
	public void user_open_url(String url) {
	    driver.get(url);
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	    lp.setUsername(email);
	    lp.setPassword(password);
	}

	@When("Clicks on login")
	public void clicks_on_login() {
	    lp.clickSubmit();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
	    driver.getTitle();
	    
	    if(driver.getPageSource().contains("Login was unsuccessful."))
	    {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }
	    else
	    {
	    	Assert.assertEquals(title,driver.getTitle());
	    }
	}

	@When("User clicks on log out link")
	public void user_clicks_on_log_out_link() throws InterruptedException {
	    lp.clickLogout();
	    Thread.sleep(2000);
	}

	@Then("Close browser")
	public void close_browser() {
	    
	}
	
}
