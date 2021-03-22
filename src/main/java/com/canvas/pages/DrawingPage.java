package com.canvas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import utility.CommonMethods;

public class DrawingPage {
	WebDriver driver;
	SoftAssert softAssert;
	WebDriverWait wait;
	CommonMethods common;
	
	public DrawingPage(WebDriver driver,SoftAssert softAssert) {
		this.driver = driver;
		this.softAssert  = softAssert;
		common = new CommonMethods(driver);
		PageFactory.initElements(driver, this);
	}
	//HTML Canvas Studio - Free Online Tool
	@FindBy(xpath="//div[@class='toolbar']/input[contains(@class,'line')]")
	WebElement line;
	
	By linesymbol = By.xpath("//div[@class='toolbar']/input[contains(@class,'line')]");
	
	public void lineClickFn() {
		
			if(line.isDisplayed())
			{
				common.clickWhenVisible(line);
			}
	}
	@FindBy(xpath="//div[@id='container']/canvas[@id='imageView']")
	WebElement canvas;
	public void drawShapeFn(int x1,int y1, int x2,int y2) {
		Actions act = new Actions(driver);
		Action mouse = act.moveToElement(canvas,x1,y1).clickAndHold().moveByOffset(x2, y2).release().click().build();
		mouse.perform();
	}
	@FindBy(xpath="//div[@class='toolbar']/input[contains(@class,'eraser')]")
	WebElement eraser;
public void EraserClickFn() {
		
			if(eraser.isDisplayed())
			{
				common.clickWhenVisible(eraser);
			}
	}
	public void Erase(int x1,int y1, int x2,int y2) {
		Actions act = new Actions(driver);
		Action mouse = act.moveToElement(canvas,x1,y1).clickAndHold().moveByOffset(x2, y2).release().click().build();
		mouse.perform();
	}
	@FindBy(xpath="//div[@class='toolbar']/input[contains(@class,'rectangle')]")
	WebElement rect;

	public void RectangleClickFn() {
		
			if(rect.isDisplayed())
			{
				common.clickWhenVisible(rect);
		}
	}
	
}
