package com.aliyun.tea;

import com.alipay.sdk.m.y.l;
import com.aliyun.tea.utils.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TeaResponse {
    public InputStream body;
    public HashMap<String, String> headers = new HashMap<>();
    public Response response;
    public int statusCode;
    public String statusMessage;

    public TeaResponse() {
    }

    public InputStream getResponse() {
        return this.body;
    }

    public String getResponseBody() {
        if (this.body == null) {
            return String.format("{\"message\":\"%s\"}", this.statusMessage);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = this.body.read(bArr);
                if (i == -1) {
                    return new String(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, i);
            } catch (Exception e) {
                throw new TeaException(e.getMessage(), e);
            }
        }
    }

    public TeaResponse(Response response) {
        this.response = response;
        this.statusCode = response.code();
        this.statusMessage = response.message();
        this.body = response.body().byteStream();
        for (Map.Entry entry : response.headers().toMultimap().entrySet()) {
            this.headers.put((String) entry.getKey(), StringUtils.join(l.b, (Iterable) entry.getValue()));
        }
    }
}
