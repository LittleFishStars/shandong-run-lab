package com.kc.bw.okhttp.request.base;

import com.kc.bw.okhttp.callback.Callback;
import com.kc.bw.okhttp.model.Progress;
import com.kc.bw.okhttp.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ProgressRequestBody<T> extends RequestBody {
    public Callback<T> callback;
    public UploadInterceptor interceptor;
    public RequestBody requestBody;

    @Keep
    public final class CountingSink extends ForwardingSink {
        public Progress progress;
        public final ProgressRequestBody this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CountingSink(ProgressRequestBody progressRequestBody, Sink sink) {
            super(sink);
            this.this$0 = progressRequestBody;
            Progress progress = new Progress();
            this.progress = progress;
            progress.totalSize = progressRequestBody.contentLength();
        }

        public void write(Buffer buffer, long j) {
            super.write(buffer, j);
            Progress.changeProgress(this.progress, j, new Progress.Action(this) { // from class: com.kc.bw.okhttp.request.base.ProgressRequestBody.CountingSink.1
                public final CountingSink this$1;

                {
                    this.this$1 = this;
                }

                @Override // com.kc.bw.okhttp.model.Progress.Action
                public void call(Progress progress) {
                    if (this.this$1.this$0.interceptor != null) {
                        this.this$1.this$0.interceptor.uploadProgress(progress);
                    } else {
                        this.this$1.this$0.onProgress(progress);
                    }
                }
            });
        }
    }

    @Keep
    public interface UploadInterceptor {
        void uploadProgress(Progress progress);
    }

    public ProgressRequestBody(RequestBody requestBody, Callback<T> callback) {
        this.requestBody = requestBody;
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgress(Progress progress) {
        runOnUiThread(new Runnable(this, progress) { // from class: com.kc.bw.okhttp.request.base.ProgressRequestBody.1
            public final ProgressRequestBody this$0;
            public final Progress val$progress;

            {
                this.this$0 = this;
                this.val$progress = progress;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.this$0.callback != null) {
                    this.this$0.callback.uploadProgress(this.val$progress);
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
        BufferedSink bufferedSinkBuffer = Okio.buffer(new CountingSink(this, bufferedSink));
        this.requestBody.writeTo(bufferedSinkBuffer);
        bufferedSinkBuffer.flush();
    }
}
