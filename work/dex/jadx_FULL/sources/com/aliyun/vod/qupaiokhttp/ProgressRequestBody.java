package com.aliyun.vod.qupaiokhttp;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class ProgressRequestBody extends RequestBody {
    protected ProgressCallback callback;
    protected CountingSink countingSink;
    protected RequestBody delegate;
    private long previousTime;

    public final class CountingSink extends ForwardingSink {
        private long bytesWritten;
        long contentLength;

        public CountingSink(Sink sink) {
            super(sink);
            this.bytesWritten = 0L;
            this.contentLength = 0L;
        }

        public void write(Buffer buffer, long j) throws IOException {
            super.write(buffer, j);
            if (this.contentLength == 0) {
                this.contentLength = ProgressRequestBody.this.contentLength();
            }
            this.bytesWritten += j;
            if (ProgressRequestBody.this.callback != null) {
                long jCurrentTimeMillis = (System.currentTimeMillis() - ProgressRequestBody.this.previousTime) / 1000;
                if (jCurrentTimeMillis == 0) {
                    jCurrentTimeMillis++;
                }
                long j2 = this.bytesWritten;
                long j3 = j2 / jCurrentTimeMillis;
                long j4 = this.contentLength;
                ProgressRequestBody.this.callback.updateProgress((int) ((100 * j2) / j4), j3, j2 == j4);
            }
        }
    }

    public ProgressRequestBody(RequestBody requestBody, ProgressCallback progressCallback) {
        this.delegate = requestBody;
        this.callback = progressCallback;
    }

    public long contentLength() {
        try {
            return this.delegate.contentLength();
        } catch (IOException e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public MediaType contentType() {
        return this.delegate.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.previousTime = System.currentTimeMillis();
        CountingSink countingSink = new CountingSink(bufferedSink);
        this.countingSink = countingSink;
        BufferedSink bufferedSinkBuffer = Okio.buffer(countingSink);
        this.delegate.writeTo(bufferedSinkBuffer);
        bufferedSinkBuffer.flush();
    }
}
