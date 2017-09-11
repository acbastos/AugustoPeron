package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Exercicio02_Elementos {
	
	@Test
	public void localizandoElementos(){
		
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Localizando Elementos")).click();
		WebElement tituloDaPagina = driver.findElement(By.tagName("h5"));
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement campoSenha = driver.findElement(By.id("password"));
		WebElement campoLembrarSenha = driver.findElement(By.id("lembrar"));
		WebElement botaoLogin = driver.findElement(By.id("submit"));
		WebElement botaoLimpar = driver.findElement(By.xpath("/html/body/div/form/input[5]"));
		WebElement estadoBotao = driver.findElement(By.id("submit"));
		estadoBotao.isEnabled();
		WebElement linkVoltar = driver.findElement(By.partialLinkText("Voltar para"));
		
		driver.quit();
	}

}
