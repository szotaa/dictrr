package pl.szotaa.dictrr;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@RequiredArgsConstructor
public class HttpServer {

    private final ServerSocket server;
    private final HttpRequestFactory factory;
    private final HttpRequestHandler handler;

    public void start(){
        log.info("Listening for HTTP requests on port: " + server.getLocalPort());
        while (true) {
            try (Socket connection = server.accept()) {
                HttpRequest request = factory.getHttpRequest(connection);
                HttpResponse response = handler.handle(request);
                connection.getOutputStream().write(response.getMessage().getBytes());
            } catch (InterruptedException | ExecutionException | IOException e) {
                log.error(e.getMessage());
            } catch (MethodNotSupportedException e) {
                log.info(e.getMessage());
            }
        }
    }
}
