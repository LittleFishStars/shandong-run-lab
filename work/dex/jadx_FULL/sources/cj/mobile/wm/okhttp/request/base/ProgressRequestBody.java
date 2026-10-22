package cj.mobile.wm.okhttp.request.base;

import cj.mobile.wm.okhttp.callback.Callback;
import cj.mobile.wm.okhttp.model.Progress;
import cj.mobile.wm.okhttp.utils.ThreadUtils;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ProgressRequestBody<T> extends RequestBody {
    public Callback<T> callback;
    public UploadInterceptor interceptor;
    public RequestBody requestBody;

    public final class CountingSink extends ForwardingSink {
        public Progress progress;

        public CountingSink(Sink sink) {
            super(sink);
            Progress progress = new Progress();
            this.progress = progress;
            progress.totalSize = ProgressRequestBody.this.contentLength();
        }

        public void write(Buffer buffer, long j) {
            super.write(buffer, j);
            Progress.changeProgress(this.progress, j, new Progress.Action() { // from class: cj.mobile.wm.okhttp.request.base.ProgressRequestBody.CountingSink.1
                @Override // cj.mobile.wm.okhttp.model.Progress.Action
                public void call(Progress progress) {
                    if (ProgressRequestBody.this.interceptor != null) {
                        ProgressRequestBody.this.interceptor.uploadProgress(progress);
                    } else {
                        ProgressRequestBody.this.onProgress(progress);
                    }
                }
            });
        }
    }

    public interface UploadInterceptor {
        void uploadProgress(Progress progress);
    }

    public ProgressRequestBody(RequestBody requestBody, Callback<T> callback) {
        this.requestBody = requestBody;
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(final Progress progress) {
        runOnUiThread(new Runnable() { // from class: cj.mobile.wm.okhttp.request.base.ProgressRequestBody.1
            @Override // java.lang.Runnable
            public void run() {
                if (ProgressRequestBody.this.callback != null) {
                    ProgressRequestBody.this.callback.uploadProgress(progress);
                }
            }
        });
    }

    public long contentLength() {
        try {
            return this.requestBody.contentLength();
        } catch (IOException unused) {
            return -1L;
        }
    }

    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    public void runOnUiThread(Runnable runnable) {
        ThreadUtils.runOnUIThread(runnable);
    }

    public void setInterceptor(UploadInterceptor uploadInterceptor) {
        this.interceptor = uploadInterceptor;
    }

    public void writeTo(BufferedSink bufferedSink) {
        BufferedSink bufferedSinkBuffer = Okio.buffer(new CountingSink(bufferedSink));
        this.requestBody.writeTo(bufferedSinkBuffer);
        bufferedSinkBuffer.flush();
    }
}
