#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controllers;

import com.agapsys.rcf.Controller;
import com.agapsys.rcf.HttpMethod;
import com.agapsys.rcf.HttpRequest;
import com.agapsys.rcf.HttpResponse;
import com.agapsys.rcf.WebAction;
import com.agapsys.rcf.WebController;
import java.io.IOException;

@WebController("sample")
public class SampleController extends Controller {

	@WebAction(httpMethods = HttpMethod.GET, mapping = "/getObject", defaultAction = true)
	public String getObject(HttpRequest req) {
		return "Hello world!";
	}

	@WebAction
	public void get(HttpRequest request, HttpResponse response) throws IOException {
		response.getServletResponse().getWriter().print("Hello world!");
	}

}
