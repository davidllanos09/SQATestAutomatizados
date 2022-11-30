package AutomatizacionTest;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PVN_008 {
private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8000/");
	}

	@Test
	public void test() {
		BaseTest();
		FormularioPrecioViabilidadDeNegocio();
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	public void BaseTest() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("student@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("12345678");
		
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();
	}
	
	Hashtable<String, Integer> datos = new Hashtable<String, Integer>();
	public void LoadData() {
		datos.put(null, null);
	}
	
	public void FormularioPrecioViabilidadDeNegocio() {
		driver.get("http://localhost:8000/form5");
		WebElement btnGuardar = driver.findElement(By.id("btnGuardar"));
		WebElement btnFinally = driver.findElement(By.id("btnFinally"));
		List<WebElement> listaElementos = new ArrayList<WebElement>();
		//CargarElementos
		for(int i = 1 ; i <= 24; i++){
			listaElementos.add(driver.findElement(By.id("input"+i)));
		}
		//FinCargarElementos
		for(int i = 0; i < listaElementos.size(); i++) {
			if(i<=3) {
				listaElementos.get(i).click();
			}else if(i>=4 && i <=11){
				listaElementos.get(i).click();
			}else if (i>=12 && i <=13) {
				listaElementos.get(i).sendKeys("Estos Son Valores Para Test");
			}else if (i==14) {
				listaElementos.get(i).sendKeys("100");	
			}else if (i>=15 && i<=18) {
				listaElementos.get(i).sendKeys("10");
			}else {
				listaElementos.get(i).sendKeys("Estos Son Valores Para Test");
			}
		}
		btnGuardar.click();
		
	}
}
