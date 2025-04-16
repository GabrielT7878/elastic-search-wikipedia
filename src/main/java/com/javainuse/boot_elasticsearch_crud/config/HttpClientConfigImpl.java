package com.javainuse.boot_elasticsearch_crud.config;

import java.io.File;

import javax.net.ssl.SSLContext;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfigImpl implements HttpClientConfigCallback {

	@Value("${elastic.security.username}")
	private String username;

	@Value("${elastic.security.password}")
	private String password;


	@Override
	public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
		try {
			final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			UsernamePasswordCredentials usernamePasswordCredentials = new UsernamePasswordCredentials("elastic",
					"user123");
			credentialsProvider.setCredentials(AuthScope.ANY, usernamePasswordCredentials);
			httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);

			SSLContext sslContext = buildSSLContext();
			httpClientBuilder.setSSLContext(sslContext);

		} catch (Exception e) {
		}
		return httpClientBuilder;
	}

	private static SSLContext buildSSLContext() {
		try{
			return new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build();
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}