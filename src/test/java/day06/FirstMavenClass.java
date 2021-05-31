package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.get("http://amazon.com");

        WebElement aramaKutusu =driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        //4- Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazdirWebElementi = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazdirWebElementi.getText());

        Thread.sleep(5000);
        //sadece sonuc adedini istersek sonuc yazisini String'e atayip string manipulation yaparak ulasabiliriz.

        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        driver.navigate().back();
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for (WebElement each: basliklarListesi

        ){
            System.out.println(each.getText());
        }

        driver.close();


    }
}
