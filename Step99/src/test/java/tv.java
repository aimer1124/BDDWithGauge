import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class tv {
    public String APP_URL = System.getenv("APP_ENDPOINT");
    public WebDriver driver;

    @BeforeStep
    public void StepUpDriver() {
        driver = DriverFactory.getDriver();
    }

    @Step("Open TV in Baidu")
    public void OpenProductListURL() throws InterruptedException {
        driver.get(APP_URL + "/tv");
        Thread.sleep(5000);
    }

}

