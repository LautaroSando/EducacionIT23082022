package edit.EducacionIT23082022;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio8 {
	
	String Url ="https://demoqa.com/alerts";
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
	public void alerta1() {
		driver.findElement(By.cssSelector("#alertButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
	}
	@Test
	public void alerta2() {
		
		driver.findElement(By.cssSelector("#timerAlertButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
		
		
	}
	
	@Test
	public void alerta3() {
		
		driver.findElement(By.cssSelector("#confirmButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(150));
		alerta.dismiss();
		
		
	}
	
	@Test
	public void alerta4() {
		
		driver.findElement(By.cssSelector("#promtButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys("Mi clase de pop ups");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(150));
		alerta.accept();
		
		
		
		
	}
		


}
