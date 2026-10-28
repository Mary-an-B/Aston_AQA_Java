import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    private final WebDriver driver;
    private final By titleLocator = By.xpath("//h2[contains(normalize-space(), 'Онлайн пополнение без комиссии')]");
    private final By logo1Locator = By.xpath("//img[@alt='Visa']");
    private final By logo2Locator = By.xpath("//img[contains(@alt, 'Verified By Visa')]");
    private final By logo3Locator = By.xpath("//img[@alt='MasterCard']");
    private final By logo4Locator = By.xpath("//img[contains(@alt, 'MasterCard Secure Code')]");
    private final By logo5Locator = By.xpath("//img[contains(@alt, 'Белкарт')]");
    private final By linkServiceLocator = By.linkText("Подробнее о сервисе");
    private final By inputConnectionPhoneLocator = By.xpath("//input[@id='connection-phone']");
    private final By inputConnectionSumLocator = By.xpath("//input[@id='connection-sum']");
    private final By buttonLocator = By.xpath("//form[@id='pay-connection']//button");
    private final By inputCardLocator = By.xpath("//input[@id='cc-number']");
    private final By placeholderConnectionPhoneLocator = By.xpath("//input[@id='connection-phone']");
    private final By placeholderConnectionSumLocator = By.xpath("//input[@id='connection-sum']");
    private final By placeholderConnectionEmailLocator = By.xpath("//input[@id='connection-email']");
    private final By paymentTypeLocator = By.xpath("//button[@class='select__header']");
    private final By placeholderInternetPhoneLocator = By.xpath("//input[@id='internet-phone']");
    private final By placeholderInternetSumLocator = By.xpath("//input[@id='internet-sum']");
    private final By placeholderInternetEmailLocator = By.xpath("//input[@id='internet-email']");
    private final By placeholderInstallmentScoreLocator = By.xpath("//input[@id='score-instalment']");
    private final By placeholderInstallmentSumLocator = By.xpath("//input[@id='instalment-sum']");
    private final By placeholderInstallmentEmailLocator = By.xpath("//input[@id='instalment-email']");
    private final By placeholderArrearsScoreLocator = By.xpath("//input[@id='score-arrears']");
    private final By placeholderArrearsSumLocator = By.xpath("//input[@id='arrears-sum']");
    private final By placeholderArrearsEmailLocator = By.xpath("//input[@id='arrears-email']");
    private final By paymentCostLocator = By.xpath("//span[@class='ng-star-inserted']");
    private final By phoneNumberLocator = By.cssSelector("div.pay-description__text");
    private final By paymentButtonLocator = By.cssSelector("button[type='submit']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получение заголовка блока онлайн-пополнения")
    public String getTitleOnlinePayText() {
        WebElement title = driver.findElement(titleLocator);
        return title.getText().replaceAll("\\s+", " ").trim();
    }

    @Step("Получение названий логотипов платежных систем")
    public String[] getLogoPayment() {
        String[] logos = new String[5];
        logos[0] = driver.findElement(logo1Locator).getAttribute("alt");
        logos[1] = driver.findElement(logo2Locator).getAttribute("alt");
        logos[2] = driver.findElement(logo3Locator).getAttribute("alt");
        logos[3] = driver.findElement(logo4Locator).getAttribute("alt");
        logos[4] = driver.findElement(logo5Locator).getAttribute("alt");
        return logos;
    }

    @Step("Переход по ссылке Подробнее о сервисе")
    public void clickServiceDetailsLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(linkServiceLocator));
        link.click();
    }

    @Step("Заполнение формы и переход к оплате")
    public void fillPaymentFormAndContinue(String phoneNumber, String amount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input1 = wait.until(ExpectedConditions.elementToBeClickable(inputConnectionPhoneLocator));
        input1.clear();
        input1.sendKeys(phoneNumber);
        WebElement input2 = wait.until(ExpectedConditions.elementToBeClickable(inputConnectionSumLocator));
        input2.clear();
        input2.sendKeys(amount);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));
        button.click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.payment-widget-iframe")));
    }

    public boolean isCardFieldDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputCardLocator));
        return true;
    }

    public String[] getPlaceholders(By phoneLocator, By sumLocator, By emailLocator) {
        String[] placeholders = new String[3];
        placeholders[0] = driver.findElement(phoneLocator).getAttribute("placeholder");
        placeholders[1] = driver.findElement(sumLocator).getAttribute("placeholder");
        placeholders[2] = driver.findElement(emailLocator).getAttribute("placeholder");
        return placeholders;
    }

    @Step("Выбор типа платежа")
    public void switchingPaymentType(String paymentType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(paymentTypeLocator));
        dropdown.click();
        WebElement string = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='select__option' and contains(text(), '" + paymentType + "')]")));
        string.click();
    }

    @Step("Получение подсказок полей Услуги связи")
    public String[] getPlaceholderConnection() {
        return getPlaceholders(
                placeholderConnectionPhoneLocator,
                placeholderConnectionSumLocator,
                placeholderConnectionEmailLocator
        );
    }

    @Step("Получение подсказок полей Домашний интернет")
    public String[] getPlaceholderInternet() {
        return getPlaceholders(
                placeholderInternetPhoneLocator,
                placeholderInternetSumLocator,
                placeholderInternetEmailLocator
        );
    }

    @Step("Получение подсказок полей Рассрочка")
    public String[] getPlaceholderInstallment() {
        return getPlaceholders(
                placeholderInstallmentScoreLocator,
                placeholderInstallmentSumLocator,
                placeholderInstallmentEmailLocator
        );
    }

    @Step("Получение подсказок полей Задолженность")
    public String[] getPlaceholderArrears() {
        return getPlaceholders(
                placeholderArrearsScoreLocator,
                placeholderArrearsSumLocator,
                placeholderArrearsEmailLocator
        );
    }
    @Step("Получение текста суммы платежа в форме оплаты")
    public String getPaymentCost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentCost = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentCostLocator));
        return paymentCost.getText();
    }

    @Step("Получение номера телефона в форме оплаты")
    public String getPhoneNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberLocator));
        return phoneNumber.getText();
    }

    @Step("Получение текста кнопки оплаты")
    public String getPaymentButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentButtonLocator));
        return paymentButton.getText();
    }

}