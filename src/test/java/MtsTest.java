import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Отклонить']")));
        button.click();
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void checkTitleOnlinePay() {
        WebElement title = driver.findElement(By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]"));
        String actual = title.getText().replaceAll("\\s+", " ").trim();
        String expected = "Онлайн пополнение без комиссии";
        assertEquals(expected.toLowerCase(), actual.toLowerCase());
    }

    @Test
    public void checkLogoPayment() {
        WebElement logo1 = driver.findElement(By.xpath("//img[@alt='Visa']"));
        WebElement logo2 = driver.findElement(By.xpath("//img[contains(@alt, 'Verified By Visa')]"));
        WebElement logo3 = driver.findElement(By.xpath("//img[@alt='MasterCard']"));
        WebElement logo4 = driver.findElement(By.xpath("//img[contains(@alt, 'MasterCard Secure Code')]"));
        WebElement logo5 = driver.findElement(By.xpath("//img[contains(@alt, 'Белкарт')]"));
        assertAll(
                () -> assertEquals("Visa", logo1.getAttribute("alt")),
                () -> assertEquals("Verified By Visa", logo2.getAttribute("alt")),
                () -> assertEquals("MasterCard", logo3.getAttribute("alt")),
                () -> assertEquals("MasterCard Secure Code", logo4.getAttribute("alt")),
                () -> assertEquals("Белкарт", logo5.getAttribute("alt"))
        );
    }

    @Test
    public void checkServiceDetailsLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Отклонить']")));
//        button.click();
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));
        link.click();
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    public void checkButtonContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='connection-phone']")));
        input1.clear();
        input1.sendKeys("297777777");
        WebElement input2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='connection-sum']")));
        input2.clear();
        input2.sendKeys("100");
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='pay-connection']//button")));
        button.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.payment-widget-iframe")));
        WebElement inputCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='cc-number']")));
        assertTrue(inputCard.isDisplayed());
    }
}
