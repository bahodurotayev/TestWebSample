package runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.*;
import utils.ThreadLocalBaseDriver;

@CucumberOptions(
        plugin = {
                "html:target/cucumber-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent_report/index.html" // extent report plugin
        },
        features = {
                "src/test/java/features/logpage.feature"
        },
        glue = {"stepDef"} ,// tell cucumber where to look for step definitions
        dryRun = false
)
    public class LoginRunner extends AbstractTestNGCucumberTests {

    @Parameters("browser")
    @BeforeClass
    public void configureBrowser(@Optional("chrome") String browser) {
        ThreadLocalBaseDriver.setBrowser(browser);
    }


        @AfterClass
        public void configReport(){
            Reporter.loadXMLConfig("src/main/java/runner/reportConfig/report.xml");
            Reporter.setSystemInfo("Author", "NewYorkCompus");
            Reporter.setSystemInfo("Application name", "Payee");
            Reporter.setSystemInfo("Operating System", System.getProperty("os.name"));
            Reporter.setSystemInfo("Environment", "test");

    }
}
