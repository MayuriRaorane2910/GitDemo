package mayuriraoraneacademy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mayuriraoraneacademy.AbstractComponents.AbstractComponent;

public class cartPage extends AbstractComponent{
	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;

	
	public Boolean verifyProductDisplay(String ProductName) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct ->
		cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}

	public checkOutPage goTocheckOut() {
		
		checkoutele.click();
		return new checkOutPage(driver);
	
		
	}
}
