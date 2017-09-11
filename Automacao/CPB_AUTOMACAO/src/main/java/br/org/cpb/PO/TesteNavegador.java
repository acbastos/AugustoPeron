package br.org.cpb.PO;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.sun.jna.platform.dnd.GhostedDragImage;

import br.org.cpb.UTIL.MassaUtil;
import br.org.cpb.UTIL.BaseUtil;

public class TesteNavegador {
	

	@Before
	public void antesDeTudo(){

	}
	
	@Test
	public void TestarNavegador() throws InterruptedException{
	
		
		DesiredCapabilities dcaps = DesiredCapabilities.phantomjs();  
		dcaps.setCapability("takesScreenshot", false);

		File executavelPhantomJS = new File("Drivers/phantomjs.exe");  
		dcaps.setCapability("phantomjs.binary.path", executavelPhantomJS.getAbsolutePath());

		WebDriver driver = new PhantomJSDriver(dcaps);
		
   // WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);	
    driver.get("http://www.google.com");
    System.out.println(driver.getTitle());
		
		    
	}
	
	@After
	public void depoisDeTudo(){
		
		
			
	}
}

	
	
	
	

    

