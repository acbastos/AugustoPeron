package junit;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.NEWARRAY;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercicio7PreenchendoElementos {
    
	@Test
	public void preenchendoElementos() {

		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Manipulando Elementos HTML")).click();
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("")));
		//Prenchendo nome
		driver.findElement(By.id("name1")).sendKeys("Augusto");
		

		//Prenchendo Sobrenome
		driver.findElement(By.id("name2")).sendKeys("Peron");
		
		//Selecionando sexo
		driver.findElement(By.name("gender")).click();
		
		//Selecionando comida favorita
		driver.findElement(By.id("value3")).click();
		
		//Informando TextArea
		driver.findElement(By.id("txtarea")).clear();
		driver.findElement(By.id("txtarea")).sendKeys("Churrasco");
		
		//Selecionando combo
		Select combo = new Select(driver.findElement(By.name("education")));
		combo.selectByVisibleText("Graduado");
		
		//Selecionado lista
		Select combo2 = new Select(driver.findElement(By.id("dia")));
		combo2.selectByVisibleText("Noite");
		
		//Clicando no botão
		driver.findElement(By.name("send")).click();
		
		
		//----------------------------Validações-------------------
		
		//Validando nome
		Assert.assertEquals("Olá, Augusto Peron", driver.findElement(By.id("nome")).getText());
		//Validando sexo
		Assert.assertEquals("Você é Homem", driver.findElement(By.id("sexo")).getText());
		//Validando comida
		Assert.assertEquals("E você gosta de Pizza", driver.findElement(By.id("comida")).getText());
		//Validando outra comida
		Assert.assertEquals("Você também gosta de: Churrasco", driver.findElement(By.id("outra_comida")).getText());
		//Validando parte do dia favorita
		Assert.assertEquals("Sua parte favorita do dia é: Noite", driver.findElement(By.id("parte_favorita")).getText());
		//Validando Grau de instrução
		Assert.assertEquals("Seu grau de instrução é: Graduado", driver.findElement(By.id("instrucao")).getText());
		
		
		
		//driver.quit();
		
		
		

	}
}