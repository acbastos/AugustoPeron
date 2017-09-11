package teste.testee;

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import util.MassaUtil;
import util.TestUtil;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;


import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;


public class testTestNG {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TesteNovoCadastro.class);
  GeradoraCPF gerador = new GeradoraCPF();
  MassaUtil massa = new MassaUtil();
  TestUtil util = new TestUtil(driver);
 
 
  

  
  @BeforeTest
  public void setUp() throws Exception {
	   System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("http://localhost:8080/cadastro-geral-web/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @org.testng.annotations.Test
  public void testENovoCadastro() throws Exception {
    
    
    // Realizando login
    driver.findElement(By.id("usuario")).clear();
    driver.findElement(By.id("usuario")).sendKeys("clubebolinha@hotmail.com");
    driver.findElement(By.id("senha")).clear();
    driver.findElement(By.id("senha")).sendKeys("clubefoda");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    // Acessando o menu
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.linkText("Início"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
     
    driver.findElement(By.xpath("/html/body/div[3]/div[1]/a/img")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[3]/div[2]/form/div/ul/li[3]/a")).click();
    
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fListaPessoas:nomeCompleto"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//button/span[text()='Novo Cadastro']/..")).click();
    // Preenchendo dados da aba Documentos
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDocumentos:cpf"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fDocumentos:cpf")).sendKeys(gerador.geraCPFSemMask());
    driver.findElement(By.id("fDocumentos:rg")).click();
    driver.findElement(By.id("fDocumentos:rg")).clear();
    driver.findElement(By.id("fDocumentos:rg")).sendKeys("321321");
    driver.findElement(By.id("fDocumentos:orgaoExpedidor")).clear();
    driver.findElement(By.id("fDocumentos:orgaoExpedidor")).sendKeys("ssp");
    new Select(driver.findElement(By.id("fDocumentos:ufOrgaoExpedidor"))).selectByVisibleText("AP");
    Thread.sleep(1000);
    //driver.findElement(By.id("fDocumentos:dataEmissaoRg")).sendKeys("10102001");
    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[4]/button[1]")).click();
    // Preenchendo aba dados pessoais
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosPessoais:fotoPessoa"))) break; } catch (Exception e) {}
   
    }
    driver.findElement(By.xpath("//button/span[text()='Atualizar Foto']/..")).click();
    //Assert.assertTrue(driver.getPageSource().contains("type=\"file\""));
    driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\augusto\\Desktop\\images.jpg");
    
    driver.findElement(By.id("fDadosPessoais:nome")).clear();
    driver.findElement(By.id("fDadosPessoais:nome")).sendKeys("Augusto teste" + massa.gerarNumeroAleatorio3());
    driver.findElement(By.id("fDadosPessoais:sobrenome")).clear();
    driver.findElement(By.id("fDadosPessoais:sobrenome")).sendKeys("1");
    driver.findElement(By.id("fDadosPessoais:nomePreferencial")).clear();
    driver.findElement(By.id("fDadosPessoais:nomePreferencial")).sendKeys("testee");
    driver.findElement(By.id("fDadosPessoais:email")).clear();
    driver.findElement(By.id("fDadosPessoais:email")).sendKeys("a@a.com");
    //driver.findElement(By.id("fDadosPessoais:dataNascimento")).sendKeys("10/10/1980");
    new Select(driver.findElement(By.id("fDadosPessoais:estadoCivil"))).selectByVisibleText("SOLTEIRO(A)");
    new Select(driver.findElement(By.id("fDadosPessoais:naturalidadeUf"))).selectByVisibleText("DF");
    driver.findElement(By.xpath("//select[@id='fDadosPessoais:naturalidadeUf']/option[8]")).click();
    new Select(driver.findElement(By.id("fDadosPessoais:naturalidadeCidade"))).selectByVisibleText("BRASÍLIA");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//table[@id='fDadosPessoais:genero']/tbody/tr/td/div/div[2]")).click();
   // driver.findElement(By.id("fDadosPessoais:genero:0")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("fDadosPessoais:nomeMae")).clear();
    driver.findElement(By.id("fDadosPessoais:nomeMae")).sendKeys("teste");
    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[1]/td[2]/div/div[2]/form/div[2]/button[2]")).click();
    // Preencher aba Dados profissionais
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosProfissionais:funcao"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    new Select(driver.findElement(By.id("fDadosProfissionais:funcao"))).selectByVisibleText("ATLETA");
    driver.findElement(By.id("fDadosProfissionais:clubes_input")).sendKeys("SEM CLUB");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='fDadosProfissionais:clubes_panel']/ul/li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fDadosProfissionais:clubes_input")).sendKeys(Keys.ENTER);
    Thread.sleep(1200);
    driver.findElement(By.id("fDadosProfissionais:confederacoes_input")).sendKeys("comit");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='fDadosProfissionais:confederacoes_panel']/ul/li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

  driver.findElement(By.id("fDadosProfissionais:confederacoes_input")).sendKeys(Keys.ENTER);
    Thread.sleep(1000);
    new Select(driver.findElement(By.id("fDadosProfissionais:formacao"))).selectByVisibleText("ENSINO FUNDAMENTAL INCOMPLETO");
    driver.findElement(By.id("fDadosProfissionais:pis")).sendKeys("78978978978");
    driver.findElement(By.id("fDadosProfissionais:registroProfissional")).clear();
    driver.findElement(By.id("fDadosProfissionais:registroProfissional")).sendKeys("3213213123213");
    driver.findElement(By.id("fDadosProfissionais:inscricaoAutonomo")).clear();
    driver.findElement(By.id("fDadosProfissionais:inscricaoAutonomo")).sendKeys("dsadsadas");
    driver.findElement(By.id("fDadosProfissionais:sdms")).clear();
    driver.findElement(By.id("fDadosProfissionais:sdms")).sendKeys("dsdsadsa");
    new Select(driver.findElement(By.id("fDadosProfissionais:treinador"))).selectByVisibleText("ABEL CASTRO MARTINS");
    new Select(driver.findElement(By.id("fDadosProfissionais:modalidade1"))).selectByVisibleText("ATLETISMO");
    driver.findElement(By.xpath("//button/span[text()='Salvar e Continuar']/..")).click();
    // Preencher aba Deficiência
    
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/fieldset/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/div/div[2]")).click();
    //driver.findElement(By.id("fDeficiencia:j_idt221:0")).click();
    Thread.sleep(1000);
    new Select(driver.findElement(By.id("fDeficiencia:tipoDeficiencia"))).selectByVisibleText("FISICA");
    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[3]/button[2]")).click();
    // Preencher aba Dados de contato
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosContato:endereco"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[4]/button[2]")).click();
    Thread.sleep(1000);
    // Preencher aba Dados bancarios
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosBancarios:banco"))) break; } catch (Exception e) {}
    	
    }

    new Select(driver.findElement(By.id("fDadosBancarios:banco"))).selectByVisibleText("BANCO ABC BRASIL S.A.");
    new Select(driver.findElement(By.id("fDadosBancarios:tipoContaBancaria"))).selectByVisibleText("CONTA CORRENTE");
    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
    driver.findElement(By.id("fDadosBancarios:agencia")).clear();
    driver.findElement(By.id("fDadosBancarios:agencia")).sendKeys(massa.gerarNumeroAleatorio2());
    driver.findElement(By.id("fDadosBancarios:dvAgencia")).clear();
    driver.findElement(By.id("fDadosBancarios:dvAgencia")).sendKeys(massa.gerarNumeroAleatorio3());
    driver.findElement(By.id("fDadosBancarios:conta")).clear();
    driver.findElement(By.id("fDadosBancarios:conta")).sendKeys(massa.gerarNumeroAleatorio2());
    driver.findElement(By.id("fDadosBancarios:dvConta")).clear();
    driver.findElement(By.id("fDadosBancarios:dvConta")).sendKeys(massa.gerarNumeroAleatorio());
    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/span/div[2]/div/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[4]/button[2]")).click();
    // Aba dependentes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/div/div[2]"))) break; } catch (Exception e) {}
    }
    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[4]/div/button[2]")).click();
    // Aba passaportes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/fieldset/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/div/div[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/fieldset/div/div/button[2]")).click();
    // Aba vistos
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/div/div[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[3]/div/div/button[2]")).click();
    // Aba Uniformes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fUniformes:agasalhoPasseio"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[25]/button[2]")).click();
    // Aba equipamentos
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/fieldset/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/div/div[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[3]/button[2]")).click();
    // Aba Classificações esportivas
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fClassificacoesFuncionais:table_paginator_top"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[2]/button[2]")).click();
    // Aba dados complementares
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosComplementares:apelido"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[8]/button[2]")).click();
    // Aba Ocorrências
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[3]/button[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr/td[2]/div/div[2]/form/div[3]/button[2]")).click();
    // Aba anexos
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fAnexos:fotoRg"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[1]/td[2]/div/div[2]/form/div[4]/button[2]")).click();
  }

  @AfterTest
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
