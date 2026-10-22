package cn.hzjizhun.admin.http.net.thread;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.hzjizhun.admin.http.net.EasyHttpConfig;
import cn.hzjizhun.admin.http.net.EasyHttpUtil;
import cn.hzjizhun.admin.http.net.EasyHttpUtils;
import cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback;
import cn.hzjizhun.admin.http.net.core.EasyCall;
import cn.hzjizhun.admin.http.net.core.HttpUrlConnection;
import cn.hzjizhun.admin.http.net.core.Request;
import java.net.HttpURLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RequestTaskProxy {
    private static final String TAG = "RequestTaskProxy";
    private volatile IBaseEasyCallback mBaseEasyCallback;
    private EasyHttpConfig mConfig;
    private EasyCall mEasyCall;
    private FutureTask<HttpURLConnection> mFutureTask;
    private volatile Request mRequest;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    private final AtomicBoolean mTaskInvoked = new AtomicBoolean();
    private final AtomicBoolean isError = new AtomicBoolean();
    private final AtomicInteger mRetryCount = new AtomicInteger();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public class a extends FutureTask {
        public a(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            super.done();
            try {
                get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                RequestTaskProxy.this.callError(e);
            } catch (ExecutionException e2) {
                e2.printStackTrace();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Throwable f310a;

        public b(Throwable th) {
            this.f310a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            EasyHttpUtils.e("callError...");
            if (RequestTaskProxy.this.mBaseEasyCallback != null) {
                RequestTaskProxy.this.mBaseEasyCallback.onFailure(RequestTaskProxy.this.mEasyCall, this.f310a);
            }
        }
    }

    public class c implements Callable {
        public c() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public HttpURLConnection call() {
            int responseCode;
            String str = RequestTaskProxy.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("isRetry: [");
            sb.append(RequestTaskProxy.this.mRetryCount.get() >= 1);
            sb.append("]");
            EasyHttpUtil.Logger.w(str, sb.toString());
            EasyHttpUtil.Logger.w(RequestTaskProxy.TAG, RequestTaskProxy.this.mRequest.toString());
            HttpURLConnection httpURLConnectionExecute = null;
            try {
                RequestTaskProxy.this.mTaskInvoked.set(true);
                httpURLConnectionExecute = HttpUrlConnection.execute(RequestTaskProxy.this.mRequest, RequestTaskProxy.this.mConfig);
                if (httpURLConnectionExecute != null && (responseCode = httpURLConnectionExecute.getResponseCode()) >= 300 && responseCode < 400 && !TextUtils.isEmpty(httpURLConnectionExecute.getHeaderField("Location"))) {
                    RequestTaskProxy.this.mRequest.url = httpURLConnectionExecute.getHeaderField("Location");
                    EasyHttpUtil.Logger.w(RequestTaskProxy.TAG, "Redirect to url:" + RequestTaskProxy.this.mRequest.url);
                    RequestTaskProxy.this.start();
                }
                RequestTaskProxy.this.mRetryCount.set(0);
                RequestTaskProxy.this.postResult(httpURLConnectionExecute);
                EasyHttpUtil.Logger.w(RequestTaskProxy.TAG, "Connection success!");
                if (RequestTaskProxy.this.isError.get() && RequestTaskProxy.this.mConfig.isOpenRetry() && RequestTaskProxy.this.mRetryCount.getAndIncrement() < RequestTaskProxy.this.mConfig.getRetryCount()) {
                    EasyHttpUtil.Logger.w(RequestTaskProxy.TAG, "RetryCount:" + RequestTaskProxy.this.mRetryCount.get());
                    try {
                        Thread.sleep(RequestTaskProxy.this.mConfig.getRetryIntervalMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    RequestTaskProxy.this.start();
                    RequestTaskProxy.this.isError.set(false);
                    RequestTaskProxy.this.mCancelled.set(false);
                }
                return httpURLConnectionExecute;
            } catch (Throwable th) {
                try {
                    RequestTaskProxy.this.callError(th);
                    return httpURLConnectionExecute;
                } finally {
                    if (RequestTaskProxy.this.isError.get() && RequestTaskProxy.this.mConfig.isOpenRetry() && RequestTaskProxy.this.mRetryCount.getAndIncrement() < RequestTaskProxy.this.mConfig.getRetryCount()) {
                        EasyHttpUtil.Logger.w(RequestTaskProxy.TAG, "RetryCount:" + RequestTaskProxy.this.mRetryCount.get());
                        try {
                            Thread.sleep(RequestTaskProxy.this.mConfig.getRetryIntervalMillis());
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        RequestTaskProxy.this.start();
                        RequestTaskProxy.this.isError.set(false);
                        RequestTaskProxy.this.mCancelled.set(false);
                    }
                }
            }
        }
    }

    public RequestTaskProxy(EasyHttpConfig easyHttpConfig, Request request, IBaseEasyCallback iBaseEasyCallback) {
        this.mRequest = request;
        this.mBaseEasyCallback = iBaseEasyCallback;
        this.mConfig = easyHttpConfig;
        this.mEasyCall = new EasyCall(this.mRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callError(Throwable th) {
        try {
            this.isError.set(true);
            this.mCancelled.set(true);
            postMainThread(new b(th));
        } catch (Throwable th2) {
            if (this.mBaseEasyCallback != null) {
                this.mBaseEasyCallback.onFailure(this.mEasyCall, th2);
            }
            boolean z = EasyHttpUtils.sisOpen;
        }
    }

    private void postMainThread(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResult(HttpURLConnection httpURLConnection) {
        try {
            EasyHttpUtils.d("postResult...");
            if (!this.mTaskInvoked.get() || this.mBaseEasyCallback == null) {
                callError(new Exception("error"));
                return;
            }
            EasyHttpUtils.d("postResult..." + httpURLConnection.getResponseCode());
            if (httpURLConnection.getResponseCode() == 200) {
                this.mBaseEasyCallback.onResponse(this.mEasyCall, httpURLConnection);
            } else {
                callError(new Exception("error"));
            }
        } catch (Throwable th) {
            callError(th);
        }
    }

    public void cancel() {
        FutureTask<HttpURLConnection> futureTask = this.mFutureTask;
        if (futureTask != null && !futureTask.isCancelled() && !this.mFutureTask.isDone()) {
            this.mFutureTask.cancel(true);
            EasyHttpUtil.Logger.w(TAG, " Cancelled Http Task:" + this.mRequest.toString());
        }
        if (this.mBaseEasyCallback != null) {
            this.mBaseEasyCallback.onCancel();
        }
    }

    public Request getRequest() {
        return this.mRequest;
    }

    public void start() {
        a aVar = new a(new c());
        this.mFutureTask = aVar;
        EasyThreadPools.executor(aVar);
    }
}
