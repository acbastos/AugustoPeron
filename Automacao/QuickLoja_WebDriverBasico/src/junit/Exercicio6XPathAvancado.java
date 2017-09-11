package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercicio6XPathAvancado {

	@Test
	public void testeXpathAvancado() {

		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Localizando Elementos CSS e XPath (Avançado)")).click();
        driver.findElement(By.xpath("//input[starts-with(@id,'name')]"));
        driver.findElement(By.xpath("//input[contains(@id,'-password')]"));
        //outro exemplo para senha
        driver.findElement(By.xpath("//input[substring(@id,string-length(@id)-7) = 'password']"));
		
	}
}