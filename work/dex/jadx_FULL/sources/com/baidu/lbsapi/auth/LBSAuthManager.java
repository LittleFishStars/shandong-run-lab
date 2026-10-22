package com.baidu.lbsapi.auth;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.maps.AMap;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huachenjie.common.constants.UserConstants;
import com.kuaishou.weapon.p0.t;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LBSAuthManager {
    public static final int CODE_AUTHENTICATE_SUCC = 0;
    public static final int CODE_AUTHENTICATING = 602;
    public static final int CODE_INNER_ERROR = -1;
    public static final int CODE_KEY_NOT_EXIST = 101;
    public static final int CODE_NETWORK_FAILED = -11;
    public static final int CODE_NETWORK_INVALID = -10;
    public static final int CODE_UNAUTHENTICATE = 601;
    public static final String VERSION = "1.0.31";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f26303a = null;
    private static String b = null;
    private static int c = -1;
    private static String d;
    private static String e;
    private static p h;
    private static int i;
    private static LBSAuthManager k;
    private byte[] m;
    private static Hashtable j = new Hashtable();
    private static String n = "";
    private static String o = "";
    private static String p = "";
    private static boolean q = false;
    private static String r = null;
    private e f = null;
    private g g = null;
    private boolean l = false;
    private final Handler s = new l(this, Looper.getMainLooper());

    private LBSAuthManager(Context context) {
        f26303a = context;
        p pVar = h;
        if (pVar != null && !pVar.isAlive()) {
            h = null;
        }
        b.b("BaiduApiAuth SDK Version:1.0.31");
        h();
    }

    private int a(String str) {
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            i2 = jSONObject.getInt("status");
            if (jSONObject.has("current") && i2 == 0) {
                long j2 = jSONObject.getLong("current");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if ((jCurrentTimeMillis - j2) / 3600000.0d >= 24.0d) {
                    i2 = 601;
                } else if (this.l) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if (!simpleDateFormat.format(Long.valueOf(jCurrentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j2)))) {
                        i2 = 601;
                    }
                    return i2;
                }
            }
            if (jSONObject.has("current") && i2 == 602) {
                if ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000 > 180.0d) {
                    return 601;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return i2;
    }

    private String a(int i2) throws IOException {
        FileInputStream fileInputStream;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/" + i2 + "/cmdline");
                try {
                    byte[] bArr = new byte[256];
                    int i3 = 0;
                    while (true) {
                        int i4 = fileInputStream.read();
                        if (i4 <= 0 || i3 >= 256) {
                            break;
                        }
                        bArr[i3] = (byte) i4;
                        i3++;
                    }
                    if (i3 > 0) {
                        String str = new String(bArr, 0, i3, "UTF-8");
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return str;
                    }
                    fileInputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        return null;
    }

    private String a(Context context) {
        String strA;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            strA = a(Process.myPid());
        } catch (IOException unused) {
            strA = null;
        }
        if (strA != null) {
            return strA;
        }
        return context == null ? "" : context.getPackageName();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0045 A[Catch: NameNotFoundException -> 0x0058, TryCatch #1 {NameNotFoundException -> 0x0058, blocks: (B:14:0x003f, B:16:0x0045, B:18:0x004f), top: B:29:0x003f }] */
    /* JADX WARN: Code duplicated, block: B:18:0x004f A[Catch: NameNotFoundException -> 0x0058, TRY_LEAVE, TryCatch #1 {NameNotFoundException -> 0x0058, blocks: (B:14:0x003f, B:16:0x0045, B:18:0x004f), top: B:29:0x003f }] */
    private String a(Context context, String str) {
        LBSAuthManagerListener lBSAuthManagerListener;
        String str2 = "";
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                String string = bundle.getString("com.baidu.lbsapi.API_KEY");
                if (string != null) {
                    try {
                        if (string.equals("")) {
                            lBSAuthManagerListener = (LBSAuthManagerListener) j.get(str);
                            if (lBSAuthManagerListener != null) {
                                lBSAuthManagerListener.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                            }
                        }
                        str2 = string;
                    } catch (PackageManager.NameNotFoundException unused) {
                        str2 = string;
                        LBSAuthManagerListener lBSAuthManagerListener2 = (LBSAuthManagerListener) j.get(str);
                        if (lBSAuthManagerListener2 != null) {
                            lBSAuthManagerListener2.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                        }
                    }
                } else {
                    lBSAuthManagerListener = (LBSAuthManagerListener) j.get(str);
                    if (lBSAuthManagerListener != null) {
                        lBSAuthManagerListener.onAuthResult(101, ErrorMessage.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                    }
                    str2 = string;
                }
                return str2;
            }
            LBSAuthManagerListener lBSAuthManagerListener3 = (LBSAuthManagerListener) j.get(str);
            if (lBSAuthManagerListener3 != null) {
                lBSAuthManagerListener3.onAuthResult(101, ErrorMessage.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:10:0x001d A[Catch: JSONException -> 0x0064, all -> 0x00b6, TryCatch #0 {JSONException -> 0x0064, blocks: (B:8:0x0010, B:10:0x001d, B:11:0x0022, B:13:0x002a, B:14:0x0033, B:16:0x0042, B:17:0x0047), top: B:34:0x0010, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x002a A[Catch: JSONException -> 0x0064, all -> 0x00b6, TryCatch #0 {JSONException -> 0x0064, blocks: (B:8:0x0010, B:10:0x001d, B:11:0x0022, B:13:0x002a, B:14:0x0033, B:16:0x0042, B:17:0x0047), top: B:34:0x0010, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x0042 A[Catch: JSONException -> 0x0064, all -> 0x00b6, TryCatch #0 {JSONException -> 0x0064, blocks: (B:8:0x0010, B:10:0x001d, B:11:0x0022, B:13:0x002a, B:14:0x0033, B:16:0x0042, B:17:0x0047), top: B:34:0x0010, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0087 A[Catch: all -> 0x00b6, TryCatch #1 {, blocks: (B:5:0x0005, B:6:0x0009, B:8:0x0010, B:10:0x001d, B:11:0x0022, B:13:0x002a, B:14:0x0033, B:16:0x0042, B:17:0x0047, B:21:0x0083, B:23:0x0087, B:24:0x008a, B:26:0x00aa, B:28:0x00ae, B:29:0x00b4, B:20:0x0065), top: B:36:0x0005, inners: #0 }] */
    public void a(String str, String str2) {
        Message messageObtainMessage;
        int i2;
        p pVar;
        p pVar2;
        JSONObject jSONObject;
        synchronized (LBSAuthManager.class) {
            if (str == null) {
                str = j();
                messageObtainMessage = this.s.obtainMessage();
                i2 = -1;
                try {
                    jSONObject = new JSONObject(str);
                    if (!jSONObject.has("status")) {
                        jSONObject.put("status", -1);
                    }
                    if (!jSONObject.has("current")) {
                        jSONObject.put("current", System.currentTimeMillis());
                    }
                    c(jSONObject.toString());
                    if (jSONObject.has("current")) {
                        jSONObject.remove("current");
                    }
                    i2 = jSONObject.getInt("status");
                    messageObtainMessage.what = i2;
                    messageObtainMessage.obj = jSONObject;
                    Bundle bundle = new Bundle();
                    bundle.putString("listenerKey", str2);
                    messageObtainMessage.setData(bundle);
                    this.s.sendMessage(messageObtainMessage);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    messageObtainMessage.what = i2;
                    messageObtainMessage.obj = new JSONObject();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("listenerKey", str2);
                    messageObtainMessage.setData(bundle2);
                    this.s.sendMessage(messageObtainMessage);
                }
                pVar = h;
                if (pVar != null) {
                    pVar.c();
                }
                i--;
                b.a("httpRequest called mAuthCounter-- = " + i);
                if (i == 0 && (pVar2 = h) != null) {
                    pVar2.a();
                    h = null;
                }
            } else {
                messageObtainMessage = this.s.obtainMessage();
                i2 = -1;
                jSONObject = new JSONObject(str);
                if (!jSONObject.has("status")) {
                    jSONObject.put("status", -1);
                }
                if (!jSONObject.has("current")) {
                    jSONObject.put("current", System.currentTimeMillis());
                }
                c(jSONObject.toString());
                if (jSONObject.has("current")) {
                    jSONObject.remove("current");
                }
                i2 = jSONObject.getInt("status");
                messageObtainMessage.what = i2;
                messageObtainMessage.obj = jSONObject;
                Bundle bundle3 = new Bundle();
                bundle3.putString("listenerKey", str2);
                messageObtainMessage.setData(bundle3);
                this.s.sendMessage(messageObtainMessage);
                pVar = h;
                if (pVar != null) {
                    pVar.c();
                }
                i--;
                b.a("httpRequest called mAuthCounter-- = " + i);
                if (i == 0) {
                    pVar2.a();
                    h = null;
                }
            }
            throw th;
        }
    }

    private void a(HashMap map, String str, String str2) {
        if (map == null || map.size() <= 0 || str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            return;
        }
        try {
            String strA = r.a(str2);
            if (strA == null || strA.length() <= 0) {
                map.put(str, str2);
            } else {
                map.put(str, strA);
            }
        } catch (Exception e2) {
            map.put(str, str2);
            Log.e("LBSAuthManager", "encodeAuthParam", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has(AMap.ENGLISH)) {
            return;
        }
        if (jSONObject.optInt(AMap.ENGLISH, 0) == 0) {
            if (jSONObject.optString("ck").length() > 0) {
                this.m = c.a(jSONObject.optString("ck").getBytes(StandardCharsets.UTF_8));
            }
        } else {
            a(jSONObject, "ak");
            a(jSONObject, "ck");
            a(jSONObject, "sk");
            a(jSONObject, UserConstants.URL_PARAMS.b);
            b(jSONObject);
        }
    }

    private void a(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.length() <= 0 || str == null || str.length() <= 0 || !jSONObject.has(str)) {
            return;
        }
        try {
            byte[] bArrB = r.b(jSONObject.optString(str));
            if (bArrB != null && bArrB.length > 0) {
                jSONObject.put(str, new String(bArrB, StandardCharsets.UTF_8));
                if ("ck".equals(str)) {
                    this.m = bArrB;
                    return;
                }
                return;
            }
            jSONObject.put(str, "");
            jSONObject.put("decode_status", -1);
        } catch (Exception e2) {
            Log.e("LBSAuthManager", " decodeAuthResult ", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable hashtable, String str2, String str3, int i2, String str4, String str5) {
        String strA;
        String strA2 = a(f26303a, str2);
        if (strA2 == null || strA2.equals("")) {
            return;
        }
        HashMap map = new HashMap();
        r.a();
        map.put("pk", r.b() != null ? r.b() : "");
        map.put("url", "https://api.map.baidu.com/sdkcs/verify");
        b.a("url:https://api.map.baidu.com/sdkcs/verify");
        map.put(com.alibaba.ariver.remotedebug.b.c.g, "json");
        a(map, "ak", strA2);
        b.a("ak:" + ((String) map.get("ak")));
        a(map, "mcode", d.a(f26303a));
        map.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry entry : hashtable.entrySet()) {
                String str6 = (String) entry.getKey();
                String str7 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                    map.put(str6, str7);
                }
            }
        }
        String cuid = !TextUtils.isEmpty(o) ? getCUID() : r;
        b.a("cuid:" + r);
        if (TextUtils.isEmpty(cuid)) {
            map.put("cuid", "");
        } else {
            map.put("cuid", cuid);
        }
        map.put(t.r, f26303a.getPackageName());
        map.put("version", VERSION);
        map.put("macaddr", "");
        try {
            strA = d.a();
        } catch (Exception unused) {
            strA = "";
        }
        if (TextUtils.isEmpty(strA)) {
            map.put(MediaFormat.KEY_LANGUAGE, "");
        } else {
            map.put(MediaFormat.KEY_LANGUAGE, strA);
        }
        if (z) {
            map.put("force", z ? "1" : "0");
        }
        if (str == null) {
            map.put("from_service", "");
        } else {
            map.put("from_service", str);
        }
        String strI = i();
        if (!TextUtils.isEmpty(strI)) {
            map.put("extend", strI);
        }
        e eVar = new e(f26303a);
        this.f = eVar;
        eVar.a(map, str3, i2, str4, str5, new n(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, Hashtable hashtable, String[] strArr, String str2, String str3, int i2, String str4, String str5) {
        String strA;
        String strA2 = a(f26303a, str2);
        if (strA2 == null || strA2.equals("")) {
            return;
        }
        HashMap map = new HashMap();
        r.a();
        map.put("pk", r.b() != null ? r.b() : "");
        map.put("url", "https://api.map.baidu.com/sdkcs/verify");
        map.put(com.alibaba.ariver.remotedebug.b.c.g, "json");
        a(map, "ak", strA2);
        map.put("from", "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry entry : hashtable.entrySet()) {
                String str6 = (String) entry.getKey();
                String str7 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str7)) {
                    map.put(str6, str7);
                }
            }
        }
        String cuid = !TextUtils.isEmpty(o) ? getCUID() : r;
        b.a("sendAuthRequests : cuid: " + cuid);
        if (TextUtils.isEmpty(cuid)) {
            map.put("cuid", "");
        } else {
            map.put("cuid", cuid);
        }
        map.put(t.r, f26303a.getPackageName());
        map.put("version", VERSION);
        map.put("macaddr", "");
        try {
            strA = d.a();
        } catch (Exception unused) {
            strA = "";
        }
        if (TextUtils.isEmpty(strA)) {
            map.put(MediaFormat.KEY_LANGUAGE, "");
        } else {
            map.put(MediaFormat.KEY_LANGUAGE, strA);
        }
        if (z) {
            map.put("force", z ? "1" : "0");
        }
        if (str == null) {
            map.put("from_service", "");
        } else {
            map.put("from_service", str);
        }
        String strI = i();
        if (!TextUtils.isEmpty(strI)) {
            map.put("extend", strI);
        }
        String[] strArr2 = new String[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String strA3 = r.a(strArr[i3]);
            if (strA3 == null || strA3.length() <= 0) {
                strArr2[i3] = strArr[i3];
            } else {
                strArr2[i3] = strA3;
            }
        }
        g gVar = new g(f26303a);
        this.g = gVar;
        gVar.a(map, strArr2, str3, i2, str4, str5, new o(this, str2));
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (jSONObject.has("ck")) {
            jSONObject.remove("ck");
        }
        if (jSONObject.has(AMap.ENGLISH)) {
            jSONObject.remove(AMap.ENGLISH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String string;
        String strA = a(f26303a, str);
        try {
            JSONObject jSONObject = new JSONObject(j());
            if (!jSONObject.has("ak")) {
                return true;
            }
            if (jSONObject.has(AMap.ENGLISH) && jSONObject.getInt(AMap.ENGLISH) == 1) {
                a(jSONObject, "ak");
            }
            string = jSONObject.getString("ak");
        } catch (JSONException e2) {
            e2.printStackTrace();
            string = "";
        }
        return (strA == null || string == null || strA.equals(string)) ? false : true;
    }

    private void c(String str) {
        f26303a.getSharedPreferences("authStatus_" + a(f26303a), 0).edit().putString("status", str).apply();
    }

    public static LBSAuthManager getInstance(Context context) {
        if (k == null) {
            synchronized (LBSAuthManager.class) {
                if (k == null) {
                    k = new LBSAuthManager(context);
                }
            }
        } else if (context != null) {
            f26303a = context;
        } else if (b.f26304a) {
            b.c("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return k;
    }

    private void h() {
        synchronized (LBSAuthManager.class) {
            if (h == null) {
                p pVar = new p("auth");
                h = pVar;
                pVar.start();
                while (h.f26317a == null) {
                    try {
                        b.a("wait for create auth thread.");
                        Thread.sleep(3L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private String i() {
        try {
            JSONObject jSONObject = new JSONObject(j());
            return !jSONObject.has("extend") ? "" : jSONObject.getString("extend");
        } catch (JSONException unused) {
            return "";
        }
    }

    private String j() {
        return f26303a.getSharedPreferences("authStatus_" + a(f26303a), 0).getString("status", "{\"status\":601}");
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0036 A[Catch: all -> 0x00e0, TryCatch #0 {, blocks: (B:6:0x0007, B:9:0x0012, B:12:0x001d, B:14:0x0036, B:15:0x003b, B:17:0x0043, B:20:0x004d, B:23:0x0088, B:27:0x00a1, B:29:0x00a8, B:32:0x00ad, B:33:0x00d7, B:35:0x00d9, B:26:0x009e, B:38:0x00dc), top: B:44:0x0007, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public int authenticate(boolean z, String str, Hashtable hashtable, LBSAuthManagerListener lBSAuthManagerListener) {
        String str2;
        String strA;
        int iA;
        p pVar;
        synchronized (LBSAuthManager.class) {
            boolean z2 = false;
            if (hashtable == null) {
                this.l = z2;
                str2 = System.currentTimeMillis() + "";
                if (lBSAuthManagerListener != null) {
                    j.put(str2, lBSAuthManagerListener);
                }
                strA = a(f26303a, str2);
                if (strA != null) {
                    i++;
                    b.a(" mAuthCounter  ++ = " + i);
                    String strJ = j();
                    b.a("getAuthMessage from cache:" + strJ);
                    iA = a(strJ);
                    if (iA == 601) {
                        c(new JSONObject().put("status", 602).toString());
                    }
                    h();
                    pVar = h;
                    if (pVar != null) {
                        b.a("mThreadLooper.mHandler = " + h.f26317a);
                        h.f26317a.post(new m(this, iA, z, str2, str, hashtable));
                        return iA;
                    }
                    return -1;
                }
                return 101;
            }
            String str3 = (String) hashtable.get("zero_auth");
            if (str3 != null && Integer.valueOf(str3).intValue() == 1) {
                z2 = true;
            }
            this.l = z2;
            str2 = System.currentTimeMillis() + "";
            if (lBSAuthManagerListener != null) {
                j.put(str2, lBSAuthManagerListener);
            }
            strA = a(f26303a, str2);
            if (strA != null && !strA.equals("")) {
                i++;
                b.a(" mAuthCounter  ++ = " + i);
                String strJ2 = j();
                b.a("getAuthMessage from cache:" + strJ2);
                iA = a(strJ2);
                if (iA == 601) {
                    try {
                        c(new JSONObject().put("status", 602).toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                h();
                pVar = h;
                if (pVar != null && pVar.f26317a != null) {
                    b.a("mThreadLooper.mHandler = " + h.f26317a);
                    h.f26317a.post(new m(this, iA, z, str2, str, hashtable));
                    return iA;
                }
                return -1;
            }
            return 101;
            throw th;
        }
    }

    public String decodeAESMessage(String str) {
        byte[] bArr;
        if (str != null && str.length() > 0 && (bArr = this.m) != null && bArr.length > 0) {
            try {
                byte[] bArrA = c.a(str.getBytes(StandardCharsets.UTF_8));
                byte[] bArr2 = this.m;
                return new String(a.a(bArr2, bArr2, bArrA), StandardCharsets.UTF_8);
            } catch (Exception e2) {
                Log.e("LBSAuthManager", "decodeAESMessage", e2);
            }
        }
        return null;
    }

    public String getCUID() {
        if (!TextUtils.isEmpty(r)) {
            return r;
        }
        if (f26303a == null) {
            return "";
        }
        try {
            b.a("mIsPrivacyMode " + q);
            if (q) {
                com.baidu.a.a.a.a.a.a(!TextUtils.isEmpty(o) ? o : Settings.Secure.getString(f26303a.getContentResolver(), "android_id"));
                String strA = com.baidu.a.a.a.a.a.a(f26303a);
                r = strA;
                b.a("getCUID: " + strA);
                return strA;
            }
            SharedPreferences sharedPreferences = f26303a.getSharedPreferences("Map_Privacy", 0);
            if (sharedPreferences.contains("cuid")) {
                return sharedPreferences.getString("cuid", "");
            }
            String str = q.a(UUID.randomUUID().toString().getBytes(), true) + "|MAPSDK001";
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("cuid", str);
            editorEdit.apply();
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getKey() {
        Context context = f26303a;
        if (context == null) {
            return "";
        }
        try {
            return getPublicKey(context);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getMCode() {
        Context context = f26303a;
        return context == null ? "" : d.a(context);
    }

    public boolean getPrivacyMode() {
        return q;
    }

    public String getPublicKey(Context context) throws PackageManager.NameNotFoundException {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }

    public void setAndroidId(String str) {
        if (f26303a == null || TextUtils.isEmpty(str)) {
            return;
        }
        o = str;
    }

    public void setHttpProxyUsernameAndPassword(String str, String str2) {
        d = str;
        e = str2;
    }

    public void setKey(String str) {
        if (f26303a == null || TextUtils.isEmpty(str)) {
            return;
        }
        n = str;
    }

    public void setPackageName(String str) {
        p = str;
    }

    public void setPrivacyMode(boolean z) {
        Context context = f26303a;
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("Map_Privacy", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (z) {
            editorEdit.putBoolean("privacyMode", z);
            editorEdit.apply();
        } else {
            z = sharedPreferences.getBoolean("privacyMode", false);
        }
        q = z;
    }

    public void setProxy(String str, int i2) {
        b = str;
        c = i2;
    }
}
