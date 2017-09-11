package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercicio04CssSelectorAvancado {

	
	@Test
	public void testeCssSelectorAvancado(){
		
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Localizando Elementos CSS e XPath (Avançado)")).click();
		WebElement divEmail = driver.findElement(By.cssSelector("input[id^='name']"));
		WebElement divSenha = driver.findElement(By.cssSelector("input[id$='password']"));
		WebElement divRepetirSenha = driver.findElement(By.cssSelector("input[id*='-password-']"));
		
		driver.close();
	}
}
