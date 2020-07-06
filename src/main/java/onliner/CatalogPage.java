package onliner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage {

    private WebDriver webDriver;

    public CatalogPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//li[@data-id = '1']")
    private WebElement electronicsButton;

    @FindBy(xpath = "(//div[@class= 'catalog-navigation-list__aside-title'])[1]")
    private WebElement mobilePhonesLine;

    @FindBy(xpath = "(//a[@href ='https://catalog.onliner.by/mobile'])[1]")
    private WebElement mobilephoneIcon;


    public MobilePhonePage goToMobilePhones(){
        electronicsButton.click();
        mobilePhonesLine.click();
        mobilephoneIcon.click();
        return new MobilePhonePage(webDriver);
    }


}
