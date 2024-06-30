package com.kamijoucen.ruler.std.http.model;

import java.util.Map;

public class RequestC {

    public final String url;

    public final Map<?, ?> header;

    public final String body;

    public RequestC(String url, Map<?, ?> header) {
        this(url, header, null);
    }

    public RequestC(String url, Map<?, ?> header, String body) {
        this.url = url;
        this.header = header;
        this.body = body;
    }

}
