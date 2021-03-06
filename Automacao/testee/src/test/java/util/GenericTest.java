package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class GenericTest {

	public static final Logger LOGGER = LoggerFactory
			.getLogger(GenericTest.class);

	public static final String SOCKS_USERNAME = "luciano.lkbs";
	public static final String SOCKS_PASSWORD = "stefanini@55";
	public static final int PROXY_PORT = 3128;
	public static final String CODIFIED_PROXY_PASSWORD = "stefanini%4055";
	public static final String PROXY_ADDRESS = "proxy.dpf.gov.br";
	public static final String PROXY_DPF_GOV_BR = SOCKS_USERNAME + ":"
			+ CODIFIED_PROXY_PASSWORD + "@" + PROXY_ADDRESS;
	public static final String SSL_PROXY = PROXY_DPF_GOV_BR + ":" + PROXY_PORT;
	public static final int APP_PORT = 8080;
//	public static final int APP_PORT = 9999;
	public static final String NO_PROXY = "10.2.104.67,localhost:"
			+ APP_PORT
			+ "/*,localhost*,*localhost*,http://localhost:9999/sis2/*,https://localhost:9999/sis2/";
	public static final String SISEGSOLANGE = "/sis2/paginas/publico/login.seam?dispatcher=efetuarLogin&cd_pessoa=5006011&cd_matricula=17790&cpf=49033050153&cd_senha=E10ADC3949BA59ABBE56E057F20F883E&cd_sistema=226&ds_e_mail_analista=&tp_pessoa=&cd_grupo=2&lot_cd_lotacao=123&gestor=&usuario=49033050153&username=49033050153&password=E10ADC3949BA59ABBE56E057F20F883E&login=login&senha=2806201317&e_mail=solange.sbm@dpf.gov.br&nome=SOLANGE%20BERTO%20DE%20MEDEIROS&tpGrupo=";
	public static final String SISEGDANTE = "/sis2/paginas/publico/login.seam?dispatcher=efetuarLogin&cd_pessoa=5005843&cd_matricula=17654&cpf=94213844153&cd_senha=361633153A464830A1FE85DEC5EFAB17&cd_sistema=219&ds_e_mail_analista=&tp_pessoa=&cd_grupo=1&lot_cd_lotacao=1037&gestor=&usuario=94213844153&username=94213844153&password=361633153A464830A1FE85DEC5EFAB17&login=login&senha=1203201411&e_mail=dante.dlpf@dpf.gov.br&nome=DANTE LUIZ PIPPI FILHO&tpGrupo=";
	public static final String SISEGPABLO = "/sis2/paginas/publico/login.seam?dispatcher=efetuarLogin&cd_pessoa=5006011&cd_matricula=17790&cpf=84003332172&cd_senha=E10ADC3949BA59ABBE56E057F20F883E&cd_sistema=226&ds_e_mail_analista=&tp_pessoa=&cd_grupo=2&lot_cd_lotacao=123&gestor=&usuario=49033050153&username=49033050153&password=E10ADC3949BA59ABBE56E057F20F883E&login=login&senha=2806201317&e_mail=solange.sbm@dpf.gov.br&nome=SOLANGE";
	public static final String AUTHENTICATION_URL = "10.2.104.67:"
			+ APP_PORT
			+ SISEGSOLANGE;
	public static final String XPATH_CABECALHO = "//div[@id='layout-cabecalho']/div[2]/a";
	private static final String INICIO_DE_CENARIO_DE_TESTE = "===== Inicio do cen�rio =====: ";
	private static final String FIM_DE_CENARIO_DE_TESTE = "===== Fim do Cen�rio ======: ";
	private static final String FIM_DA_CLASSE_DE_TESTE = "===== Fim da Classe de Teste =====";
	private static String pathDriverChrome = "chromedriver.exe";

	public WebDriver webDriver;

	@Parameters({ "browser", "pathdriver" })
	@BeforeClass
	public void iniciaTestes(String browser, String pathDriver) {
		try {
			LOGGER.info("Criando a instancia do Browser" + browser);
			webDriver = instanciaBrowser(browser, pathDriver);

		} catch (Exception e) {
			LOGGER.error("Erro ao Instanciar o WebDriver", e);
			e.printStackTrace();
		}
	}

	@AfterClass
	public void encerraTestes() throws Exception {
		LOGGER.info(FIM_DA_CLASSE_DE_TESTE);
		webDriver.close();
		webDriver.quit();
	}

	@BeforeMethod
	public void beforeMethod(Method metodo) {
		LOGGER.info(INICIO_DE_CENARIO_DE_TESTE + metodo.getName());
	}

	@AfterMethod
	public void afterMethod(Method metodo, ITestContext context) {
		LOGGER.info(FIM_DE_CENARIO_DE_TESTE + metodo.getName());
	}

	/**
	 * M�todo que recebe a string com o nome do browser a ser instanciado
	 *
	 * @param browser
	 * @return instancia do browser {@link org.openqa.selenium.WebDriver}
	 * @throws Exception
	 */
	private WebDriver instanciaBrowser(String browser, String pathdriver)
			throws Exception {

		WebDriver driver = null;

		if ("firefox".equals(browser)) {
			System.setProperty("binary", pathdriver);
			org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
			proxy.setSslProxy(SSL_PROXY);
			proxy.setFtpProxy(SSL_PROXY);
			proxy.setHttpProxy(SSL_PROXY);
			// proxy.setSocksProxy(SSL_PROXY);
			proxy.setSocksUsername(SOCKS_USERNAME);
			proxy.setSocksPassword(SOCKS_PASSWORD);
			proxy.setNoProxy(NO_PROXY);
			// proxy.setProxyType(Proxy.ProxyType.MANUAL);

			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability(CapabilityType.PROXY, proxy);
			driver = new FirefoxDriver(dc);
			driver.manage().deleteAllCookies();
			driver.manage()
					.timeouts()
					.implicitlyWait(WaitTool.DEFAULT_WAIT_4_PAGE,
							TimeUnit.SECONDS);

		} else if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", pathDriverChrome);
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage()
					.timeouts()
					.implicitlyWait(WaitTool.DEFAULT_WAIT_4_PAGE,
							TimeUnit.SECONDS);

		} else if ("ie".equals(browser)) {
			System.setProperty("webdriver.ie.driver", pathdriver);
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.manage()
					.timeouts()
					.implicitlyWait(WaitTool.DEFAULT_WAIT_4_PAGE,
							TimeUnit.SECONDS);

		} else {
			throw new Exception("Browser n�o identificado: " + browser);

		}
		return driver;
	}

	public void login() throws InterruptedException {
		webDriver.get(AUTHENTICATION_URL);
		webDriver.manage().window().maximize();
		
	}

	public void home() throws InterruptedException {
		webDriver.findElement(By.xpath(".//*[@id='princialMenu']")).click();
		Thread.sleep(1000);
	}

	public void homeInterface() throws InterruptedException {
		webDriver.findElement(By.xpath(XPATH_CABECALHO)).click();
		Thread.sleep(1000);
		// .//*[@id='layout-cabecalho']/div[2]/a[1]
	}

}
