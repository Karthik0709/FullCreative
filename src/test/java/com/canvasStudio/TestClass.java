package com.canvasStudio;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.canvas.pages.DrawingPage;

import baseClass.BaseTest;

public class TestClass extends BaseTest {
	
	WebDriver driver;
	SoftAssert softAssert;
	@Parameters({"environment"})
	@BeforeMethod
	public void beginmethod(String env) {
		driver = getChromeDriver();
		softAssert = getAssert();
		driver.get(env);
	}
	
	@Test
	public void automate() {
		DrawingPage draw = new DrawingPage(driver, softAssert);
		int initialx = -299,initialy= -250;
		int h1=initialx+200;
		int h2=200;
		int v1=(h2-h1)/2;
		int y1=initialy+110;
		int y2=200;
		int z1=-100;
		int z2=100;
		draw.lineClickFn();
		draw.drawShapeFn(h1,y1,h2,0);
		draw.drawShapeFn(0,y1-90, 0, y2);
		draw.RectangleClickFn();
		draw.drawShapeFn(z1, 50, 200, 80);
		draw.EraserClickFn();
		draw.Erase(h1, y1, h2, 0);
		System.out.println("Completed");
	}
	

}
