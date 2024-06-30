package com.kamijoucen.ruler.std.http;

import java.util.HashMap;
import java.util.Map;
import com.kamijoucen.ruler.std.http.model.RequestC;
import com.kamijoucen.ruler.std.http.model.ResponseC;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClient {

    private static final OkHttpClient client = new OkHttpClient();

    public static ResponseC get(RequestC req) {
        // to string map
        Map<String, String> header = new HashMap<>();
        req.header.forEach((k, v) -> header.put(k.toString(), v.toString()));
        Request request = new Request.Builder().url(req.url).headers(Headers.of(header)).build();
        try {
            Response response = client.newCall(request).execute();
            if (response == null) {
                return null;
            }
            return new ResponseC(response.code(), response.message(),
                    response.headers().toMultimap(), response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // get json
    public static String get(String url) {
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
