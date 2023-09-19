package com.socialshop.backend.eurekaserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class EurekaServerApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void eurekaServerIsRunning() {
		RestTemplate restTemplate = new RestTemplate();
		String statusUrl = "http://localhost:" + port + "/actuator/health";
		String response = restTemplate.getForObject(statusUrl, String.class);
		assertEquals("{\"status\":\"UP\"}", response);
    }

}
