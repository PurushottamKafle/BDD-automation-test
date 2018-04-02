package Cucumberproject.stepsfile;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Login {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\cucumber\\Cucumberproject\\src\\test\\java\\resources\\chromedriver.exe");
	    this.driver=new ChromeDriver();
	    this.driver.manage().window().maximize();
	    this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	
	/*use this if you wish to use firefox browser for testing
	/*@Before 
	public void setup_firefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\cucumber\\Cucumberproject\\src\\test\\java\\resources\\geckodriver.exe");
	    DesiredCapabilities d=new DesiredCapabilities();
	    d.setCapability("marionette", true);
		this.driver=new FirefoxDriver(d);
	    this.driver.manage().window().maximize();
	    this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}*/
	
	@After
	public void tearDown() throws InterruptedException {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver=null;
	}
	
	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
	    driver.get("https://stackoverflow.com/");
	}

	@And("^User clicks on the login button on the webpage$")
	public void user_clicks_on_the_login_button_on_the_webpage() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()=\"Log In\"]")).click();   
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(" "); //add stackoverflow email in sendkeys
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(" "); //add stackoverflow password in sendkeys
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='submit-button']")).click();
	}

	@Then("^User must be redirected to successful login page$")
	public void user_must_be_redirected_to_successful_login_page() throws Throwable {
		Thread.sleep(1000);
		WebElement elem=driver.findElement(By.xpath("//a[contains(text(),\"Ask Question\")]"));
		Assert.assertEquals(true,elem.isDisplayed());
	}

}
