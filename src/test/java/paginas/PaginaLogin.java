package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement txtEmail;
	@FindBy(css = "#passwd")
	WebElement txtPassword;
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement btnSingin;
	@FindBy(linkText =  "Sign out")
	WebElement linkSignOut;
	
	
	public PaginaLogin(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	

	//acciones
	public void escribirEmail(String email) {
		
		txtEmail.sendKeys(email);
	}
	public void escribirPassword(String password) {
		
		txtPassword.sendKeys(password);
	}

	public void btnLogin() {
	
	btnSingin.click();
}
	
	public void hacerClickSingOut() {
		
		linkSignOut.click();
	}
}
