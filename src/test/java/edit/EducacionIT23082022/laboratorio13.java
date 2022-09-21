package edit.EducacionIT23082022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class laboratorio13 {
	
	String URL = "https://selenium.dev/";
	WebDriver driver;
	
	
	
	
	@BeforeSuite
	public void abrirPagina() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
	
	}
			
		@Test
		public void test1() {
			
			System.out.println("prueba sin el chromedriver.exe");
			
			//prueba cambio git
				
	}
}


