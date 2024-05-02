package AnanayMahajan.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page1{ 
WebDriver driver;
	
	public Page1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//div[@class='maincounter-number']")
	WebElement currentWorldPopulation;
	
	@FindBy(xpath = "(//div[@class='sec-counter'])[1]")
	WebElement birthsToday;
	
	@FindBy(xpath = "(//div[@class='sec-counter'])[2]")
	WebElement deathsToday;
	
	@FindBy(xpath = "(//div[@class='sec-counter'])[3]")
	WebElement populationGrowthToday;
	
	@FindBy(xpath = "(//div[@class='sec-counter'])[4]")
	WebElement birthsThisYear;
	
	@FindBy(xpath = "(//div[@class='sec-counter'])[5]")
	WebElement deathsThisYear;
	
	@FindBy(xpath = "(//div[@class='sec-counter'])[6]")
	WebElement populationGrowthThisYear;
	
	
	public String getcurrentWorldPopulation() {
		return currentWorldPopulation.getText();
	
	}
	
	public String getBirthsToday() {
		return birthsToday.getText();
	
	}
	
	public String getdeathsToday() {
		return deathsToday.getText();
	
	}
	
	public String getpopulationGrowthToday() {
		return populationGrowthToday.getText();
	
	}
	
	public String getbirthsThisYear() {
		return birthsThisYear.getText();
	
	}
	
	public String getdeathsThisYear() {
		return deathsThisYear.getText();
	
	}
	
	public String getpopulationGrowthThisYear() {
		return populationGrowthThisYear.getText();
	
	}
}
	