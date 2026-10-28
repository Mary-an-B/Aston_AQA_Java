import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    PaymentPage paymentPage;
    String phoneNumber = "297777777";
    String amount = "100";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        paymentPage = new PaymentPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Отклонить']")));
        button.click();
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @DisplayName("Проверка заголовка блока онлайн-пополнения")
    @Description("Проверяет наличие заголовка 'Онлайн пополнение без комиссии'")
    @Test
    public void checkTitleOnlinePay() {
        String actual = paymentPage.getTitleOnlinePayText();
        String expected = "Онлайн пополнение без комиссии";
        assertEquals(expected.toLowerCase(), actual.toLowerCase());
    }

    @DisplayName("Проверка логотипов платежных систем")
    @Description("Проверяет наличие названий пяти платежных систем в атрибутах alt")
    @Test
    public void checkLogoPayment() {
        String[] logos = paymentPage.getLogoPayment();
        assertAll(
                () -> assertEquals("Visa", logos[0]),
                () -> assertEquals("Verified By Visa", logos[1]),
                () -> assertEquals("MasterCard", logos[2]),
                () -> assertEquals("MasterCard Secure Code", logos[3]),
                () -> assertEquals("Белкарт", logos[4])
        );
    }

    @DisplayName("Проверка ссылки Подробнее о сервисе")
    @Description("Проверяет, что ссылка 'Подробнее о сервисе' открывает страницу с информацией о порядке оплаты и безопасности интернет-платежей")
    @Test
    public void checkServiceDetailsLink() {
        paymentPage.clickServiceDetailsLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }
    @DisplayName("Проверка работы кнопки Продолжить")
    @Description("Проверяет переход к оплате после заполнения номера телефона и суммы")
    @Test
    public void checkButtonContinue() {
        paymentPage.fillPaymentFormAndContinue(phoneNumber, amount);
        assertTrue(paymentPage.isCardFieldDisplayed());
    }

    @DisplayName("Проверка подсказок полей Услуги связи")
    @Description("Проверяет значения подсказок для полей номер телефона, суммы и e-mail в блоке Услуги связи")
    @Test
    public void checkPlaceholderConnection() {
        String[] placeholders = paymentPage.getPlaceholderConnection();
        assertAll(
                () -> assertEquals("Номер телефона", placeholders[0]),
                () -> assertEquals("Сумма", placeholders[1]),
                () -> assertEquals("E-mail для отправки чека", placeholders[2])
        );
    }

    @DisplayName("Проверка подсказок полей Домашний интернет")
    @Description("Проверяет значения подсказок для полей номер абонента, суммы и e-mail в блоке Домашний интернет")
    @Test
    public void checkPlaceholderInternet() {
        paymentPage.switchingPaymentType("Домашний интернет");
        String[] placeholders = paymentPage.getPlaceholderInternet();
        assertAll(
                () -> assertEquals("Номер абонента", placeholders[0]),
                () -> assertEquals("Сумма", placeholders[1]),
                () -> assertEquals("E-mail для отправки чека", placeholders[2])
        );
    }

    @DisplayName("Проверка подсказок полей Рассрочка")
    @Description("Проверяет значения подсказок для полей номер счета, суммы и e-mail в блоке Рассрочка")
    @Test
    public void checkPlaceholderInstallment() {
        paymentPage.switchingPaymentType("Рассрочка");
        String[] placeholders = paymentPage.getPlaceholderInstallment();
        assertAll(
                () -> assertEquals("Номер счета на 44", placeholders[0]),
                () -> assertEquals("Сумма", placeholders[1]),
                () -> assertEquals("E-mail для отправки чека", placeholders[2])
        );
    }

    @DisplayName("Проверка подсказок полей Задолженность")
    @Description("Проверяет значения подсказок для полей номер счета, суммы и e-mail в блоке Задолженность")
    @Test
    public void checkPlaceholderArrears() {
        paymentPage.switchingPaymentType("Задолженность");
        String[] placeholders = paymentPage.getPlaceholderArrears();
        assertAll(
                () -> assertEquals("Номер счета на 2073", placeholders[0]),
                () -> assertEquals("Сумма", placeholders[1]),
                () -> assertEquals("E-mail для отправки чека", placeholders[2])
        );
    }

    @DisplayName("Проверка информации о платеже")
    @Description("Проверяет отображение суммы платежа, номера телефона и текста кнопки оплаты после заполнения формы")
    @Test
    public void checkPaymentInfo() {
        paymentPage.fillPaymentFormAndContinue(phoneNumber, amount);
        assertAll(
                () -> assertTrue(paymentPage.getPaymentCost().contains(amount)),
                () -> assertTrue(paymentPage.getPhoneNumber().contains(phoneNumber)),
                () -> assertTrue(paymentPage.getPaymentButtonText().contains(amount))
        );
    }
}