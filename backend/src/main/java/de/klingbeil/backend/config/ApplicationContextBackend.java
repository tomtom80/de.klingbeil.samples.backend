package de.klingbeil.backend.config;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ImportResource("classpath:applicationContext.xml")
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"de.klingbeil.backend.controller",
		"de.klingbeil.backend.service", "de.klingbeil.backend.entity"})
@Import({ApplicationContextDataSource.class, ApplicationContextAware.class})
public class ApplicationContextBackend {
	private static final String PROPERTY_NAME_MESSAGESOURCE_BASENAME = "message.source.basename";
	private static final String PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE = "message.source.use.code.as.default.message";
	private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/jsp/";
	private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

	@Resource
	private Environment environment;

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(environment
				.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_BASENAME));
		messageSource
				.setUseCodeAsDefaultMessage(Boolean.parseBoolean(environment
						.getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE)));
		return messageSource;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
		viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);
		return viewResolver;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}
}
