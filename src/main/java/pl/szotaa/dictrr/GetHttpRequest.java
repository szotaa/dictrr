package pl.szotaa.dictrr;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetHttpRequest extends HttpRequest {

    public GetHttpRequest(StorageService storageService, String route) {
        super(storageService, route);
    }

    @Override
    public HttpResponse call() throws Exception {
        return new HttpResponse(storageService.get(route));
    }
}
