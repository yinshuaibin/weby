package com.y.config.shiro;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import com.alibaba.druid.util.StringUtils;

public class MySessionManager extends DefaultWebSessionManager {

	private static final String AUTHORIZATION = "Authorization";

	private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

	//是否使用Servlet容器的会话
	@Override
	public boolean isServletContainerSessions() {
		return true;
	}

	public MySessionManager() {
		super();
	}
	@Override
	protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
		String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
		//如果请求头中有 Authorization 则其值为sessionId
		if (!StringUtils.isEmpty(id)) {
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
			request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
			return id;
		} else {
			//否则按默认规则从cookie取sessionId
			return super.getSessionId(request, response);
		}
	}

}
