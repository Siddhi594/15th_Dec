package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Handle_dropdown_list
{
	public static void handleSelectedClass(WebElement ele, String value)
	{
		Select sc=new Select(ele);
		sc.selectByVisibleText(value);
	}

}
