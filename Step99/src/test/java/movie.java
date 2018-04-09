import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class movie {

    public WebDriver driver;
    public String APP_URL = System.getenv("APP_ENDPOINT");

    @BeforeStep
    public void StepUpDriver() {
        driver = DriverFactory.getDriver();
    }

    @Step("open movie in Baidu")
    public void openMovieInBaidu() throws InterruptedException {
        driver.get(APP_URL + "/movie");
        Thread.sleep(2000);
    }
}
