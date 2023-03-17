package com.srvcode.springboot.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/*
 * If we want to specify Java-based configuration for our Spring MVC projects,
 * we need our configuration class to implement this WebMvcConfigurer interface.
 * 
 * 
 */
@Configuration
public class InternationalizationService implements WebMvcConfigurer{

	/*
	 * The localResolver bean allows us to determine the default locale for our application
	 * Here we've set the default locale to be Locale.US
	 */
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	/*
	 * An interceptor in Spring is a component that processes our request before passing
	 * our request on to Spring MVC's controller.
	 * 
	 * All of our incoming web requests along with the request path will pass 
	 * through this localeChangeInterceptor. It will be processed before it's passed on to the 
	 * controller that renders the view corresponding to that path.
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localChangeInterceptor = new LocaleChangeInterceptor();
		// Here the localeChangeInterceptor basically sets the ParamName as lang
		localChangeInterceptor.setParamName("lang");
		return localChangeInterceptor;
	}
	
	/*
	 * Now in order for the above localeChangeInterceptor to actually take effect,
	 * we need to explicitly add this interceptor to the interceptor registry in our application.
	 * 
	 * Using this interceptor essentially tells Spring use the lang param in order to determine
	 * the locale of this app & the lang in which the messages will be displayed.
	 * 
	 * message_<locale>.properties : The locale will be specified using "lang" request parameter.
	 * message_french : lang=french
	 * message_latin : lang=latin
	 * 
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
}
