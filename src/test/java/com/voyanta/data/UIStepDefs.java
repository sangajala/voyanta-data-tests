package com.voyanta.data;

import com.voyanta.data.pageobject.voyanta.SignInPageObject;
import com.voyanta.data.pageobject.voyanta.SimpleOnFailed;

import com.voyanta.data.pageobject.voyanta.pageobject.DataManager;
import com.voyanta.data.pageobject.voyanta.pageobject.UploadPage;
import com.voyanta.data.pageobject.voyanta.pageobject.VUtils;
import com.voyanta.data.utils.PropertiesLoader;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by sriramangajala on 10/07/2014.
 */
public class UIStepDefs {
    static String URL;
    static SignInPageObject signInPage;
    static WebDriver driver;
    static String propertiesFileName = "src/main/resources/";
    String fileName ;
    @Before
    public static void driverUp() throws MalformedURLException, InterruptedException {

////	   System.setProperty("webdriver.chrome.driver", "/Users/sriramangajala/Documents/Automated-UAT/voyanta-availablity-tests/src/main/resources/chromedriver 5");
//        driver=new FirefoxDriver();
////       System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chrome\\chromedriver.exe");
        Capabilities capabilities = DesiredCapabilities.firefox();
        System.out.println("Server URL is " + PropertiesLoader.getProperty("server"));
        driver = new RemoteWebDriver(new java.net.URL(PropertiesLoader.getProperty("server")),capabilities);

        URL = PropertiesLoader.getProperty("ui_url");
        driver.get(URL);
        signInPage=new SignInPageObject();
        PageFactory.initElements(driver, signInPage);
        signInPage.signIn(PropertiesLoader.getProperty("username"), PropertiesLoader.getProperty("password"));
        System.out.print(System.getProperty("test_phase"));
//        signInPage.waitForFirstPageToLoad(driver,(By.className("QvContent")));

    }

    @When("^user uploads the Data from 'UI' with file '(.*)'$")
    public void user_uploads_the_Data_from_UI(String fileName) throws Throwable {
        this.fileName = fileName;
        UploadPage uploadPage = new UploadPage();
        PageFactory.initElements(driver, uploadPage);
        driver.get(uploadPage.getURL());
        uploadPage.selectFiles(PropertiesLoader.getProperty("windows_boxFolder")+PropertiesLoader.getProperty("windows_testDataFolder")+fileName);

        uploadPage.save();

        VUtils.waitFor(10);

    }

    @When("^it also passed through the Validation and Approval$")
    public void the_uploaded_file_is() throws Throwable {
        DataManager dataManager = new DataManager();
        PageFactory.initElements(driver, dataManager);

        dataManager.go_to_History();
        Assert.assertTrue("Uploading failed as no file present history tab",driver.findElement(By.xpath("//div[@id='list-table-holder']/table/tbody/tr")).getText().contains(fileName));
        Assert.assertTrue("File found but not the latest one",driver.findElement(By.xpath("//div[@id='list-table-holder']/table/tbody/tr")).getText().contains("secs"));
        Assert.assertTrue("File uploaded but not Approved",driver.findElement(By.xpath("//div[@id='list-table-holder']/table/tbody/tr")).getText().contains("Approved"));
    }

    @After
    public static void tearDown(){
        driver.close();
        driver.quit();
        driver=null;
    }

}
