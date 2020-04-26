import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Example3 {
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
//Открыть https://otus.ru, кнопку «Принять участие» и
//Вывести на экран значение «отображается ли он»? (isDisplay())
//Вывести на экран «доступен ли он»? (isEnabled)
    @Test
    public void ExampleTest() {
        driver.get("https://otus.ru");
        WebElement button = driver.findElement(By.xpath("//a[@class='inline-block button button_red-stripe hide-md js-event-click']"));
        driver.manage().window().maximize();
        System.out.println(button.isDisplayed());
        System.out.println(button.isEnabled());
    }

}
