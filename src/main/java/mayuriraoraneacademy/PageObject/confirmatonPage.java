package mayuriraoraneacademy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import mayuriraoraneacademy.AbstractComponents.AbstractComponent;

public class confirmatonPage extends AbstractComponent {

	WebDriver driver;

	public confirmatonPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement ConfirmationMessage;

	public String getconfirmationMessage() {
		// String ConfirmMessage =
		// driver.findElement(By.cssSelector("hero-primary")).getText();

//		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		return ConfirmationMessage.getText();

	}

}
