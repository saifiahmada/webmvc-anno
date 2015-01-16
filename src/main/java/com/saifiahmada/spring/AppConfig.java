package com.saifiahmada.spring;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.saifiahmada.spring" })
@PropertySource(value = { "classpath:application.properties" })
@EnableJpaRepositories(basePackages = { "com.saifiahmada.spring.repository" })
public class AppConfig extends WebMvcConfigurerAdapter {

	
	@Autowired 
	private Environment env;
	 

	/*
	 * @Override public void addResourceHandlers(ResourceHandlerRegistry
	 * registry) { registry.addResourceHandler("/assets/**")
	 * .addResourceLocations("classpath:/META-INF/resources/webjars/")
	 * .setCachePeriod(31556926);
	 * registry.addResourceHandler("/css/**").addResourceLocations("/css/")
	 * .setCachePeriod(31556926);
	 * registry.addResourceHandler("/img/**").addResourceLocations("/img/")
	 * .setCachePeriod(31556926);
	 * registry.addResourceHandler("/js/**").addResourceLocations("/js/")
	 * .setCachePeriod(31556926); }
	 */

	/*
	 * @Override public void configureDefaultServletHandling(
	 * DefaultServletHandlerConfigurer configurer) { configurer.enable(); }
	 */

	/*
	 * @Bean public InternalResourceViewResolver
	 * getInternalResourceViewResolver() { InternalResourceViewResolver resolver
	 * = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/jsp/"); resolver.setSuffix(".jsp"); return
	 * resolver; }
	 */

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer
				.setDefinitions(new String[] { "/WEB-INF/defs/general.xml" });
		return tilesConfigurer;
	}

	@Bean
	public UrlBasedViewResolver ViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver
				.setViewClass(org.springframework.web.servlet.view.tiles3.TilesView.class);
		return viewResolver;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		EntityManagerFactory factory = entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);
		factory.setPackagesToScan("com.saifiahmada.spring.domain");
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(vendorAdapter);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto")); 
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory;
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClass"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}

}
