package com.mobileAutomationFlipkart;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Filpkart {
	
	
	public static AndroidDriver<MobileElement> driver;
	MobileElement foundElem;
	public String destDir;
	public DateFormat dateformat;
	
	@BeforeClass
    
    public static void openDevice() throws MalformedURLException
    {
		
		URL url = new URL("http://localhost:4723/wd/hub");
        //Step 1 is to create a object for Desiredcapbailies class
        
        DesiredCapabilities caps = new DesiredCapabilities();
        
        //Details given as part of your device
        
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformVersion", "9.0");
        caps.setCapability("noReset", "true");
        
		caps.setCapability("appPackage","com.flipkart.android");
		caps.setCapability("appActivity","com.flipkart.android.SplashActivity");
		
        driver = new AndroidDriver<MobileElement>(url,caps);
        
        driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS);
    }
	
	@Test
	
	public void starttestcase() throws InterruptedException {
		
		System.out.println("Start application");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//android.widget.Button[@text= 'LATER']")).click();
		
		//driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=' Search for Products, Brands and More']")).click();
		
		
		Thread.sleep(3000);
    	driver.findElement(By.xpath("//android.widget.EditText[@text='Search for Products, Brands..']")).sendKeys("apple 13");
		
    	Thread.sleep(2000);   	
    	driver.findElement(By.xpath("//android.widget.TextView[@text = 'apple 13']")).click();
    	

    	
    	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
    	driver.findElement(By.xpath("//android.widget.TextView[@text='APPLE iPhone 13 (Starlight, 128 GB)']")).click();
    	
		
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    	driver.findElement(By.xpath("//android.widget.TextView[@text='Add to cart']")).click();
    		
    	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    		//Define the folder to save the screenshot
    		
    		destDir = "./Screenshot";
    		
    		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		
    		dateformat = new SimpleDateFormat("dd-MMM-YYYY__hh_mm_ssaa");
    		new File(destDir).mkdirs();
    		
    		String destFile = dateformat.format(new Date())+ ".png";
    		
    		try
    		{
    			FileUtils.copyFile(scrFile, new File(destDir +"/"+ destFile));
    		}
    		
    		catch(IOException e)
    		{
    			e.printStackTrace();
    		}
    		
    	}
    	
    	
	}