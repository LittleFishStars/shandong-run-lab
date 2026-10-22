package com.igexin.assist.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.push.config.d;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.g.b;
import com.igexin.sdk.PushManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class AssistUtils {
    public static final String BRAND_HON = "honor";
    public static final String BRAND_HW = "huawei";
    public static final String BRAND_MZ = "meizu";
    public static final String BRAND_OPPO = "oppo";
    public static final String BRAND_STP = "stp";
    public static final String BRAND_VIVO = "vivo";
    public static final String BRAND_XIAOMI = "xiaomi";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f37790a = "";

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    /* JADX WARN: Code duplicated, block: B:13:0x002c A[PHI: r1
      0x002c: PHI (r1v5 java.lang.String) = 
      (r1v0 java.lang.String)
      (r1v1 java.lang.String)
      (r1v2 java.lang.String)
      (r1v3 java.lang.String)
      (r1v4 java.lang.String)
      (r1v6 java.lang.String)
     binds: [B:12:0x002a, B:15:0x003c, B:18:0x004b, B:21:0x005a, B:24:0x006a, B:9:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    /* JADX WARN: Code duplicated, block: B:17:0x003f  */
    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:29:0x0079  */
    public static String getDeviceBrand() {
        Context applicationContext;
        String str;
        Context applicationContext2;
        String str2;
        if (!TextUtils.isEmpty(f37790a)) {
            return f37790a;
        }
        if (d.U) {
            Context applicationContext3 = ServiceManager.b.getApplicationContext();
            str = BRAND_HON;
            if (b.a(applicationContext3, BRAND_HON)) {
                f37790a = str;
            } else {
                applicationContext = ServiceManager.b.getApplicationContext();
                str = BRAND_HW;
                if (b.a(applicationContext, BRAND_HW)) {
                    f37790a = str;
                } else {
                    str = "xiaomi";
                    if (b.a(ServiceManager.b.getApplicationContext(), "xiaomi")) {
                        f37790a = str;
                    } else {
                        str = "oppo";
                        if (b.a(ServiceManager.b.getApplicationContext(), "oppo")) {
                            f37790a = str;
                        } else {
                            applicationContext2 = ServiceManager.b.getApplicationContext();
                            str = BRAND_MZ;
                            if (b.a(applicationContext2, BRAND_MZ)) {
                                f37790a = str;
                            } else {
                                str = "vivo";
                                if (b.a(ServiceManager.b.getApplicationContext(), "vivo")) {
                                    f37790a = str;
                                } else {
                                    if (b.a(ServiceManager.b)) {
                                        str2 = "stp";
                                    } else {
                                        str2 = Build.BRAND;
                                    }
                                    f37790a = str2;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            applicationContext = ServiceManager.b.getApplicationContext();
            str = BRAND_HW;
            if (b.a(applicationContext, BRAND_HW)) {
                f37790a = str;
            } else {
                str = "xiaomi";
                if (b.a(ServiceManager.b.getApplicationContext(), "xiaomi")) {
                    f37790a = str;
                } else {
                    str = "oppo";
                    if (b.a(ServiceManager.b.getApplicationContext(), "oppo")) {
                        f37790a = str;
                    } else {
                        applicationContext2 = ServiceManager.b.getApplicationContext();
                        str = BRAND_MZ;
                        if (b.a(applicationContext2, BRAND_MZ)) {
                            f37790a = str;
                        } else {
                            str = "vivo";
                            if (b.a(ServiceManager.b.getApplicationContext(), "vivo")) {
                                f37790a = str;
                            } else {
                                if (b.a(ServiceManager.b)) {
                                    str2 = "stp";
                                } else {
                                    str2 = Build.BRAND;
                                }
                                f37790a = str2;
                            }
                        }
                    }
                }
            }
        }
        return f37790a.toLowerCase();
    }

    public static void startGetuiService(Context context) {
        if (context != null) {
            try {
                PushManager.getInstance().initialize(context);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }
}
