package com.luv2code.springdemo.customSuccessHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
     
    @Override
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);
  
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
  
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
     
    protected String determineTargetUrl(Authentication authentication) {
        String url="";
         
        Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();
         
        List<String> roles = new ArrayList<String>();
 
        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }
 
         if (isUser(roles)) {
        	
            url = "/logged/a";
        } 
 
        return url;
    }
  
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
     
    private boolean isUser(List<String> roles) {
        if (roles.contains("ROLE_USERS")) {
            return true;
        }
        return false;
    }
 

 
}
