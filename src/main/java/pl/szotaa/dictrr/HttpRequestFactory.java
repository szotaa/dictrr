package pl.szotaa.dictrr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Optional;

@Slf4j
@Component
public class HttpRequestFactory {

    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";

    public HttpRequest getHttpRequest (Socket socket) {
        HttpRequest result = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Optional<String> methodOptional = Optional.ofNullable(reader.readLine());
            String method = methodOptional.orElseThrow(MethodNotSupportedException::new);
            String route = getRoute(method);
            if (method.contains(GET_METHOD)) {
                result = new GetHttpRequest(route);
            } else if (method.contains(POST_METHOD)) {
                String body = getBody(reader);
                result = new PostHttpRequest(route, body);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (MethodNotSupportedException e) {
            log.info(e.getMessage());
        }

        return result;
    }

    private String getRoute(String method){
        return method.substring(method.indexOf("/"), method.indexOf("HTTP"));
    }

    private String getBody(BufferedReader reader) throws IOException {
        int contentLength = 0;
        String line = null;
        while ((line = reader.readLine()) != null && !line.equals("")) {
            if(line.contains("content-length")) {
                contentLength = Integer.parseInt(line.substring(line.indexOf(":") + 1).trim());
            }
        }
        char[] body = new char[contentLength];
        reader.read(body);
        return String.valueOf(body);
    }
}
