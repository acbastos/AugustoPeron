package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercicio05Xpath {
	
	@Test
	public void localizarElementosPorXpath(){
		
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Localizando Elementos CSS e XPath")).click();
		WebElement divPai = driver.findElement(By.xpath("//div[@class='divpai border']"));
		WebElement divFilho = driver.findElement(By.xpath("//div[@class='divfilho border']"));
		WebElement divNeto1 = driver.findElements(By.xpath("//div[@class='divneto border']")).get(0);
		WebElement divNeto2 = driver.findElement(By.xpath("//div[contains(text(),'Div Neto 2')]"));
		WebElement divDataInicio = driver.findElement(By.xpath("//input[@id='dataInicio']")); 
		driver.close();

}
}
