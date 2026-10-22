package cj.mobile.wm;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class xa {
    public static Object dexa;
    public static Class<?> dexb;
    public static Method dexc;
    public static Method dexd;
    public static Method dexe;
    public static Method dexf;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            dexb = cls;
            dexa = cls.newInstance();
            dexc = dexb.getMethod("getUDID", Context.class);
            dexd = dexb.getMethod("getOAID", Context.class);
            dexe = dexb.getMethod("getVAID", Context.class);
            dexf = dexb.getMethod("getAAID", Context.class);
        } catch (Exception e) {
            Log.e(com.alipay.sdk.m.o0.b.f25481a, "reflect exception!", e);
        }
    }

    public static String dexa(Context context) {
        return dexa(context, dexd);
    }

    public static String dexa(Context context, Method method) {
        Object obj = dexa;
        if (obj != null && method != null) {
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke != null) {
                    return (String) objInvoke;
                }
                return null;
            } catch (Exception e) {
                Log.e(com.alipay.sdk.m.o0.b.f25481a, "invoke exception!", e);
            }
        }
        return null;
    }

    public static boolean dexa() {
        return (dexb == null || dexa == null) ? false : true;
    }
}
