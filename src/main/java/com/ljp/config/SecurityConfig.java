package com.ljp.config;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

import com.alibaba.fastjson.JSON;
import com.ljp.bean.User;
import com.ljp.bean.UserSafe;
import com.ljp.monitor.Monitor;
import com.ljp.service.UserSafeService;
import com.ljp.service.UserService;
import com.ljp.utils.CommonUtil;
import com.ljp.utils.JwtUtil;

import io.jsonwebtoken.Claims;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private DataSource dataSource;
	
	@Autowired
	private UserSafeService userSafeService;
	@Autowired
	private UserService userService;
	
	//初始化顺序的问题，所以把DataSource放在这里
	public SecurityConfig(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return new PasswordEncoder() {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
//				int l1=rawPassword.length();
//				int l2=encodedPassword.length();
//				if(l1!=l2)return false;
//				for(int i=0;i<l1;i++) {
//					if(rawPassword.charAt(i)!=encodedPassword.charAt(i)){
//						return false;
//					}
//				}
				System.out.println("rawPassword:"+rawPassword+",encodedPassword:"+encodedPassword);
				boolean matches = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
				return matches;
			}
			@Override
			public String encode(CharSequence rawPassword) {
				String encode = bCryptPasswordEncoder.encode(rawPassword);
				System.out.println("rawPassword:"+rawPassword+",encode:"+encode);
				return encode;
			}
		};
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				System.out.println("userDetailsService.do->username:"+username);
				User user = userService.searchByName(username);
				System.out.println(user);
				return user;
			}
		});
		auth.jdbcAuthentication().passwordEncoder(getPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.userDetailsService(new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				System.out.println("userDetailsService.do->username:"+username);
//				User user = userService.searchByName(username);
//				System.out.println(user);
//				return user;
//			}
//		});
		//设置头的filter
		http.addFilterBefore(new Filter() {
			@Override
			public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
					throws IOException, ServletException {
				HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;
				HttpServletResponse httpServletResponse = (HttpServletResponse) arg1;
				httpServletRequest.setCharacterEncoding("UTF-8");
				httpServletResponse.setCharacterEncoding("UTF-8");
				httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
				httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
				httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
				Monitor.incream("all");
				System.out.println("MobleType:"+httpServletRequest.getHeader("User-Agent"));
				Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
				System.out.println("parameterNames");
				while(parameterNames.hasMoreElements()) {
					System.out.println(parameterNames.nextElement());
				}
				System.out.println("attributeNames");
				Enumeration<String> attributeNames = httpServletRequest.getAttributeNames();
				while(attributeNames.hasMoreElements()) {
					System.out.println(attributeNames.nextElement());
				}
				System.out.println("getHeaderNames");
				Enumeration<String> names = httpServletRequest.getHeaderNames();
				while(names.hasMoreElements()) {
					System.out.println(names.nextElement());
				}
				System.out.println(httpServletRequest.getHeader("Authorization"));
				//TODO axios的auth在header里的“Authorization”，不知用了什么加密方式
				arg2.doFilter(httpServletRequest, httpServletResponse);
			}
		}, WebAsyncManagerIntegrationFilter.class);
		//jwt 认证filter
		UsernamePasswordAuthenticationFilter u;
		http.addFilterAfter(new Filter() {
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
					throws IOException, ServletException {
				HttpServletRequest httpServletRequest = (HttpServletRequest) request;
				HttpServletResponse httpServletResponse = (HttpServletResponse) response;
				String token = httpServletRequest.getHeader("jwt-token");
				System.out.println("getHeader.token:"+token);
				if(token==null) {
					System.out.println("没有发现jwt令牌");
					chain.doFilter(httpServletRequest, httpServletResponse);
					return;
				}
				Claims claims = JwtUtil.checkJWT(token);
				if(claims==null||JwtUtil.isExpiration(claims)){
					System.out.println("jwt令牌已过期或无效");
//					httpServletResponse.sendError(407);
//					httpServletResponse.getWriter().append("false");
//					httpServletResponse.setContentType("text/text");
					chain.doFilter(httpServletRequest, httpServletResponse);
					return;
				}
				//TODO JWTUtil getPassword异常,估计是密码保护
				SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
						JwtUtil.getUserName(claims), "", 
						Collections.singleton(new SimpleGrantedAuthority(JwtUtil.getUserRole(claims)))));
				System.out.println("jwt令牌认证成功");
				chain.doFilter(httpServletRequest, httpServletResponse);
			}
		}, UsernamePasswordAuthenticationFilter.class);
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET).permitAll()
			.antMatchers(HttpMethod.OPTIONS).permitAll()
			.antMatchers("/login","/","/tc/shop/goods/category/list","error").permitAll()
			
			.anyRequest().authenticated()
//			.anyRequest().permitAll()
			.and()
			.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
//			.loginPage("/login")
			.successHandler(new AuthenticationSuccessHandler() {
				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						Authentication authentication) throws IOException, ServletException {
					System.out.println("authentication"+authentication);
					UserDetails principal = (UserDetails) authentication.getPrincipal();
					String token = JwtUtil.generateJsonWebToken(principal);
					System.out.println("认证成功，令牌是："+token);
					UserSafe safeInfo = CommonUtil.getSafeInfo(request);
					safeInfo.setUserId(((User)principal).getId());//TODO
					int isSafe = userSafeService.updateInfo(safeInfo);
					System.out.println("isSafe"+isSafe);
					response.getWriter().write(JSON.toJSONString(token));
					response.getWriter().close();
				}
			}).failureHandler(new AuthenticationFailureHandler() {
				@Override
				public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException exception) throws IOException, ServletException {
					//TODO 认证失败应该处理一下吧
					System.out.println("登录失败");
			        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//					response.getWriter().write("false");
//					response.getWriter().close();
				}
			})
			.and()
			.logout().disable()
			.cors().disable().csrf().disable()
			.sessionManagement()
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and();
	        http.exceptionHandling()
	        .accessDeniedHandler(new AccessDeniedHandler() {
				
				@Override
				public void handle(HttpServletRequest request, HttpServletResponse response,
						AccessDeniedException accessDeniedException) throws IOException, ServletException {
					//TODO jwt认证异常处理
					System.out.println("jwt认证异常");
			        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//					response.setStatus(407);
//					response.setContentType("text/text");
//					response.getWriter().write("false");
//					response.getWriter().close();
				}
			})
	        .authenticationEntryPoint(new AuthenticationEntryPoint() {
				@Override
				public void commence(HttpServletRequest request, HttpServletResponse response,
						AuthenticationException authException) throws IOException, ServletException {
					//TODO jwt认证异常处理
					System.out.println("jwt认证异常");
			        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//					response.setStatus(407);
//					response.sendError(407, "没有权限");
//					response.setContentType("text/text");
//					response.getWriter().write("false");
//					response.getWriter().close();
				}
			});
	}
	
}
