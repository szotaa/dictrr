package pl.szotaa.dictrr;

import lombok.Getter;

@Getter
public class HttpResponse {

    private final String message;

    public HttpResponse(String message) {
        this.message = "HTTP/1.1 200 OK\n\n" + message;
    }
}
