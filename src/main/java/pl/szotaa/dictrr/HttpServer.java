package pl.szotaa.dictrr;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
@Component
@AllArgsConstructor
public class HttpServer {

    private ServerSocket server;

    public void start(){
        while (true) {
            try (
                    Socket socket = server.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream()
            ) {

            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }
}
