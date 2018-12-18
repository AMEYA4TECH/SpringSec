
package org.arpit.java2blog.springmvc.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("username")
public class HelloWorldController {

	@RequestMapping("/helloworld")
	public ModelAndView hello(ModelMap model,Principal principal,HttpServletRequest httpServletRequest) {
		/*HttpSession session = httpServletRequest.getSession();
		session.setMaxInactiveInterval(1*60);*/
		String loggedInUserName=principal.getName();
		
		return new ModelAndView("hello", "userName", loggedInUserName);
	}
	
	@RequestMapping("/admin")
	public ModelAndView helloAdmin(ModelMap model,Principal principal) {

		String loggedInUserName=principal.getName();
		
		return new ModelAndView("admin", "userName", loggedInUserName);
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";

	}

	@RequestMapping(value="/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}
	
	// for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied(Principal user) {

			ModelAndView model = new ModelAndView();
			if (user != null) {
				model.addObject("msg", "Hi " + user.getName()
				+ ", You can not access this page!");
			} else {
				model.addObject("msg",
				"You can not access this page!");
			}

			model.setViewName("403");
			return model;
		}
		
		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String onLogoutSuccess(HttpServletRequest httpServletRequest,
				HttpServletResponse httpServletResponse,
				Authentication authentication) throws IOException, ServletException {
			HttpSession session= httpServletRequest.getSession(false);
		    SecurityContextHolder.clearContext();
		         session= httpServletRequest.getSession(false);
		        if(session != null) {
		            session.invalidate();
		        }
		        for(Cookie cookie : httpServletRequest.getCookies()) {
		            cookie.setMaxAge(0);
		        }

			
			if (authentication != null && authentication.getDetails() != null) {
				try {
					httpServletRequest.getSession().invalidate();
					System.out.println("User Successfully Logout");
					// you can add more codes here when the user successfully logs
					// out,
					// such as updating the database for last active.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("User Successfully Logout");
			httpServletResponse.setStatus(HttpServletResponse.SC_OK);
			// redirect to login
			// httpServletResponse.sendRedirect("/login");
			return "login";
		}
		@RequestMapping(value="/invSession", method = RequestMethod.GET)
		public String inValidSession(ModelMap model) {
		//	model.addAttribute("error", "true");
			
			System.out.println("Hi ur seesion is expried");
			return "invsession";
		}
		
}

