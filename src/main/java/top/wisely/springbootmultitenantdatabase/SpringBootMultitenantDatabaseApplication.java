package top.wisely.springbootmultitenantdatabase;

import org.hibernate.engine.jdbc.connections.spi.DataSourceBasedMultiTenantConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.HashMap;

@SpringBootApplication
public class SpringBootMultitenantDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultitenantDatabaseApplication.class, args);
	}


}
