package AnanayMahajan.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AppTest {
    
  @Test
  public void shouldAnswerWithTrue() {
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.worldometers.info/world-population/");
  }
}
