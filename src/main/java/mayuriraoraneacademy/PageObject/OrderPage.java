package mayuriraoraneacademy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mayuriraoraneacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> ProductNames;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;

	
	public Boolean verifyOrderDisplay(String ProductName) {
		Boolean match = ProductNames.stream().anyMatch(cartProduct ->
		cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	public checkOutPage goTocheckOut() {
		
		checkoutele.click();
		return new checkOutPage(driver);
	
		
	}
}
