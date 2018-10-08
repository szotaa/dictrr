package pl.szotaa.dictrr;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
@RequiredArgsConstructor
public class HttpRequestHandler {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public HttpResponse handle(HttpRequest httpRequest) throws InterruptedException, ExecutionException {
        Future<HttpResponse> future = executorService.submit(httpRequest);
        return future.get();
    }
}
