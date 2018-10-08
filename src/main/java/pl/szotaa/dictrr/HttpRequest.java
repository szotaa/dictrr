package pl.szotaa.dictrr;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.Callable;

@RequiredArgsConstructor
public abstract class HttpRequest implements Callable<HttpResponse> {

    protected final StorageService storageService;
    protected final String route;
}
