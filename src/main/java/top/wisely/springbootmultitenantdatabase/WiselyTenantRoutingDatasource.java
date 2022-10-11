package top.wisely.springbootmultitenantdatabase;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;

@Component
public class WiselyTenantRoutingDatasource  extends AbstractRoutingDataSource {
    private final WiselyTenantIdResolver wiselyTenantIdResolver;

    public WiselyTenantRoutingDatasource(WiselyTenantIdResolver wiselyTenantIdResolver) {
        setDefaultTargetDataSource(createDatabase("jdbc:mysql://127.0.0.1:3306/public"));
        this.wiselyTenantIdResolver = wiselyTenantIdResolver;
        HashMap<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("companya",createDatabase("jdbc:mysql://127.0.0.1:3306/companya"));
        targetDataSources.put("companyb",createDatabase("jdbc:mysql://127.0.0.1:3306/companyb"));
        setTargetDataSources(targetDataSources);
    }


    @Override
    protected String determineCurrentLookupKey() {
        return wiselyTenantIdResolver.resolveCurrentTenantIdentifier();
    }


    private DataSource createDatabase(String databaseUrl) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url(databaseUrl);
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("example");
        return dataSourceBuilder.build();
    }
}
