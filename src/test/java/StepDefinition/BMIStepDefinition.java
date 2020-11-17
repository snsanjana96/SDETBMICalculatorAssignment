package StepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BMIStepDefinition {
	public static WebDriver driver; 
	@Given("^I open the Calculator\\.Net URL$")
	public void i_open_the_Calculator_Net_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SanjanaNayak\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
    	driver.get("https://www.calculator.net/");
    	String LoginTitle = driver.getTitle();
        System.out.println("Login Page Title: " +LoginTitle);
        String ExpectedTitle = "Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science";
        assertEquals(ExpectedTitle,LoginTitle);
	}

	@Given("^Click on BMI Calculator Link$")
	public void click_on_BMI_Calculator_Link() throws Throwable {
		WebElement BMICalc= driver.findElement(By.linkText("BMI Calculator"));
        BMICalc.sendKeys(Keys.ENTER);
        WebElement BMICalc1= driver.findElement(By.linkText("Metric Units"));
        BMICalc1.sendKeys(Keys.ENTER);
        String BMITitle = driver.getTitle();
		String ExpectedBMITitle ="BMI Calculator";
		System.out.println("BMI Page Title: " +BMITitle);
		assertEquals(ExpectedBMITitle,BMITitle);
	}
	

	@When("^I Enter Age \"([^\"]*)\", Height \"([^\"]*)\", Weight \"([^\"]*)\"$")
	public void i_Enter_Age_Height_Weight(String arg1, String arg2, String arg3) throws Throwable {
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys(arg1);
		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys(arg2);
		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys(arg3);
		System.out.println("Entering the Age, Height and Weight");
	}

	@When("^Click on Calculate button$")
	public void click_on_Calculate_button() throws Throwable {
		   driver.findElement(By.xpath("//input[@type='image']")).click();
		   System.out.println("And Clicked on Submit button");
	}

	@Then("^I validate the BMI Result$")
	public void i_validate_the_BMI_Result() throws Throwable {
		  WebElement BMIResult = driver.findElement(By.xpath("//b[contains(text(),'BMI = ')]"));
		    System.out.println("The BMI Result is: " +BMIResult.getText());
	}

	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
	    driver.quit();
	    throw new PendingException();
	}



}
