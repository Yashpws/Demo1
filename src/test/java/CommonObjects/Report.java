package CommonObjects;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Report {
	public static int ReprotDetails = 0;

	public static int stepnum = 0;

	public static void Report_Details_Header() {
		Reporter.log("<table border=1px; style= width:100%;color=#808080>"
				+ "<tr> <th width=20%>Browser Selected</th> <th width=20%> Environment Used</th></tr>");
		ReprotDetails = 1;
	}
	   @Test
	public static void Report_Details_Values(String pBrowserName, String pEnvUsed) {
		String trstart = "<tr align=center>";
		String trend = "</tr>";
		String thstart = "<td width=15%>";
		String thend = "</td>";
		String tableend = "</table>";
		String BrowserName = pBrowserName;
		String EnvUsed = pEnvUsed;
		Reporter.log(trstart + thstart + BrowserName + thend + thstart + EnvUsed + thend + trend + tableend);
	}
	   @Test
	public static void Report_section_Name(String pSectionName) {
		String TableStart = "<table border=1px; style= width:100%;color=#808080;body bgcolor=#F5DEB3>";

		String trstart = "<tr align=center>";
		String trend = "</tr>";
		String thstart = "<th width=15% >";
		String thend = "</th>";
		String SectionName = pSectionName;
		String TableEnd = "</table>";
		Reporter.log(TableStart + trstart + thstart + SectionName + thend + trend + TableEnd);
	}

	@Test
	public static void ReporterOutputHeader() throws InterruptedException {
		Thread.sleep(1000);
		stepnum = 0;
		Reporter.log("<table border=1px; style= width:100%;color=#808080> "
				+ " <tr font-family:Georgia, Garamond, Serif><th width=2%;body bgcolor=#BDBDBD>Testcase ID</th> <th width=20%;body bgcolor=#BDBDBD>Testcase Description</th> <th width=20%;body bgcolor=#BDBDBD>Input Value</th> <th width=20%;body bgcolor=#BDBDBD>Expected Value</th> <th width=20% ;body bgcolor=#BDBDBD>Actual Value</th> "
				+ "<th width=18% ;body bgcolor=#BDBDBD>Result</th></tr>");

	}
	   @Test
	public static void ReporterOutput(String ptestcaseID, String pStepDescription, String pInputValue,
			String pExpectedValue, String pActualValue, String pResult, String pId) throws Throwable {
		// String TableHeader = "<table border=1 style= width:100%> " +
		// "<tr> <th>Step Description</th> <th>Input Value</th> <th>Expected
		// Value</th> <th>Actual Value</th> <th>Result</th></tr>";
		Thread.sleep(1000);
		//stepnum++;
		//String Stepnumber = "STEP " + stepnum + "";
		//String TestcaseID = Stepnumber;
		String TestcaseID = ptestcaseID;
		String StepDescription = pStepDescription;
		String InputValue = pInputValue;
		String ExpectedValue = pExpectedValue;
		String ActualValue = pActualValue;
		String Result = pResult;
		String Id = pId;

		String trstart = "<tr id=" + Id + ">";
		String trend = "</tr>";
		// String thstart = "<td width=20% id="+Id+">";
		String thstart = "<td width=20%>";
		// String thstart = "<td width=20% id="+ +">";
		String thend = "</td>";

		if (Result.equalsIgnoreCase("Pass")) {
			Result = "<TD align=center BGCOLOR= #00ff00 > Pass";
		}
		if (Result.equalsIgnoreCase("Fail")) {
			Result = "<TD align=center BGCOLOR= #A71313 > Fail";
		}

		Reporter.log(trstart + thstart + TestcaseID + thend + thstart + StepDescription + thend + thstart + InputValue
				+ thend + thstart + ExpectedValue + thend + thstart + ActualValue + thend + Result + trend);
	}
	   @Test
	public static void TableEnd() {
		Reporter.log("</table>");
	}
	   @Test
	public static void ExporttoExcel() {
		Reporter.log("<button type=button>ExportToExcel</button>");
	}

}
