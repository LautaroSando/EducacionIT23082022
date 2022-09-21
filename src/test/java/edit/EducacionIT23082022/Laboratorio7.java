package edit.EducacionIT23082022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio7 {
	
	String Url ="http://automationpractice.com/index.php";
	String chromePath="..\\EducacionIT23082022\\Driver\\chromedriver104.0.5112.79.exe";
	WebDriver driver;
	
	
	
	@BeforeSuite
	
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		
		// en la pagina principal hacer click en el Sing in
		PaginaInicio Inicio = new PaginaInicio(driver);
		//Hacer click en el boton de Sing in
		Inicio.hacerClickEnSingIn();
		
		// en la pagina principal hacer click en el Login
		PaginaLogin Login = new PaginaLogin(driver);
		//Ingresar el Email
		Login.escribirEmail("micorreo0.12996167487105847@correo.com");
		//Ingresar la PW
		Login.escribirPassword("123456");
		//Hacer click en el boton de logueo
		Login.btnLogin();
		
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		
	}
	
	@Test
	public void buscarPalabra() {
		// en la pagina principal escribir palabra y presionar enter
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.EscribirPalabra("dress");
		inicio.PresionarEnterBuscador();
		
		
	}
	

}
