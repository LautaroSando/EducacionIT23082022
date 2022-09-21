package edit.EducacionIT23082022;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;


public class Laboratorio9 {
	
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
	
	@Test (dataProvider = "Datos Login")
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
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatos(){
		
		Object[][] datos = new Object [4][2];
		
		datos[0][0] ="micorreo0.12996167487105847@correo.com";
		datos[0][1] ="123456";
		datos[1][0] ="ana@test.com";
		datos[1][1] ="ana1234";
		datos[2][0] ="pedro@test.com";
		datos[2][1] ="pedro1234";
		datos[3][0] ="juan@test.com";
		datos[3][1] ="juan1234";
		
		return datos;
	}
	

}
