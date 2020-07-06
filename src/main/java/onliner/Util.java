package onliner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static final String SCREENSHOT_PATH = "C:\\Screenhots\\";

    public static void takeScreenshot(WebDriver webDriver, WebElement webElement, String testName) {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ss_mm_hh");
        String fileName = testName + "_Kvach_" + format.format(date) + ".png";

        WebDriverWait wait = (new WebDriverWait(webDriver, 10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(SCREENSHOT_PATH + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToElement(WebDriver webDriver, WebElement webElement) {

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);

        if (!webElement.isDisplayed()) {
            throw new RuntimeException("Element " + webElement + " not Displayed");
        }
    }

    public static Double getInteger(String string) {

        Pattern pat = Pattern.compile("[-]?[0-9]+(.,[0-9]+)?");
        Matcher matcher = pat.matcher(string);
        Double result = 0.00d;
        if (matcher.find()) {
            result = Double.parseDouble(matcher.group());
        } else {
            throw new RuntimeException("Not Found digital expression in - " + string);
        }
        return result;
    }

}
