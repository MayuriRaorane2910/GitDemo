package mayuriraoraneacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mayuriraoraneacademy.PageObject.OrderPage;
import mayuriraoraneacademy.PageObject.cartPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement order;
	
	public void waitForElementToAppear(By findBy) {
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	public void waitForWebElementToAppear(WebElement findBy) {
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	
	public cartPage goToCartPage() {
		
		cartHeader.click();
		cartPage cartpage= new cartPage(driver);
		return cartpage;
		
	}
	

	public OrderPage goToOrderPage() {
		
		order.click();
		OrderPage orderpage= new OrderPage(driver);
		return orderpage;
		
	}
	

	
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	
	
}
