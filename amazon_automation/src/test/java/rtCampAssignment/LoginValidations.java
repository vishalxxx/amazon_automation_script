package rtCampAssignment;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import org.testng.Assert;
import org.testng.annotations.*;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginValidations {

	@Test
	public void amazon_login_positive() {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");
		page.hover("//span[text()=\"Hello, sign in\"]");
		page.click("//span[text()=\"Sign in\"]");
		page.locator("//input[@id=\"ap_email\"]").fill("vishalgoswamijims@gmail.com");
		page.click("//input[@id=\"continue\"]");
		page.locator("//input[@id=\"ap_password\"]").fill("Test@123");
		page.click("//input[@id=\"signInSubmit\"]");
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
	}
	@Test
	public void amazon_login_invalid_email() throws Throwable{
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");
		page.hover("//span[text()=\"Hello, sign in\"]");
		page.click("//span[text()=\"Sign in\"]");
		page.locator("//input[@id=\"ap_email\"]").fill("abc1234yt@gmail.com");
		page.click("//input[@id=\"continue\"]");
		Locator error = page.locator("//span[contains(text(),\"We cannot find an account with that email address\")]");
		Assert.assertNotNull(error);
		
	}
	@Test
	public void amazon_login_invalid_pass() throws Throwable{
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");
		page.hover("//span[text()=\"Hello, sign in\"]");
		page.click("//span[text()=\"Sign in\"]");
		page.locator("//input[@id=\"ap_email\"]").fill("vishalgoswamijims@gmail.com");
		page.click("//input[@id=\"continue\"]");
		page.locator("//input[@id=\"ap_password\"]").fill("Test@123");
		Locator error = page.locator("//span[contains(text(),\"Your password is incorrect\")]");
		Assert.assertNotNull(error);
		
	}
	@Test
	public void amazon_login_empty_email() throws Throwable{
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");
		page.hover("//span[text()=\"Hello, sign in\"]");
		page.click("//span[text()=\"Sign in\"]");
		page.click("//input[@id=\"continue\"]");
		Locator error = page.locator("//div[contains(text(),\"Enter your email or mobile phone number\")]");
		Assert.assertNotNull(error);
		
	}
	
	
	
}
