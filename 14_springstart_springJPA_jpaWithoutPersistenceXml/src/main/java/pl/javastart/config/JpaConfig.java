package pl.javastart.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JpaConfig {

	
	@Bean
	public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		Map<String, String> prop = new HashMap<>();
		
		prop.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/library1?useSSL=false&serverTimezone=UTC");
		prop.put("javax.persistence.jdbc.user" , "root");
		prop.put("javax.persistence.jdbc.password", "admin");
		prop.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        prop.put("javax.persistence.schema-generation.database.action", "none");
		
        emf.setPersistenceUnitName("spring-jpa-pu");
        emf.setJpaPropertyMap(prop);
        emf.setJpaVendorAdapter(adapter);
        emf.setPackagesToScan("pl.javastart.model");
		
		return emf;
	}
	
	
	@Bean
	public JpaVendorAdapter createAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		return adapter;	
	}
	

	
}
