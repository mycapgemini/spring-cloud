package org.zuul.gatewau.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class SimpleFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
	@Override
	public Object run() {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s request to %s", request.getMethod(),request.getRequestURI().toString()));
		
		System.out.println("NIRAJ KUMAR ::::::::::::::::; "+ request.getMethod());
		return request.getMethod();
	}

	@Override
	public boolean shouldFilter() {
		System.out.println("NIRAJ KUMAR ::::::::::::::::; shouldFilter");
		return false;
	}

	@Override
	public int filterOrder() {
		System.out.println("NIRAJ KUMAR ::::::::::::::::; filterOrder");
		return 1;
	}

	@Override
	public String filterType() {
		System.out.println("NIRAJ KUMAR ::::::::::::::::; filterType");
		return "pre";
	}

}
