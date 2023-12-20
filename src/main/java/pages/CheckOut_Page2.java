package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Page2 extends TestBase
{
	@FindBy(xpath="//span[@class='title']") private WebElement titleOfCheckoutpage2;
	@FindBy(xpath="//div[@class='cart_quantity_label']") private WebElement qtyLabel;
	@FindBy(xpath="//div[@class='cart_desc_label']") private WebElement descLabel;
	@FindBy(xpath="//div[text()='Payment Information']") private WebElement paymentLabel;
	@FindBy(xpath="//div[text()='Shipping Information']") private WebElement shippingLabel;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement priceLabel;
	@FindBy(xpath="//button[@id='finish']") private WebElement finishBtn;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	
	public CheckOut_Page2()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifytitleOfCheckoutpage2()
	{
		return titleOfCheckoutpage2.getText();
	}
	public String verifyqtyLabel()
	{
		return qtyLabel.getText();
	}
	public String verifydescLabel()
	{
		return descLabel.getText();
	}
	public String verifypaymentLabel()
	{
		return paymentLabel.getText();
	}
	public String verifyshippingLabel()
	{
		return shippingLabel.getText();
	}
	public String verifypriceLabel()
	{
		return priceLabel.getText();
	}
	public String clickOnfinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
	public String clickOncancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	
	

}
