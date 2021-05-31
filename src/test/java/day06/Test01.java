package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {

    /*
    * 1-Test01 isimli bir class olusturun
2- https://www.walmart.com/ adresine gidin
3- Browseri tam sayfa yapin
4-Sayfayi “refresh” yapin
5- Sayfa basliginin “Save” ifadesi icerdigini control edin
6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
7- URL in walmart.com icerdigini control edin
8-”Nutella” icin arama yapiniz
9- Kac sonuc bulundugunu yaziniz
10-Sayfayi kapatin*/
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        driver.get("http://walmart.com/");

        driver.navigate().refresh();


        String baslik = driver.getTitle();

        if (baslik.contains("Save")){
            System.out.println("save iceriyor");
        }else{
            System.out.println("save icermiyor");
        }

        String baslik01 = driver.getTitle();

        if (baslik01.contains("Walmart.com | Save Money.Live Better")){
            System.out.println("verilen degere esittir.");
        }else{
            System.out.println("verilen degere esit degildir.");


            String url = driver.getCurrentUrl();

            if (url.contains("walmart.com")){
                System.out.println("walmart.com iceriyor");
            }else{
                System.out.println("walmart.com icermiyor");
            }

            WebElement search = driver.findElement(By.xpath("(//input[@type='text'])[2]"));

            search.click();

            search.sendKeys("Nutella");
            search.submit();


            WebElement aramasonuclari = driver.findElement(By.xpath("(//div[@class='result-summary-container'])"));

            System.out.println(aramasonuclari);

            driver.close();


        }
}
}
