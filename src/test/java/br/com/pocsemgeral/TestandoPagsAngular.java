package br.com.pocsemgeral;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

// Lembrando que nativamente o protractor tem recursos assincronos e insere esperas automaticamente na pagina sem uso de comando
public class TestandoPagsAngular {
	 static WebDriver driver;
	 static NgWebDriver ngdriver;
	 
	 @Before
	 public void setUp(){
		 
	  // Apontando caminho relativo no projeto para execucao dos drivers
      System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	 }
	  
	 @Test
	 public void pag1() throws InterruptedException{
	  //Chamando uma pagina em angular e maximizando naveg
	  driver.get("https://hello-angularjs.appspot.com/sorttablecolumn");

	  // Criando uma instancia de objeto do NgWebDriver que simula algumas atuacoes do Protractor passando driver com casting JS para o controle
	  ngdriver = new NgWebDriver((JavascriptExecutor) driver);
	  
	  // Interagindo com elementos da pagina usando o driver porem incrementando recursos do angular internamente
	  driver.findElement(ByAngular.model("name")).sendKeys("Test Company");
	  driver.findElement(ByAngular.model("employees")).sendKeys("1000");
	  driver.findElement(ByAngular.model("headoffice")).sendKeys("Mysore");
	  driver.findElement(ByAngular.buttonText("Submit")).click();
	  
	  // Atribuindo espera e recebendo texto do elemento especifico na 4 linha e coluna nome
	  Thread.sleep(2000);
	  String txt = driver.findElement(ByAngular.repeater("company in companies").row(4).column("name")).getText();
	  // Informando texto
	  System.out.println(txt + " Added.");
	  
	  // Valida se texto obtido e igual ao passado 
	  // Se sim ja imprime texto de ocorrencia na console e interage com demais elementos na pag angular
	  if(txt.equalsIgnoreCase("Test Company")){
	   System.out.println("New Company Added. Now remove it");
	   driver.findElement(ByAngular.repeater("company in companies").row(4)).findElement(ByAngular.buttonText("Remove")).click();
	  }

	   // Aguarda e fecha navegador
	   Thread.sleep(3000); 
	 }
	 
	 @Test
	 public void pag2(){
         driver.get("http://juliemr.github.io/protractor-demo/");
         ngdriver = new NgWebDriver((JavascriptExecutor) driver);
         ngdriver.waitForAngularRequestsToFinish();
         driver.findElement(ByAngular.model("first")).sendKeys("2");
         driver.findElement(ByAngular.model("second")).sendKeys("2");
         //driver.findElement(By.id("gobutton")).click();
         driver.findElement(ByAngular.buttonText("Go!")).click();
	 }
	 
	 @After
	 public void tearDown (){
		 driver.quit();
	 }
	
	
// Refs 
// https://advancedtestautomation.blogspot.com.br/2017/05/selenium-for-angular-js-pages.html
// http://qavalidation.com/2017/10/ngwebdriver-way-automate-angular-apps-selenium-using-java.html/
}
