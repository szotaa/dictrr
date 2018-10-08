package pl.szotaa.dictrr;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PostHttpRequest extends HttpRequest {

    private final String body;

    public PostHttpRequest(String route, String body) {
        super(route);
        this.body = body;
    }

    @Override
    public void run() {

    }
}
