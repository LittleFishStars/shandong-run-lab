package cj.mobile.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cj.mobile.listener.CJNativeExpressListener;
import cj.mobile.listener.CJSplashListener;
import com.jd.ad.sdk.bl.initsdk.JADPrivateController;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.bl.initsdk.JADYunSdkConfig;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.feed.JADFeedListener;
import com.jd.ad.sdk.splash.JADSplash;
import com.jd.ad.sdk.splash.JADSplashListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JADSplash f21856a;
    public View b;
    public JADFeed c;
    public View d;
    public int e;
    public boolean f;
    public int g;
    public cj.mobile.p.h h;
    public String i;
    public String j;
    public Context k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public String p;
    public Handler q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21857a;
        public final /* synthetic */ String b;
        public final /* synthetic */ f c;

        public a(f fVar, Context context, String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class b extends JADPrivateController {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21858a;

        public b(f fVar, Context context) {
        }

        public String getOaid() {
        }

        public boolean isCanUseIP() {
            return !cj.mobile.p.b.j0;
        }

        public boolean isCanUseLocation() {
            return !cj.mobile.p.b.j0;
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f21859a;

        public c(f fVar, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class d implements JADSplashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21860a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ CJSplashListener d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Context f;
        public final /* synthetic */ f g;

        public d(f fVar, String str, String str2, cj.mobile.p.h hVar, CJSplashListener cJSplashListener, String str3, Context context) {
        }

        public void onClick() {
        }

        public void onClose() {
        }

        public void onExposure() {
        }

        public void onLoadFailure(int i, String str) {
        }

        public void onLoadSuccess() {
        }

        public void onRenderFailure(int i, String str) {
        }

        public void onRenderSuccess(View view) {
        }
    }

    public class e implements JADFeedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21861a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cj.mobile.p.h c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CJNativeExpressListener e;
        public final /* synthetic */ Context f;
        public final /* synthetic */ f g;

        public e(f fVar, String str, String str2, cj.mobile.p.h hVar, String str3, CJNativeExpressListener cJNativeExpressListener, Context context) {
        }

        public void onClick() {
        }

        public void onClose() {
        }

        public void onExposure() {
        }

        public void onLoadFailure(int i, String str) {
        }

        public void onLoadSuccess() {
        }

        public void onRenderFailure(int i, String str) {
        }

        public void onRenderSuccess(View view) {
        }
    }

    public String d() {
        return this.o;
    }

    public String e() {
        return JADYunSdk.getSDKVersion();
    }

    public View c() {
        return this.d;
    }

    public String b() {
        return this.n;
    }

    public f b(int i) {
        this.e = i;
        return this;
    }

    public void b(Context context, String str) {
    }

    public String a() {
        return this.p;
    }

    public f a(boolean z) {
        this.f = z;
        return this;
    }

    public f a(int i) {
        this.g = i;
        return this;
    }

    public final JADYunSdkConfig a(Context context, String str) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJSplashListener cJSplashListener, cj.mobile.p.h hVar) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(Context context, String str, String str2, String str3, int i, int i2, CJNativeExpressListener cJNativeExpressListener, cj.mobile.p.h hVar) {
    }
}
