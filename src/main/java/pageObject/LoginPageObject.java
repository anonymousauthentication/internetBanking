package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css ="input[type=\"text\"]")
	WebElement emailInput;

	@FindBy(css = "input[type*=\"pass\"]")
	WebElement passInput;

	@FindBy(css = "input[name*=\"btnLogin\"]")
	WebElement loginButton;

	public void setUserName(String userName) {
		emailInput.sendKeys(userName);
	}

	public void setPassword(String passWord) {
		passInput.sendKeys(passWord);
	}

	public void loginSubmit() {
		loginButton.submit();
	}
}
