package com.kc.bw.okhttp.interceptor;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.WeakHashMap;
import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SameRequestFilterInterceptor implements Interceptor {
    public static final int MAX_RETRY_NUM = 5;
    public Charset UTF_8 = Charset.forName(dexg.dexa("VUG.9"));
    public IConfig config;
    public boolean enableFilter;
    public Handler handler;
    public static final String TAG = dexg.dexa("SfrvftuGjmufs");
    public static WeakHashMap<String, ResonseForClone> responseWeakHashMap = new WeakHashMap<>();
    public static WeakHashMap<String, WeakReference<Call>> calls = new WeakHashMap<>();
    public static boolean logEnable = false;
    public static SameRequestFilterInterceptor INTERCEPTOR = new SameRequestFilterInterceptor(true, new IConfig() { // from class: com.kc.bw.okhttp.interceptor.SameRequestFilterInterceptor.1
        @Override // com.kc.bw.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public String generateCacheKey(Request request) {
            String strReplaceAll = (request.toString() + dexg.dexa("'ifbefst;") + request.headers() + dexg.dexa("'cpez;") + request.body()).replaceAll(dexg.dexa("]t+"), "");
            return SameRequestFilterInterceptor.logEnable ? strReplaceAll : SameRequestFilterInterceptor.getMD5(strReplaceAll);
        }

        @Override // com.kc.bw.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public long responseCacheTimeInMills() {
            return 1000L;
        }

        @Override // com.kc.bw.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public boolean shouldFilter(String str) {
            return true;
        }
    });

    @Keep
    public interface IConfig {
        String generateCacheKey(Request request);

        long responseCacheTimeInMills();

        boolean shouldFilter(String str);
    }

    @Keep
    public static class ResonseForClone {
        public String body;
        public Response response;

        public ResonseForClone(String str, Response response) {
            this.body = str;
            this.response = response;
        }

        public Response getClonedResonse() {
            return new Response.Builder().code(this.response.code()).protocol(this.response.protocol()).message(this.response.message()).body(ResponseBody.create(this.response.body().contentType(), this.body)).headers(this.response.headers()).header(dexg.dexa("dbdifeSftpotf"), dexg.dexa("zft")).request(this.response.request()).build();
        }
    }

    public SameRequestFilterInterceptor(boolean z, IConfig iConfig) {
        this.config = iConfig;
        this.enableFilter = z;
    }

    private Response check(Interceptor.Chain chain, Request request, String str) {
        try {
            if (!needwait(str)) {
                return responseWeakHashMap.containsKey(str) ? responseWeakHashMap.get(str).getClonedResonse() : realExceute(chain, request, str);
            }
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500L);
                if (!needwait(str)) {
                    return responseWeakHashMap.containsKey(str) ? responseWeakHashMap.get(str).getClonedResonse() : realExceute(chain, request, str);
                }
            }
            return new Response.Builder().code(504).protocol(Protocol.HTTP_2).message(dexg.dexa("sfrvftu!ujnf!pvu")).body(ResponseBody.create((MediaType) null, "")).headers(request.headers()).header(dexg.dexa("dbdifeSftpotf"), dexg.dexa("zft")).request(request).build();
        } catch (Throwable th) {
            Log.w(TAG, dexg.dexa("joufsdfqu!difdl!fssps;") + th.toString());
            return responseWeakHashMap.containsKey(str) ? responseWeakHashMap.get(str).getClonedResonse() : realExceute(chain, request, str);
        }
    }

    private String generateKey(Request request) {
        return this.config.generateCacheKey(request);
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(dexg.dexa("NE6"));
            messageDigest.update(str.getBytes());
            return new BigInteger(1, messageDigest.digest()).toString(16).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Handler getMainHandler() {
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        return this.handler;
    }

    public static void log(String str) {
        if (logEnable) {
            Log.d(TAG, str);
        }
    }

    private boolean needwait(String str) {
        synchronized (this) {
            if (responseWeakHashMap.containsKey(str)) {
                log(dexg.dexa("睊轔殙蛅sftqpotf-蜵珦揼鰼轔殙-溷輅餆痱蛅sftqpotf;") + str);
                return false;
            }
            if (!calls.containsKey(str)) {
                log(dexg.dexa("弼徖東痺ꄾ糢睊-幎ꝁ駂變-蜵珦犨颍鰸粃;") + str);
                return false;
            }
            WeakReference<Call> weakReference = calls.get(str);
            if (weakReference == null) {
                log(dexg.dexa("幎ꝁ駂變濆-蜵珦搒鰸粃!dbmm!XfblSfgfsfodf!opu!fyjtu;"));
                return false;
            }
            Call call = weakReference.get();
            if (call != null && !call.isCanceled()) {
                log(dexg.dexa("鰸粃搰鄾箤杩變濆牗箤杩犨颍.offexbju!dbmm!jt!svoojoh;") + call);
                return true;
            }
            log(dexg.dexa("幎ꝁ駂變濆-蜵珦搒鰸粃!dbmm!opu!fyjtu!ps!jt!dbodfme;") + call);
            return false;
        }
    }

    private Response realExceute(Interceptor.Chain chain, Request request, String str) {
        calls.put(str, new WeakReference<>(chain.call()));
        if (dexg.dexa("9:9DC368G928C8:4328ECFD8:73G911D").equals(str)) {
            Log.w(TAG, dexg.dexa("拡龾朿芈�螢蝡21訓砦蝌疉矝\n!uisfbe;") + Thread.currentThread().getName());
            try {
                Thread.sleep(5000L);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Response responseProceed = chain.proceed(request);
        if (responseProceed != null) {
            try {
                if (responseProceed.isSuccessful() && responseProceed.body() != null) {
                    ResponseBody responseBodyBody = responseProceed.body();
                    if (responseBodyBody.contentLength() <= 4096) {
                        BufferedSource bufferedSourceSource = responseBodyBody.source();
                        bufferedSourceSource.request(responseBodyBody.contentLength() > 0 ? responseBodyBody.contentLength() : 2147483647L);
                        Buffer buffer = bufferedSourceSource.buffer();
                        Charset charset = this.UTF_8;
                        MediaType mediaTypeContentType = responseBodyBody.contentType();
                        if (mediaTypeContentType != null) {
                            charset = mediaTypeContentType.charset(this.UTF_8);
                        }
                        String string = buffer.clone().readString(charset);
                        responseWeakHashMap.put(str, new ResonseForClone(string, new Response.Builder().code(responseProceed.code()).protocol(responseProceed.protocol()).message(responseProceed.message()).body(ResponseBody.create(responseProceed.body().contentType(), string)).headers(responseProceed.headers()).header(dexg.dexa("dbdifeSftpotf"), dexg.dexa("zft")).request(request).build()));
                        getMainHandler().postDelayed(new Runnable(this, str) { // from class: com.kc.bw.okhttp.interceptor.SameRequestFilterInterceptor.2
                            public final SameRequestFilterInterceptor this$0;
                            public final String val$key;

                            {
                                this.this$0 = this;
                                this.val$key = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                SameRequestFilterInterceptor.responseWeakHashMap.remove(this.val$key);
                            }
                        }, this.config.responseCacheTimeInMills());
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        calls.remove(str);
        return responseProceed;
    }

    public Response intercept(Interceptor.Chain chain) {
        IConfig iConfig;
        Request request = chain.request();
        if (this.enableFilter && (iConfig = this.config) != null && iConfig.shouldFilter(request.url().toString())) {
            return check(chain, request, generateKey(request));
        }
        return chain.proceed(request);
    }
}
