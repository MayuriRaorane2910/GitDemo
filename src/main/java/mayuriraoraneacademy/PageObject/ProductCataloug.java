package mayuriraoraneacademy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mayuriraoraneacademy.AbstractComponents.AbstractComponent;

public class ProductCataloug extends AbstractComponent {

	WebDriver driver;

	public ProductCataloug(WebDriver driver) {
		// Initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// List<WebElement> products = driver.findElements(By.cssSelector(".card"));
	// PageFactory

	@FindBy(css = ".card")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	@FindBy(css="[routerlink*='cart']")
	WebElement cart;

	By productBy = By.cssSelector(".card");
	By addToCart = By.cssSelector(".card-body button:last-of-type ");
	By toastMessage = By.cssSelector("#toast-container");

//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}

	public WebElement getProductByName(String ProductName) {
		WebElement prod = products.stream().filter(product ->
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String ProductName) {
		WebElement prod = getProductByName(ProductName);
		prod.findElement(By.cssSelector(".card-body button:last-of-type ")).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
	public void clickonCart() {
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
	} 
}
