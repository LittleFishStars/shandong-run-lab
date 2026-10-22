package com.kc.openset.common.okhttp;

import android.os.Handler;
import android.os.Looper;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OkHttpScheduler {
    private static final MediaType CONTENT_TYPE_JSON;
    private static final String TAG = OSETSDKProtected.getString2(SecExceptionCode.SEC_ERROR_SECURITYBODY_UNSUPPORTED);
    private OkHttpClient mOkHttpClient;
    private final Handler mainHandler;
    public final X509TrustManager trustAllCert;

    /* JADX INFO: renamed from: com.kc.openset.common.okhttp.OkHttpScheduler$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements Callback {
        final OkHttpScheduler this$0;
        final OSETHttpCallback val$callback;

        static {
            OSETSDKProtected.interface11(4385);
        }

        public AnonymousClass1(OkHttpScheduler okHttpScheduler, OSETHttpCallback oSETHttpCallback) {
            this.this$0 = okHttpScheduler;
            this.val$callback = oSETHttpCallback;
        }

        public static native /* synthetic */ void lambda$onFailure$0(OSETHttpCallback oSETHttpCallback, IOException iOException);

        public static native /* synthetic */ void lambda$onResponse$1(OSETHttpCallback oSETHttpCallback, int i, String str);

        public static native /* synthetic */ void lambda$onResponse$2(OSETHttpCallback oSETHttpCallback, String str);

        public static native /* synthetic */ void lambda$onResponse$3(OSETHttpCallback oSETHttpCallback, Exception exc);

        public native void onFailure(Call call, IOException iOException);

        public native void onResponse(Call call, Response response);
    }

    @Keep
    public static class Holder {
        static final OkHttpScheduler INSTANCE;

        static {
            OSETSDKProtected.interface11(4386);
            INSTANCE = new OkHttpScheduler(null);
        }

        private Holder() {
        }
    }

    @Keep
    public static class TrustAllCerts implements X509TrustManager {
        static {
            OSETSDKProtected.interface11(4387);
        }

        private TrustAllCerts() {
        }

        public /* synthetic */ TrustAllCerts(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // javax.net.ssl.X509TrustManager
        public native void checkClientTrusted(X509Certificate[] x509CertificateArr, String str);

        @Override // javax.net.ssl.X509TrustManager
        public native void checkServerTrusted(X509Certificate[] x509CertificateArr, String str);

        @Override // javax.net.ssl.X509TrustManager
        public native X509Certificate[] getAcceptedIssuers();
    }

    static {
        OSETSDKProtected.interface11(4388);
        CONTENT_TYPE_JSON = MediaType.get(OSETSDKProtected.getString2(1500));
    }

    private OkHttpScheduler() {
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.trustAllCert = new TrustAllCerts(null);
        init();
    }

    public /* synthetic */ OkHttpScheduler(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static native /* synthetic */ void access$200(OkHttpScheduler okHttpScheduler, Runnable runnable);

    private native Callback createCallback(OSETHttpCallback oSETHttpCallback);

    private native Request.Builder createNewBuilder(String str, String str2);

    private native Request.Builder createOldBuilder(String str, String str2);

    public static native OkHttpScheduler getInstance();

    private native void init();

    private native void postToMain(Runnable runnable);

    public native void get(String str, Map<String, String> map, OSETHttpCallback oSETHttpCallback);

    public native void post(String str, Map<String, String> map, String str2, OSETHttpCallback oSETHttpCallback);
}
