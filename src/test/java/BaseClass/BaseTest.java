package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public String OsmosSellerUrl = "https://osmos-qa-staging-1.onlinesales.ai/";
    public String OsmosPulseUrl = "https://osmos-qa-staging-2.onlinesales.ai/";
    public String OsmosPulseUrlSandbox = "https://osmos-sandbox-pulse.onlinesales.ai/";
    public String PulseUrl = "https://oms-qa-staging-2.onlinesales.ai/";
    public String TvingSellerUrl = "https://oms-qa-staging-1.onlinesales.ai/";
    public String BillingURL = "https://monetize-staging-4.onlinesales.ai/dashboard";

    public String UserName = "ankit@frugaltesting.com";
    public String Password = "Frugal@123";
    public String Language = "en";

    public void Setup() {

        if (System.getProperty("BillingUrl") != null)
            BillingURL = System.getProperty("BillingUrl");

        if (System.getProperty("OsmosSellerUrl") != null)
            OsmosSellerUrl = System.getProperty("OsmosSellerUrl");

        if (System.getProperty("OsmosPulseUrl") != null)
            OsmosPulseUrl = System.getProperty("OsmosPulseUrl");

        if (System.getProperty("TivingSellerUrl") != null)
            TvingSellerUrl = System.getProperty("TivingSellerUrl");

        if (System.getProperty("PulseUrl") != null)
            PulseUrl = System.getProperty("PulseUrl");

        if (System.getProperty("Language") != null)
            Language = System.getProperty("Language");


        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1280,720");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors");
        if (!Language.equals("en")) {
            options.addArguments("--lang=" + Language);
        }
        driver.set(new ChromeDriver(options));
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeSuite()
    public void setupEnvironment() throws IOException {

        File allureResultsDir = new File("allure-results");

        if (allureResultsDir.exists())
            deleteDirectory(allureResultsDir);

        allureResultsDir.mkdir();

        Properties props = new Properties();
        props.setProperty("Osmos Seller Url", OsmosSellerUrl);
        props.setProperty("Osmos Pulse Url", OsmosPulseUrl);
        props.setProperty("Pulse Url", PulseUrl);
        props.setProperty("Tving Seller Url", TvingSellerUrl);
        props.setProperty("Platform", System.getProperty("os.name"));

        try (FileWriter writer = new FileWriter("allure-results" + File.separator + "environment.properties")) {
            props.store(writer, "Test Environment Details");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
