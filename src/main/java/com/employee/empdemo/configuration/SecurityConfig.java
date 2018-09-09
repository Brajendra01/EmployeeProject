package com.employee.empdemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Bean("authenticationManager")
	 @Override
	 public AuthenticationManager authenticationManagerBean() throws Exception {
		 return super.authenticationManagerBean();
	 }
	
	@Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		System.out.println("SecurityConfig--> configureGlobal():::");
		auth.inMemoryAuthentication().withUser("ajay").password("{noop}123").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN");
		
	}
	
	//.csrf() is optional, enabled by default, if using WebSecurityConfigurerAdapter constructor
	
	@Override
	public void configure(HttpSecurity http)throws Exception{
		System.out.println("Configure():::");
		http.csrf().disable();
		http.authorizeRequests()
		// this line will authentic all request, if you wanna hit a request without login, it will redirect to login page
		// if you login successfull then you can access any data.
		.antMatchers("/","/loginPage").permitAll().anyRequest().authenticated()
		
			// based on role we are going to redirect to the page , like ADMIN, USER etc.
			.antMatchers("/homePage").access("hasRole('ROLE_USER')")
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
			.and()
			   // loginPage() method we use for custom login page.
				.formLogin().loginPage("/loginPage").successHandler(myAuthenticationSuccessHandler())
				// after successfull login , by default we redirect to home page.
				//.defaultSuccessUrl("/homePage")
				.failureUrl("/loginPage?error")
				.usernameParameter("username").passwordParameter("password")				
			.and()
				.logout().logoutSuccessUrl("/loginPage?logout"); 
		
	}
	
	
	

}
