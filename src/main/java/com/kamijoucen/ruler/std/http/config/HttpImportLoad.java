package com.kamijoucen.ruler.std.http.config;

import com.kamijoucen.ruler.config.option.CustomImportLoad;
import com.kamijoucen.ruler.std.http.HttpClient;

public class HttpImportLoad implements CustomImportLoad {

    @Override
    public String load(String path) {
        return HttpClient.get(path);
    }

    @Override
    public boolean match(String path) {
        return path.startsWith("http://") || path.startsWith("https://");
    }

}
