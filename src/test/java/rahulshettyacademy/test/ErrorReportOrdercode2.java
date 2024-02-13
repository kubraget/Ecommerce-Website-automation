package rahulshettyacademy.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmPage;
import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.ProductCatLog;
import rahulshettyacademy.testComponent.BaseTest;
import rahulshettyacademy.testComponent.Retry;

public class ErrorReportOrdercode2 extends BaseTest {
	String Pname = "ADIDAS ORIGINAL";

	@Test
	public void submit() {
		ProductCatLog productcatlog = landingpage.Login("arbuk001@gmail.com", "1112@Arbuk");
		productcatlog.getProductName(Pname);
		productcatlog.AddToCart(Pname);
		CartPage cartpage = productcatlog.goToCartPage();
		Boolean match = cartpage.VerifyCartList(Pname);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckOutPage();
		checkoutpage.getCounrtyName();
		ConfirmPage confirmpage = checkoutpage.goToConfirmPage();
		String confirmMessage = confirmpage.getConfirmMess();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "submit" })
	public void OrderPageHistory() {
		ProductCatLog productcatlog = landingpage.Login("arbuk001@gmail.com", "1112@Arbuk");
		OrderPage orderpage = productcatlog.goToOrderPage();
		Boolean match = orderpage.VerifyOrderList(Pname);
		Assert.assertTrue(match);
	}

	@Test(groups = { "errorhandling" }, retryAnalyzer = Retry.class)
	public void ErrorValidation() {
		ProductCatLog productcatlog = landingpage.Login("arbuk01@gmail.com", "1112@Arbuk");
		Assert.assertEquals("Incorrect email o password.", landingpage.getErrorMess());
	}
}
