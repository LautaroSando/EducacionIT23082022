package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	
	//elementos que vamos a utilizar
	
	
	@FindBy (xpath = "//a[contains(text(),'Sign in')]")
	WebElement linkSigin;
	
	@FindBy(css = "#search_query_top")
	WebElement txtBuscador;
	
	
	//constructor
	
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	//acciones
	public void hacerClickEnSingIn() {
		linkSigin.click();
		
	}
	
	public void EscribirPalabra(String palabra) {
		
		txtBuscador.sendKeys(palabra);
	}
	
	public void PresionarEnterBuscador() {
		
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	
	
	

}
