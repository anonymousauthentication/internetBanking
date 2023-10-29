package com.main.ExtentReportListner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class chapter3 {
	public static void main(String args[]) throws IOException {
		ExtentReports extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("allTest.html");
		ExtentSparkReporter sparkReporter_Fail = new ExtentSparkReporter("fail.html");
		sparkReporter_Fail.filter().statusFilter().as(new Status[] { Status.FAIL}).apply();
		ExtentSparkReporter sparkReporter_SkipAndWar = new ExtentSparkReporter("SkipAndWar.html");
		sparkReporter_SkipAndWar.filter().statusFilter().as(new Status[] { Status.WARNING,Status.SKIP}).apply();
		extentReports.attachReporter(sparkReporter_all,sparkReporter_Fail, sparkReporter_SkipAndWar );

		extentReports
		.createTest("Test 1")
		.log(Status.INFO, "Info 2")
		.log(Status.INFO, "<b>info 3</b>")
		.log(Status.INFO, "<i>info 4</i>")
		.log(Status.INFO, "<b><i>info 4</i></b>");

		String XmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "- <note>\r\n" + "  <to>Tove</to>\r\n"
				+ "  <from>Jani</from>\r\n" + "  <heading>Reminder</heading>\r\n"
				+ "  <body>Don't forget me this weekend!</body>\r\n" + "</note>";

		String JsonData = "{\r\n" + "  \"id\": 12,\r\n" + "  \"title\": \"Brown Perfume\",\r\n"
				+ "  \"description\": \"Royal_Mirage Sport Brown Perfu...\",\r\n" + "  \"price\": 40,\r\n"
				+ "  \"discountPercentage\": 15.66,\r\n" + "  \"rating\": 4,\r\n" + "  \"stock\": 52,\r\n"
				+ "  \"brand\": \"Royal_Mirage\",\r\n" + "  \"category\": \"fragrances\",\r\n"
				+ "  \"thumbnail\": \"https://i.dummyjson.com/data/products/12/thumbnail.jpg\",\r\n"
				+ "  \"images\": [\r\n" + "    \"https://i.dummyjson.com/data/products/12/1.jpg\",\r\n"
				+ "    \"https://i.dummyjson.com/data/products/12/2.jpg\",\r\n"
				+ "    \"https://i.dummyjson.com/data/products/12/3.png\",\r\n"
				+ "    \"https://i.dummyjson.com/data/products/12/4.jpg\",\r\n"
				+ "    \"https://i.dummyjson.com/data/products/12/thumbnail.jpg\"\r\n" + "  ]\r\n" + "}";

		extentReports.createTest("XML Based Test").log(Status.INFO,
				MarkupHelper.createCodeBlock(XmlData, CodeLanguage.XML));

		extentReports.createTest("JSON Based Test").log(Status.INFO,
				MarkupHelper.createCodeBlock(JsonData, CodeLanguage.JSON));
		
		List<String> listData = new ArrayList<>();
		listData.add("Manohar");
		listData.add("Kant");
		listData.add("Joshi");
		
		Map<Integer, String > 	mapData = new HashMap<>();
		mapData.put(101, "Manohar");
		mapData.put(102, "Kant");
		mapData.put(103, "Joshi");
		
		Set<Integer> setData = mapData.keySet();

		extentReports.createTest("Pass Test")
		.pass("Pass Test");
		
		extentReports.createTest("Fail Test")
		.fail("fail test");
		
		extentReports.createTest("Dkip Test")
		.skip("Skip Test");
		
		extentReports.createTest("List Based Test")
		.log(Status.INFO,MarkupHelper.createOrderedList(listData))
		.log(Status.INFO,MarkupHelper.createUnorderedList(listData));
		
		extentReports.createTest("List Based Test")
		.log(Status.INFO,MarkupHelper.createOrderedList(mapData))
		.log(Status.INFO,MarkupHelper.createUnorderedList(mapData));
		
		extentReports.createTest("List Based Test")
		.log(Status.INFO,MarkupHelper.createOrderedList(setData))
		.log(Status.INFO,MarkupHelper.createUnorderedList(setData));
		
		extentReports.createTest("Hishlisht Based Test")
		.log(Status.INFO,MarkupHelper.createLabel("Hishlighted Message", ExtentColor.GREEN))
		.log(Status.INFO, "Not a Highlighted Messsage");
		
		try {
			int i = 5/0;
		}catch(Exception e) {
			extentReports.createTest("Exception Test 1")
			.log(Status.FAIL, e);
		}
		
		
		Throwable t =  new RuntimeException("Custom Exception");
		extentReports.createTest("Custom Exception")
		.log(Status.FAIL, t);
		
		extentReports.createTest("Exception Test 3")
		.fail(t);    
		
        
		extentReports.flush();
		Desktop.getDesktop().browse(new File("allTest.html").toURI());
		Desktop.getDesktop().browse(new File("fail.html").toURI());
		Desktop.getDesktop().browse(new File("SkipAndWar.html").toURI());
	}
}