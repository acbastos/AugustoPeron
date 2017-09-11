package junit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExemploJunit {

	@Test
	public void meuPrimeiroTeste() {
		String fruta = "Pera";
		Assert.assertTrue("Estava esperando uma pera",fruta.equals("Pera"));
   
	}
	
	@Test
	public void meuSegundoTeste(){
		String fruta2 = "uva";
		Assert.assertTrue("Estava esperando uma uva",fruta2.equals("Pera"));
	}
	
	@Test
	public void meuTerceiroTeste() {
		String fruta3 = "banana";
		Assert.assertEquals("Frutas diferentes", fruta3, "banana");
	}
	
	@Test
	public void meuQuartoTeste(){
		String fruta4 = "banana";
		Assert.assertTrue("Frutas diferentes",fruta4.equals("Pera"));
	}

}
