package rahulshettyacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement countryName;
	By countryBy = By.cssSelector(".ta-results");
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement countryIndia;

	public void getCounrtyName() {
		Actions a = new Actions(driver);
		a.sendKeys(countryName, "India").build().perform();
		WaitEleAppear(countryBy);
		countryIndia.click();
	}

	@FindBy(css = ".action__submit")
	WebElement confirmP;

	public ConfirmPage goToConfirmPage() {
		confirmP.click();
		ConfirmPage confirmpage = new ConfirmPage(driver);
		return confirmpage;
	}

}
