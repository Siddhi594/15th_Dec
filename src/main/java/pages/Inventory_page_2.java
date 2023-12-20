package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.Handle_dropdown_list;

public class Inventory_page_2 extends TestBase
{
	//object repository
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement appLogo;
	@FindBy(xpath="//span[@class='title']") private WebElement productsLabel;
	@FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement addToCart;
	@FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement CartCount;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDown;
	@FindBy(xpath="//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']") private WebElement linkedinLogo;
	@FindBy(xpath="//div[@class='footer_copy']") private WebElement Footer;
	//product added
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement boltProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement fleeceProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement redProduct;
	//product removed
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackpackProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removebikeLightProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeboltTshirtProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removefleecjacketProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeonesieProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeresTshirtProduct;
	//constructor
	public Inventory_page_2()
	{
		PageFactory.initElements(driver, this);
	}
	public String appLogo()
	{
		return appLogo.getText();
	}
	public String verifyproductsLabel()
	{
		return productsLabel.getText();
	}
	public boolean verifytwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	public boolean verifyfacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	public boolean verifylinkedinLogo()
	{
		return linkedinLogo.isDisplayed();
	}
	public String Footer()
	{
		return Footer.getText();
	}
	public String add6Products()
	{
		Handle_dropdown_list.handleSelectedClass(dropDown, "Price (low to high)");
		backPackProduct.click();
		bikeLightProduct.click();
		boltProduct.click();
		fleeceProduct.click();
		onesieProduct.click();
		redProduct.click();
		return CartCount.getText();
	}
	public String remove2Pproducts() throws InterruptedException
	{
		add6Products();
		Thread.sleep(2000);
		removebackpackProduct.click();
		removebikeLightProduct.click();
		return CartCount.getText();
	}
	public String LoginToYourCart()
	{
		addToCart.click();
		return driver.getCurrentUrl();
	}
}
