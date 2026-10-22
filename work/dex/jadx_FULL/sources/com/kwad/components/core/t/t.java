package com.kwad.components.core.t;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class t {
    public static final String TAG = "t";
    private static final String alS = "com.kwad.components.core.t.t";
    private static volatile t alT;
    private boolean alU = false;
    private com.kwad.sdk.core.config.item.r.a alV;

    private t() {
    }

    private static void U(long j) {
        com.kwad.sdk.core.d.c.d(TAG, "checkBySuper end:" + (SystemClock.elapsedRealtime() - j));
    }

    private boolean a(List<String> list, List<String> list2) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        return true;
                    }
                }
            }
        }
        com.kwad.sdk.m.b.TD().c(stackTrace);
        return a(list2, stackTrace);
    }

    private static boolean bm(String str) {
        return (str.startsWith("android") || str.startsWith("java") || str.startsWith("dalvik") || str.startsWith("com.android") || str.contains(alS) || !str.startsWith("androidx")) ? false : true;
    }

    private static boolean bn(String str) {
        return !str.startsWith("com.kwad");
    }

    private static boolean bo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static t wU() {
        if (alT == null) {
            synchronized (t.class) {
                if (alT == null) {
                    alT = new t();
                }
            }
        }
        return alT;
    }

    private void wW() {
        com.kwad.sdk.core.config.item.r.a aVar = this.alV;
        if (aVar == null) {
            return;
        }
        if (!this.alU && aVar.aRk.size() > 0) {
            Iterator<String> it = this.alV.aRk.iterator();
            while (it.hasNext()) {
                boolean zBo = bo(it.next());
                this.alU = zBo;
                if (zBo) {
                    break;
                }
            }
        }
        if (this.alU) {
            ArrayList arrayList = new ArrayList();
            if (this.alV.aRh.size() > 0) {
                for (Map.Entry<Integer, String> entry : this.alV.aRh.entrySet()) {
                    if (bo(entry.getValue())) {
                        arrayList.add(entry.getKey());
                    }
                }
            }
            com.kwad.sdk.core.config.item.r.a aVar2 = this.alV;
            com.kwad.components.core.p.a.vL().a(a(aVar2.aRi, aVar2.aRj), arrayList);
        }
    }

    public final boolean b(SceneImpl sceneImpl, String str) {
        boolean zA;
        if (this.alU) {
            com.kwad.sdk.core.config.item.r.a aVar = this.alV;
            zA = a(aVar.aRi, aVar.aRj);
        } else {
            zA = false;
        }
        com.kwad.components.core.p.a.vL().a(sceneImpl, zA, str);
        return zA;
    }

    public final void init() {
        com.kwad.sdk.core.config.item.r.a aVar = (com.kwad.sdk.core.config.item.r.a) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aNS);
        this.alV = aVar;
        if (aVar != null) {
            wW();
        }
    }

    public final int wV() {
        com.kwad.sdk.core.config.item.r.a aVar = this.alV;
        if (aVar != null) {
            return aVar.aRl;
        }
        return 0;
    }

    private boolean a(List<String> list, StackTraceElement[] stackTraceElementArr) {
        if (list != null && !list.isEmpty()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.sdk.core.d.c.d(TAG, "checkBySuper begin:" + jElapsedRealtime);
            int length = stackTraceElementArr.length;
            for (int i = 0; i < length; i++) {
                String className = stackTraceElementArr[i].getClassName();
                if (className != null && bm(className) && bn(className)) {
                    try {
                        if (a(list, Class.forName(className).getSuperclass())) {
                            U(jElapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        if (className.contains("$") && a(list, Class.forName(className.substring(0, className.lastIndexOf("$"))).getSuperclass())) {
                            U(jElapsedRealtime);
                            return true;
                        }
                    } catch (Throwable unused2) {
                        continue;
                    }
                }
            }
            U(jElapsedRealtime);
        }
        return false;
    }

    private static boolean a(List<String> list, Class cls) {
        int i = 0;
        while (cls != null && !TextUtils.equals(cls.getName(), "java.lang.Object")) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (cls.getName().contains(it.next())) {
                    return true;
                }
            }
            cls = cls.getSuperclass();
            i++;
            if (i >= 4) {
                break;
            }
        }
        return false;
    }
}
