package com.djavu.deploy

import javax.sql.DataSource

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.hibernate4.HibernateExceptionTranslator
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.web.filter.DelegatingFilterProxy
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer

@Configuration
class StaticConfig extends WebMvcConfigurerAdapter {

    void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("fonts/*.*").addResourceLocations("fonts/*.*")
        registry.addResourceHandler("/css/*.css").addResourceLocations("css/*.css")
        registry.addResourceHandler("/js/*.js").addResourceLocations("js/*.js")
        registry.addResourceHandler("/*.html").addResourceLocations("*.html")
    }
}

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories('com.djavu.socialevents')
class RepositoryConfig {

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter()
        vendorAdapter.setGenerateDdl true
        vendorAdapter.setShowSql true

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean()
        factory.setJpaVendorAdapter vendorAdapter
        factory.setPackagesToScan 'com.djavu.socialevents'
        factory.setDataSource dataSource()

        return factory
    }

    @Bean
    DataSource dataSource() {
        new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build()
    }

    @Bean
    HibernateExceptionTranslator exceptionTranslator() {
        new HibernateExceptionTranslator()
    }

    @Bean
    JpaTransactionManager transactionManager() {
        new JpaTransactionManager(entityManagerFactory().getObject())
    }
}

@Configuration
@ComponentScan(basePackages = 'com.djavu.socialevents')
@ImportResource('classpath:springmvc-resteasy.xml')
class ApiConfig {
}

class DjavuInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    String[] getServletMappings() {
        [ '/api/*' ]
    }

    Class[] getRootConfigClasses() {
        [ RepositoryConfig.class ]
    }

    Class[] getServletConfigClasses() {
        [ StaticConfig.class, ApiConfig.class ]
    }
}
