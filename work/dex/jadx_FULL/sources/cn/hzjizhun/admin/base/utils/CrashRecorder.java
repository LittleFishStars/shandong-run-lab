package cn.hzjizhun.admin.base.utils;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.y.l;
import com.zj.adlib.rzb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class CrashRecorder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f22706a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f287a;

    public CrashRecorder(String str) {
        this.f287a = str;
    }

    public static CrashRecorder a(String str) {
        CrashRecorder crashRecorder;
        HashMap map = f22706a;
        CrashRecorder crashRecorder2 = (CrashRecorder) map.get(str);
        if (crashRecorder2 != null) {
            return crashRecorder2;
        }
        synchronized (CrashRecorder.class) {
            crashRecorder = (CrashRecorder) map.get(str);
            if (crashRecorder == null) {
                crashRecorder = new CrashRecorder(str);
                map.put(str, crashRecorder);
            }
        }
        return crashRecorder;
    }

    public static CrashRecorder getAdxInstance() {
        return a("MTc2NjAzNjM1OTYxNA");
    }

    public static CrashRecorder getInstance() {
        return a("MTc2NjAzNjM1OTYxNA2");
    }

    public final boolean b() {
        try {
            return "cn.bibledbs".equals(this.f286a.getPackageName());
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void c() {
        Set<String> hashSet;
        String string;
        try {
            StringBuilder sb = new StringBuilder();
            try {
                hashSet = this.f286a.getSharedPreferences(this.f287a, 0).getAll().keySet();
            } catch (Throwable unused) {
                hashSet = new HashSet<>();
            }
            for (String str : hashSet) {
                if (str.startsWith("url_")) {
                    try {
                        string = this.f286a.getSharedPreferences(this.f287a, 0).getString(str, "");
                    } catch (Throwable unused2) {
                        string = "";
                    }
                    if (!TextUtils.isEmpty(string)) {
                        sb.append(string);
                        sb.append(l.b);
                    }
                }
            }
            String string2 = sb.toString();
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            rzb.a().f19454a.errorReport("crash： " + string2);
        } catch (Throwable unused3) {
        }
    }

    public void finishPage() {
        try {
            if (b()) {
                this.f286a.getSharedPreferences(this.f287a, 0).edit().clear().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public void init(Context context) {
        boolean z;
        Set<String> hashSet;
        if (context != null) {
            try {
                this.f286a = context.getApplicationContext();
                if (b()) {
                    try {
                        z = this.f286a.getSharedPreferences(this.f287a, 0).getBoolean("is_running", false);
                    } catch (Throwable unused) {
                        z = false;
                    }
                    if (z) {
                        c();
                    }
                    try {
                        this.f286a.getSharedPreferences(this.f287a, 0).edit().putBoolean("is_running", true).commit();
                    } catch (Throwable unused2) {
                    }
                    try {
                        hashSet = this.f286a.getSharedPreferences(this.f287a, 0).getAll().keySet();
                    } catch (Throwable unused3) {
                        hashSet = new HashSet<>();
                    }
                    for (String str : hashSet) {
                        if (str.startsWith("url_")) {
                            try {
                                this.f286a.getSharedPreferences(this.f287a, 0).edit().remove(str).commit();
                            } catch (Throwable unused4) {
                            }
                        }
                    }
                }
            } catch (Throwable unused5) {
            }
        }
    }

    public void loadWebPage(String str, String str2) {
        if (str2 != null) {
            try {
                if (!str2.isEmpty() && b()) {
                    this.f286a.getSharedPreferences(this.f287a, 0).edit().putString("url_" + str, str2).commit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void releasePager(String str) {
        try {
            if (b()) {
                this.f286a.getSharedPreferences(this.f287a, 0).edit().remove("url_" + str).commit();
            }
        } catch (Throwable unused) {
        }
    }
}
