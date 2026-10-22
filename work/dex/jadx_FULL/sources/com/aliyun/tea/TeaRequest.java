package com.aliyun.tea;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TeaRequest {
    public static final String URL_ENCODING = "UTF-8";
    public InputStream body;
    public String pathname;
    public Integer port;
    public String protocol = "http";
    public String method = "GET";
    public Map<String, String> query = new HashMap();
    public Map<String, String> headers = new HashMap();

    public static TeaRequest create() {
        return new TeaRequest();
    }

    public String toString() {
        String str = ("Protocol: " + this.protocol + "\nPort: " + this.port + "\n" + this.method + " " + this.pathname + "\n") + "Query:\n";
        for (Map.Entry<String, String> entry : this.query.entrySet()) {
            str = str + "    " + entry.getKey() + ": " + entry.getValue() + "\n";
        }
        String str2 = str + "Headers:\n";
        for (Map.Entry<String, String> entry2 : this.headers.entrySet()) {
            str2 = str2 + "    " + entry2.getKey() + ": " + entry2.getValue() + "\n";
        }
        return str2;
    }
}
