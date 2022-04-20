import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Document document = Jsoup.connect("https://www.litres.ru/knigi-nauka-obrazovanie/ekonomika/").get();
        Elements elements = document.getElementsByClass("art__name__href").select("a[href]");

        List<String> links = new ArrayList<>();
        for (Element e : elements) {
            links.add(e.attr("href"));
        }
        System.setProperty("webdriver.chrome.driver", "selenium\\chromedriver.exe");

        for (int i = 0; i < links.size(); i++) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.litres.ru" + links.get(i));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, 10);

            //  WebElement nowLink = driver.findElement(By.xpath("//button[contains(@class,'ReviewsLoader-module__loadMore')]"));
            boolean isTrue = true;
            while (isTrue) {
                try {

                    //WebElement nowLink = driver.findElement(By.xpath("//div[contains(@class,'ReviewsLoader-module__loadMore')]//button"));
                    // nowLink.click();
                    WebElement nowLink = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//button[contains(@class,'ReviewsLoader-module__loadMore')]"))));

                    jse.executeScript("arguments[0].click()", nowLink);
                    // nowLink.click();
                    //nowLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ReviewsLoader-module__loadMore')]")));
                } catch (NoSuchElementException ex) {
                    isTrue = false;
                } catch (StaleElementReferenceException ex) {
                    isTrue = false;
                } catch (TimeoutException ex) {
                    isTrue = false;
                }
            }
            Thread.sleep(1000);


            List<WebElement> comments = driver.findElements(By.xpath("//article[contains(@class,'Comment-module__comment')]"));

            for (int j = 0; j < comments.size(); j++) {
                System.out.println(comments.get(j).getText() + " НОМЕР КОММЕНТА " + (j + 1));
            }
            Thread.sleep(comments.size() * 10);

            driver.close();
        }


    }
}
