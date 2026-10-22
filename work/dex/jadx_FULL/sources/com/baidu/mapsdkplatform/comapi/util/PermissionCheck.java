package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.RVParams;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.beizi.fusion.widget.ScrollClickView;
import com.huachenjie.common.constants.UserConstants;
import com.kuaishou.weapon.p0.t;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PermissionCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f26682a = "PermissionCheck";
    private static Context b = null;
    private static String c = null;
    private static Hashtable<String, String> d = null;
    private static LBSAuthManager e = null;
    private static LBSAuthManagerListener f = null;
    private static d g = null;
    private static int h = 601;
    private static boolean i = false;
    public static int j = 200;
    public static int k = 202;
    public static int l = 252;

    public static class b implements LBSAuthManagerListener {
        private b() {
        }

        @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
        public void onAuthResult(int i, String str) {
            if (str == null) {
                Log.e(PermissionCheck.f26682a, "The result is null");
                int iPermissionCheck = PermissionCheck.permissionCheck();
                Log.d(PermissionCheck.f26682a, "onAuthResult try permissionCheck result is: " + iPermissionCheck);
                return;
            }
            c cVar = new c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("status")) {
                    cVar.f26683a = jSONObject.optInt("status");
                }
                if (jSONObject.has("appid")) {
                    cVar.c = jSONObject.optString("appid");
                }
                if (jSONObject.has(UserConstants.URL_PARAMS.b)) {
                    cVar.b = jSONObject.optString(UserConstants.URL_PARAMS.b);
                }
                if (jSONObject.has("message")) {
                    cVar.d = jSONObject.optString("message");
                }
                if (jSONObject.has("token")) {
                    cVar.e = jSONObject.optString("token");
                }
                if (jSONObject.has("ak_permission")) {
                    cVar.f = jSONObject.optInt("ak_permission");
                }
                if (jSONObject.has("user_permission")) {
                    cVar.g = jSONObject.optInt("user_permission");
                }
                if (jSONObject.has(RVParams.ANTI_PHISHING)) {
                    cVar.h = jSONObject.optInt(RVParams.ANTI_PHISHING);
                }
                if (jSONObject.has(ScrollClickView.DIR_UP)) {
                    cVar.i = jSONObject.optInt(ScrollClickView.DIR_UP);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int unused = PermissionCheck.h = cVar.f26683a;
            if (PermissionCheck.g == null || !PermissionCheck.i) {
                return;
            }
            PermissionCheck.g.a(cVar);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26683a = 0;
        public String b = "-1";
        public String c = "-1";
        public String d = "";
        public String e;
        public int f;
        public int g;
        public int h;
        public int i;

        public String toString() {
            return String.format("=============================================\n----------------- 鉴权错误信息 ------------\nsha1;package:%s\nkey:%s\nerrorcode: %d uid: %s appid %s msg: %s\n请仔细核查 SHA1、package与key申请信息是否对应，key是否删除，平台是否匹配\n=============================================\n", com.baidu.mapsdkplatform.comapi.util.a.a(PermissionCheck.b), PermissionCheck.c, Integer.valueOf(this.f26683a), this.b, this.c, this.d);
        }
    }

    public interface d {
        void a(c cVar);
    }

    public static void destory() {
        g = null;
        b = null;
        f = null;
    }

    public static String getApiKey() {
        return c;
    }

    public static int getPermissionResult() {
        return h;
    }

    public static void init(Context context) {
        ApplicationInfo applicationInfo;
        String string;
        b = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(b.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null && TextUtils.isEmpty(c)) {
            c = applicationInfo.metaData.getString("com.baidu.lbsapi.API_KEY");
        }
        if (d == null) {
            d = new Hashtable<>();
        }
        if (e == null) {
            e = LBSAuthManager.getInstance(b);
        }
        if (f == null) {
            f = new b();
        }
        try {
            string = context.getPackageManager().getPackageInfo(b.getPackageName(), 0).applicationInfo.loadLabel(b.getPackageManager()).toString();
        } catch (Exception e3) {
            e3.printStackTrace();
            string = "";
        }
        try {
            JSONObject jSONObject = new JSONObject(f.r());
            d.put("mb", jSONObject.optString("mb"));
            d.put("os", jSONObject.optString("os"));
            d.put(com.alipay.sdk.m.w.a.v, jSONObject.optString(com.alipay.sdk.m.w.a.v));
            d.put("imt", "1");
            d.put("net", jSONObject.optString("net"));
            d.put("cpu", jSONObject.optString("cpu"));
            d.put("glr", jSONObject.optString("glr"));
            d.put("glv", jSONObject.optString("glv"));
            d.put("resid", jSONObject.optString("resid"));
            d.put("appid", "-1");
            d.put("ver", "1");
            d.put("screen", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("screen_x")), Integer.valueOf(jSONObject.optInt("screen_y"))));
            d.put("dpi", String.format("(%d,%d)", Integer.valueOf(jSONObject.optInt("dpi_x")), Integer.valueOf(jSONObject.optInt("dpi_y"))));
            d.put(t.r, jSONObject.optString(t.r));
            d.put("cuid", jSONObject.optString("cuid"));
            d.put("name", string);
        } catch (Exception unused) {
        }
    }

    public static synchronized int permissionCheck() {
        if (!i) {
            return 0;
        }
        LBSAuthManager lBSAuthManager = e;
        if (lBSAuthManager != null && f != null && b != null) {
            lBSAuthManager.setKey(c);
            CommonInfo commonInfo = Initializer.getCommonInfo();
            if (commonInfo != null) {
                String androidID = commonInfo.getAndroidID();
                if (!TextUtils.isEmpty(androidID)) {
                    e.setAndroidId(androidID);
                }
            }
            int iAuthenticate = e.authenticate(false, "lbs_androidsdk", d, f);
            if (iAuthenticate != 0) {
                Log.e(f26682a, "permission check result is: " + iAuthenticate);
            }
            return iAuthenticate;
        }
        Log.e(f26682a, "The authManager is: " + e + "; the authCallback is: " + f + "; the mContext is: " + b);
        return 0;
    }

    public static void setApiKey(String str) {
        if (str == null || str.trim().length() <= 0) {
            return;
        }
        c = str;
    }

    public static void setPermissionCheckResultListener(d dVar) {
        g = dVar;
    }

    public static void setPrivacyMode(boolean z) {
        i = z;
        if (z) {
            permissionCheck();
        } else {
            f.t();
        }
    }
}
