package pl.szotaa.dictrr;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class HttpRequest implements Runnable {

    protected final String route;
}
