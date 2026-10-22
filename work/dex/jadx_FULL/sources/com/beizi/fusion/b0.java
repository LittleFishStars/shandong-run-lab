package com.beizi.fusion;

import android.app.ActivityManager;
import android.content.Context;
import com.byazt.hv.TTDownloadField;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27085a;
    private final String b;
    private final String c;
    private final a0 d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b0 f27086a = new b0();
    }

    private b0() {
        this.f27085a = "alE/Wd6TQF6QDt5MOuPgTJhj5qydYaJMv1s3ioRo108=";
        this.b = "HmbXL1RJ0QhOMpVM8sDB4g==";
        this.c = "Qw020bKiuI4Tpk03J/klVA==";
        if (a.f27086a != null) {
            throw new RuntimeException("Singleton ...");
        }
        this.d = new a0();
    }

    public static b0 a() {
        return a.f27086a;
    }

    public gd b() {
        return this.d;
    }

    public boolean a(Context context) {
        g gVar = (g) h.a().b(context);
        if (gVar == null) {
            return true;
        }
        v vVarA = gVar.a();
        return !s.a(vVarA != null ? vVarA.p() : null, "allow_use_app_status", false);
    }

    public boolean b(Context context) {
        boolean zEquals;
        boolean z;
        int iIntValue;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            id idVar = (id) dh.a().b(context);
            idVar.a(e.ASNP_AES);
            id.a aVar = id.a.AS_LAST_OR_FIRST;
            Object objInvoke = ActivityManager.class.getMethod(idVar.a("alE/Wd6TQF6QDt5MOuPgTJhj5qydYaJMv1s3ioRo108=", "1001", aVar, true), null).invoke(activityManager, null);
            if (!(objInvoke instanceof List)) {
                return true;
            }
            String str = context.getApplicationInfo().packageName;
            Iterator it = ((List) objInvoke).iterator();
            if (!it.hasNext()) {
                return true;
            }
            Object next = it.next();
            Class<?> cls = next.getClass();
            try {
                Field declaredField = cls.getDeclaredField(idVar.a("HmbXL1RJ0QhOMpVM8sDB4g==", "1001", aVar, true));
                declaredField.setAccessible(true);
                Object obj = declaredField.get(next);
                zEquals = obj != null ? obj.equals(str) : true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Field declaredField2 = cls.getDeclaredField(idVar.a("Qw020bKiuI4Tpk03J/klVA==", "1001", id.a.AS_LAST_OR_FIRST, true));
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(next);
                z = !(obj2 instanceof Integer) || (iIntValue = ((Integer) obj2).intValue()) == 100 || iIntValue == 200;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return zEquals && z;
        } catch (Throwable th3) {
            th3.printStackTrace();
            return true;
        }
    }
}
