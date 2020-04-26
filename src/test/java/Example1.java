import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void ExampleTest() {
        //Задача:
        //В тесте открыть OTUS.ru, найти WebElement (и что-нибудь с ним , поставить тест на паузу\breakpoint, перезагрузить страницу и снова использовать этот элемент
        driver.get("https://otus.ru");
        WebElement newEl = driver.findElement(By.xpath("//div[@class='header2__logo-img']"));
        driver.navigate().refresh();
        newEl.click();
    }

}
