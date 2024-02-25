package mayuriraoraneacademy.Tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mayuriraoraneacademy.PageObject.LandingPage;
import mayuriraoraneacademy.PageObject.OrderPage;
import mayuriraoraneacademy.PageObject.ProductCataloug;
import mayuriraoraneacademy.PageObject.cartPage;
import mayuriraoraneacademy.PageObject.checkOutPage;
import mayuriraoraneacademy.PageObject.confirmatonPage;
import mayuriraoraneacademy.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	String ProductName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String,String> input)
			throws IOException, InterruptedException {

		ProductCataloug productcataloug = landingPage.LoginApplication(input.get("email"),input.get("password"));
		List<WebElement> products = productcataloug.getProductList();
		productcataloug.addProductToCart(input.get("Product"));
		cartPage cartpage = productcataloug.goToCartPage();
		Boolean match = cartpage.verifyProductDisplay(input.get("Product"));
		Assert.assertTrue(match);
		Thread.sleep(2000);
		checkOutPage checkoutpage = cartpage.goTocheckOut();
		checkoutpage.selectCountry("India");
		confirmatonPage ConfirmmationPage = checkoutpage.submitOrder();
		String ConfirmMessage = ConfirmmationPage.getconfirmationMessage();
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		// "ZARA COAT 3";
		ProductCataloug productcataloug = landingPage.LoginApplication("mayuri@yahoo.com", "Mayuri@29");
		OrderPage orderPage = productcataloug.goToOrderPage();

		Assert.assertTrue(orderPage.verifyOrderDisplay(ProductName));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//mayuriraoraneacademy//data//PurchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	//@DataProvider
	//public Object[][] getData() {
	//return new Object[][] {{"mayuri@yahoo.com","Mayuri@29","ZARA COAT 3"},{"mr@yahoo.com","Imqueen@29","ADIDAS ORIGINAL"}};
	
//	}

//	HashMap<String,String> map = new HashMap<String,String>();
		//map.put("email","mayuri@yahoo.com");
		//map.put("password","Mayuri@29");
	//	map.put("Product","ZARA COAT 3");
		
		//HashMap<String,String> map1 = new HashMap<String,String>();
		//map1.put("email","mr@yahoo.com");
		//map1.put("password","Imqueen@29");
		//map1.put("Product","ADIDAS ORIGINAL");
	

}
