package Test_Pages;

import org.openqa.selenium.By;

import utils.CommonUtilities;

public class AddUserPage extends CommonUtilities{

	//private final By adminMenu = By.xpath("//span[text()='Admin']");
	//private final By adminMenu = By.xpath("(//a[@class=\"oxd-main-menu-item\"])[1]");
	//private final By addIcon = By.className("oxd-icon bi-plus oxd-button-icon");
	//private final By selectUserRole = By.xpath("(//div[text()='-- Select --'])[1]");
	//private final By selectUserStatus = By.xpath("(//div[text()='-- Select --'])[2]");
	//private final By employeeName = By.xpath("//input[@placeholder='Type for hints...']");
	//private final By username =By.className("oxd-input oxd-input--active");
	//private final By password =By.xpath("(//input[@type='password'])[1]");
	//private final By confirmPassword =By.xpath("(//input[@type='password'])[2]");
	private final By saveBtn = By.xpath("//button[@type='submit']");
	private final By pimMenu = By.xpath("(//a[@class=\"oxd-main-menu-item\"])[2]");
	private final By addBtn = By.xpath("(//button[@type='button'])[4]");
	private final By firstName = By.name("firstName");
	private final By middleName = By.name("middleName");
	private final By lastName = By.name("lastName");
	
	
	
	public void addUser(String Name, String Middlename, String Lastname ) {
		
		click(pimMenu, "pimMenu");
		click(addBtn,"addBtn");
		sendKeys(firstName, Name, "First Name");
		sendKeys(middleName,Middlename, "middleName");
		sendKeys(lastName, Lastname, "lastName");
		click(saveBtn, "Save Button");
		
		
	}
	
	
}
