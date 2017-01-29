#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

import ${package}.RcfContainer;
import com.agapsys.http.HttpGet;
import com.agapsys.http.HttpResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SampleControllerTest {

    private RcfContainer sc;
    private HttpResponse.StringResponse resp;

    @Before
    public void before() {
        sc = RcfContainer.newInstance()
            .registerController(SampleController.class);

        sc.start();
    }

    @After
    public void after() {
        sc.stop();
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
