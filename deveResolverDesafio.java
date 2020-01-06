package br.liegeLopes.cursoAppium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class deveResolverDesafio {

    AndroidDriver driver;

    @Before
    private void inicializa() throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
        desiredCapabilities.setCapability("appPackage", "com.ctappium");


        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    @Test

    public void formulario() throws MalformedURLException {

        //encontrar formulário
        List elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
        for (Object Elemento: elementosEncontrados){
            System.out.println(Elemento.getText());
        }
        elementosEncontrados.get(1).click();

        //escrever nome
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("nome");
        el2.sendKeys("Liege Lopes");
        String text = el2.getText();
        Assert.assertEquals("Liege Lopes", text);

        MobileElement el3 = (MobileElement) driver.findElementById("android:id/text1");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("check");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByXPath("//android.widget.Button[@content-desc=\"save\"]/android.widget.TextView");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView");
        el7.click();

        driver.quit();

    }


    }
}
