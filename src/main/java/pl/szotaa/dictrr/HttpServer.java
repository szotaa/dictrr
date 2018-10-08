package pl.szotaa.dictrr;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;

@Slf4j
@Component
@RequiredArgsConstructor
public class HttpServer {

    private final ServerSocket server;
    private final HttpRequestFactory factory;

    public void start(){
        log.info("Listening for HTTP requests on port: " + server.getLocalPort());
        while (true) {
            try {
                HttpRequest request = factory.getHttpRequest(server.accept());
                new Thread(request).start();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }
}
