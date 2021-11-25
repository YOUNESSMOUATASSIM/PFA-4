package mooqaf.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder= passwordEncoder();
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
			
	} 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.csrf().disable();
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/register**/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/villes**/**","/specialites**/**").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST,"/propositions**/**","/villes**/**","/specialites**/**","/particuliers**/**","/professionnels**/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT,"/propositions**/**","/villes**/**","/specialites**/**","/particuliers**/**","/professionnels**/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/propositions**/**","/villes**/**","/specialites**/**","/particuliers**/**","/professionnels**/**").hasAuthority("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PATCH,"/propositions**/**","/villes**/**","/specialites**/**","/particuliers**/**","/professionnels**/**").hasAuthority("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.logout();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	 public PasswordEncoder passwordEncoder()
	 {
		return new BCryptPasswordEncoder();
		 
	 }
	
}
