package org.arpit.java2blog.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class SessionHandler extends HandlerInterceptorAdapter{
	private static final long MAX_INACTIVE_SESSION_TIME = 5 * 10000;

    @Autowired
    private HttpSession session;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		 long startTime = System.currentTimeMillis();
	        request.setAttribute("executionTime", startTime);
	        if (isUserLogged()) {
	            session = request.getSession();
	            //System.out.println("Time since last request in this session: {} ms", System.currentTimeMillis() - request.getSession().getLastAccessedTime());
	            if (System.currentTimeMillis() - session.getLastAccessedTime() > MAX_INACTIVE_SESSION_TIME) {
	               // log.warn("Logging out, due to inactive session");
	                SecurityContextHolder.clearContext();
	                request.logout();
	                System.out.println("timeout session");
	                response.sendRedirect("/logout");
	            }
	        }
	        return true;
	}
	
	public static boolean isUserLogged() {
        try {
            return !SecurityContextHolder.getContext().getAuthentication().getName().equals("arpit");
        } catch (Exception e) {
            return false;
        }
    }

}
