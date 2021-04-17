package E2EProjectCopy.CalendarAppCopy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author AKHIL BINGI
 *
 */
public class loginPage {
	public WebDriver driver;

	// implementing Encapsulation Concept here Declaring variables in private mode
	// for Data security issues
	private By logPage = By.linkText("Login");
	private By loginEmail = By.xpath("//input[@name='username']");
	private By loginPwd = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//form[@action='/login']/button");
	private By newUser = By.linkText("I don't have a account");
	private By currDate = By.xpath("//td[starts-with(@class,'active')]");
	private By currMonYear = By.xpath("//span[@class='current']");
	private By toDo = By.xpath("//input[@id='todoItem']");
	private By tButton = By.xpath("//button[@id='addTodo']");

	// Created constructor so when ever an object of this class is created this
	// method is called so that the actual driver refers to the driver in this class

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement enterLoginPage() {
		return driver.findElement(logPage);
	}

	public WebElement lemail() {
		return driver.findElement(loginEmail);
	}

	public WebElement lpassword() {
		return driver.findElement(loginPwd);
	}

	public WebElement lbutton() {
		return driver.findElement(loginButton);
	}

	public WebElement lnewUser() {
		return driver.findElement(newUser);
	}

	public WebElement getCurrDate() {
		return driver.findElement(currDate);
	}

	public WebElement getcurrMonYear() {
		// TODO Auto-generated method stub
		return driver.findElement(currMonYear);
	}

	public WebElement getToDoList() {
		// TODO Auto-generated method stub
		return driver.findElement(toDo);
	}

	public WebElement addToDo() {
		// TODO Auto-generated method stub
		return driver.findElement(tButton);
	}

}
