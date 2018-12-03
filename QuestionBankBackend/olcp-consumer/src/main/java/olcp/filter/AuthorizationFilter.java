//package olcp.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.HashMap;
//
///**
// * 权限拦截器
// */
//@WebFilter
//public class AuthorizationFilter implements Filter {
//
//    public AuthorizationFilter() {
//    }
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationFilter.class);
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        // 支持跨域访问
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,X-Custom-Header");
//        response.setHeader("X-Powered-By", "SpringBoot");
//        if ("option".equalsIgnoreCase(request.getMethod())) {
//            responseJSON(response, new HashMap<>());
//            return;
//        }
////        //除了拦截login.html 其他html都拦截
////        StringBuffer url = request.getRequestURL();
////        //System.out.println(url);
////        String path = url.toString();
////        // 只拦截这些类型请求
////        if (path.endsWith(".do") || path.endsWith(".html")) {
////            // 登录，图片不拦截
////            if (path.endsWith("register")
////                    || path.endsWith("login")
////                    || path.endsWith("logout")
////                    || path.endsWith("error.html")
////                    || path.endsWith("checkuserNickName")) {
////                chain.doFilter(request, response);
////            } else {
////                processAccessControl(request, response, chain);
////            }
////
////        } else {
////            //其他静态资源都不拦截
////            chain.doFilter(request, response);
////        }
//    }
//
//    /**
//     * @param request
//     * @param response
//     * @param chain
//     * @throws IOException
//     * @throws ServletException
//     */
//    private Boolean processAccessControl(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        Object adminUser = request.getSession().getAttribute("login_user");
//        Object user = request.getSession().getAttribute("user");
//        String url = request.getRequestURL().toString();
////        if (url.indexOf("admin") != -1) {
////            if (adminUser == null) {
////                return false;
////            } else {
////                chain.doFilter(request, response);
////            }
////        } else {
////            if (user == null) {
////                return false;
////            } else {
////                chain.doFilter(request, response);
////            }
////        }
//        return true;
//    }
//
//
//    @Override
//    public void destroy() {
//
//    }
//
//    /**
//     * 返回JOSN数据格式
//     *
//     * @param response
//     * @param object
//     * @throws IOException
//     */
//    public static void responseJSON(HttpServletResponse response, Object object) throws IOException {
//        response.setContentType("application/json;charset=utf-8");
//        response.setCharacterEncoding("UTF-8");
//        ObjectMapper mapper = new ObjectMapper();
//        if (object == null)
//            return;
//        String jsonStr = mapper.writeValueAsString(object);
//        OutputStream out = response.getOutputStream();
//        out.write(jsonStr.getBytes("UTF-8"));
//        out.flush();
//    }
//}