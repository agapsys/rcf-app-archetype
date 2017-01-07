#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

import ${package}.ServletContainerBuilder;
import com.agapsys.http.HttpGet;
import com.agapsys.http.HttpResponse;
import com.agapsys.sevlet.container.ServletContainer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SampleControllerTest {

	private ServletContainer sc;
	private HttpResponse.StringResponse resp;

	@Before
	public void before() {
		sc = new ServletContainerBuilder()
			.registerController(SampleController.class)
			.build();

		sc.startServer();
	}

	@After
	public void after() {
		sc.stopServer();
	}

	@Test
	public void testGetObject1() {
		resp = sc.doRequest(new HttpGet("/sample/getObject"));

		Assert.assertEquals(200, resp.getStatusCode());
		Assert.assertEquals("${symbol_escape}"Hello world!${symbol_escape}"", resp.getContentString());
	}

	@Test
	public void testGetObject2() {
		resp = sc.doRequest(new HttpGet("/sample/"));

		Assert.assertEquals(200, resp.getStatusCode());
		Assert.assertEquals("${symbol_escape}"Hello world!${symbol_escape}"", resp.getContentString());

        resp = sc.doRequest(new HttpGet("/sample/"));

		Assert.assertEquals(200, resp.getStatusCode());
		Assert.assertEquals("${symbol_escape}"Hello world!${symbol_escape}"", resp.getContentString());
	}

	@Test
	public void testGet() {
		resp = sc.doRequest(new HttpGet("/sample/get"));

		Assert.assertEquals(200, resp.getStatusCode());
		Assert.assertEquals("Hello world!", resp.getContentString());
	}
}
