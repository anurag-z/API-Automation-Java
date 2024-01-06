package Reuseablelibrary;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.apache.commons.lang.math.NumberUtils;

import org.apache.commons.lang3.StringUtils;

import org.json.JSONArray;

import org.json.JSONException;

import org.json.JSONObject;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;

//import files.payload;

import io.restassured.path.json.JsonPath;

import io.restassured.path.xml.XmlPath;

import io.restassured.response.Response;

public class Reuseablecomponents {

	// *MS

	public Response executePostAPI(String endPointUrl, String body, Properties globalProp, ExtentTest test,
			Hashtable<String, String> headers) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> POST");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Body: </b>" + body);

		Response res;

		if (body != "") {

			res = given().headers(headers).body(body).when().post(endPointUrl).then().extract().response();

			test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		}

		else

		{

			res = given().headers(headers).when().post(endPointUrl).then().extract().response();

			test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		}

		return res;

	}

	public Response executePostAPI(String endPointUrl, String body, Properties globalProp, ExtentTest test) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> POST");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Body: </b>" + body);

		Response res;

		if (body != "") {

			res = given().body(body).when().post(endPointUrl).then().extract().response();

			test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		} else {

			res = given().when().post(endPointUrl).then().extract().response();

			test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		}

		return res;

	}

	public static String hiddenExpandResponse(Response res) {

		String formttatedtrace = "<details>\n" +

				"<summary>Click Here to See Response Body</summary>\n" +

				" " + res.asString() + "\n" +

				"</details>\n";

		return formttatedtrace;

	}

	public Response executeGetAPI(String endPointUrl, Properties globalProp, ExtentTest test) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> GET");

		test.log(LogStatus.INFO, "<b>URL: </b>" + globalProp.getProperty("baseURI") + endPointUrl);

		Response Response = given().header("Content-Type", globalProp.getProperty("contentType")).when()
				.get(endPointUrl)

				.then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(Response));

		return Response;

	}

	// *MS Patch API Call

	public Response executePatchAPI(String endPointUrl, String body, Properties globalProp, ExtentTest test,

			Hashtable<String, String> headers) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> PATCH");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Body: </b>" + body);

		Response res = given().headers(headers).body(body).when().patch(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	// *MS

	public Response executePutAPI(String endPointUrl, String body, Properties globalProp, ExtentTest test) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> PUT");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Body: </b>" + body);

		Response res = given().header("Content-Type", globalProp.getProperty("contentType")).body(body).when()

				.put(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	// *MS

	public Response executePutAPI(String endPointUrl, String body, Properties globalProp, ExtentTest test,

			Hashtable<String, String> headers) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> PUT");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Body: </b>" + body);

		Response res = given().headers(headers).body(body).when().put(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	// *MS

	public Response executePutAPI(String endPointUrl, Properties globalProp, ExtentTest test,

			Hashtable<String, String> headers) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> PUT");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response res = given().headers(headers).when().put(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	// *MS

	public Response executeDeleteAPI(String endPointUrl, Properties globalProp, ExtentTest test,

			Hashtable<String, String> headers) {

		// RequestSpecification httpRequest = RestAssured.given();

		// test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Type: </b> DELETE");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response res = given().headers(headers).when().delete(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	// *MS

	public Response executeGetAPI(String endPointUrl, Properties globalProp, ExtentTest test,

			Hashtable<String, String> headers) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> GET");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response res;

		res = given().headers(headers).when().get(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	public Response executePOSTMultiform(String endPointUrl, String filePath, String format, Properties globalProp,

			Hashtable<String, String> headers, Hashtable<String, String> formparams, ExtentTest test) {

		Response res;

		res = given().log().all().headers(headers).multiPart("file", new File(filePath), format).formParams(formparams)

				.when().post(endPointUrl).then().extract().response();

		return res;

	}

	public Response POSTMultiform(String endPointUrl, String filePath, String format, Properties globalProp,

			Hashtable<String, String> headers, Hashtable<String, String> formparams, ExtentTest test) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> POST");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response res;

		res = given().log().all().headers(headers).multiPart("file", new File(filePath), format).formParams(formparams)

				.when().post(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	public Response executeGETMultiform(String endPointUrl, Properties globalProp,

			Hashtable<String, String> headers, Hashtable<String, String> formparams, ExtentTest test) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> GET");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response res;

		res = given().log().all().headers(headers).formParams(formparams)

				.when().get(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	public Response getAuthToken(String CId, String CSecret, Properties globalProp, ExtentTest test) {

		Response response = given().contentType("application/x-www-form-urlencoded; charset=utf-8")

				.formParam("grant_type", "client_credentials").formParam("scope", CId + "/.default")

				.formParam("client_id", CId).formParam("client_secret", CSecret).when()

				.post("https://login.microsoftonline.com/" + (globalProp.getProperty("clcTenantId"))

						+ "/oauth2/v2.0/token");

		return response;

	}

	public Response executePOSTMultiform_Onboarding(String endPointUrl, String filePath, Properties globalProp,

			Hashtable<String, String> headers, Hashtable<String, String> formparams, ExtentTest test) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> POST");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response res;

		res = given().log().all().headers(headers).multiPart("file", new File(filePath)).formParams(formparams)

				.when().post(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	// *MS

	public void validatePartialResponseFieldValues(String actualResponse, String expectedResponse, ExtentTest test)

			throws Exception {

		JSONObject actualFields = new JSONObject(actualResponse);

		JSONObject expectedFields = new JSONObject(expectedResponse);

		Iterator<String> keys = expectedFields.keys();

		while (keys.hasNext()) {

			String key = keys.next();

			String expectedValue = (String) expectedFields.get((String) key);

			String actualValue = (String) actualFields.get((String) key);

			if (expectedValue.trim().equalsIgnoreCase(actualValue)) {

				test.log(LogStatus.PASS, "Valaidate data for <b>'" + key + "'<b><br> Actual: " + actualValue

						+ "<br> Expected: " + expectedValue);

			} else {

				test.log(LogStatus.FAIL, "Valaidate data for <b>'" + key + "'<b><br> Actual: " + actualValue

						+ "<br> Expected: " + expectedValue);

			}

		}

	}

	// MS - newly added

	public String getDataFromResp(String actualResponse, String expKey, ExtentTest test) throws Exception {

		String actualValue = "";

		JSONObject actualFields = new JSONObject(actualResponse);

		Iterator<String> keys = actualFields.keys();

		while (keys.hasNext()) {

			String key = keys.next();

			if (key.trim().equalsIgnoreCase(expKey)) {

				actualValue = (String) actualFields.get((String) key);

				test.log(LogStatus.PASS, "Read data for <b>'" + key + "'<b><br> Actual: " + actualValue);

			}

		}

		return actualValue;

	}

	// *MS

	public Response retrievePostResponseforDynamicData(String contentType, String body, String endPointUrl) {

		return given().header("Content-Type", contentType).body(body).when().post(endPointUrl).then().extract()

				.response();

	}

	// *MS

	public Response retrieveGetResponse(String contentType, String endPointUrl) {

		return given().header("Content-Type", contentType).when().get(endPointUrl).then().extract().response();

	}

	// *MS & Contract Testing

	/*
	 * public JSONCompareResult validateResponse(String actualResponse, String
	 * expectedResponse, ExtentTest test)
	 * 
	 * throws UnsupportedEncodingException {
	 * 
	 * JSONCompareResult result = null;
	 * 
	 * try {
	 * 
	 * JSONObject actualObject = new JSONObject(actualResponse);
	 * 
	 * JSONObject expectedObject = new JSONObject(expectedResponse);
	 * 
	 * result = JSONCompare.compareJSON(actualObject, expectedObject,
	 * JSONCompareMode.LENIENT);
	 * 
	 * if (result.passed()) {
	 * 
	 * test.log(LogStatus.PASS, "<b>Expected Response:</b> " + expectedResponse
	 * 
	 * + "<br><b>Actual Response:</b> " + actualResponse);
	 * 
	 * } else {
	 * 
	 * test.log(LogStatus.FAIL, "<b>Expected Response:</b> " + expectedResponse
	 * 
	 * + "<br><b>Actual Response:</b> " + actualResponse);
	 * 
	 * }
	 * 
	 * } catch (JSONException e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * return result;
	 * 
	 * }
	 */
	// *MS & Contract Testing

	/*
	 * public void validateResponseLogJSONDifference(String actualResponse, String
	 * expectedResponse, ExtentTest test)
	 * 
	 * throws UnsupportedEncodingException {
	 * 
	 * JSONCompareResult res = null;
	 * 
	 * try {
	 * 
	 * JSONObject actualObject = new JSONObject(actualResponse);
	 * 
	 * JSONObject expectedObject = new JSONObject(expectedResponse);
	 * 
	 * res = JSONCompare.compareJSON(actualObject, expectedObject,
	 * JSONCompareMode.LENIENT);
	 * 
	 * if (res.passed()) {
	 * 
	 * test.log(LogStatus.PASS, "<b>Expected Response:</b> " + expectedResponse
	 * 
	 * + "<br><b>Actual Response:</b> " + actualResponse);
	 * 
	 * } else {
	 * 
	 * test.log(LogStatus.FAIL, "<b>Expected Response:</b> " + expectedResponse
	 * 
	 * + "<br><b>Actual Response:</b> " + actualResponse);
	 * 
	 * }
	 * 
	 * if (res.isFailureOnField()) {
	 * 
	 * List<FieldComparisonFailure> fFailures = res.getFieldFailures();
	 * 
	 * for (FieldComparisonFailure fail : fFailures) {
	 * 
	 * String fieldName = fail.getField().toString();
	 * 
	 * if (fieldName.contains("[") && fieldName.contains("]")) {
	 * 
	 * int sIndex = fieldName.indexOf('[');
	 * 
	 * int lIndex = fieldName.lastIndexOf(']') + 1;
	 * 
	 * fieldName = fieldName.replace(fieldName.substring(sIndex, lIndex), "");
	 * 
	 * }
	 * 
	 * // String fieldName = fail.getField().toString().split("\\].")[1];
	 * 
	 * String expectedValue = fail.getActual().toString();
	 * 
	 * String actualValue = fail.getExpected().toString();
	 * 
	 * String expectedFieldType = fail.getActual().getClass().getSimpleName();
	 * 
	 * String actualFieldType = fail.getExpected().getClass().getSimpleName();
	 * 
	 * test.log(LogStatus.FAIL,
	 * 
	 * "Field validation failed for <b>'" + fieldName +
	 * "'</b><br> Expected Value is <b>'"
	 * 
	 * + expectedValue + "'</b>, Actual Value is <b>'" + actualValue
	 * 
	 * + "'</b>.<br> Expected Field Data Type is <b>'" + expectedFieldType
	 * 
	 * + "'</b>, Actual Field Data Type is <b>'" + actualFieldType + "'</b>.");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (res.isMissingOnField()) {
	 * 
	 * List<FieldComparisonFailure> fFailures = res.getFieldMissing();
	 * 
	 * for (FieldComparisonFailure fail : fFailures) {
	 * 
	 * String fieldName = fail.getField().toString();
	 * 
	 * String expectedValue = fail.getExpected().toString();
	 * 
	 * test.log(LogStatus.FAIL,
	 * 
	 * "<b>'" + fieldName +
	 * "' </b>field is missing in the actual response. Expected Value is <b>'"
	 * 
	 * + expectedValue + "'</b>.");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (res.isUnexpectedOnField()) {
	 * 
	 * List<FieldComparisonFailure> fFailures = res.getFieldUnexpected();
	 * 
	 * for (FieldComparisonFailure fail : fFailures) {
	 * 
	 * String fieldName = fail.getField().toString();
	 * 
	 * test.log(LogStatus.FAIL,
	 * 
	 * "<b>'" + fieldName +
	 * "' </b>field is added additionally in the actual response.");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } catch (JSONException e) {
	 * 
	 * test.log(LogStatus.FAIL, "JSON Comparison failed<br>" + e.getMessage());
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * }
	 */
	// *MS & Contract Testing

	/*
	 * public void validateSchemaResponseLogJSONDifference(String actualResponse,
	 * String expectedResponse, ExtentTest test)
	 * 
	 * throws UnsupportedEncodingException {
	 * 
	 * JSONCompareResult res = null;
	 * 
	 * try {
	 * 
	 * JSONObject actualObject = new JSONObject(actualResponse);
	 * 
	 * JSONObject expectedObject = new JSONObject(expectedResponse);
	 * 
	 * res = JSONCompare.compareJSON(actualObject, expectedObject,
	 * JSONCompareMode.LENIENT);
	 * 
	 * 
	 * 
	 * if (res.passed()) { test.log(LogStatus.PASS, "<b>Expected Response:</b> " +
	 * 
	 * expectedResponse + "<br><b>Actual Response:</b> " + actualResponse); } else {
	 * 
	 * test.log(LogStatus.FAIL, "<b>Expected Response:</b> " + expectedResponse +
	 * 
	 * "<br><b>Actual Response:</b> " + actualResponse); }
	 * 
	 * 
	 * 
	 * if (res.isFailureOnField()) {
	 * 
	 * List<FieldComparisonFailure> fFailures = res.getFieldFailures();
	 * 
	 * for (FieldComparisonFailure fail : fFailures) {
	 * 
	 * String fieldName = fail.getField().toString();
	 * 
	 * if (fieldName.contains("[") && fieldName.contains("]")) {
	 * 
	 * int sIndex = fieldName.indexOf('[');
	 * 
	 * int lIndex = fieldName.lastIndexOf(']') + 1;
	 * 
	 * fieldName = fieldName.replace(fieldName.substring(sIndex, lIndex), "");
	 * 
	 * }
	 * 
	 * // String fieldName = fail.getField().toString().split("\\].")[1];
	 * 
	 * String expectedValue = fail.getActual().toString();
	 * 
	 * String actualValue = fail.getExpected().toString();
	 * 
	 * String expectedFieldType = fail.getActual().getClass().getSimpleName();
	 * 
	 * String actualFieldType = fail.getExpected().getClass().getSimpleName();
	 * 
	 * if (!actualFieldType.equalsIgnoreCase(expectedFieldType)) {
	 * 
	 * test.log(LogStatus.FAIL,
	 * 
	 * "Field validation failed for <b>'" + fieldName +
	 * "'</b><br> Expected Value is <b>'"
	 * 
	 * + expectedValue + "'</b>, Actual Value is <b>'" + actualValue
	 * 
	 * + "'</b>.<br> Expected Field Data Type is <b>'" + expectedFieldType
	 * 
	 * + "'</b>, Actual Field Data Type is <b>'" + actualFieldType + "'</b>.");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (res.isMissingOnField()) {
	 * 
	 * List<FieldComparisonFailure> fFailures = res.getFieldMissing();
	 * 
	 * for (FieldComparisonFailure fail : fFailures) {
	 * 
	 * String fieldName = fail.getField().toString();
	 * 
	 * String expectedValue = fail.getExpected().toString();
	 * 
	 * test.log(LogStatus.FAIL,
	 * 
	 * "<b>'" + fieldName +
	 * "' </b>field is missing in the actual response. Expected Value is <b>'"
	 * 
	 * + expectedValue + "'</b>.");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (res.isUnexpectedOnField()) {
	 * 
	 * List<FieldComparisonFailure> fFailures = res.getFieldUnexpected();
	 * 
	 * for (FieldComparisonFailure fail : fFailures) {
	 * 
	 * String fieldName = fail.getField().toString();
	 * 
	 * test.log(LogStatus.FAIL,
	 * 
	 * "<b>'" + fieldName +
	 * "' </b>field is added additionally in the actual response.");
	 * 
	 * }
	 * 
	 * }
	 * 
	 * } catch (JSONException e) {
	 * 
	 * test.log(LogStatus.FAIL, "JSON Comparison failed<br>" + e.getMessage());
	 * 
	 * e.printStackTrace();
	 * 
	 * }
	 * 
	 * }
	 */
	// *MS

	public void validateStatusCode(String actualStatusCode, String expectedStatusCode, ExtentTest test)

			throws UnsupportedEncodingException {

		if (actualStatusCode.replaceAll(" ", "").equalsIgnoreCase(expectedStatusCode.replaceAll(" ", "")))

			test.log(LogStatus.PASS, "<b>Expected Status Code: </b> " + expectedStatusCode

					+ "    <br><b>Actual Status Code: </b> " + actualStatusCode);

		else

			test.log(LogStatus.FAIL, "<b>Expected Status Code: </b> " + expectedStatusCode

					+ "    <br><b>Actual Status Code: </b> " + actualStatusCode);

	}

	// *MS

	public void validateJSONResponse(String actualResponse, String expectedValue, String strJsonPath, ExtentTest test) {

		JsonPath jsonPath = new JsonPath(actualResponse);

		String strActualValue = jsonPath.getString(strJsonPath);

		if (expectedValue.equalsIgnoreCase(strActualValue)) {

			test.log(LogStatus.PASS, "Test Passed");

		} else {

			test.log(LogStatus.FAIL, "Test Failed");

		}

	}

	// *MS

	public void validateXMLResponse(String actualResponse, String expectedValue, String strJsonPath, ExtentTest test) {

		XmlPath xmlPath = new XmlPath(actualResponse);

		String strActualValue = xmlPath.getString(strJsonPath);

		if (expectedValue.equalsIgnoreCase(strActualValue)) {

			test.log(LogStatus.PASS, "Test Passed");

		} else {

			test.log(LogStatus.FAIL, "Test Failed");

		}

	}

	// *MS

	public Response retrievePostResponse(String strPayload, Properties globalProp) {

		return given().header("Content-Type", "application/json").body(strPayload).when()

				.post(globalProp.getProperty("endpoint")).then().extract().response();

	}

	public Response retrieveGetResponse(Properties globalProp) {

		return given().header("Content-Type", "application/json").when().get(globalProp.getProperty("getendpoint"))

				.then().extract().response();

	}

	// *MS

	/*
	 * public void validateIndividualFields(Response resp, ExtentTest test, String
	 * strFieldName, String strExpectedValue)
	 * 
	 * throws Exception {
	 * 
	 * JsonPath js = new JsonPath(resp.asString());
	 * 
	 * String strActualValue = js.get(strFieldName);
	 * 
	 * validateResponse(strActualValue, strExpectedValue, test);
	 * 
	 * }
	 */

	public void assertEqualValue(String propertyName, String actual, String expected, ExtentTest test)

			throws UnsupportedEncodingException {

		if (actual.replaceAll(" ", "").equalsIgnoreCase(expected.replaceAll(" ", ""))) {

			test.log(LogStatus.PASS, "<b>Expected value of " + propertyName + " : </b> " + expected

					+ "    <br><b>Actual value of " + propertyName + " : </b> " + actual);

			Assert.assertTrue(true);

		} else {

			test.log(LogStatus.FAIL, "<b>Expected value of " + propertyName + " : </b> " + expected

					+ "    <br><b>Actual value of " + propertyName + " : </b> " + actual);

			Assert.assertTrue(false);

		}

	}

	public void assertContainsValue(String propertyName, String actual, String expected, ExtentTest test)

			throws UnsupportedEncodingException {

		if (actual.replaceAll(" ", "").contains(expected.replaceAll(" ", ""))) {

			test.log(LogStatus.PASS, "<b>Expected value of " + propertyName + " : </b> " + expected

					+ "    <br><b>Actual value of " + propertyName + " : </b> " + actual);

			Assert.assertTrue(true);

		} else {

			test.log(LogStatus.FAIL, "<b>Expected value of " + propertyName + " : </b> " + expected

					+ "    <br><b>Actual value of " + propertyName + " : </b> " + actual);

			Assert.assertTrue(false);

		}

	}

	public void assertNotEmpty(String propertyName, String propertyValue, ExtentTest test) {

		if (!propertyValue.isBlank())

			test.log(LogStatus.PASS, "<b>Value of " + propertyName + " is not empty ");

		else

			test.log(LogStatus.FAIL, "<b>Value of " + propertyName + " is empty ");

	}

	public Response getAuthToken_Partnerauth(String endPointUrl, Properties globalProp, ExtentTest test)

	{

		test.log(LogStatus.INFO, "<b>Request Type: </b> POST");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response response = given().auth().preemptive()
				.basic("e0cc2106-e0cb-4463-9bb5-4ee5c3a8982d", "KePDra7wz33xBE8yVccDON6UbL")

				.contentType("application/x-www-form-urlencoded; charset=utf-8")

				.formParam("grant_type", "client_credentials").when().post(endPointUrl);

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(response));

		return response;

	}

	public Response getAuthToken_ClientIntrospect(String endPointUrl, Properties globalProp, ExtentTest test,
			String Accesstoken)

	{

		test.log(LogStatus.INFO, "<b>Request Type: </b> POST");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response response = given().auth().preemptive()
				.basic("e0cc2106-e0cb-4463-9bb5-4ee5c3a8982d", "KePDra7wz33xBE8yVccDON6UbL")

				.contentType("application/x-www-form-urlencoded; charset=utf-8")

				.formParam("token", Accesstoken)

				.formParam("endpoint", "/subscription/validate").when().post(endPointUrl);

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(response));

		return response;

	}

	public Response getAuthToken_Mirage(String endPointUrl, Properties globalProp, ExtentTest test, String posttag)

	{

		test.log(LogStatus.INFO, "<b>Request Type: </b> POST");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response response = given()

				.contentType("application/x-www-form-urlencoded; charset=utf-8")

				.formParam("token", posttag).when().post(endPointUrl);

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(response));

		return response;

	}

	public Response executeDeleteAPI(String endPointUrl, String body, Properties globalProp, ExtentTest test,

			Hashtable<String, String> headers) {

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Type: </b> DELETE");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Body: </b>" + body);

		Response res = given().headers(headers).body(body).when().delete(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	public Response executeDeleteAPIEncoding(String endPointUrl, Properties globalProp, ExtentTest test,

			Hashtable<String, String> headers) {

		// RequestSpecification httpRequest = RestAssured.given();

		// test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		test.log(LogStatus.INFO, "<b>Request Type: </b> DELETE");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response res = given().urlEncodingEnabled(false).headers(headers).when().delete(endPointUrl).then().extract()
				.response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

	public Response executeGetAPIEncodingURL(String endPointUrl, Properties globalProp, ExtentTest test,

			Hashtable<String, String> headers) {

		test.log(LogStatus.INFO, "<b>Request Type: </b> GET");

		test.log(LogStatus.INFO, "<b>URL: </b>" + RestAssured.baseURI + endPointUrl);

		Response res;

		res = given().urlEncodingEnabled(false).headers(headers).when().get(endPointUrl).then().extract().response();

		test.log(LogStatus.INFO, "<b>Response: </b>" + hiddenExpandResponse(res));

		return res;

	}

}
