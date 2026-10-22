package android.taobao.windvane.extra.core;

import android.app.Application;
import android.os.Environment;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b {
    private static final String s = "sc_lshco";
    private static final String t = "2.14.0.24^^2.14.0.25^^2.14.0.28^^2.14.0.29^^2.14.0.31^^2.14.0.35";
    private static final String u = "2.14.0.24^^2.14.0.25^^2.14.0.28^^2.14.0.29^^2.14.0.31^^2.14.0.35";
    private static final String v = "2.14.0.24^^2.14.0.25^^2.14.0.28^^2.14.0.29^^2.14.0.31^^2.14.0.35";
    private static final String[] w = {AlibcProtocolConstant.APPLINK_PACKAGE_NAME, "com.youku.phone"};
    private static final String[] x = {AlibcProtocolConstant.APPLINK_PACKAGE_NAME};
    private static final String[] y = {"com.tmall.wireless", "com.youku.phone", "com.huawei.hwvplayer.youku", "cn.damai"};
    private static b z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21235a;
    public String b;
    public String c;
    public String e;
    public String h;
    public String d = "true";
    public String f = "com.eg.android.AlipayGphone^^com.taobao.taobao";
    public String g = "true";
    public String i = "";
    public String j = "0^^*,map,video,camera,ai-camera,canvas,weex-view";
    public int k = 10;
    public int l = 134217728;
    public boolean m = false;
    public int n = 60;
    public int o = 8388608;
    public boolean p = true;
    public int q = 100663296;
    public int r = 100663296;

    public static b a() {
        if (z == null) {
            synchronized (b.class) {
                if (z == null) {
                    z = new b();
                }
            }
        }
        return z;
    }

    private String b(String str) {
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath(), str).getAbsolutePath();
    }

    private boolean c(String str) {
        return !TextUtils.isEmpty(str);
    }

    private static boolean f() {
        Application application = GlobalConfig.context;
        if (application != null) {
            return a(application.getPackageName(), y);
        }
        return false;
    }

    private static boolean g() {
        Application application = GlobalConfig.context;
        if (application != null) {
            return a(application.getPackageName(), x);
        }
        return false;
    }

    private static String h() {
        g();
        return "2.14.0.24^^2.14.0.25^^2.14.0.28^^2.14.0.29^^2.14.0.31^^2.14.0.35";
    }

    public boolean d() {
        return c(this.d) && c(this.f21235a) && c(this.b);
    }

    public boolean e() {
        return c(this.f21235a) && c(this.e) && c(this.f) && s.equals(this.c);
    }

    public String toString() {
        return "UCParamData{sdCopyPathCd='" + this.f21235a + "', hostUcmVersionsCd='" + this.b + "', scLoadPolicyCd='" + this.c + "', scCopyToSdcardCd='" + this.d + "', thirtyUcmVersionsCd='" + this.e + "', scPkgNames='" + this.f + "', scStillUpd='" + this.g + "', scWaitMilts='" + this.h + "', u4FocusAutoPopupInputHostList='" + this.i + "', cdResourceEmbedSurfaceEmbedViewEnableList='" + this.j + "', cachePageNumber=" + this.k + ", discardableLimitBytes=" + this.l + ", discardableReleaseFreeAfterTimeSwitch=" + this.m + ", discardableReleaseFreeAfterSecond=" + this.n + ", discardableReleaseFreeUntilByte=" + this.o + ", discardableReleaseForAllocFailedSwitch=" + this.p + ", grDiscardableLimitByte=" + this.q + ", grResourceCacheLimitByte=" + this.r + '}';
    }

    public static boolean c() {
        return f() || g();
    }

    public boolean b() {
        Application application = GlobalConfig.context;
        if (application != null) {
            return a(application.getPackageName(), w);
        }
        return false;
    }

    public b a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            TaoLog.d("UCParamData", str);
            JSONObject jSONObject = new JSONObject(str);
            this.f21235a = b(jSONObject.optString("sdCopyPathCd", "/alipay/com.eg.android.AlipayGphone/"));
            this.b = jSONObject.optString("hostUcmVersionsCd", "2.14.0.24^^2.14.0.25^^2.14.0.28^^2.14.0.29^^2.14.0.31^^2.14.0.35");
            this.c = jSONObject.optString("scLoadPolicyCd", c() ? s : "");
            this.d = jSONObject.optString("scCopyToSdcardCd", this.d);
            this.e = jSONObject.optString("thirtyUcmVersionsCd", h());
            this.f = jSONObject.optString("scPkgNames", this.f);
            this.g = jSONObject.optString("scStillUpd", this.g);
            this.h = jSONObject.optString("scWaitMilts", c() ? "1" : "600000");
            this.i = jSONObject.optString("u4FocusAutoPopupInputHostList", "");
            this.k = jSONObject.optInt("cachePageNumber", this.k);
            this.l = jSONObject.optInt("discardableLimitBytes", this.l);
            this.m = jSONObject.optBoolean("discardableReleaseFreeAfterTimeSwitch", this.m);
            this.n = jSONObject.optInt("discardableReleaseFreeAfterSecond", this.n);
            this.o = jSONObject.optInt("discardableReleaseFreeUntilByte", this.o);
            this.p = jSONObject.optBoolean("discardableReleaseForAllocFailedSwitch", this.p);
            this.q = jSONObject.optInt("grDiscardableLimitByte", this.q);
            this.r = jSONObject.optInt("grResourceCacheLimitByte", this.r);
            this.j = jSONObject.optString("cdResourceEmbedSurfaceEmbedViewEnableList", this.j);
            return this;
        } catch (Throwable unused) {
            TaoLog.w("UCParamData", "failed to parse uc params", str);
            return null;
        }
    }

    private static boolean a(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
