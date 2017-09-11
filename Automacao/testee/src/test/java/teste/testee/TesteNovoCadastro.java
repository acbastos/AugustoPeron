package teste.testee;

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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

import util.MassaUtil;
import util.TestUtil;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;


public class TesteNovoCadastro {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TesteNovoCadastro.class);
  GeradoraCPF gerador = new GeradoraCPF();
  MassaUtil massa = new MassaUtil();

  
  
  @Before
  public void setUp() throws Exception {
	   System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("http://localhost:8080/cadastro-geral-web/");
	   driver.manage().window().maximize();
	   LOGGER.info("teste");
  }

  @Test
  public void testENovoCadastro() throws Exception {
    
    
    // Realizando login
    driver.findElement(By.id("usuario")).clear();
    driver.findElement(By.id("usuario")).sendKeys("Danillo");
    driver.findElement(By.id("senha")).clear();
    driver.findElement(By.id("senha")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    // Acessando o menu
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.linkText("Início"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
//     Thread.sleep(2000);
//     Actions actions = new Actions(driver);
//     WebElement menuHoverLink = driver.findElement(By.xpath("/html/body/div[2]/form/div/ul/li[2]/a/span[2]"));
//     actions.moveToElement(menuHoverLink).perform();
     
    
     Thread.sleep(1000);
    driver.findElement(By.linkText("Pessoa")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("formCartaNovaPessoa:j_idt190"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("formCartaNovaPessoa:j_idt190")).click();
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
    //driver.findElement(By.id("fDocumentos:dataEmissaoRg")).sendKeys("10102001");
    driver.findElement(By.id("fDocumentos:j_idt254")).click();
    // Preenchendo aba dados pessoais
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosPessoais:fotoPessoa"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fDadosPessoais:nome")).clear();
    driver.findElement(By.id("fDadosPessoais:nome")).sendKeys(massa.geraNomePessoa2palavras());
    driver.findElement(By.id("fDadosPessoais:sobrenome")).clear();
    driver.findElement(By.id("fDadosPessoais:sobrenome")).sendKeys("1");
    driver.findElement(By.id("fDadosPessoais:nomePreferencial")).clear();
    driver.findElement(By.id("fDadosPessoais:nomePreferencial")).sendKeys("testee");
    driver.findElement(By.id("fDadosPessoais:email")).clear();
    driver.findElement(By.id("fDadosPessoais:email")).sendKeys("a@a.com");
    driver.findElement(By.id("fDadosPessoais:dataNascimento")).sendKeys("10101980");
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
    driver.findElement(By.id("fDadosPessoais:j_idt300")).click();
    // Preencher aba Dados profissionais
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosProfissionais:funcao"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    new Select(driver.findElement(By.id("fDadosProfissionais:funcao"))).selectByVisibleText("ATLETA");
    Thread.sleep(1500);
    driver.findElement(By.id("fDadosProfissionais:clubes_input")).sendKeys("SEM CLUB");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='fDadosProfissionais:clubes_panel']/ul/li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fDadosProfissionais:clubes_input")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("fDadosProfissionais:confederacoes_input")).sendKeys("comit");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//div[@id='fDadosProfissionais:confederacoes_panel']/ul/li"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fDadosProfissionais:confederacoes_input")).sendKeys(Keys.ENTER);
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
    driver.findElement(By.id("fDadosProfissionais:j_idt318")).click();
    // Preencher aba Deficiência
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.xpath("//table[@id='fDeficiencia:j_idt221']/tbody/tr/td/div/div[2]"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//table[@id='fDeficiencia:j_idt221']/tbody/tr/td/div/div[2]")).click();
    driver.findElement(By.id("fDeficiencia:j_idt221:0")).click();
    Thread.sleep(1500);
    new Select(driver.findElement(By.id("fDeficiencia:tipoDeficiencia"))).selectByVisibleText("FISICA");
    driver.findElement(By.id("fDeficiencia:j_idt282")).click();
    // Preencher aba Dados de contato
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosContato:j_idt344"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fDadosContato:j_idt344")).click();
    Thread.sleep(1000);
    // Preencher aba Dados bancarios
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosBancarios:banco"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    new Select(driver.findElement(By.id("fDadosBancarios:banco"))).selectByVisibleText("BANCO ABC BRASIL S.A.");
    new Select(driver.findElement(By.id("fDadosBancarios:tipoContaBancaria"))).selectByVisibleText("CONTA CORRENTE");
    driver.findElement(By.cssSelector("option[value=\"1\"]")).click();
    driver.findElement(By.id("fDadosBancarios:agencia")).clear();
    driver.findElement(By.id("fDadosBancarios:agencia")).sendKeys(massa.gerarNumeroAleatorio2());
    driver.findElement(By.id("fDadosBancarios:dvAgencia")).clear();
    driver.findElement(By.id("fDadosBancarios:dvAgencia")).sendKeys(massa.gerarNumeroAleatorio2());
    driver.findElement(By.id("fDadosBancarios:conta")).clear();
    driver.findElement(By.id("fDadosBancarios:conta")).sendKeys(massa.gerarNumeroAleatorio2());
    driver.findElement(By.id("fDadosBancarios:dvConta")).clear();
    driver.findElement(By.id("fDadosBancarios:dvConta")).sendKeys(massa.gerarNumeroAleatorio2());
    driver.findElement(By.id("fDadosBancarios:j_idt235")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("fDadosBancarios:j_idt254")).click();
    // Aba dependentes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDependentes:j_idt246"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    Thread.sleep(1000);
    driver.findElement(By.id("fDependentes:j_idt246")).click();
    // Aba passaportes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fPassaportes:j_idt252"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fPassaportes:j_idt252")).click();
    // Aba vistos
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fVistos:j_idt241"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fVistos:j_idt241")).click();
    // Aba Uniformes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fUniformes:j_idt1039"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fUniformes:j_idt1039")).click();
    // Aba equipamentos
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fEquipamentos:j_idt258"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fEquipamentos:j_idt258")).click();
    // Aba Classificações esportivas
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fClassificacoesFuncionais:j_idt230"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fClassificacoesFuncionais:j_idt229")).click();
    // Aba dados complementares
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fDadosComplementares:j_idt275"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fDadosComplementares:j_idt275")).click();
    // Aba Ocorrências
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fOcorrencias:j_idt234"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fOcorrencias:j_idt234")).click();
    // Aba anexos
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("fAnexos:j_idt238"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("fAnexos:j_idt238")).click();
  }

  @After
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
