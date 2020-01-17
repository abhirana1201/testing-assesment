package webdriverexamples;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;

public class Moushover {

	public static void takepicture(WebDriver driver,String filename) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,new File(".//screenshot//"+filename+".png"));

	}
	public static void main(String [] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Share\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.amazon.in");
		takepicture(driver,"img1");
		Actions action=new Actions(driver);
		WebElement electronics=driver.findElement(By.linkText("Best bargain finds"));
		action.moveToElement(electronics).build().perform();
		takepicture(driver,"img2");
		electronics.click();
		Thread.sleep(3000);
		WebElement Apple=driver.findElement(By.linkText("ELECTRONICS"));
		action.moveToElement(Apple).build().perform();
		takepicture(driver,"img3");
		Thread.sleep(3000);
		Apple.click();
	}
}
