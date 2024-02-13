package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class ProductCatLog extends AbstractComponent {
	WebDriver driver;

	public ProductCatLog(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By productBy = By.cssSelector(".mb-3");
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	public List<WebElement> getProductList() {
		WaitEleAppear(productBy);
		return products;
	}

	public WebElement getProductName(String Pname) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(Pname)).findFirst()
				.orElse(null);
		return prod;
	}

	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	public void AddToCart(String Pname) {
		WebElement prod = getProductName(Pname);
		prod.findElement(addToCart).click();
		WaitEleAppear(toastMessage);
		WaitEleDisappear(spinner);
	}

}
