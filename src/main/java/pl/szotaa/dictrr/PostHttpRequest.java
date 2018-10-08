package pl.szotaa.dictrr;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostHttpRequest extends HttpRequest {

    private final String body;

    public PostHttpRequest(StorageService storageService, String route, String body) {
        super(storageService, route);
        this.body = body;
    }

    @Override
    public HttpResponse call() throws Exception {
        storageService.set(route, body);
        return new HttpResponse(route + " set to: " + body);
    }
}
