package com.alipay.sdk.tid;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.w.a;
import com.alipay.sdk.m.w.b;
import com.alipay.sdk.m.y.d;
import com.alipay.sdk.m.y.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TidHelper {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        b.c().a(context);
    }

    public static Tid b(Context context) throws Exception {
        try {
            com.alipay.sdk.m.t.b bVarA = new c().a(a.f(), context);
            if (bVarA != null) {
                JSONObject jSONObject = new JSONObject(bVarA.a());
                com.alipay.sdk.m.x.a aVarA = com.alipay.sdk.m.x.a.a(context);
                String strOptString = jSONObject.optString("tid");
                String string = jSONObject.getString(com.alipay.sdk.m.x.a.j);
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(string)) {
                    aVarA.a(strOptString, string);
                }
                return a(context, aVarA);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void clearTID(Context context) {
        com.alipay.sdk.m.x.a.a(context).b();
    }

    public static String getIMEI(Context context) {
        a(context);
        return d.b(context).b();
    }

    public static String getIMSI(Context context) {
        a(context);
        return d.b(context).c();
    }

    public static synchronized String getTIDValue(Context context) {
        Tid tidLoadOrCreateTID;
        tidLoadOrCreateTID = loadOrCreateTID(context);
        return Tid.isEmpty(tidLoadOrCreateTID) ? "" : tidLoadOrCreateTID.getTid();
    }

    public static String getVirtualImei(Context context) {
        a(context);
        com.alipay.sdk.m.o.c.a();
        return com.alipay.sdk.m.o.c.f();
    }

    public static String getVirtualImsi(Context context) {
        a(context);
        com.alipay.sdk.m.o.c.a();
        return com.alipay.sdk.m.o.c.g();
    }

    public static Tid loadLocalTid(Context context) {
        com.alipay.sdk.m.x.a aVarA = com.alipay.sdk.m.x.a.a(context);
        if (aVarA.j()) {
            return null;
        }
        return new Tid(aVarA.f(), aVarA.e(), aVarA.g().longValue());
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        g.b(com.alipay.sdk.m.n.a.B, "load_create_tid");
        a(context);
        Tid tidLoadTID = loadTID(context);
        if (Tid.isEmpty(tidLoadTID)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return null;
            }
            try {
                tidLoadTID = b(context);
            } catch (Throwable unused) {
            }
        }
        return tidLoadTID;
    }

    public static Tid loadTID(Context context) {
        a(context);
        Tid tidA = a(context, com.alipay.sdk.m.x.a.a(context));
        if (tidA == null) {
            g.b(com.alipay.sdk.m.n.a.B, "load_tid null");
        }
        return tidA;
    }

    public static boolean resetTID(Context context) throws Exception {
        Tid tidB;
        g.b(com.alipay.sdk.m.n.a.B, "reset_tid");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Exception("Must be called on worker thread");
        }
        a(context);
        clearTID(context);
        try {
            tidB = b(context);
        } catch (Throwable unused) {
            tidB = null;
        }
        return !Tid.isEmpty(tidB);
    }

    public static Tid a(Context context, com.alipay.sdk.m.x.a aVar) {
        if (aVar == null || aVar.k()) {
            return null;
        }
        return new Tid(aVar.f(), aVar.e(), aVar.g().longValue());
    }
}
