package br.org.cpb.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.org.cpb.UTIL.BaseUtil;

 

public class RetificarProvasPO extends BaseUtil {
	
	public RetificarProvasPO(){
		super(driver);
	}
	
	
	public void retificarProva() throws InterruptedException{
		
		
		int num = 2;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("home:eventosInscricaoFinalizada:0:btnSelecionarEvento")));
		
		driver.findElement(By.id("home:eventosInscricaoFinalizada:0:btnSelecionarEvento")).click();
		//Thread.sleep(1000);
		//Acessar o menu consulta
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[3]/form/div/ul/li[4]/a/span[2]")));
		driver.findElement(By.xpath("/html/body/div[3]/form/div/ul/li[4]/a/span[2]")).click();
		
		for(num=0 ; num <= 2 ; num++){
            
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("listaProvasPesquisadas:statusSerie")));
		Select select = new Select(driver.findElement(By.id("listaProvasPesquisadas:statusSerie")));
        select.selectByVisibleText("RESULTADO OFICIAL");
		
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("listaProvasPesquisadas:btnPesquisar")));
		driver.findElement(By.id("listaProvasPesquisadas:btnPesquisar")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("listaProvasPesquisadas:provasPesquisadas:0:btnRetificarResultados")));
		driver.findElement(By.id("listaProvasPesquisadas:provasPesquisadas:0:btnRetificarResultados")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("formRetificacaoResultadosTrack:btnFinalizar")));
		driver.findElement(By.id("formRetificacaoResultadosTrack:btnFinalizar")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("formRetificacaoResultadosField:confirm")));
		driver.findElement(By.id("formRetificacaoResultadosField:confirm")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/form/fieldset/div[4]/button[3]")));
		driver.findElement(By.xpath("/html/body/div[5]/form/fieldset/div[4]/button[3]")).click();
		
		
		
		 }
	}

}
