package junit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercicio01 {
	
	@Test
	
	public void teste001(){
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/index.html");
		driver.findElement(By.linkText("Utilizando as funções de navegação")).click();
		driver.navigate().to("http://www.qualister.info/treinamentos/selenium/webdriver/exercicios/fundamentos/12h/lista/navegacao/contador.html");
		driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        //driver.quit();
        
    
	}

}
