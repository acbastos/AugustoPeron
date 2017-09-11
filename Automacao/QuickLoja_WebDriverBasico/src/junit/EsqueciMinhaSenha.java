package junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsqueciMinhaSenha {

	@Test
	public void test() {
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost:8080/cadastro-geral-web/");
		
		//Preenchendo campo usuario
		driver.findElement(By.linkText("Esqueci Minha Senha (Clube e Confederações)")).click();
		
		driver.findElement(By.id("form:usuario")).sendKeys("priscila@cpb.org.br");
		
		driver.findElement(By.id("form:j_idt13")).click();
		
	}

}
