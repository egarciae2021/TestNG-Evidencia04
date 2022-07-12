package com.xmartlabs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ValidarDecimalesTEST {

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
        waiter(1000);
        WebElement Tecla_nueve = driver.findElement(By.id("nine"));
        Tecla_nueve.click();
        waiter(1000);
        WebElement Tecla_punt = driver.findElement(By.id("dot"));
        Tecla_punt.click();
        waiter(1000);
        WebElement Tecla_seis =  driver.findElement(By.id("six"));
        Tecla_seis.click();

        WebElement Caja_resultado = driver.findElement(By.id("display"));
        String Resultado = Caja_resultado.getAttribute("value");

        String resul_esperado = "59.6";
        if(Resultado.equalsIgnoreCase(resul_esperado))
        {
            System.out.println("Si permite registrar decimales");
            waiter(3000);
        }
        else{
            System.out.println("Hubo un error registrando decimales");
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
