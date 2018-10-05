package pl.szotaa.dictrr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.net.ServerSocket;

@ComponentScan("pl.szotaa.dictrr")
@PropertySource("classpath:dictrr.properties")
class DictrrConfig {

    @Bean
    public ServerSocket serverSocket(@Value("${port}") int port) throws IOException {
        return new ServerSocket(port);
    }
}
