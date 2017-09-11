package br.org.cpb.PO;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

import br.org.cpb.UTIL.ComandosAgeis;
import br.org.cpb.UTIL.MassaUtil;
import br.org.cpb.UTIL.BaseUtil;
import br.org.cpb.UTIL.TestUtil;

public class ClassificacaoEsportivaPO extends BaseUtil {
	
	private MassaUtil massa = new MassaUtil();
	private ComandosAgeis util = new ComandosAgeis();
	
	public ClassificacaoEsportivaPO(){
		super(driver);
	}
	
	
	public void incluirClassificacaoEsportiva(String nome) throws InterruptedException{
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Acessando menu Classificação esportiva
		driver.findElement(By.xpath("//div[@class='iconemobile']")).click();
		driver.findElement(By.linkText("Classificação Esportiva")).click();
		//Pesquisando pessoa
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("form:nomeCompleto")));
		driver.findElement(By.id("form:nomeCompleto")).sendKeys(nome);
		driver.findElement(By.id("form:btnPesquisar")).click();
        //Selecionando pessoa		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("form:table:0:btnEditar")));
		driver.findElement(By.id("form:table:0:btnEditar")).click();
		//Preenchendo dados da classificação do atleta
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("form:classesFuncionais1")));
		util.slcCmbAleatoriamente(By.id("form:classesFuncionais1"));
		util.slcCmbAleatoriamente(By.id("form:classesFuncionais2"));
		util.slcCmbAleatoriamente(By.id("form:status"));
		util.preencheCampoPorId("form:nomeClassificador", massa.geraNomePessoa1palavra());
		util.slcCmbAleatoriamente(By.id("form:abrangencia"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button/span[text()='Salvar Classe']/..")).click();
		
		Assert.assertEquals("Classificação Esportiva incluída com sucesso.", driver.findElement(By.xpath("//div[@class='ui-messages-info ui-corner-all']")).getText());
		
		
	}
	
	
	
	

}
