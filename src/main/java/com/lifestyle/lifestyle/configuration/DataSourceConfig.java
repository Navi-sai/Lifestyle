package com.lifestyle.lifestyle.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;


 
@Configuration
public class DataSourceConfig {
	
	@Value("${spring.cloud.azure.credential.client-id}")
	private String clientId;
	
	@Value("${spring.cloud.azure.credential.client-secret}")
	private String clientSecret;
	
	@Value("${spring.cloud.azure.credential.tenant-id}")
	private String tenantId;
	
	@Value("${spring.cloud.azure.keyvault.secret.endpoint}")
	private String keyVaultUrl;
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Bean
	public DataSource dataSource() {
		ClientSecretCredential credential = new ClientSecretCredentialBuilder().clientId(clientId).clientSecret(clientSecret).tenantId(tenantId).build();
		
		SecretClient secretClient = new SecretClientBuilder().vaultUrl(keyVaultUrl).credential(credential).buildClient();
		
		String username = secretClient.getSecret("sqlusername").getValue();
		String password = secretClient.getSecret("sqlpassword").getValue();
		
		System.out.println("username is va - " + username);
		System.out.println("password is va - " + password);
		
		return DataSourceBuilder.create().url(dbUrl).username(username).password(password).driverClassName("com.mysql.cj.jdbc.Driver").build();
		
	}

}
