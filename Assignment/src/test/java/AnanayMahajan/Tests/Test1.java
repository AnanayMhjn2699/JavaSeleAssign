package AnanayMahajan.Tests;

import org.testng.annotations.Test;

import AnanayMahajan.PageObjects.Page1;
import AnanayMahajan.TestComponents.BaseTest;

public class Test1 extends BaseTest{
 	
	@Test
	public void testWorldPopulation1() {
		long endTime = System.currentTimeMillis() + 10000;
		while (System.currentTimeMillis() < endTime) {
			
			System.out.println("Current World Population = "+locator.getcurrentWorldPopulation());
			System.out.println("Births Today = "+locator.getBirthsToday());
			System.out.println("Deaths Today = "+locator.getdeathsToday());
			System.out.println("Population Growth Today = "+locator.getpopulationGrowthToday());
			System.out.println("Births This Year = "+locator.getbirthsThisYear());
			System.out.println("Deaths This Year = "+locator.getdeathsThisYear());
			System.out.println("Population Growth This Year = "+locator.getpopulationGrowthThisYear());
			System.out.println();
		}
	}
}