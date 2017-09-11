package util;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IResultMap;
import org.testng.ITestResult;



import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Util extends GenericTest {

    public static final String OCOREU_UM_ERRO_INESPERADO = "Ocoreu um erro inesperado ";
    public static final String ERRO_AO_SALVAR_SCREEN_SHOTS = "Erro ao Salvar ScreenShots";
    public static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
    public static final Map<String, ITestResult> RESULTADOS = new HashMap<String, ITestResult>();
    public static final List<String> TESTCONTEXTNAME = new ArrayList<String>();
    public static final List<String> TESTRESULTNAMES = new ArrayList<String>();


    /**.
     * Descricao: Metodo responsavel por tirar evidencia da tela que esta sendo testada
     * @param nomeArquivo
     * @param subDiretorio
     * @param webDriver
     */
//	public static void tirarEvidencia(String nomeArquivo, String subDiretorio, WebDriver webDriver){
//		
//		WebDriver augmentedDriver = new Augmenter().augment(webDriver);
//		File scrFile = ((TakesScreenshot)augmentedDriver).
//        getScreenshotAs(OutputType.FILE);
//		  
//		salvarEvidencia(scrFile, subDiretorio +"/" + nomeArquivo + ".png");
//	}
//	
    /**.
     * Descricao: Metodo responsavel por salvar evidencia retirada
     * @param arquivo
     * @param nomeArquivo
     */
//	public static void salvarEvidencia(File arquivo, String nomeArquivo){
//        File outputFile = new File(GenericTest.getScreenshotsFolder(), nomeArquivo);
//        try {
//            FileUtils.copyFile(arquivo, outputFile);
//        } catch (IOException ioe) {
//        	LOGGER.error(ERRO_AO_SALVAR_SCREEN_SHOTS + ioe);
//        	Assert.fail(ERRO_AO_SALVAR_SCREEN_SHOTS + ioe.getMessage());
//        }
//    }

    /**
     * .
     * Descricao: Configura propriedades expecificas para o firefox
     *
     * @param extraCapabilities
     */
    public static void setFirefoxProfile(DesiredCapabilities extraCapabilities) {
//		FirefoxProfile profile = new FirefoxProfile();

//		profile.setPreference("browser.cache.disk.enable", false);
//		profile.setPreference("browser.cache.memory.enable", false);
//		profile.setPreference("browser.cache.offline.enable", false);
//		profile.setPreference("network.http.use-cache", false);
        System.setProperty("binary", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");

//		extraCapabilities.setCapability(new FirefoxDriver(), profile);

    }


//	public static void adicionaResultados(){
//		for(String testResultName : TESTRESULTNAMES){
//			ResultadoTeste linha = new ResultadoTeste();
//			for(String testContextName : TESTCONTEXTNAME){
//				StringBuilder chave = new StringBuilder(testResultName).append("_").append(testContextName);
//				ITestResult testResult = RESULTADOS.get(chave.toString());
//				if(testResult!=null){
//					testResult.setAttribute("testContextName", testContextName);
//				}
//				linha.getColunas().add(testResult);
//			}
//			LINHASRELATORIO.add(linha);
//		}
//	}

    /**
     * .
     * Dexcricao: Metodo responsavel por coletar os resultados dos testes
     *
     * @param testContextName
     * @param results
     */
    public static void coletaResultados(String testContextName, IResultMap results) {
        for (ITestResult testResult : results.getAllResults()) {
            StringBuilder chave = new StringBuilder(testResult.getName()).append("_").append(testContextName);
            RESULTADOS.put(chave.toString(), testResult);
        }
    }

    /**
     * Descricao:  Metodo responsavel por verificar se o metodo e um metodo de teste.
     * Nome: isMetodoTeste
     *
     * @param m
     * @return boolean
     */
    public static boolean isMetodoTeste(Method m) {
        for (Annotation annotation : m.getAnnotations()) {
            if (annotation.annotationType().toString().contains("org.testng.annotations.Test")) {
                return true;
            }
        }
        return Boolean.FALSE;
    }

    public static String getDetalhes(ITestResult r) {
        StringBuilder sb = new StringBuilder();
        if (r.getThrowable() != null && r.getThrowable().getLocalizedMessage() != null) {
            String localizedMessage = r.getThrowable().getLocalizedMessage().
                    replace("'", "").
                    replace("<", "(").
                    replace(">", ")").
                    replaceAll("\\r|\\n", "<br/>").
                    replace("\"", "&quot;");
            sb.append("<br/><strong>").append(localizedMessage).append("</strong><br/><br/>");
            if (r.getThrowable().getLocalizedMessage() != null) {
                for (StackTraceElement ste : r.getThrowable().getStackTrace()) {
                    String stackLine = ste.toString().
                            replace("'", "").
                            replace("<", "(").
                            replace(">", ")").
                            replaceAll("\\r|\\n", "<br/>").
                            replace("\"", "&quot;");
                    sb.append(stackLine).append("<br/>");
                }
            }
        }
        return sb.toString();
    }

//	public void esperarPorElementoNaoVisivel(By by) throws InterruptedException {
//		Thread.sleep(5000);
//		for (int second = 0;; second++) {
//			if (second >= 20)
//				Assert.fail("timeout");
//			try {
//				if (!this.elementoEstaVisivel(by)) {
//					break;
//				}
//			} catch (Exception e) {
//				Assert.fail("timeout");
//			}
//			Thread.sleep(1000);
//		}
//	}
//	
//
//	public void esperarPorElementoVisivel(By by) throws InterruptedException {
//		for (int second = 0;; second++) {
//			if (second >= 5)
//				Assert.fail("timeout");
//			try {
//				if (this.elementoEstaVisivel(by)) {
//					break;
//				}
//			} catch (Exception e) {
//				Assert.fail("timeout");
//			}
//			Thread.sleep(1000);
//		}
//	}

//	public boolean elementoEstaVisivel(By by) {
//		try {
//			return getWebDriver().findElement(by).isDisplayed();
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}
//	
//	
//	@SuppressWarnings("rawtypes")
//	public boolean trocarParaJanela(String fragmentoUrl) {
//		Iterator it = getWebDriver().getWindowHandles().iterator();
//
//		while (it.hasNext()) {
//			String idJanela = (String) it.next();
//			getWebDriver().switchTo().window(idJanela);
//			if (getWebDriver().getCurrentUrl().contains(fragmentoUrl)) {
//				break;
//			}
//		}
//
//		return getWebDriver().getCurrentUrl().contains(fragmentoUrl);
//
//	}

    public void aguarde(int i) throws InterruptedException {
        i = i * 1000;
        Thread.sleep(i);
    }

    public Timestamp data() {
        java.util.Date date = new java.util.Date();
        Timestamp currentTimestamp = new Timestamp(date.getTime());
        return currentTimestamp;
    }

    public String telefone() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 11; i++) {
            String aleatorio = ("" + Math.random() * 10).substring(0, 1);
            sb.append(aleatorio);
        }
        String numero = sb.toString();
//		 Integer ddd = (int) (Math.random()*10);
//		 String dddstring = ddd.toString();
//		 numero = "06"+dddstring+num;
        return numero;
    }


}
