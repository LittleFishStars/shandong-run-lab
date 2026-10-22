package cj.mobile.wm.okhttp.interceptor;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import cj.mobile.wm.dexc;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SameRequestFilterInterceptor implements Interceptor {
    public static final int MAX_RETRY_NUM = 5;
    public Charset UTF_8 = Charset.forName(dexc.dexa("VUG.9"));
    public IConfig config;
    public boolean enableFilter;
    public Handler handler;
    public static final String TAG = dexc.dexa("SfrvftuGjmufs");
    public static WeakHashMap<String, ResonseForClone> responseWeakHashMap = new WeakHashMap<>();
    public static WeakHashMap<String, WeakReference<Call>> calls = new WeakHashMap<>();
    public static boolean logEnable = false;
    public static SameRequestFilterInterceptor INTERCEPTOR = new SameRequestFilterInterceptor(true, new IConfig() { // from class: cj.mobile.wm.okhttp.interceptor.SameRequestFilterInterceptor.1
        @Override // cj.mobile.wm.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public String generateCacheKey(Request request) {
            String strReplaceAll = (request.toString() + dexc.dexa("'ifbefst;") + request.headers() + dexc.dexa("'cpez;") + request.body()).replaceAll(dexc.dexa("]t+"), "");
            return SameRequestFilterInterceptor.logEnable ? strReplaceAll : SameRequestFilterInterceptor.getMD5(strReplaceAll);
        }

        @Override // cj.mobile.wm.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public long responseCacheTimeInMills() {
            return 1000L;
        }

        @Override // cj.mobile.wm.okhttp.interceptor.SameRequestFilterInterceptor.IConfig
        public boolean shouldFilter(String str) {
            return true;
        }
    });

    public interface IConfig {
        String generateCacheKey(Request request);

        long responseCacheTimeInMills();

        boolean shouldFilter(String str);
    }

    public static class ResonseForClone {
        public String body;
        public Response response;

        public ResonseForClone(String str, Response response) {
            this.body = str;
            this.response = response;
        }

        public Response getClonedResonse() {
            return new Response.Builder().code(this.response.code()).protocol(this.response.protocol()).message(this.response.message()).body(ResponseBody.create(this.response.body().contentType(), this.body)).headers(this.response.headers()).header(dexc.dexa("dbdifeSftpotf"), dexc.dexa("zft")).request(this.response.request()).build();
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
            return new Response.Builder().code(504).protocol(Protocol.HTTP_2).message(dexc.dexa("sfrvftu!ujnf!pvu")).body(ResponseBody.create((MediaType) null, "")).headers(request.headers()).header(dexc.dexa("dbdifeSftpotf"), dexc.dexa("zft")).request(request).build();
        } catch (Throwable th) {
            Log.w(TAG, dexc.dexa("joufsdfqu!difdl!fssps;") + th.toString());
            return responseWeakHashMap.containsKey(str) ? responseWeakHashMap.get(str).getClonedResonse() : realExceute(chain, request, str);
        }
    }

    private String generateKey(Request request) {
        return this.config.generateCacheKey(request);
    }

    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(dexc.dexa("NE6"));
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

    private synchronized boolean needwait(String str) {
        if (responseWeakHashMap.containsKey(str)) {
            log(dexc.dexa("睊轔殙蛅sftqpotf-蜵珦揼鰼轔殙-溷輅餆痱蛅sftqpotf;") + str);
            return false;
        }
        if (!calls.containsKey(str)) {
            log(dexc.dexa("弼徖東痺ꄾ糢睊-幎ꝁ駂變-蜵珦犨颍鰸粃;") + str);
            return false;
        }
        WeakReference<Call> weakReference = calls.get(str);
        if (weakReference == null) {
            log(dexc.dexa("幎ꝁ駂變濆-蜵珦搒鰸粃!dbmm!XfblSfgfsfodf!opu!fyjtu;"));
            return false;
        }
        Call call = weakReference.get();
        if (call != null && !call.isCanceled()) {
            log(dexc.dexa("鰸粃搰鄾箤杩變濆牗箤杩犨颍.offexbju!dbmm!jt!svoojoh;") + call);
            return true;
        }
        log(dexc.dexa("幎ꝁ駂變濆-蜵珦搒鰸粃!dbmm!opu!fyjtu!ps!jt!dbodfme;") + call);
        return false;
    }

    private Response realExceute(Interceptor.Chain chain, Request request, final String str) {
        calls.put(str, new WeakReference<>(chain.call()));
        if (dexc.dexa("9:9DC368G928C8:4328ECFD8:73G911D").equals(str)) {
            Log.w(TAG, dexc.dexa("拡龾朿芈�螢蝡21訓砦蝌疉矝\n!uisfbe;") + Thread.currentThread().getName());
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
                        responseWeakHashMap.put(str, new ResonseForClone(string, new Response.Builder().code(responseProceed.code()).protocol(responseProceed.protocol()).message(responseProceed.message()).body(ResponseBody.create(responseProceed.body().contentType(), string)).headers(responseProceed.headers()).header(dexc.dexa("dbdifeSftpotf"), dexc.dexa("zft")).request(request).build()));
                        getMainHandler().postDelayed(new Runnable() { // from class: cj.mobile.wm.okhttp.interceptor.SameRequestFilterInterceptor.2
                            @Override // java.lang.Runnable
                            public void run() {
                                SameRequestFilterInterceptor.responseWeakHashMap.remove(str);
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
