#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

import com.agapsys.rcf.Controller;
import com.agapsys.rcf.HttpExchange;
import com.agapsys.rcf.HttpMethod;
import com.agapsys.rcf.WebAction;
import com.agapsys.rcf.WebController;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

@WebController("sample")
public class SampleController extends Controller {

	@WebAction(httpMethods = HttpMethod.GET, mapping = "getObject", defaultAction = true)
	public String getObject(HttpServletRequest req) {
		return "Hello world!";
	}

	@WebAction
	public void get(HttpExchange exchange) throws IOException {
		exchange.getCoreResponse().getWriter().print("Hello world!");
	}

}
