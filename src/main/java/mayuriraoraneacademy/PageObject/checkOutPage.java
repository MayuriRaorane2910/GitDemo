package mayuriraoraneacademy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mayuriraoraneacademy.AbstractComponents.AbstractComponent;

public class checkOutPage extends AbstractComponent {
	
	WebDriver driver;
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
		}

	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')] [2])")
	WebElement selectcountry;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {

		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();

		waitForElementToAppear(By.cssSelector(".ta-results"));

		selectcountry.click();

		
	}
	
	public confirmatonPage submitOrder() {
		
		submit.click();
		confirmatonPage confirmationpage = new confirmatonPage(driver);
		return confirmationpage;
	}
}
