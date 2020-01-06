package br.liegeLopes.cursoAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class calculadoraTeste {

    @Test
    public void deveSomarDoisValores() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");


        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        MobileElement el2 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_4");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("plus");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("equals");
        el5.click();

        System.out.println(el5.getText());
        Assert.assertEquals("=", el5.getText());

        driver.quit();

    }
}
