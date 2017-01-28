package fr.mikrethor.cardroom.ws.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import fr.mikrethor.cardroom.ws.jpa.Hand;
import fr.mikrethor.cardroom.ws.jpa.HandRepository;

//Put spring config above all classes in order to allow scan
@SpringBootApplication(scanBasePackages = { "fr.mikrethor.cardroom.ws.controllers", "fr.mikrethor.cardroom.ws.errors",
		"fr.mikrethor.cardroom.ws.jpa", "fr.mikrethor.cardroom.ws.config" })
@EnableJpaRepositories(basePackages = "fr.mikrethor.cardroom.ws.jpa", entityManagerFactoryRef = "cardroomEmf")
@ComponentScan(basePackages = { "fr.mikrethor.cardroom.ws.controllers", "fr.mikrethor.cardroom.ws.errors",
		"fr.mikrethor.cardroom.ws.jpa", "fr.mikrethor.cardroom.ws.config" })
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	// tag::entrypoint[]
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	// end::entrypoint[]

	@Bean
	public DataSource datasource() {
		BasicDataSource ds = new org.apache.commons.dbcp.BasicDataSource();
		ds.setDriverClassName("org.hsqldb.jdbcDriver");
		ds.setUrl("jdbc:hsqldb:file:target/cardroom_bd;create=true");
		ds.setUsername("sa");
		ds.setPassword("");
		return ds;
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
		jpaVendorAdapter.setGenerateDdl(false);
		jpaVendorAdapter.setShowSql(true);
		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean cardroomEmf(DataSource datasource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setPersistenceUnitName("puCardroom");
		em.setDataSource(datasource);
		em.setPackagesToScan(new String[] { "fr.mikrethor.cardroom.ws.jpa" });
		em.setJpaVendorAdapter(jpaVendorAdapter);
		em.setPersistenceProviderClass(HibernatePersistenceProvider.class);

		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.autocommit", "true");
		properties.setProperty("hibernate.current_session_context_class", "thread");
		properties.setProperty("hibernate.default_schema", "CARDROOM");
		properties.setProperty("hibernate.connection.useUnicode", "true");
		properties.setProperty("hibernate.connection.characterEncoding", "UTF-8");
		properties.setProperty("javax.persistence.schema-generation.database.action", "drop-and-create");
		properties.setProperty("javax.persistence.schema-generation.scripts.action", "drop-and-create");
		properties.setProperty("javax.persistence.schema-generation.scripts.create-target", "target/sampleCreate.ddl");
		properties.setProperty("javax.persistence.schema-generation.scripts.drop-target", "target/sampleDrop.ddl");
		properties.setProperty("javax.persistence.schema-generation.create-source", "script-then-metadata");
		// Script pour la création du schéma
		properties.setProperty("javax.persistence.schema-generation.create-script-source", "init-db.sql");
		// script pour le chargement des tables
		properties.setProperty("javax.persistence.sql-load-script-source", "init-data.sql");

		em.setJpaProperties(properties);
		return em;
	}

	@Bean
	public CommandLineRunner demo(HandRepository handRepository) {
		return (args) -> {
			Hand hand = new Hand("testHand");
			hand = handRepository.save(hand);
		};
	}

}
