package rahulshettyacademy.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.bouncycastle.asn1.dvcs.Data;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.CheckOutPage;
import rahulshettyacademy.pageobject.ConfirmPage;
import rahulshettyacademy.pageobject.ProductCatLog;
import rahulshettyacademy.testComponent.BaseTest;

public class Hashcode extends BaseTest {

	@Test(dataProvider = "getData", groups = "Hash")
	public void submit(HashMap<String,String> input)throws IOException {
		ProductCatLog productcatlog = landingpage.Login(input.get("email"),input.get("password"));
		productcatlog.getProductName(input.get("Pname"));
		productcatlog.AddToCart(input.get("Pname"));
		CartPage cartpage = productcatlog.goToCartPage();
		Boolean match = cartpage.VerifyCartList(input.get("Pname"));
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckOutPage();
		checkoutpage.getCounrtyName();
		ConfirmPage confirmpage = checkoutpage.goToConfirmPage();
		String confirmMessage = confirmpage.getConfirmMess();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@DataProvider
	public Object[][] getData()throws IOException {
		List<HashMap<String,String>> data = getJsonnDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademey//data//HashOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
}
