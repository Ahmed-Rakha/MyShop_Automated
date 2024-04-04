package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

public class SearchBrokenURLs {

    private final WebDriver driver;

    public SearchBrokenURLs(WebDriver driver) {
        this.driver = driver;
    }

    public void createListOfBrokenAnchors() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("URL is Empty");
                continue;
            }
            try {
                HttpURLConnection cn = (HttpURLConnection) new URL(url).openConnection();
                cn.setRequestMethod("HEAD");
                cn.connect();
                int res = cn.getResponseCode();
                if(res >= 400 ){
                    System.out.println("Http response code for " + url + ": " + res + " ---> is Broken");
                }
                cn.disconnect(); // Close the connection

            } catch (MalformedURLException e) {
                System.out.println("Malformed URL: " + url);
            } catch (ProtocolException e) {
                System.out.println("Protocol error for URL: " + url);
            } catch (Exception e) {
                System.out.println("Error occurred while checking URL: " + url);
            }
        }
    }
}
