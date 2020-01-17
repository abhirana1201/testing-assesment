package webdriverexamples;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Watch {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Share\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		String tab1 = driver.getWindowHandle();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watches");
		takepicture(driver, "img1");
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		takepicture(driver, "img2");
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		WebElement watch = driver.findElement(By.cssSelector("img[data-image-index=\"3\"]"));
		action.moveToElement(watch).click().build().perform();
		ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
		tab2.remove(tab1);
		driver.switchTo().window(tab2.get(0));
		Thread.sleep(1000);
		takepicture(driver, "watch");
		Thread.sleep(3000);
		driver.close();

	}

	public static void takepicture(WebDriver driver, String filename) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\test\\" + filename + ".png"));

	}
}