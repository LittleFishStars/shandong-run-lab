package com.aliyun.tea.okhttp;

import com.alipay.sdk.m.t.e;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.utils.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OkRequestBody extends RequestBody {
    private String contentType;
    private InputStream inputStream;

    public OkRequestBody(TeaRequest teaRequest) {
        this.inputStream = teaRequest.body;
        this.contentType = teaRequest.headers.get(e.f);
    }

    public long contentLength() throws IOException {
        InputStream inputStream = this.inputStream;
        return (inputStream == null || inputStream.available() <= 0) ? super.contentLength() : this.inputStream.available();
    }

    public MediaType contentType() {
        if (!StringUtils.isEmpty((CharSequence) this.contentType)) {
            return MediaType.parse(this.contentType);
        }
        if (this.inputStream == null) {
            return null;
        }
        return MediaType.parse("application/json; charset=UTF-8;");
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (this.inputStream == null) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (true) {
            int i = this.inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                bufferedSink.write(bArr, 0, i);
            }
        }
    }
}
