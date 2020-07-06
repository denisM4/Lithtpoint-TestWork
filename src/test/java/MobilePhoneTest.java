import onliner.CatalogPage;
import onliner.MainPage;
import onliner.MobilePhonePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MobilePhoneTest {

    private WebDriver webDriver;
    private MainPage mainPage;
    private MobilePhonePage mobilePhonePage;
    private CatalogPage catalogPage;
    private final static String URL = "https://www.onliner.by/";

    @Before
    public void setUp() {

        webDriver = new ChromeDriver();
        webDriver.get(URL);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().fullscreen();

        mainPage = PageFactory.initElements(webDriver, MainPage.class);
        mobilePhonePage = PageFactory.initElements(webDriver, MobilePhonePage.class);
        catalogPage = PageFactory.initElements(webDriver, CatalogPage.class);
    }

    @Test
    public void checkFirstPriceAppleByCatalog() {

        mainPage.catalogClick();
        catalogPage.goToMobilePhones();
        mobilePhonePage.selectApplePhone();
        double price = mobilePhonePage.getFirstPriceMobile("ByCatalog");
        Assert.assertTrue("First price = " + price, price > 100);
    }

    @Test
    public void checkFirstPriceAppleBySearchField() {

        mainPage.fillInSearchField("мобильные телефоны");
        mainPage.mobilePhonesClick();
        mobilePhonePage.selectApplePhone();
        double price = mobilePhonePage.getFirstPriceMobile("BySearchField");
        Assert.assertTrue("First price = " + price, price > 100);
    }

    @After
    public void close() {
        if (!webDriver.equals(null)) {
            webDriver.close();
        }
    }
}
