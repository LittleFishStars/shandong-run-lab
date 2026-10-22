package com.huachenjie.college.page.popcorn;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.huachenjie.ad.interfaces.RewardVideoAdListener;
import com.zj.adlib.ew;
import com.zj.adlib.fv5;
import com.zj.adlib.gv1;
import com.zj.adlib.r8a;
import com.zj.adlib.r90;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class PopcornJavascriptApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f33610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<PopcornWebActivity> f8466a;
    public WeakReference<WebView> b;

    public class a extends RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f8467a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicBoolean f8468a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ long[] f8469a;
        public final /* synthetic */ String b;

        public a(long[] jArr, AtomicBoolean atomicBoolean, String str, String str2) {
            this.f8469a = jArr;
            this.f8468a = atomicBoolean;
            this.f8467a = str;
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(AtomicBoolean atomicBoolean) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showResult", atomicBoolean.get() ? 1 : 0);
                if (PopcornJavascriptApi.this.b.get() != null) {
                    ((WebView) PopcornJavascriptApi.this.b.get()).evaluateJavascript("javascript:getAdvertisingResult('" + jSONObject.toString() + "')", null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void b(int i) {
            this.f8469a[1] = System.currentTimeMillis();
            PopcornWebActivity popcornWebActivity = (PopcornWebActivity) PopcornJavascriptApi.this.f8466a.get();
            final AtomicBoolean atomicBoolean = this.f8468a;
            popcornWebActivity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.tu6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45006a.g(atomicBoolean);
                }
            });
            if (this.f8468a.get()) {
                String str = this.f8467a;
                long[] jArr = this.f8469a;
                long j = jArr[1];
                long j2 = jArr[0];
                popcornWebActivity.x0(str, (j - j2) / 1000, j2, this.b);
            }
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void c(int i, String str, String str2) {
            fv5.b("广告加载失败");
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void d(int i, String str) {
            this.f8468a.set(true);
        }

        @Override // com.huachenjie.ad.interfaces.RewardVideoAdListener
        public void e(int i, String str) {
            this.f8469a[0] = System.currentTimeMillis();
        }
    }

    public PopcornJavascriptApi(PopcornWebActivity popcornWebActivity, WebView webView, String str) {
        this.f33610a = str;
        this.f8466a = new WeakReference<>(popcornWebActivity);
        this.b = new WeakReference<>(webView);
    }

    @UiThread
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void d(String str, String str2) {
        ew.l().f(r8a.e, str2, gv1.getActivity(this.b.get()), new a(new long[]{System.currentTimeMillis(), 0}, new AtomicBoolean(false), str, str2));
    }

    @JavascriptInterface
    @Keep
    public String getTokenAndDeviceId(String str) {
        try {
            String strI = r90.i();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("deviceId", strI);
            jSONObject.put("token", this.f33610a);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @JavascriptInterface
    public void loadRewardVideoAd(String str) {
        try {
            if (this.b.get() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            final String strOptString = jSONObject.optString("userId");
            final String strOptString2 = jSONObject.optString("adId");
            jSONObject.optString("timestamp");
            this.b.get().post(new Runnable() { // from class: com.zj.adlib.su6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44780a.d(strOptString2, strOptString);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
