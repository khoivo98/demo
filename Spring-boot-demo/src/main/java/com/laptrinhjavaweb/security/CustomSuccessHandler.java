package com.laptrinhjavaweb.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.util.SecurityUtils;

//class tự do
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	//phan quyen 
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		//neu la admin -> /quan-tri/trang-chu
		//neu la user -> /trang-chu
		List<String> roles = SecurityUtils.getAuthorities();
		if(isAdmin(roles) || isManager(roles)) {
			url = "/admin/home";
		} else if(isUser(roles)) {
			url = "/home";
		}
		return url;
	}
	
	private boolean isAdmin(List<String> roles) {
		return roles.contains("ADMIN");
	}
	private boolean isManager(List<String> roles) {
		return roles.contains("MANAGER");
	}
	private boolean isUser(List<String> roles) {
		return roles.contains("USER");
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	
	
}
