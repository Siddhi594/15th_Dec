package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
	//object repository
	@FindBy(xpath="//div[@class='app_logo']") private WebElement appLogoText;
	
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement YourCartLabel;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement QtyLabel;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement descLabel;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement CartCounts;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement CartButton;
	@FindBy(xpath="//button[@id='continue-shopping']") private WebElement continueShoppingBtn;
	@FindBy(xpath="//button[@id='checkout']") private WebElement checkoutBtn;
	//product added
	
	//product removed
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removeJacket;
	@FindBy(xpath="remove-sauce-labs-onesie") private WebElement removeOnesie;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removeBackpack;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLight;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeRedTshirt;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeBoltTshirt;
	//constructor
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String appLogoText()
	{
		return appLogoText.getText();
	}
	public String YourCartText()
	{
		return YourCartLabel.getText();
	}
	public String QtyLabel()
	{
		return QtyLabel.getText();
	}
	public String descLabel()
	{
		return descLabel.getText();
	}
	public String verifycontinueShoppingBtn()
	{
		continueShoppingBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifycheckoutBtn()
	{
		checkoutBtn.click();
		return driver.getCurrentUrl();
	}
	public String LoginToYourCart()
	{
		CartButton.click();
		return driver.getCurrentUrl();
	}
	public String remove3products()
	{
		removeRedTshirt.click();
		removeBikeLight.click();
		removeJacket.click();
		return CartCounts.getText();
	}
}
