package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProduct;

	public Boolean VerifyCartList(String Pname) {
		Boolean match = cartProduct.stream().anyMatch(cartP -> cartP.getText().equalsIgnoreCase(Pname));
		return match;
	}

	@FindBy(css = ".totalRow button")
	WebElement checkoutP;

	public CheckOutPage goToCheckOutPage() {
		checkoutP.click();
		CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}

}
