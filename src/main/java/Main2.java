import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.litres.ru/knigi-nauka-obrazovanie/ekonomika/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;  // пролистываем до кнопки список книг
//        while (true) {
//            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//            Thread.sleep(500);
//
//            if (driver.findElement(By.className("loader_button")).isDisplayed()) {
//                break;
//            }
//        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        var links = driver.findElements(By.xpath("//a[contains(@class, 'art__name__href')]"));

//            jse.executeScript("arguments[0].scrollIntoView()", showMore);
        for (int i = 0; i < links.size(); i++) {
            links.get(i).click();
            Thread.sleep(3000);
            WebElement nowLink = driver.findElement(By.xpath("//button[contains(@class,'ReviewsLoader-module__loadMore')]"));
            boolean isTrue= true;
            while (isTrue) {
                try {
                    nowLink.click();
                    nowLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ReviewsLoader-module__loadMore')]")));
                } catch (NoSuchElementException ex) {
                    isTrue = false;
                } catch (StaleElementReferenceException ex) {
                    isTrue = false;
                } catch (TimeoutException ex) {
                    isTrue = false;
                }
            }


            Thread.sleep(2000);

            List<WebElement> comments = driver.findElements(By.xpath("//article[contains(@class,'Comment-module__comment')]"));

            for (int j = 0; j < comments.size(); j++) {
                System.out.println(comments.get(j).getText() + "  " + j);
            }
            Thread.sleep(comments.size() * 10);

            for (WebElement comment : comments) {
                System.out.println(comment.findElement(By.xpath("//div[contains(@class,'Comment-module__userInfoWrap')]")).getText() +"\n" +
                        comment.findElement(By.xpath("//div[contains(@class, 'Comment-module__reviewText')]")).getText()+"\n\n");
            }

            jse.executeScript("window.history.go(-1)");
            //driver.navigate().back();
            links = driver.findElements(By.xpath("//a[contains(@class, 'art__name__href')]"));
        }

    }

    public static void printFeedback(WebDriver driver){}


    public class book {
        private List<Feedback> feedbacks;

        public List<Feedback> getFeedbacks() {
            return feedbacks;
        }

        public void setFeedbacks(List<Feedback> feedbacks) {
            this.feedbacks = feedbacks;
        }
    }

    public class Feedback {
        private String name;
        private String comment;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}



