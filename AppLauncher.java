package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AppLauncher extends ProjectSpecificMethod {
	@Test
	public void appLauncher() throws InterruptedException
	{
		//click on toogle menu button
		driver.findElement(By.xpath(" //div[@class='slds-icon-waffle']")).click();
		//click on view all
		WebElement viewall = driver.findElement(By.xpath("(//button[@class='slds-button'])[2]"));
		Actions a=new Actions(driver);
		a.moveToElement(viewall).click().perform();
		
		//click on legal entities
		driver.findElement(By.xpath("//div[@class='slds-col slds-scrollable slds-p-horizontal_large']//ul//li[73]")).click();

		//click on new button in new window
		driver.findElement(By.xpath("//a[@class='forceActionLink']")).click();
		//send company name
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("TestLeaf");
		//send description
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("Salesforces");
		//click on status dropdown icon
		WebElement status_dd =driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
		driver.executeScript("arguments[0].click();", status_dd);
		// a.scrollToElement(status_dd).perform();
		 //status_dd.click();
		//click().perform();
		Thread.sleep(2000);
		//click on active option
		driver.findElement(By.xpath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left slds-dropdown_length-with-icon-7']//lightning-base-combobox-item[2]")).click();
		
		//click on save button
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		//click on legal entity link in alert window
		driver.findElement(By.xpath("//a[text()='Legal Entity Name']")).click();
		
		//get the error msg disdlayed below the name text box
		String text = driver.findElement(By.xpath("//label[text()='Legal Entity Name']/following::div[contains(@class, 'slds-form-element__help')]")).getText();
		System.out.println("Errror message:"+text);
		
		
	}
	

}

