//package com.srvcode.apiproxy.filter;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//
//public class RouteFilter extends ZuulFilter {
//
//	private static Logger log = LoggerFactory.getLogger(RouteFilter.class);
//
//	@Override
//	public boolean shouldFilter() {
//		return true;
//	}
//
//	@Override
//	public Object run() throws ZuulException {
//		RequestContext ctx = RequestContext.getCurrentContext();
//		HttpServletRequest request = ctx.getRequest();
//
//		log.info("RouteFilter:"
//				+ String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
//		return null;
//	}
//
//	@Override
//	public String filterType() {
//		return "route";
//	}
//
//	@Override
//	public int filterOrder() {
//		return 1;
//	}
//
//}
