package Utils;

import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    Properties pro;

    public ConfigReader() {
        try {
            File src = new File("./Configuration/config.property");
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            Reporter.log("Exception is =="+e.getMessage());
        }
    }

    public String getUrl() {
        String urlPath = pro.getProperty("url");
        return urlPath;
    }

    public String getBrowserName() {
        return pro.getProperty("browserNmae");
    }

    public String getDeviceName() {
        return pro.getProperty("deviceName");
    }

    public String getPlatformName() {
        return pro.getProperty("platformName");
    }

    public String getPlatformVersion() {
        return pro.getProperty("platformVersion");
    }

    public String getAppPackage() {
        return pro.getProperty("appPackage");
    }

    public String getAppActivity() {
        return pro.getProperty("appActivity");
    }

    public String getudid() {
        return pro.getProperty("udid");
    }

}
