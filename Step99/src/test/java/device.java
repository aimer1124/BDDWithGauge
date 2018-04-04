import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class device {

    public WebDriver driver;

    @BeforeStep
    public void StepUpDriver() {
        driver = DriverFactory.getDriver();
    }

    @Step("open zhihuHomePage")
    public void openZhihuHomePage() throws InterruptedException {
        driver.get("http://www.zhihu.com");
        Thread.sleep(2000);
    }
}
