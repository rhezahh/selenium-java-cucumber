package utilities;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.*;

public class DriverManager
{

    public void setUp(String browserName)
    {
        //Create an instance of ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            chromeOptions.setExperimentalOption("prefs", prefs);
            chromeOptions.addArguments("--incognito");
            ThreadManager.setDriver(new ChromeDriver(chromeOptions));
        }
        else {
                throw new IllegalArgumentException("Please specify valid browser name.");
        }

        ThreadManager.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ThreadManager.getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGELOAD_WAIT_DURATION, TimeUnit.SECONDS);
        ThreadManager.getDriver().manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        ThreadManager.getDriver().manage().window().maximize();
    }

    public void tearDown()
    {
        if(ThreadManager.getDriver()!=null)
        {
            ThreadManager.getDriver().quit();
        }
    }
}