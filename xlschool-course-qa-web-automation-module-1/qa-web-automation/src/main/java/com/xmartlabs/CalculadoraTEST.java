package com.xmartlabs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.sql.SQLOutput;

public class CalculadoraTEST {

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
        driver.get("https://web2.0calc.es/");
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
        waiter(3000);
        WebElement Boton_n7 = driver.findElement(By.id("Btn7"));
        Boton_n7.click();
        waiter(2000);
        WebElement BtnPlus = driver.findElement(By.id("BtnPlus"));
        BtnPlus.click();
        waiter(2000);
        WebElement Boton_n9 = driver.findElement(By.id("Btn9"));
        Boton_n9.click();
        waiter(2000);
        WebElement BtnCalc = driver.findElement(By.id("BtnCalc"));
        BtnCalc.click();

        waiter(2000);
        WebElement Caja_resultado = driver.findElement(By.id("input"));
        String Resultado = Caja_resultado.getAttribute("value");

        String resul_esperado = "18";
        if(Resultado.equalsIgnoreCase(resul_esperado))
        {
            System.out.println("El resultado es correcto");
        }
        else{
            System.out.println("El resultado es incorrecto");
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
