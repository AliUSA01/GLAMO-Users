package az.glamouserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GlamoUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlamoUserServiceApplication.class, args);

    }

}
