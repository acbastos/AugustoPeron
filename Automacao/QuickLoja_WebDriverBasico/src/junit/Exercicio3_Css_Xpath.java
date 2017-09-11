package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercicio3_Css_Xpath {
	@Test
	public void localizarElementosPorCssSelector(){
		
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Localizando Elementos CSS e XPath")).click();
		WebElement divPai = driver.findElement(By.cssSelector(".divpai"));
		WebElement divFilho = driver.findElement(By.cssSelector(".divfilho"));
		WebElement divNeto1 = driver.findElement(By.cssSelector(".divfilho > div"));
		//WebElement divNeto2 = driver.findElement(By.cssSelector(".divfilho > .divneto > .divneto"));
		WebElement divDataInicio = driver.findElement(By.cssSelector("#dataInicio"));
		
		driver.close();
	}

}
