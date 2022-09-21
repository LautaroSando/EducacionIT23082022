package edit.EducacionIT23082022;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String Chromepath ="..\\EducacionIT23082022\\Driver\\chromedriver104.0.5112.79.exe";
	WebDriver driver;
	
	
	@Test
	public void registrarUsuario() {
		
		System.setProperty("webdriver.chrome.driver", Chromepath);
		
		driver = new ChromeDriver();
		
		driver.navigate().to(url); // es equivalente al driver.get(url)
		driver.manage().window().maximize();
		
		
		
		//Paso 1 : Ingresar el correo
		
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		
		txtEmail.sendKeys("test01092022_1@test.com");
		
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
		
		
		//Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id_gender2")));
		
		//Paso 2: cargar formulario
		
		
		//Radio
		
		driver.findElement(By.cssSelector("#id_gender2")).click();
		
		// First name
		
		WebElement txtFname = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		
		txtFname.sendKeys("Pepe");
		
		//Second name
		driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Garcia");
		
		
		
		//Password
		
		driver.findElement(By.cssSelector("#passwd")).sendKeys("123456");
		
		
		
		//Day
		
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue("21");
		
		//Month
		
		Select month = new Select(driver.findElement(By.cssSelector("#months")));
		month.selectByIndex(3);
		
		//Year
		
		Select year = new Select(driver.findElement(By.cssSelector("#years")));
		year.selectByValue("2022");
		
		
		//Check signs newsletter
		
		driver.findElement(By.cssSelector("#newsletter")).click();
		
		//Ofertas especiales
		
		driver.findElement(By.xpath("//input[@id='optin']")).click();
		
		//direccion - address
		
		driver.findElement(By.cssSelector("#address1")).sendKeys("Calle Falsa 123"); 
		
		//city
		
		driver.findElement(By.cssSelector("#city")).sendKeys("Chalten"); 
		//state
		Select state = new Select(driver.findElement(By.cssSelector("#id_state")));
		state.selectByIndex(12);
		
		//zip
		
		driver.findElement(By.cssSelector("#postcode")).sendKeys("25452");
		
		//country
		
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
				
		//mobile_phone
		
		driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("132566548");
				
		
		//alias
		
	
		WebElement txtAlias = driver.findElement(By.cssSelector("#alias"));
		
		txtAlias.clear();
		
		txtAlias.sendKeys("Mi casa");
		
		// apretar el boton
		
		driver.findElement(By.cssSelector("#submitAccount")).click();
		
		
		
	}
	
	
	
	
	
	
	

}
