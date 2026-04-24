package ch8_6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlretsTest {
	protected WebDriver driver;
	private WebElement jsBtnE;
	private WebElement jsConfirmBtnE;
	private WebElement jsPromptBtnE;
	
	private static String baseUrl = "https://the-internet.herokuapp.com/javascript_alerts";
	
	private By jsBtn = By.xpath(".//button[contains(text(),'Alert')]");
	private By jsConfirmBtn = By.xpath(".//button[contains(text(),'Confirm')]");
	private By jsPromptBtn = By.xpath(".//button[contains(text(),'Prompt')]");
	private By result = By.xpath("//p[@id=\"result\"]");
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		System.out.println("The browser has been opened");
	}
	
	@Test (priority = 1)
	public void testJsPrompt() {
		jsPromptBtnE = driver.findElement(jsPromptBtn);
		System.out.println("JS Prompt Button found!");
		
		jsPromptBtnE.click();
		
		Alert alert = driver.switchTo().alert();
	
		String myName = "Abdullah A. Muhaisen";
		alert.sendKeys(myName);
		
		String alertText = alert.getText();
		System.out.println("Alert text: " + alertText);
		
		
		alert.accept();
		System.out.println("Switch and sendKeys succesfully!");
		
		
		WebElement resultE = driver.findElement(result);
		Assert.assertTrue(resultE.getText().contains(myName),"Result test is wrong!");
		System.out.println("Entered string: (" + myName + ") found in result: (" + resultE.getText() + ")");
	}
	
	@Test (priority = 2)
	public void testJsAlert() {
		jsBtnE = driver.findElement(jsBtn);
		System.out.println("JS Alert Button found!");
		
		jsBtnE.click();
		
		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		System.out.println("Alert text: " + alertText);
		
		alert.accept();
		System.out.println("JS Alert Accepted!");
		
		WebElement resultE = driver.findElement(result);
		Assert.assertTrue(resultE.getText().contains("clicked"),"Result test is wrong!");
	}
	
	@Test (priority = 3)
	public void testJsConfirm() {
		jsConfirmBtnE = driver.findElement(jsConfirmBtn);
		System.out.println("JS Confirm Button found!");
		
		jsConfirmBtnE.click();
		
		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		System.out.println("Alert text: " + alertText);
		
		alert.dismiss();
		System.out.println("JS Confirm Cancelled!");
		
		WebElement resultE = driver.findElement(result);
		Assert.assertTrue(resultE.getText().contains("Cancel"),"Result test is wrong!");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("The browser has been closed!");
		if(driver!=null) {
			driver.quit();
		}
	}
}
