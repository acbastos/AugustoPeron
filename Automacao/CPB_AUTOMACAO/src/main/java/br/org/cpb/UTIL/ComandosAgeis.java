package br.org.cpb.UTIL;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ComandosAgeis extends BaseUtil {
	
	public ComandosAgeis(){
		
		super(driver);
	}
	
	
	 public void slcCmbAleatoriamente(By by) {

	        WebElement combo = driver.findElement(by);
	        Select s = new Select(combo);
	        List<WebElement> itens = s.getOptions();

	        int numItens = itens.size() - 1;
	        WebElement elementoSelecionado = null;

	        do {
	            int numAleat = (int) (Math.random() * 150);
	            if (numAleat >= 1 && !(numAleat > numItens)) {
	                s.selectByIndex(numAleat);
	                break;
	            }

	        } while (true);
	    }
	 
	 public void limpaCampoPorId(String id) {
	   
	            driver.findElement(By.id(id)).clear();
	    }
	 
	
	 public void preencheCampoPorId(String id, String texto) {
	            limpaCampoPorId(id);
	        
	            driver.findElement(By.id(id)).sendKeys(texto);
 
	        }
	 

	
	

}
