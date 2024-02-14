package utilities;

import globals.Globals;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
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
    public String getScreenShot(String testCaseName) throws IOException{
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports//"+ testCaseName +".png";
    }

}
