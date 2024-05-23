package com.kamijoucen.ruler.std.http.config;

import com.kamijoucen.ruler.config.option.CustomImportLoader;
import com.kamijoucen.ruler.config.option.ImportMatchOrder;
import com.kamijoucen.ruler.std.http.HttpClient;

@ImportMatchOrder
public class HttpImportLoader implements CustomImportLoader {

    @Override
    public String load(String path) {
        return HttpClient.get(path);
    }

    @Override
    public boolean match(String path) {
        return path.startsWith("http://") || path.startsWith("https://");
    }

}
