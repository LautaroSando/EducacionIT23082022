package edit.EducacionIT23082022;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class laboratorio12 {
	
	String Url ="https://demo.guru99.com/test/table.html";
	String chromePath="..\\EducacionIT23082022\\Driver\\chromedriver104.0.5112.79.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void AbrirPagina() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	
	public void ImprimirValoresTabla() {
		
		String  valor1 = driver.findElement(By.xpath("//td[contains(text(),'3')]")).getText();
		
		System.out.println("valor de la primera fila columna 3:"+valor1);
		
		String  valor2 = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		
		System.out.println("valor de la fila dos columna dos:"+valor2);
		
		String  valor3 = driver.findElement(By.xpath("//tbody/tr[3]/td[2]")).getText();
		
		System.out.println("valor de la  fila tres columna 2:"+valor3);
		
		String  valor4 = driver.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[4]/td[3]")).getText();
		
		System.out.println("valor de la fila 4 columna 3:"+valor4);
		
		
		
		
	}
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();	
	}

}
