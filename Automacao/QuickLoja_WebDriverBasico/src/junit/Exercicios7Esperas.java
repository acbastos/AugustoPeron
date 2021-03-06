package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercicios7Esperas {
	
	@Test
	public void aguardandoElementos() {

//		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Esperando elementos")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("username")));
		//Prenchendo nome
		driver.findElement(By.id("username")).sendKeys("demo");
		
		//Prenchendo senha
		driver.findElement(By.id("password")).sendKeys("demo");
		
		//Clicando no bot�o
		driver.findElement(By.id("login")).click();
		
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='message']")));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".success")));
		
		Assert.assertEquals("Voce efetuou o login com sucesso!", driver.findElement(By.cssSelector(".success")).getText());
		
		driver.quit();
		
	}
	
	@Test
	public void aguardandoElementos2() {

		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Esperando elementos")).click();
		
		//Prenchendo nome
		driver.findElement(By.id("username")).sendKeys("demo");
		
		//Prenchendo senha
		driver.findElement(By.id("password")).sendKeys("demo");
		
		//Clicando no bot�o
		driver.findElement(By.id("login")).click();
		
		Assert.assertEquals("Voce efetuou o login com sucesso!", driver.findElement(By.cssSelector(".success")).getText());
		
		driver.close();
		
	}
}
