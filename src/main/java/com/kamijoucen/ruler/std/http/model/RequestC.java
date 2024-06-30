package com.kamijoucen.ruler.std.http.model;

import java.util.Map;

public class RequestC {

    public final String url;

    public final Map<?, ?> header;

    public RequestC(String url, Map<?, ?> header) {
        this.url = url;
        this.header = header;
    }
}
