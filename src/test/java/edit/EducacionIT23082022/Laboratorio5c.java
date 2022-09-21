package edit.EducacionIT23082022;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.text.html.HTMLDocument.HTMLReader.FormAction;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;

public class Laboratorio5c {
	
	String URL = "http://automationpractice.com/index.php";
	String ChromePath = "..\\EducacionIT23082022\\Driver\\chromedriver104.0.5112.79.exe";
	String ImagPath = "..\\EducacionIT23082022\\Evidencias\\";
	String docPath="..\\EducacionIT23082022\\Evidencias\\documentoEvidencias"+LocalDateTime.now().withNano(0)+".docx";
	File screen;
	WebDriver driver;
	
	
	
	
	@BeforeSuite
		//Acciones que se van a ejecutar antes de toda la suit
	
	public void setUp() {
		
		System.out.println("beforeSuite - Inicio de la suite de prueba");
	}
	@BeforeClass
		//Acciones que se van a ejecutar antes del @Test de este archivo
	public void bedoreClass() {
		System.out.println("beforeClass - Inicio de la clase Java");
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.get(URL);
	}
	@BeforeTest
		//Acciones que se van a ejecutar antes de cada test
	
	public void bedoreTest() {
		System.out.println("beforeTest - Inicio de la prueba");	
		
	}
	
	@Test (description ="cp001 - buscar palabra",priority=20)
	public void buscarPalabra() throws IOException {
		
		//Captura de evidencia
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File(ImagPath + "01_Pantalla_inicial.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		// Escribir la palabra a buscar
			
			txtBuscador.sendKeys("dress");
			
			//Captura de evidencia
			screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen,new File(ImagPath + "02_PalabraAbuscar.jpg"));
			
		// botón buscar
			txtBuscador.sendKeys(Keys.ENTER);
			
			//Captura de evidencia
			screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen,new File(ImagPath + "03_IngresoDeLaPalabra.jpg"));
			
			//Validaciones
			
			Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
	}
	@Test (description ="cp001 - Contact US",priority=5)
	public void irAcontacUS() throws InvalidFormatException, IOException, InterruptedException {
		
		//Crear el documento para la evidencia
		
		CapturaEvidencia.escribirTituloEnDocumento(docPath,"Documento de evidencias de pruebas", 18);
		
		//Captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver,ImagPath + "img.jpg",docPath, "pantalla principal");
		
		driver.findElement(By.cssSelector("a[title='Contact Us']")).click();
		
		//Captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver,ImagPath + "img.jpg",docPath, "formulario de carga");
		
		Select Subject = new Select(driver.findElement(By.id("id_contact")));
		Subject.selectByIndex(1);		
		
		driver.findElement(By.cssSelector("#email")).sendKeys("jose"+Math.random()+"@test.com");
		
		driver.findElement(By.cssSelector("#id_order")).sendKeys("132456");
		
		driver.findElement(By.xpath("//input[@id='fileUpload']")).sendKeys("C:\\Users\\lauta\\OneDrive\\Escritorio\\Txt para el curso.txt");
		
		driver.findElement(By.cssSelector("#message")).sendKeys("Esto es una prueba para el campo MENSAJE");
		
		//Captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver,ImagPath + "img.jpg",docPath, "Mensaje de prueba");
		
		driver.findElement(By.cssSelector("#submitMessage")).click();
		
		//Captura de evidencia
		
		CapturaEvidencia.capturarPantallaEnDocumento(driver,ImagPath + "img.jpg",docPath, "Final");
		
	}
	
	
	@AfterTest
public void afterTest() {
		
		System.out.println("AfterTest - termina el test");
	}
	@AfterClass
public void afterClass() {
		
		System.out.println("AfterClass - termina la clase Java");
		driver.close();
	}
	
	@AfterSuite
public void afterSuite() {
		
		System.out.println("AfterSuite - termina la suite");
	}

}
