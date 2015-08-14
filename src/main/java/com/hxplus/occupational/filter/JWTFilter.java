package com.hxplus.occupational.filter;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import com.hxplus.occupational.service.AuthenticationServiceImpl;

@WebFilter(urlPatterns = "/user/*", 
	filterName = "AuthenticationFilter", 
	description = "Filter all URLs ", 
	initParams = { 
		@WebInitParam(name = "unprotectedUrls", 
					value = "/,/login,/user") 
		}
)
public class JWTFilter implements Filter {
	
	private final String secretkey = AuthenticationServiceImpl.getKey();
	private final SignatureAlgorithm signatureAlgorithm = AuthenticationServiceImpl.getSignaturealgorithm(); 

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        
        System.out.println("···············");
        Enumeration<String> headers = request.getHeaderNames(), atributes = request.getAttributeNames(), params = request.getParameterNames();
        System.out.println("Headers:");
        while(headers.hasMoreElements()){
        	String header = headers.nextElement(); 
        	System.out.println(header);
        	System.out.println("\t\t\t\t" + request.getHeader(header));
        }
        System.out.println("···············");
        System.out.println("Attributes:");
        while(atributes.hasMoreElements()){
        	System.out.println(atributes.nextElement());
        }
        System.out.println("···············");
        System.out.println("Parameters:");
        while(params.hasMoreElements()){
        	System.out.println(params.nextElement());
        }
        System.out.println("···············");
        

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
        	System.out.println("Header: " + authHeader);
            throw new ServletException("Missing or invalid Authorization header.");
        }

        final String token = authHeader.substring(7); // The part after "Bearer "

        try {
            final Claims claims = Jwts.parser().setSigningKey(secretkey)
                .parseClaimsJws(token).getBody();
            request.setAttribute("claims", claims);
        }
        catch (final SignatureException e) {
            throw new ServletException("Invalid token.");
        }

        chain.doFilter(req, res);
    }
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
