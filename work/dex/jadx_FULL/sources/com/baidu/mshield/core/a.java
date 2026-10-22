package com.baidu.mshield.core;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.ac.F;
import com.baidu.mshield.b.a.g;
import com.baidu.mshield.utility.c;
import com.baidu.mshield.x0.EngineImpl;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f26708a = new HashMap<>();
    public static volatile boolean b;

    /* JADX INFO: renamed from: com.baidu.mshield.core.a$a, reason: collision with other inner class name */
    public static class C0278a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.baidu.mshield.a f26709a;

        public C0278a(com.baidu.mshield.a aVar) {
            this.f26709a = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f26709a.a("4.2.6", this.f26709a.a("4.2.6") - 1);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0027 */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, String str, String str2, HashMap<String, String> map, int... iArr) {
        b(context);
        c.b(context);
        g.a(map);
        EngineImpl.getInstance(context).setSecurityVerifyInfo(str, str2, map);
        EngineImpl.getInstance(context).gpol();
        c(context);
        if (map != null) {
            HashMap<String, String> map2 = f26708a;
            synchronized (map2) {
                try {
                    map2.putAll(map);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String b(Context context) {
        try {
            com.baidu.mshield.sharedpreferences.a aVarA = com.baidu.mshield.sharedpreferences.a.a(context);
            String strE = aVarA.e();
            if (!TextUtils.isEmpty(strE)) {
                return strE;
            }
            String strV = aVarA.v();
            if (!TextUtils.isEmpty(strV)) {
                return strV;
            }
            String strB = c.b(context);
            if (TextUtils.isEmpty(strB)) {
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            }
            String[] strArrSplit = strB.split("\\|");
            if (strArrSplit != null && strArrSplit.length == 2 && !TextUtils.isEmpty(strArrSplit[0]) && !TextUtils.isEmpty(strArrSplit[1])) {
                byte[] bArrRe = F.getInstance().re(strArrSplit[1].getBytes(), strArrSplit[0].getBytes());
                if (bArrRe == null) {
                    return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
                }
                String str = strArrSplit[0] + com.baidu.mshield.utility.a.a(bArrRe);
                aVarA.m(str);
                return str;
            }
            return strB;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
    }

    public static void c(Context context) {
        try {
            com.baidu.mshield.b.c.a.b("canRunPlugin=" + a(context));
            if (a(context)) {
                d(context);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void d(Context context) {
        com.baidu.mshield.a aVar = new com.baidu.mshield.a(context);
        aVar.a("4.2.6", aVar.a("4.2.6") + 1);
        EngineImpl.getInstance(context).init(0, true);
        new Timer().schedule(new C0278a(aVar), 30000L);
    }

    public static void a(boolean z) {
        b = z;
    }

    public static boolean a() {
        return b;
    }

    public static boolean a(Context context) {
        try {
            com.baidu.mshield.a aVar = new com.baidu.mshield.a(context);
            if (aVar.a()) {
                if (aVar.a("4.2.6") < aVar.b()) {
                    return true;
                }
                EngineImpl.getInstance(context).sendWMCrashLog(5);
            }
            return false;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return true;
        }
    }

    public static void b(boolean z) {
        try {
            com.baidu.sec.privacy.b.b.a(z);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static String a(Context context, String str, int i, String str2) {
        if (i != 0) {
            try {
                if (a(context)) {
                    if (TextUtils.isEmpty(str2)) {
                        EngineImpl.getInstance(context).ice(str, i);
                    } else {
                        EngineImpl.getInstance(context).ice(str, i, str2);
                    }
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
        return b(context);
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0039 */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, HashMap<String, String> map) {
        if (map != null) {
            if (map.size() == 0) {
                return;
            }
            synchronized (f26708a) {
                try {
                    for (String str : map.keySet()) {
                        f26708a.put(str, map.get(str));
                    }
                    g.b(map);
                    EngineImpl.getInstance(context).ud(map);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String a(String str) {
        try {
            HashMap<String, String> map = f26708a;
            if (map.size() <= 0) {
                return "";
            }
            synchronized (map) {
                if (!map.containsKey(str)) {
                    return "";
                }
                return map.get(str);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return "";
        }
    }
}
