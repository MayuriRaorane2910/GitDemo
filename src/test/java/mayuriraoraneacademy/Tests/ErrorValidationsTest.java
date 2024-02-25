package mayuriraoraneacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import mayuriraoraneacademy.PageObject.ProductCataloug;
import mayuriraoraneacademy.PageObject.cartPage;
import mayuriraoraneacademy.PageObject.checkOutPage;
import mayuriraoraneacademy.PageObject.confirmatonPage;
import mayuriraoraneacademy.TestComponents.BaseTest;


public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidaton() throws IOException, InterruptedException {

		String ProductName = "ZARA COAT 3";
		landingPage.LoginApplication("maya@yahoo.com", "Maya@90");
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
	}

	@Test
	public void ProductErrorValidaton() throws IOException, InterruptedException {

		String ProductName = "ZARA COAT 3";
		ProductCataloug productcataloug = landingPage.LoginApplication("rahul@yahoo.com", "Mayuri@29");
		List<WebElement> products = productcataloug.getProductList();
		productcataloug.addProductToCart(ProductName);
		cartPage cartpage = productcataloug.goToCartPage();
		Boolean match = cartpage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		Thread.sleep(2000);

	}

}
