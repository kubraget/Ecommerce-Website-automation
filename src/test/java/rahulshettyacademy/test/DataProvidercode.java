package rahulshettyacademy.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmPage;
import rahulshettyacademy.pageobject.ProductCatLog;
import rahulshettyacademy.testComponent.BaseTest;

public class DataProvidercode extends BaseTest {

	@Test(dataProvider = "goData", groups = "Purchase")
	public void submit(String email,String password,String Pname) {
		ProductCatLog productcatlog = landingpage.Login(email, password);
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

	@DataProvider
	public Object[][] goData() {
		return new Object[][] { { "arbuk001@gmail.com", "1112@Arbuk", "ADIDAS ORIGINAL" },
				{ "kubra001@gmail.com", "Kubra@2001", "ZARA COAT 3" } };
	}
	
}
