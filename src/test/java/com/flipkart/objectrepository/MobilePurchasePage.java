package com.flipkart.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.resources.Commonactions;

public class MobilePurchasePage extends Commonactions{

	public MobilePurchasePage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//button[text()='✕']")
	private WebElement closeIcon;

	@FindBy(name="q")
	private WebElement search;

	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getMobileName() {
		return mobileName;
	}

	public WebElement getBuy() {
		return buy;
	}

	@FindBy(xpath="(//div[contains(text(),'realme')])[2]")
	private WebElement mobileName;

	@FindBy(xpath="//button[text()='BUY NOW']")
	private WebElement buy;

	}


