package rahulshettyacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	@FindBy(id = "userEmail")
	WebElement useremail;
	@FindBy(id = "userPassword")
	WebElement userpassword;
	@FindBy(id = "login")
	WebElement login;

	public ProductCatLog Login(String email, String password) {
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		login.click();
		ProductCatLog productcatlog = new ProductCatLog(driver);
		return productcatlog;
	}

	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;

	public String getErrorMess() {
		WaitElementApp(errorMessage);
		return errorMessage.getText();
	}

}
