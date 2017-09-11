package br.org.cpb.UTIL;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class BaseUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("");
	protected static WebDriver driver;
	

	public BaseUtil(WebDriver driver){
		this.driver = driver;
		
	}
	
	public void abreNavegadorChrome(){
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	public void abreHeadlessBrowserChrome(){
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		 
	      // Adicione as opções do Google Chrome. A opção window-size é importante para sites responsivos
	      ChromeOptions options = new ChromeOptions();
	      options.addArguments("headless");
	      options.addArguments("window-size=1200x600");
	      WebDriver driver = new ChromeDriver(options);
	      // uma garantia que o script realmente executou como headless
	           
	}
	
    public void abreNavegadorFirefox(){
		
    	System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
	}
	
	public void acessarUrl(String url){
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void fecharNavegador(){
		
		driver.close();
	}
	
    
	public void abreNavegadorHtmlUnitDriver(){
		
		driver = new HtmlUnitDriver(BrowserVersion.CHROME);	
		System.out.println("Abrindo navegador HtmlUnit");
		
	}
}
