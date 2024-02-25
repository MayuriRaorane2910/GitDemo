package mayuriraoraneacademy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mayuriraoraneacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// Initialization
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// PageFactory

	// WebElement UserEmail = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement UserEmail;

	@FindBy(id = "userPassword")
	WebElement PasswordEle;

	@FindBy(id = "login")
	WebElement Submit;

	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	
	public ProductCataloug LoginApplication(String email, String password) {
		// TODO Auto-generated method stub
		UserEmail.sendKeys(email);
		PasswordEle.sendKeys(password);
		Submit.click();
		ProductCataloug productcataloug = new ProductCataloug(driver);
		return productcataloug;
	}
	
	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
		
	}
		public void goTo() {
		// TODO Auto-generated method stub
		driver.get("https://rahulshettyacademy.com/client");	
	}
}
