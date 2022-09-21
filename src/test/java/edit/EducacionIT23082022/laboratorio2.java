package edit.EducacionIT23082022;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class laboratorio2 {
	
	//Variables - atributos
	
	String url = "http://automationpractice.com/index.php";
	String Chromepath = "..\\EducacionIT23082022\\Driver\\chromedriver104.0.5112.79.exe";
	String firefoxpath = "..\\EducacionIT23082022\\Driver\\geckodriver-v0.31.0-win64.exe";
	WebDriver driver;
	
	
	
	//metodos
	@Test // Siempre va para poder correrlo con Junit
	public void buscarPalabraChrome() {
		
	//1 Donde esta el driver
		
		System.setProperty("webdriver.chrome.driver", Chromepath);
		
	//2 Abrir el navegador e ingresar a la pagina
		
		driver = new ChromeDriver();
		driver.get (url);
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
	//3 Identificar el campo Buscador
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
	//3.2 Escribir la palabra a buscar
		
		txtBuscador.sendKeys("dress");
	//4 botón buscar
		txtBuscador.sendKeys(Keys.ENTER);
		
		System.out.println("URL :" + driver.getCurrentUrl());
		
		System.out.println("titulo de la pagina:"+ driver.getTitle());
		
	//5 cerrar el navegador
		
		
	}
	
	@Test // Siempre va para poder correrlo con Junit
	public void buscarPalabraFirefox() {
		
		//1 Donde esta el driver
			
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			
		//2 Abrir el navegador e ingresar a la pagina
			
			driver = new FirefoxDriver();
			driver.get (url);
			
		//3 Identificar el campo Buscador
			
			WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		//3.2 Escribir la palabra a buscar
			
			txtBuscador.sendKeys("dress");
		//4 botón buscar
			txtBuscador.sendKeys(Keys.ENTER);
		//5 cerrar el navegador
		}
}
