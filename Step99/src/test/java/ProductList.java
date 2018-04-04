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

public class ProductList {
    public String APP_URL = System.getenv("APP_ENDPOINT");
    public WebDriver driver;

    Date currentTime = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    public String product = "product" + sdf.format(currentTime);

    @BeforeStep
    public void StepUpDriver() {
        driver = DriverFactory.getDriver();
    }

    @Step("Open Product List URL")
    public void OpenProductListURL() throws InterruptedException {
//        driver.get(APP_URL + "/product");
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
    }

    @Step("Show Product List")
    public void ShowProductList() {
//        assertTrue(driver.findElement(By.className("has-gutter")).isDisplayed());
//        WebElement firstProduct = driver.findElements(By.className("product-name")).get(0);
//        assertTrue(firstProduct.isDisplayed());
        System.out.println("22");
    }

    @Step("Check Product Name")
    public void CheckListName() {
        List<WebElement> productList = driver.findElement(By.className("el-table__body-wrapper")).findElements(By.className("el-table__row"));
        assertTrue(productList.size() > 0);
        assertTrue(!productList.get(0).findElement(By.className("product-name")).getText().isEmpty());

    }

    @Step("Check Product ActionBtn")
    public void CheckProductActionBtn() {
        List<WebElement> productList = driver.findElement(By.className("el-table__body-wrapper")).findElements(By.className("el-table__row"));
        assertTrue(productList.get(0).findElement(By.className("button-selec111t")).isDisplayed());
    }

    @Step("Add Product")
    public void addProduct () throws InterruptedException {
        WebElement createProduct = driver.findElements(By.className("button-text")).get(0);
        createProduct.click();
        WebElement productName = driver.findElement(By.className("form-input"));
        productName.click();
        productName.sendKeys(product);
        WebElement productDescribe = driver.findElements(By.className("form-normal")).get(1);
        productDescribe.click();
        productDescribe.sendKeys("chanpinmiaosu");
        driver.findElement(By.className("popup-wrapper")).findElements(By.className("button")).get(1).click();
        driver.navigate().refresh();
        Thread.sleep(5000);
        List<WebElement> productList = driver.findElement(By.className("el-table__body-wrapper")).findElements(By.className("el-table__row"));
        assertTrue(productList.get(0).getText().contains(product));

    }


    }

