package rtCampAssignment;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ProductCheckout {
	@Test
	public void amazon_product_checkout() {
		
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
		page.getByPlaceholder("Search Amazon.in").fill("iphone14");
		page.locator("//div[@class=\"left-pane-results-container\"]/child::div[1]").click();
		Page newpage = page.waitForPopup(	()->page.click("//div[@data-component-type=\"s-search-result\"][1]//child::h2")		);
		newpage.waitForLoadState();
		newpage.click("//input[@type=\"submit\" and @title=\"Add to Shopping Cart\"]");
		newpage.click("//span[@id=\"attach-sidesheet-checkout-button\"]//child::input");
		newpage.click("//input[@aria-labelledby=\"orderSummaryPrimaryActionBtn-announce\"]");
		
		
	}

}
