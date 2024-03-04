package rtCampAssignment;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SearchFunctionality {

	@Test
	public void search_functionality() throws Throwable {
	Playwright playwright = Playwright.create();
	Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	page.navigate("https://www.amazon.in/");
	assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	page.getByPlaceholder("Search Amazon.in").fill("iphone14");
	page.click("//input[@id=\"nav-search-submit-button\"]");
	Thread.sleep(2000);
	List<String> search_results = page.locator("//div[@data-component-type=\"s-search-result\"]//child::h2").allTextContents();
	
	for(String s:search_results) {	
		
		System.out.println(s);

		}
	}
}
