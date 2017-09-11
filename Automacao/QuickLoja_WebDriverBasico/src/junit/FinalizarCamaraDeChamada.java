package junit;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;


public class FinalizarCamaraDeChamada {
	
	@Test
	public void aguardandoElementos() throws InterruptedException {

//		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://localhost:8080/competicao-web");
		
		driver.findElement(By.id("usuario")).clear();
	    driver.findElement(By.id("usuario")).sendKeys("sup_atletismo");
	    //Preenchendo campo senha
	    driver.findElement(By.id("senha")).clear();
	    driver.findElement(By.id("senha")).sendKeys("12345");
	    //Clicando no notão login
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.id("home:eventosInscricaoFinalizada:4:btnSelecionarEvento")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("home:tableAções:0:btnCamaraChamada")).click();
		
		int a = 180; 
		
		for (int i = 0; i <= a; i++) {
			
			Thread.sleep(1000);
			driver.findElement(By.id("formListaProvasEBaterias:tableSeries:0:btnChamadaAtletas")).click();
			
			driver.findElement(By.id("formChamadaAtletas:btnFinalizar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("formChamadaAtletas:confirm")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("formChamadaAtletas:btnVoltar")).click();
			
		}
		
		
		
		
		
		
		
		driver.quit();
		
	}

}
