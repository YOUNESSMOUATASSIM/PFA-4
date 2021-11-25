package mooqaf.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTAuthorizationFilter extends OncePerRequestFilter {


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		response.addHeader("Access-Control-Allow-Origin","*");
		response.addHeader("Access-Control-Allow-Headers","Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Heareds, authorization");
		response.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
		
		if(request.getMethod().equals("OPTIONS"))
		{
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else
		{
			String jwt=request.getHeader("Authorization");
			if(jwt==null || !jwt.startsWith("Bearer "))
			{
				filterChain.doFilter(request, response);
				return ;
			}
			JWTVerifier verifier=JWT.require(Algorithm.HMAC256("mooqaf_Secret")).build();
			DecodedJWT decodedJWT=verifier.verify(jwt.substring("Bearer ".length()));
			String username=decodedJWT.getSubject();
			List<String> roles=decodedJWT.getClaims().get("roles").asList(String.class);
			Collection<GrantedAuthority> autorities=new ArrayList<>();
			roles.forEach(r->{
				autorities.add(new SimpleGrantedAuthority(r));
			});
				
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(username,null, autorities);
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			filterChain.doFilter(request, response);
		}
		
		
	}

}
