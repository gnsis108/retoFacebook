package org.fb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement Find(String locator, String locatorType) {
        if (locatorType.equalsIgnoreCase("id")) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        } else {
            throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
    }

    public String obtenerTexto(String locator, String locatorType) {
        return Find(locator, locatorType).getText().trim();
    }

    public void clickElement(String locator, String locatorType) {
        Find(locator, locatorType).click();
    }

    public void write(String locator, String locatorType, String keysToSend) {
        Find(locator, locatorType).clear();
        Find(locator, locatorType).sendKeys(keysToSend);
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
