import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example2 {
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
//Открыть https://google.com , найти поле ввода и:
//Получить его атрибут class
//Ввести тест “Hello world”
//Получить его размеры
//*Для экстремалов: изменить атрибут (загуглить как)
    @Test
    public void ExampleTest() {
        driver.get("https://google.com");
        WebElement searchInput = driver.findElement(By.xpath("//input[@name='q']"));
        System.out.println(searchInput.getAttribute("class"));
        searchInput.sendKeys("Hello, World!");
        System.out.println(searchInput.getSize());
    }

}
