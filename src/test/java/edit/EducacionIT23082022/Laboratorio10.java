package edit.EducacionIT23082022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio10 {
	
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
	
	@Test (dataProvider = "Datos Login desde excel")
	public void login(String email,String password) {
		
		// en la pagina principal hacer click en el Sing in
		PaginaInicio Inicio = new PaginaInicio(driver);
		//Hacer click en el boton de Sing in
		Inicio.hacerClickEnSingIn();
		
		// en la pagina principal hacer click en el Login
		PaginaLogin Login = new PaginaLogin(driver);
		//Ingresar el Email
		Login.escribirEmail(email);
		//Ingresar la PW
		Login.escribirPassword(password);
		//Hacer click en el boton de logueo
		Login.btnLogin();
		
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		
		//log out
		Login.hacerClickSingOut();
		
	}
	@DataProvider(name="Datos Login desde excel")
	public Object[][] obtenerDatosExcel() throws Exception{
		
		return DatosExcel.leerExcel("..\\EducacionIT23082022\\Datos\\datos_Login.xlsx", "Hoja1");
				
	}
	

}
