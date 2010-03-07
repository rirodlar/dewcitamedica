package pe.com.citasmedicas.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author dew - Grupo 04
 */
public class AutenticacionInterceptor implements Interceptor {

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext ctx = ActionContext.getContext();
        Map session = ctx.getSession();
        System.out.println("...interceptor");
        if (session.get("usuario") == null) {
            System.out.println("...la sesión ha caducado");
            return "login";
        } else {
            System.out.println("...todo ok");
            return invocation.invoke();
        }
    }
}
