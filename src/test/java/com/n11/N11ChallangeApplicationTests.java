package com.n11;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * I convert N11ChallangeApplicationTests class baseclass for other Integraation test
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class N11ChallangeApplicationTests {
	/**
	 * i made it abstract to use inside in other Inttest class's like RomanNumeralControllerTest.class
	 */
	@Value("${local.server.port}")
	private Integer serverPort;

	public RestTemplate restTemplate;
	public String host;

	@Before
	public void setUpMvcFields() throws Exception {
		restTemplate=new RestTemplate();
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				//i dont want an exception when http status is bad request ...
				//override for test bad request.
			}
		});
		host = "http://localhost:"+serverPort;
	}

}
