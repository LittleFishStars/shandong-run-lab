package com.kwad.sdk.api;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IKsAdSDK;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class c {
    private static List<Throwable> PT;
    private static IKsAdSDK aHA;
    public static Set<String> aHB;

    public static IKsAdSDK Hu() {
        return aHA;
    }

    public static boolean Hv() {
        Boolean bool = (Boolean) g("enableDynamic", new Object[0]);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public static int Hw() {
        Integer num = (Integer) g("getAutoRevertTime", new Object[0]);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private static void Hx() {
        try {
            aHB = (Set) g("getThrowClassNotFoundSet", new Object[0]);
        } catch (Throwable unused) {
            aHB = null;
        }
    }

    public static void a(IKsAdSDK iKsAdSDK) {
        aHA = iKsAdSDK;
        Hx();
    }

    private static void b(Throwable th) {
        try {
            if (PT == null) {
                PT = new CopyOnWriteArrayList();
            }
            PT.add(th);
        } catch (Throwable unused) {
        }
    }

    public static String cV(String str) {
        return (String) g("TRANSFORM_API_HOST", str);
    }

    @Nullable
    public static <T> T g(String str, Object... objArr) {
        try {
            T t = (T) aHA.dM(str, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void pg() {
        try {
            com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.c.1
                @Override // com.kwad.sdk.api.a.b
                public final void doTask() {
                    try {
                        if (c.PT == null) {
                            return;
                        }
                        for (Throwable th : c.PT) {
                            if (c.aHA != null && KsAdSDK.haseInit()) {
                                c.aHA.re(th);
                            }
                        }
                        c.PT.clear();
                        c.z(null);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void t(Throwable th) {
        try {
            if (aHA == null || !KsAdSDK.haseInit()) {
                b(th);
            } else {
                aHA.re(th);
            }
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ List z(List list) {
        PT = null;
        return null;
    }
}
