import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Principal {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com.br");
		

	}

}
