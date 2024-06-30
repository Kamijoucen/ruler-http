package com.kamijoucen.ruler.std.http.model;

import java.util.List;
import java.util.Map;

public class ResponseC {

    public final int code;

    public final String message;

    public final Map<String, List<String>> header;

    public final String body;

    public ResponseC(int code, String message, Map<String, List<String>> header, String body) {
        this.code = code;
        this.message = message;
        this.header = header;
        this.body = body;
    }

}
