//package com.srvcode.apiproxy.filter;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//
//public class ErrorFilter extends ZuulFilter {
//
//	private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);
//
//	@Override
//	public boolean shouldFilter() {
//		return true;
//	}
//
//	@Override
//	public Object run() throws ZuulException {
//		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
//
//		log.info("ErrorFilter:" + String.format("response status is %d", response.getStatus()));
//		return null;
//	}
//
//	@Override
//	public String filterType() {
//		return "error";
//	}
//
//	@Override
//	public int filterOrder() {
//		return 1;
//	}
//
//}
