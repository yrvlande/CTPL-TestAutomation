package com.netChain2.selenium.tests.demo;

import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.connecticus.engine.BaseTestCase;
import com.connecticus.engine.Common;
import com.netChain.utils.CustomAnnotation.TestDetails;
import com.netChain2.selenium.pageObjects.accountsPayable.createInvoice.Invoice;
import com.netChain2.selenium.pageObjects.accountsPayable.createVendor.VendorCreationForm;
import com.netChain2.selenium.pageObjects.common.JavaScriptOperation.JavaScriptUtils;
import com.netChain2.selenium.pageObjects.common.apCreation.APModuleCreation;
import com.netChain2.selenium.pageObjects.common.landingPage.LandingPage;
import com.netChain2.selenium.pageObjects.common.loginPage.LoginPage;



public class DemoTest extends BaseTestCase{
	private ArrayList<String> testData;
	private ArrayList<String> testData1;
	private ArrayList<String> testData2;
	
	@BeforeClass
	public void setUp() {
		testData = Common.getTestData("NetchainTest.Login");
		testData1 = Common.getTestData("NetchainTest.CreateVendor");
		//testData2 = Common.getTestData("NetchainTest.CreateVendorNeg");
		
		
		
		
		LandingPage landingPage = new LandingPage();
		
		JavaScriptUtils.jQueryDragAndDrop("p:contains(\"Invoice Acceptance\")", "div[class=\"workflowDropZone\"]");
		
		JavaScriptUtils.jQueryDragAndDrop("p:contains(\"Invoice Approval\")", "div[class=\"workflowDropZone\"]");
		
		
		boolean check1 = landingPage.isLoginButtonDisplayed();
		
		
		landingPage.clickLogInButton();
		
		
		LoginPage loginPage = new LoginPage();
		loginPage.login(testData.get(0), testData.get(1));
		Common.sleep(2000);

		
	}
	boolean check1;
	
	
	//@BeforeTest
	
	//Positive Test Case
	//public void launchLoginPage() {
       // WebDriver driver=Common.getDriver();

		 // String uuid = UUID.randomUUID().toString();

         //Now this uuid enter to your text box
		//driver.findElement(By.id("CompanyName")).sendKeys(uuid);
		
//LandingPage landingPage = new LandingPage();
//boolean check1 = landingPage.isLoginButtonDisplayed();
//
//
//landingPage.clickLogInButton();
//
//
//LoginPage loginPage = new LoginPage();
//loginPage.login(testData.get(0), testData.get(1));
//Common.sleep(2000);

	//}

	@Test(priority=1)
	@TestDetails(author="Ruchira.Mhaisurkar", description="demo test")

	public void VendorCreation() {
		Invoice invoice = new Invoice();

		APModuleCreation apModule = invoice.createNew();
		Common.sleep(2000);
		apModule.clickAPLink();
		Common.sleep(2000);
		apModule.clickNewVendorLink();

		VendorCreationForm vendorCreation = new VendorCreationForm();

		vendorCreation.setCompanyProfileTab(testData1.get(0), testData1.get(1), testData1.get(2));
		//BaseTestCase.assertTrue(check1, "Log In Button not displayed");
		Common.sleep(2000);
		vendorCreation.clickAddEmployeeButton();
		Common.sleep(2000);
		
		vendorCreation.EnterName(testData1.get(3));
		vendorCreation.EnterEmail(testData1.get(4));
		vendorCreation.EnterPhoneNumber(testData1.get(5));
		vendorCreation.EnterTitle(testData1.get(6));
		vendorCreation.selectPaymentReceiver();

		vendorCreation.clickNextButton2();
		Common.sleep(1000);

		vendorCreation.bookingAccntAddLineButton();
		Common.sleep(1000);


		vendorCreation.selectLocation(testData1.get(7));

		vendorCreation.selectDepartment(testData1.get(8));

		vendorCreation.selectBookingAccount(testData1.get(9));

		vendorCreation.clickNextButton3();

		Common.sleep(2000);

		vendorCreation.goToProductDetailsTab();

		vendorCreation.selectProduct();

		vendorCreation.clickNextButton4();

		vendorCreation.vendorDetailsTab(testData1.get(10), testData1.get(11), testData1.get(12), testData1.get(13), testData1.get(14), testData1.get(15), testData1.get(16), testData1.get(17), testData1.get(18), testData1.get(19), testData1.get(20), testData1.get(21), testData1.get(22), testData1.get(23), testData1.get(24), testData1.get(25), testData1.get(26));
        
		//Check and test title of the Vendor list
		
		String ActualTitleValue=Common.getDriver().getTitle();
		//System.out.println("Actual title is:"+ActualTitleValue);
		
	
		
		String ExpectedTitleValue=testData1.get(27);
		System.out.println("Expected Title is:"+ExpectedTitleValue);
		
		if(ActualTitleValue.equals(ExpectedTitleValue)) {
			BaseTestCase.assertTrue(true, "Redirected to vendor list,vendor created succesfully");
		}
		else {
			BaseTestCase.assertTrue(false, "Not redirected to vendor list,vendor creation failed");
		}
		Reporter.log("Vendor created successfully",true);
		



	}
	
	
	//Negative Test Case
	@Test(priority=2)
	public void VendorCreationNegative() {
		Invoice invoice = new Invoice();
		Common.sleep(6000);
		APModuleCreation apModule = invoice.createNew();
		Common.sleep(2000);
		apModule.clickAPLink();
		Common.sleep(2000);
		apModule.clickNewVendorLink();

		VendorCreationForm vendorCreation = new VendorCreationForm();

		vendorCreation.setCompanyProfileTab(testData2.get(0), testData2.get(1), testData2.get(2));
		//BaseTestCase.assertTrue(check1, "Log In Button not displayed");
		Common.sleep(2000);
		vendorCreation.clickAddEmployeeButton();
		Common.sleep(2000);
		
		vendorCreation.EnterName(testData2.get(3));
		vendorCreation.EnterEmail(testData2.get(4));
		vendorCreation.EnterPhoneNumber(testData2.get(5));
		vendorCreation.EnterTitle(testData2.get(6));
		vendorCreation.selectPaymentReceiver();

		vendorCreation.clickNextButton2();
		Common.sleep(1000);

		vendorCreation.bookingAccntAddLineButton();
		Common.sleep(1000);


		vendorCreation.selectLocation(testData2.get(7));

		vendorCreation.selectDepartment(testData2.get(8));

		vendorCreation.selectBookingAccount(testData2.get(9));

		vendorCreation.clickNextButton3();

		Common.setTimeOuts(2000, 2000);

		vendorCreation.goToProductDetailsTab();

		vendorCreation.selectProduct();

		vendorCreation.clickNextButton4();

		vendorCreation.vendorDetailsTab(testData2.get(10), testData2.get(11), testData2.get(12), testData2.get(13), testData2.get(14), testData2.get(15), testData2.get(16), testData2.get(17), testData2.get(18), testData2.get(19), testData2.get(20), testData2.get(21), testData2.get(22), testData2.get(23), testData2.get(24), testData2.get(25), testData2.get(26));
        
		//Check and test title of the Vendor list
		
		String getalerttext=Common.getText("VENDOR_NEGATIVE_ALERT_MSG_XPATH");
		String actualalerttext="Email Address cannot be empty";
		System.out.println("Alert msg is:"+getalerttext);
		//String ActualTitleValue=Common.getDriver().getTitle();
		//System.out.println("Actual title is:"+ActualTitleValue);
		
		String ExpectedTitleValue=testData2.get(27);
		System.out.println("Expected Title is:"+ExpectedTitleValue);
		
		if(getalerttext.equals(actualalerttext)) {
			BaseTestCase.assertTrue(true, "Vendor not created as the email field is blank");
		}
		else {
			BaseTestCase.assertTrue(false, "Vendor created");
		}
		Reporter.log("Vendor not created as the email id is invalid",true);
		
		
	}
	@AfterClass
	public void teardown()
	{
		Common.quit();
	}  


}