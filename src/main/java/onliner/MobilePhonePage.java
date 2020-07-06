package onliner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobilePhonePage {

    private WebDriver webDriver;

    public MobilePhonePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//ul[@class = 'schema-filter__list']//span[text() = 'Apple']")
    private WebElement appleCheckPoint;

    @FindBy(xpath = "(//div[@class = 'schema-product__price'])[1]")
    private WebElement priceLink;

    @FindBy(xpath = "//h1[@class = 'schema-header__title']")
    private WebElement titleSearchText;

    public MobilePhonePage selectApplePhone() {
        Util.scrollToElement(webDriver, appleCheckPoint);
        appleCheckPoint.click();
        return new MobilePhonePage(webDriver);
    }

    public double getFirstPriceMobile(String testName) {
        Util.scrollToElement(webDriver, titleSearchText);
        Util.takeScreenshot(webDriver, titleSearchText, testName);
        return Util.getInteger(priceLink.getText());
    }

}
