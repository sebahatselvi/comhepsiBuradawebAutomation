package steps;

import com.hepsiburada.testautomation.util.BaseMethods;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseMethods {

    @Step("<url> adresine git")
    public void getUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Step("<key> elementine tıkla")
    public void elementeTikla(String key) {
        WebElement element = findElementByKey(key);
        clickToElement(element);
    }


    @Step("<key> elementine <value> değerini gir")
    public void sendToElement(String key, String value) {
        WebElement element = findElementByKey(key);
        elementineDegeriniGonder(element, value);

    }

    @Step("<key> saniye bekle")
    public void waitBysecond(int key) {
        waitBySeconds(key);
    }

    @Step("<key> elementinin textininin <text> olduğunu doğrula")
    public void getElementText(String key, String text) {
        WebElement element = findElementByKey(key);
        Assert.assertEquals(getElementText(element), text);

    }


}
