package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercicio8Alert {
	
	@Test
	public void alerts() {

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Alertas, Confirmações e Prompts 1")).click();
		
		//Prenchendo usuario
		driver.findElement(By.id("user")).sendKeys("user");
		
		//Clicando no botão
		driver.findElement(By.id("submit")).click();
	
        Alert alerta = driver.switchTo().alert();
        
        Assert.assertEquals("Preencha os dois campos!!!", alerta.getText());
        alerta.accept();
        
        driver.quit();
	
	}
}