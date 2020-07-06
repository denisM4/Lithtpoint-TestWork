package onliner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@href = 'https://catalog.onliner.by/mobile']")
    private WebElement mobilePhoneLink;

    @FindBy(xpath = "//a[@href='https://catalog.onliner.by/']")
    private WebElement catalogLink;

    @FindBy(xpath = "//iframe[@class = 'modal-iframe']")
    private WebElement searchFrame;


    public MainPage fillInSearchField(String data) {

        searchField.sendKeys(Keys.SPACE);
        searchField.sendKeys(data);
        return new MainPage(webDriver);
    }

    public MobilePhonePage mobilePhonesClick() {

        webDriver.switchTo().frame(searchFrame);
        mobilePhoneLink.click();
        return new MobilePhonePage(webDriver);
    }

    public CatalogPage catalogClick(){
        catalogLink.click();
        return new CatalogPage(webDriver);
    }

}
