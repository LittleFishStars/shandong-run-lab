package com.kc.bw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.kc.bw.common.utils.ConstantInfo;
import com.kc.bw.common.utils.DebugLog;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class dexk {
    public static final int dexa = 1;
    public static final String dexb = dexg.dexa("tubsuBdujwjuz");
    public static final String dexc = dexg.dexa("boespje/joufou/fyusb/JOUFOU");
    public static final String dexd = dexg.dexa("gtgc!");
    public static final String dexe = dexg.dexa("jrb!npef!");
    public static final String dexf = dexg.dexa("jrb!tusjdu!");
    public static final String dexg = dexg.dexa("jrb!tmpu!");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0055  */
    public /* synthetic */ Object dexa(List list, Context context, Object obj, Object obj2, Method method, Object[] objArr) throws Throwable {
        int i = 0;
        if (dexb.equals(method.getName())) {
            DebugLog.hook_weak(dexg.dexa("TB"));
            for (Object obj3 : objArr) {
                if (obj3 instanceof Intent) {
                    String strDexa = dexa((Intent) obj3);
                    if (ConstantInfo.Config.isEnableStrictInterceptQuickApp()) {
                        if (dexa(strDexa)) {
                            DebugLog.hook_weak(dexf);
                            i = 1;
                            break;
                        }
                        if (!TextUtils.isEmpty(strDexa) && list.contains(strDexa)) {
                            dexa(context, strDexa);
                            break;
                        }
                    } else {
                        if (ConstantInfo.Config.isEnableAdSlotInterceptQuickApp() && dexa(strDexa)) {
                            ConstantInfo.Config.setEnableAdSlotInterceptQuickApp(false);
                            DebugLog.hook_weak(dexg);
                            i = 2;
                            break;
                        }
                        if (!TextUtils.isEmpty(strDexa)) {
                            continue;
                        }
                    }
                }
            }
        }
        if (i != 1 && i != 2) {
            try {
                return method.invoke(obj, objArr);
            } catch (Throwable th) {
                DebugLog.hook_w(th.toString());
                return 1;
            }
        }
        DebugLog.hook_weak(dexe + i);
        return 1;
    }

    private String dexa(Intent intent) {
        Bundle extras;
        String scheme = "";
        if (intent == null) {
            return "";
        }
        try {
            String scheme2 = intent.getScheme();
            if (!TextUtils.isEmpty(scheme2) || (extras = intent.getExtras()) == null) {
                return scheme2;
            }
            Object obj = extras.get(dexc);
            if (!(obj instanceof Intent)) {
                return scheme2;
            }
            scheme = ((Intent) obj).getData().getScheme();
            DebugLog.hook_weak(dexd);
            return scheme;
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("gfudi!tdifnf!gbjm-") + Log.getStackTraceString(th));
            return scheme;
        }
    }

    private boolean dexa(String str) {
        List<String> list;
        return (TextUtils.isEmpty(str) || (list = ConstantInfo.Config.quickAppSchemes) == null || list.isEmpty() || !ConstantInfo.Config.quickAppSchemes.contains(str)) ? false : true;
    }

    public abstract Class<?> dexa();

    public void dexa(Context context, String str) {
        dexn.dexa(context, str);
    }

    public void dexa(final Context context, final List<String> list) {
        try {
            Object objDexb = dexb();
            Class<?> clsDexa = dexa();
            Class<?> cls = Class.forName(dexg.dexa("boespje/vujm/Tjohmfupo"));
            Field declaredField = cls.getDeclaredField(dexg.dexa("nJotubodf"));
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod(dexg.dexa("hfu"), new Class[0]);
            declaredMethod.setAccessible(true);
            final Object objInvoke = declaredMethod.invoke(objDexb, new Object[0]);
            declaredField.set(objDexb, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{clsDexa}, new InvocationHandler(this, list, context, objInvoke) { // from class: com.kc.bw.dexk$$ExternalSyntheticLambda0
                public final dexk f$0;
                public final List f$1;
                public final Context f$2;
                public final Object f$3;

                {
                    this.f$0 = this;
                    this.f$1 = list;
                    this.f$2 = context;
                    this.f$3 = objInvoke;
                }

                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return this.f$0.dexa(this.f$1, this.f$2, this.f$3, obj, method, objArr);
                }
            }));
        } catch (Throwable th) {
            DebugLog.hook_w(th.toString());
        }
    }

    public Object dexb() {
        try {
            return dexc().get("");
        } catch (Throwable th) {
            DebugLog.hook_w(th.toString());
            return null;
        }
    }

    public abstract Field dexc();
}
