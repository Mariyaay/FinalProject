package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.io.IO;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestUtil extends DataProviders{
    public WebDriver driver;
    private String browser, targetURL;
    private int implicitWait;

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public  void setupDriverAndOpenTargetURL() throws InterruptedException {
        readConfig("src/test/resources/config.properties");
        setUpDriver();
        //Implicit wait:
        driver.manage().timeouts().implicitlyWait(Duration.from(Duration.ofSeconds(implicitWait)));
        driver.get(targetURL);
    }

    private void readConfig(String pathToFile){
        // working with a file
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            targetURL = properties.getProperty("url"); //hand over the key
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("wait")); //convert a string to an integer
        }catch (IOException e){ //if an unexpected problem occurs in IO operations
            System.out.println(e);
        }
    }

    private void setUpDriver(){
        switch (browser){
            case "firefox":
                //Execute if the variable is matched with the case
                driver = setupFireFoxDriver();
                break;
            default:
                //Execute if the variable is not matched with the case
                driver = setupChromeDriver();
        }
    }

    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }

    private WebDriver setupFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
