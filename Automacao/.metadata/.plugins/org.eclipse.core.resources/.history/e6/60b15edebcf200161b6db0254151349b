package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TestUtil implements TestUtilInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestUtil.class);
    private WebDriver driver;
    private String baseUrl = "";
    private int tempoDeEspera = 1000;
    private int tempoDeEsperaCurto = 0;
    private int tmpEsperaElemento = 20;
    /**
     * Pasta para serem salvas as evidencias do UC em quest�o. padr�o "".
     */
    private String pastaEvidencias = "target\\evidencias\\";
    /**
     * Inicial para ser adicionado no nome da evidencia do UC. padrao "".
     */
    private boolean isTirarPrintErro = true;

    //============================================================================

    /**
     * Construtor que configura setar o Browser e etc...
     * Necess�rio passar a URL inicial
     */


    public TestUtil(WebDriver driver, String url) {

        setDriver(driver);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    /**
     * Construtor que configura setar o Browser e etc...
     * Necess�rio realizar o driver.get ou driver.navigate.to para a URL
     * Desejada inicialmente antes de usar este construtor
     */
    public TestUtil(WebDriver webDriver) {

        if (webDriver.getCurrentUrl() == null || webDriver.getCurrentUrl().equals("")) {
            throw new RuntimeException("URL a ser acessar n�o setada, configurar a URL no arquivo testng.xml...");
        }
        setDriver(webDriver);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    //==================== M�todos �teis =======================
    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#aguardarElementoPorID(java.lang.String)
	 */
    public void aguardarElementoPorID(String id) {
        LOGGER.info("Aguardando elemento: " + id);
        try {
            @SuppressWarnings("unused")
            WebElement myDynamicElement = (new WebDriverWait(driver, tmpEsperaElemento))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento n�o encontrado: " + id);
            fail(e.getMessage());
        }
    }


    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#maximizarJanela()
     */
    public void maximizarJanela() {
        driver.manage().window().maximize();
    }


    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#aguardarElemento(org.openqa.selenium.By, java.lang.String)
     */
    public void aguardarElemento(By by) {
        LOGGER.info("Aguardando elemento...");
        try {
            @SuppressWarnings("unused")
            WebElement myDynamicElement = (new WebDriverWait(driver, tmpEsperaElemento))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento n�o encontrado: ");
            fail(e.getMessage());
        }

    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#aguardar(int)
     */
    public void aguardar(int timeMilesegundos) {
        try {
            Thread.sleep(timeMilesegundos);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#aguardar()
     */
    public void aguardar() {
        try {
            Thread.sleep(tempoDeEspera);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#aguardar()
     */
    public void aguardarCurto() {
        try {
            Thread.sleep(tempoDeEsperaCurto);
        } catch (InterruptedException e) {
            fail(e.getMessage());
        }
    }

    //==========================================================

    //=================== Iterar janelas / manipular abas =================

	/* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#changeWindow(int)
	 */

    public void changeWindow(int janela) {

        int count = 0;
        for (String handle : driver.getWindowHandles()) {

            count++;
            if (count == janela) {
                driver.switchTo().window(handle);
            }
        }
    }

    //=================== Menu Hover ======================================

	/* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#moveCursor(org.openqa.selenium.By)
	 */

    public void moveCursor(By elemento) {

        Actions actions = new Actions(driver);
        WebElement menuHoverLink = driver.findElement(elemento);
        actions.moveToElement(menuHoverLink).perform();
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#dragAndDrop(org.openqa.selenium.By, org.openqa.selenium.By)
     */
    public void dragAndDrop(By elementoOrigem, By elementoDestino) {

        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(driver.findElement(elementoOrigem))
                .moveToElement(driver.findElement(elementoDestino))
                .release(driver.findElement(elementoDestino))
                .build();
        dragAndDrop.perform();

    }


    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcCmbAleatoriamente(By by)
     */
    public void slcCmbAleatoriamente(By by) {

        WebElement combo = driver.findElement(by);
        Select s = new Select(combo);
        List<WebElement> itens = s.getOptions();

        int numItens = itens.size() - 1;
        WebElement elementoSelecionado = null;

        do {
            int numAleat = (int) (Math.random() * 150);
            //na poupex o if tem que ter o numAleat >=1 pois combos est�o vindo com o 1� iten como "selecione"
            if (numAleat >= 1 && !(numAleat > numItens)) {
                s.selectByIndex(numAleat);
                LOGGER.info(" Iten " + numAleat + " selecionado da combo.");
                break;
            }

        } while (true);
    }

    public String getTextoPorValorParcial(By by, String valorParcial) {

        WebElement combo = driver.findElement(by);
        Select s = new Select(combo);
        List<WebElement> itens = s.getOptions();

        for (WebElement e : itens) {
            if (e.getText().contains(valorParcial)) {
                return e.getText();

            }

        }

        return null;
    }

    //=================== Campos tipos Select =============================
    public void slcCmbByeTexto(By by, String texto) {
        try {
            Select select = new Select(driver.findElement(by));
            select.selectByVisibleText(texto);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    public void slcCmbByeValue(By by, String value) {
        try {
            Select select = new Select(driver.findElement(by));
            select.selectByValue(value);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcCmbNameValue(java.lang.String, java.lang.String)
     */
    public void slcCmbNameValue(String name, String value) {
        try {
            Select select = new Select(driver.findElement(By.name(name)));
            select.selectByValue(value);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcCmbNameTexto(java.lang.String, java.lang.String)
     */
    public void slcCmbNameTexto(String name, String texto) {
        try {
            Select select = new Select(driver.findElement(By.name(name)));
            select.selectByVisibleText(texto);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcCmbIdValue(java.lang.String, java.lang.String)
     */
    public void slcCmbIdValue(String id, String value) {
        try {
            new Select(driver.findElement(By.id(id))).selectByValue(value);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcCmbIdTexto(java.lang.String, java.lang.String)
     */
    public void slcCmbIdTexto(String id, String texto) {
        try {
            new Select(driver.findElement(By.id(id))).selectByVisibleText(texto);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    public boolean isValorComboExiste(By by, String textoCombo) {

        Select combo = new Select(driver.findElement(by));

        List<WebElement> valores = combo.getOptions();

        for (WebElement e : valores) {
            if (e.getText().equals(textoCombo)) {
                return true;
            }
        }

        return false;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slc(org.openqa.selenium.By, java.lang.String)
     */
    public void slc(By by, String texto) {
        try {
            new Select(driver.findElement(by)).selectByVisibleText(texto);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    //=====================================================================

    //=================== Campos tipos RadioButton ========================

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcRadioBtnID(java.lang.String)
     */
    public void slcRadioBtnID(String id) {
        try {
            driver.findElement(By.id(id)).click();
        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento n�o encontrato: " + id);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcRadioBtnValue(java.lang.String)
     */
    public void slcRadioBtnValue(String value) {
        try {
            driver.findElement(By.xpath("//input[@value='" + value + "']")).click();
        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento com Value n�o encontrato: " + value);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcRadioBtn(org.openqa.selenium.By, java.lang.String)
     */
    public void slcRadioBtn(By by, String value) {
        try {
            driver.findElement(by).click();
        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento com Value n�o encontrato: " + value);
            fail(e.getMessage());
        }
    }

    //=====================================================================

    //=================== Campos tipos CheckBox ========================

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcChkBoxID(java.lang.String, boolean)
     */
    public void slcChkBoxID(String id, boolean check) {
        try {
            WebElement element = driver.findElement(By.id(id));
            if (check) {
                if (!element.isSelected()) {
                    element.click();
                }
            } else {
                if (element.isSelected()) {
                    element.click();
                }
            }
            driver.findElement(By.id(id)).click();
        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento n�o encontrato: " + id);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcChkboxXpath(java.lang.String, boolean)
     */
    public void slcChkboxXpath(String xPath, boolean check) {
        try {
            WebElement element = driver.findElement(By.xpath(xPath));
            if (check) {
                if (!element.isSelected()) {
                    element.click();
                }
            } else {
                if (element.isSelected()) {
                    element.click();
                }
            }
            driver.findElement(By.xpath(xPath)).click();
        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento n�o encontrato: " + xPath);
            fail(e.getMessage());
        }
    }


    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcChkBoxName(java.lang.String, boolean)
     */
    public void slcChkBoxName(String name, boolean check) {
        try {
            WebElement element = driver.findElement(By.cssSelector("input[name='" + name + "']"));
            if (check) {
                if (!element.isSelected()) {
                    element.click();
                }
            } else {
                if (element.isSelected()) {
                    element.click();
                }
            }
        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento n�o encontrato: " + name);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#slcChkBoxName(org.openqa.selenium.By, boolean)
     */
    public void slcChkBoxName(By by, boolean check) {
        try {
            WebElement element = driver.findElement(by);
            if (check) {
                if (!element.isSelected()) {
                    element.click();
                }
            } else {
                if (element.isSelected()) {
                    element.click();
                }
            }
        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento n�o encontrato: " + by.toString());
            fail(e.getMessage());
        }
    }

    //===================================================================

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#limpaCamposInput()
     */
    @SuppressWarnings("rawtypes")
    public void limpaCamposInput() {
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        if (inputs != null) {
            Iterator i = inputs.iterator();
            while (i.hasNext()) {
                WebElement e = (WebElement) i.next();
                if (e.isDisplayed() && e.isEnabled()) {
                    try {
                        e.clear();
                    } catch (Exception e2) {
                        LOGGER.warn(" Erro ao tentar limpar o campo com o valor: " + e.getAttribute("value"));
                        fail(e2.getMessage());
                    }
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#assertTextoExiste(java.lang.String)
     */
    public void assertTextoExiste(String texto) {

        aguardar(2000);
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + texto + "[\\s\\S]*$"));
        } catch (Error e) {
            LOGGER.warn("Erro ou tentar verificar se o texto estava presente na tela: " + texto);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#isTextoExiste(java.lang.String)
     */
    public boolean isTextoExiste(String texto) {

        try {
            //driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*" + texto + "[\\s\\S]*$");
            //Alterando para o m�todo abaixo pois o acima esta sempre retornando true
            Boolean isTextoExiste = driver.getPageSource().contains(texto);
            return isTextoExiste;
        } catch (Exception e) {
            LOGGER.warn("Erro ou tentar verificar se o texto estava presente na tela: " + texto);
            return false;
        }
    }

    /* (non-Javadoc)
    * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#isElementoPresente(java.lang.String)
    */
    public boolean isElementoPresente(String xPath) {
        try {
            driver.findElement(By.xpath(xPath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementoPresente(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementoPresenteIdValor(String id, String valor) {
        try {
            slcCmbIdTexto(id, valor);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /* (non-Javadoc)
        * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#isElementoPresenteCss(java.lang.String)
        */
    public boolean isElementoPresenteCss(String css) {
        try {
            driver.findElement(By.cssSelector(css));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

	 /* (non-Javadoc)
         * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#trocadeJanela()
		 */

    public void trocadeJanela() {

        int count = 1;
        for (String handle : driver.getWindowHandles()) {

            count++;
            if (count == 2) {
                driver.switchTo().window(handle);
            }
            if (count == 1) {
            }
        }

    }


    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getWebElement(java.lang.String)
     */
    public WebElement getWebElement(String id) {
        WebElement elemento = null;
        try {
            elemento = driver.findElement(By.id(id));

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento n�o encontrato: " + id);
            fail(e.getMessage());
        }
        return elemento;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getWebElementPorName(java.lang.String)
     */
    public WebElement getWebElementPorName(String name) {
        WebElement elemento = null;
        try {
            elemento = driver.findElement(By.name(name));

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento com NAME n�o encontrato: " + name);
            fail(e.getMessage());
        }
        return elemento;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getWebElementPorXpath(java.lang.String)
     */
    public WebElement getWebElementPorXpath(String xPath) {
        WebElement elemento = null;
        try {
            elemento = driver.findElement(By.xpath(xPath));

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento com NAME n�o encontrato: " + xPath);
            fail(e.getMessage());
        }
        return elemento;
    }


    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getWebElementPorCSS(java.lang.String)
     */
    public WebElement getWebElementPorCSS(String classe) {
        WebElement elemento = null;
        try {
            elemento = driver.findElement(By.cssSelector(classe));

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento com NAME n�o encontrato: " + classe);
            fail(e.getMessage());
        }
        return elemento;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getWebElementPorCSS(org.openqa.selenium.By)
     */
    public WebElement getWebElement(By by) {
        WebElement elemento = null;
        try {
            elemento = driver.findElement(by);

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento n�o encontrato: " + by.toString());
            fail(e.getMessage());
        }
        return elemento;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#limpaCampoPorId(java.lang.String)
     */
    public void limpaCampoPorId(String id) {
        try {
            driver.findElement(By.id(id)).clear();

        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento n�o encontrato: " + id);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#limpaCampoPorName(java.lang.String)
     */
    public void limpaCampoPorName(String name) {
        try {
            driver.findElement(By.name(name)).clear();

        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento com NAME n�o encontrato: " + name);
            fail(e.getMessage());
        }

    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#limpaCampoPorXpath(java.lang.String)
     */
    public void limpaCampoPorXpath(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).clear();

        } catch (NoSuchElementException e) {
            LOGGER.warn(" Elemento com NAME n�o encontrato: " + xpath);
            fail(e.getMessage());
        }

    }


    //==================== Preenchimento de campos =======================
	/* (non-Javadoc)
	 * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#preencheCampoPorId(java.lang.String, java.lang.String)
	 */
    public void preencheCampoPorId(String id, String texto) {
        limpaCampoPorId(id);
        try {
            driver.findElement(By.id(id)).sendKeys(texto);

        } catch (InvalidElementStateException e) {
            LOGGER.warn("Elemento com ID n�o esta habilitado no HTML: " + id);
            fail(e.getMessage());
        } catch (StaleElementReferenceException e) {
            LOGGER.warn("Elemento com o ID n�o encontrado no HTML: " + id);
            fail(e.getMessage());
        }

    }


    public void preencheCampoPorIdParaData(String id, String texto) {

        try {
            driver.findElement(By.id(id)).sendKeys(texto);

        } catch (InvalidElementStateException e) {
            LOGGER.warn("Elemento com ID n�o esta habilitado no HTML: " + id);
            fail(e.getMessage());
        } catch (StaleElementReferenceException e) {
            LOGGER.warn("Elemento com o ID n�o encontrado no HTML: " + id);
            fail(e.getMessage());
        }

    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#preencheCampoPorName(java.lang.String, java.lang.String)
     */
    public void preencheCampoPorName(String name, String texto) {
        limpaCampoPorName(name);
        try {
            driver.findElement(By.name(name)).sendKeys(Keys.CONTROL + "");

        } catch (InvalidElementStateException e) {
            LOGGER.warn("Elemento com ID n�o esta habilitado no HTML: " + name);
            fail(e.getMessage());
        } catch (StaleElementReferenceException e) {
            LOGGER.warn("Elemento com o ID n�o encontrado no HTML: " + name);
            fail(e.getMessage());
        }

    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#preencheCampoPorXpath(java.lang.String, java.lang.String)
     */
    public void preencheCampoPorXpath(String xPath, String texto) {
        try {
            driver.findElement(By.xpath(xPath)).sendKeys(texto);

        } catch (InvalidElementStateException e) {
            LOGGER.warn("Elemento com ID n�o esta habilitado no HTML: " + xPath);
            fail(e.getMessage());
        } catch (StaleElementReferenceException e) {
            LOGGER.warn("Elemento com o ID n�o encontrado no HTML: " + xPath);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#preencheCampo(org.openqa.selenium.By, java.lang.String)
     */
    public void preencheCampo(By by, String texto) {
        try {
            driver.findElement(by).sendKeys(texto);

        } catch (InvalidElementStateException e) {
            LOGGER.warn("Elemento n�o esta habilitado no HTML: " + by.toString());
            fail(e.getMessage());
        } catch (StaleElementReferenceException e) {
            LOGGER.warn("Elemento n�o encontrado no HTML: " + by.toString());
            fail(e.getMessage());
        }
    }
    //================================================================================

    //=========================== Cliques ===========================================

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#clickElementoBrowserAccept(java.lang.String)
     */
    public void clickElementoBrowserAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#clickElementoBrowserAccept(java.lang.String)
     */
    public void clickElementoBrowserDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#clickPorId(java.lang.String)
     */
    public void clickPorId(String id) {
        try {
            driver.findElement(By.id(id)).click();

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento n�o encontrato: " + id);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#clickPorName(java.lang.String)
     */
    public void clickPorName(String name) {
        try {
            driver.findElement(By.name(name)).click();

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento com o nome n�o encontrato: " + name);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#clickPorLink(java.lang.String)
     */
    public void clickPorLink(String link) {
        try {
            driver.findElement(By.linkText(link)).click();

        } catch (NoSuchElementException e) {
            LOGGER.warn("Link n�o encontrato: " + link);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#clickPorXPath(java.lang.String)
     */
    public void clickPorXPath(String xPath) {
        try {
            driver.findElement(By.xpath(xPath)).click();

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento com o xPath n�o encontrato: " + xPath);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#clickPorCss(java.lang.String)
     */
    public void clickPorCss(String classe) {
        try {
            driver.findElement(By.cssSelector(classe)).click();

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento n�o encontrato: " + classe);
            fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#clickPorId(org.openqa.selenium.By)
     */
    public void click(By by) {
        try {
            driver.findElement(by).click();

        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento n�o encontrato: " + by.toString());
            fail(e.getMessage());
        }
    }
    //====================================================================

    //================ Limpeza de campos =================================
	/* (non-Javadoc)
	 * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#limpaCampo(org.openqa.selenium.By)
	 */
    public void limpaCampo(By by) {
        try {
            WebElement elemento = driver.findElement(by);
            if (elemento.isDisplayed() && elemento.isEnabled()) {
                elemento.clear();
            }
        } catch (NoSuchElementException e) {
            LOGGER.warn("Elemento n�o encontrato: " + by.toString());
            fail(e.getMessage());
        } catch (Exception e) {
            LOGGER.warn(" Erro ao limpar o campo:" + by.toString());
            fail(e.getMessage());
        }
    }

    //====================================================================

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#destaque(org.openqa.selenium.WebElement)
     */
    public void destaque(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                element, "color: black; border: 3px solid red;");
		/*	for (int i = 0; i < 10; i++) {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
		                element, "color: yellow; border: 2px solid red;");
		        js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
		                element, "");
		    }*/
        try {

        } catch (Exception e) {
            LOGGER.warn(" Erro ao destacar o elemento...");
            //		fail(e.getMessage());
        }
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#destaque(java.lang.String)
     */
    public void destaque(String idElemento) {
        destaque(getWebElement(idElemento));
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#destaque(org.openqa.selenium.By)
     */
    public void destaque(By formaDeCaptura) {
        destaque(formaDeCaptura.findElement(getDriver()));
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#destaque(java.lang.String)
     */
    public void destaque(String... ids) {
        for (int i = 0; i < ids.length; i++) {
            destaque(ids[i]);
        }
    }

    //=========================== Prints =================================
	/* (non-Javadoc)
	 * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#print()
	 */
    public void print() {
        print("");
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#print(java.lang.String)
     */
    public void print(String nomeArquivo) {
        if (nomeArquivo == null) nomeArquivo = "";
        print(pastaEvidencias, nomeArquivo);
    }

    /**
     * Realiza o print da tela na pasta informada do path definido e com o nome passado
     * Caso n�o seja informado nada o print � salvo na pasta root do projeto na workspace
     */
    private void print(String pastaEvidencias, String nomeArq) {
        aguardar(2000);
        LOGGER.info(" Iniciando print da tela e salvando em: " + pastaEvidencias);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyy_HHmmssSSS");
        String dataAtual = df.format(new Date(System.currentTimeMillis()));

        try {
            FileUtils.copyFile(file, new File(pastaEvidencias + nomeArq + "" + dataAtual + ".png"));
        } catch (IOException e) {
            LOGGER.warn(" Erro ao Realizar o print da tela...");
            //fail(e.getMessage());
        }
    }
    //==========================================================

    /**
     * Registra a falha no @Test em execu��o e tira um print da tela
     *
     * @param msg
     */
    private void fail(String msg) {
        if (isTirarPrintErro) {
            print("ERRO_");
            LOGGER.info(" ************** Fail *************** ");
        }
        org.junit.Assert.fail(msg);
    }

	/*public void verificationPoint(String id, String valorEsperado){
		String valorReal = driver.findElement(By.id(id)).getText();
		org.junit.Assert.assertEquals(valorEsperado, valorReal);
	}*/

    //========================= Tabelas html =============================
	/* (non-Javadoc)
	 * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#findElementOnTable(java.lang.String, java.lang.String, java.lang.String, int)
	 */
    public ArrayList<WebElement> findElementOnTable(String idTable, String textFind, String tdClass, int indexColunReturn) {
        ArrayList<WebElement> list = new ArrayList<WebElement>();
        WebElement businessTable = driver.findElement(By.id(idTable));
        boolean nextLine = true;

        for (int i = 1; nextLine; i++) {
            List<WebElement> tableRows = businessTable.findElements(By.xpath(".//tr[" + i + "]/td[@class = '" + tdClass + "']"));

            String txt = "";
            if (!tableRows.isEmpty()) {
                for (int j = 0; j < tableRows.size(); j++) {
                    txt += tableRows.get(j).getText();
                }
                if (txt.contains(textFind)) {
                    list.add(tableRows.get(indexColunReturn));
                }
            } else {
                nextLine = false;
            }
        }
        return list;
    }

    public WebElement clickIconeTable(String idTable, String textoDaLinha, String iconeClass) {

        WebElement table = driver.findElement(By.id(idTable));
        List<WebElement> trElements = table.findElements(By.xpath("id('" + idTable + "')/tbody/tr"));


        for (WebElement tr : trElements) {
            List<WebElement> tdElements = tr.findElements(By.xpath("td"));

            WebElement trEncontrada;

            for (WebElement td : tdElements) {
                if (td.findElement(By.tagName("label")).getText().equals(textoDaLinha)) {
                    trEncontrada = tr;
                }
            }

        }

        //System.out.println(tdElements.get(0).getAttribute("id"));
        //System.out.println(tdElements.get(0).findElement(By.tagName("label")).getText());


        return null;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#findElementOnTable(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
     */
    public WebElement findElementOnTable(String idTable, String textFind, String tdClass, String icone, int indexColunReturn) {
        ArrayList<WebElement> list = findElementOnTable(idTable, textFind, tdClass, indexColunReturn);
        WebElement icon = null;
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                List<WebElement> tableRows = list.get(i).findElements(By.xpath(".//a/img"));
                if (!tableRows.isEmpty()) {
                    for (int j = 0; j < tableRows.size(); j++) {
                        if (tableRows.get(j).getAttribute("src").contains(icone)) {
                            icon = tableRows.get(j);
                            break;
                        }
                    }
                } else {
                    getLogger().info("Icone N�O Localizado!");
                }
            }
        } else {
            getLogger().info("Celulas N�O Localizadas!");
        }
        return icon;
    }

    //====================================================================

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getDriver()
     */
    public WebDriver getDriver() {
        return driver;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#setDriver(org.openqa.selenium.WebDriver)
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getBaseUrl()
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#setBaseUrl(java.lang.String)
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getTempoDeEspera()
     */
    public int getTempoDeEspera() {
        return tempoDeEspera;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#setTempoDeEspera(int)
     */
    public void setTempoDeEspera(int tempoDeEspera) {
        this.tempoDeEspera = tempoDeEspera;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getPastaEvidencias()
     */
    public String getPastaEvidencias() {
        return pastaEvidencias;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#setPastaEvidencias(java.lang.String)
     */
    public void setPastaEvidencias(String pastaEvidencias) {
        this.pastaEvidencias = pastaEvidencias;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#setTirarPrintErro(boolean)
     */
    public void setTirarPrintErro(boolean isTirarPrintErro) {
        this.isTirarPrintErro = isTirarPrintErro;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#setTmpEsperaElemento(int)
     */
    public void setTmpEsperaElemento(int tmpEsperaElemento) {
        this.tmpEsperaElemento = tmpEsperaElemento;
    }

    /* (non-Javadoc)
     * @see br.com.portalgr.br.gov.dpf.sis.br.gov.dpf.sis.tests.integrationtests.tests.integrationtests.util.TestUtilInterface#getLogger()
     */
    public Logger getLogger() {
        return LOGGER;
    }
}
