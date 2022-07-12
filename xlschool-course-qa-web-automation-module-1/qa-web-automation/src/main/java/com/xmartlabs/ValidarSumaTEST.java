package com.xmartlabs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ValidarSumaTEST {

    private  WebDriver driver;

    @BeforeSuite
    public void IniciandoSuite(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        System.setProperty("webdriver.chrome.driver", "PathChromeDriver" +
                "\\chromedriver.exe");
        System.out.println("Iniciando la SUITE");
    }

    @BeforeMethod
    public void IniciandoTest(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://apiflutter.azurewebsites.net/calculadora/Brandon-code96.github.io-main/calculadora/calculadora.html");
        driver.manage().window().maximize();
        System.out.println("Iniciando el Metodo");
    }

    @AfterSuite
    public void FinalizandoSuite(){
        driver.close();
        driver.quit();
        //driver.quit();
        System.out.println("Finalizando el Suite");
    }

    @AfterMethod
    public void FinalizandoTest(){
        System.out.println("Finalizando la Metodo");
    }
 
    @Test
    public  void PruebaTestNG() {
        waiter(2000);
        WebElement Tecla_cinco = driver.findElement(By.id("five"));
        Tecla_cinco.click();
        WebElement Tecla_suma = driver.findElement(By.id("add"));
        Tecla_suma.click();
        waiter(1000);
        WebElement Tecla_seis =  driver.findElement(By.id("six"));
        Tecla_seis.click();
        waiter(1000);
        WebElement Tecla_igual = driver.findElement(By.id("equal"));
        Tecla_igual.click();
        waiter(1000);
        WebElement Caja_resultado = driver.findElement(By.id("display"));
        String Resultado = Caja_resultado.getAttribute("value");

        String resul_esperado = "11";
        if(Resultado.equalsIgnoreCase(resul_esperado))
        {
            System.out.println("La suma fue exitosa");
            waiter(3000);
        }
        else{
            System.out.println("Hubo un error realizando la suma");
        }
    }
  
    public static void waiter(int pSeconds) {
        try {
            Thread.sleep(pSeconds);
        } catch (Exception e) {
            System.out.println("Algo ocurrió");
        }
    }
}
