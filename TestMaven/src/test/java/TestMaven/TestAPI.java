package TestMaven;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import junit.framework.Assert;

public class TestAPI 
{
	@Test
	public void responseCode()
	{
		int code=get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getStatusCode();
		System.out.println("Status code"+code);
		Assert.assertEquals(code, 200);
	}
	@Test
	public void responseBody()
	{
		String datapart=get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
		long time=get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getTime();
		System.out.println("Status code "+datapart);
		System.out.println("Response Timing "+time);
	//	Assert.assertEquals(datapart, 200);
	}
}
