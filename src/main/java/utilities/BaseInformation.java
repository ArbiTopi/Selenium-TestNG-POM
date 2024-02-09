package utilities;

import globals.Globals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BaseInformation {
    private static WebDriver driver ;

    public static BaseInformation getBaseInformation(){
        return new BaseInformation();
    }


    public static WebDriver getDriver()  {


        if(driver==null) {
            String browserType = Globals.browserType.toLowerCase();

            switch (browserType) {

                case "chrome" -> {
                    System.setProperty("webdriver.chrom.driver", "src/main/resources/chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();

                }

                case "firefox" -> {
                    System.out.println("Do nothing ");
                }
            }
        }

        return driver;
    }

}
