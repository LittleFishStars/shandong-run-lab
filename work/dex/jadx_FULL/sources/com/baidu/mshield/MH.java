package com.baidu.mshield;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.rp.Receiver;
import com.baidu.mshield.utility.g;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.sec.privacy.b.b;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class MH {
    private static boolean isLoad = false;
    private static Receiver sdkRceiver;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26696a;
        public final /* synthetic */ HashMap b;

        /* JADX INFO: renamed from: com.baidu.mshield.MH$a$a, reason: collision with other inner class name */
        public class C0276a implements com.baidu.sec.privacy.a {
            public C0276a(a aVar) {
            }

            @Override // com.baidu.sec.privacy.a
            public boolean a() {
                com.baidu.mshield.b.c.a.b("MethodImpl.isAgreePolicy()=" + com.baidu.mshield.core.a.a());
                return com.baidu.mshield.core.a.a();
            }
        }

        public a(Context context, HashMap map) {
            this.f26696a = context;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.baidu.mshield.b.c.a.b("===pre isUserAuthPrv===");
            com.baidu.xclient.gdid.a.f(this.f26696a);
            b.a(this.f26696a, "mshield", new C0276a(this));
            com.baidu.mshield.b.a.a.f26699a = "985050001";
            if (MH.initAppkey(this.f26696a)) {
                com.baidu.mshield.utility.b.a(this.f26696a).b();
                String[] strArrI = com.baidu.mshield.utility.a.i(this.f26696a);
                if (strArrI.length == 2) {
                    MH.registerSDKReceiver(this.f26696a);
                    String str = strArrI[0];
                    com.baidu.mshield.b.a.a.f26699a = str;
                    com.baidu.mshield.core.a.a(this.f26696a, str, strArrI[1], this.b, 0);
                }
            }
        }
    }

    private MH() {
    }

    public static String getVersion(Context context) {
        return "4.2.6";
    }

    public static String gz(Context context) {
        return com.baidu.mshield.core.a.b(context);
    }

    public static String gzfi(Context context, String str, int i, String str2, HashMap<String, String> map) {
        try {
            if (com.baidu.mshield.utility.a.h(context) == 1) {
                if (!isLoad) {
                    init(context, map);
                }
                return com.baidu.mshield.core.a.a(context, str, i, str2);
            }
            Bundle bundle = new Bundle();
            bundle.putString("accountId", str);
            bundle.putInt("scene", i);
            bundle.putString("para", str2);
            bundle.putBundle("property", obtainBundleFromProperties(map));
            return g.a(context, "gzfi", bundle).getString("result", "");
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return "";
        }
    }

    public static String init(Context context, HashMap<String, String> map) {
        try {
            if (com.baidu.mshield.utility.a.h(context) != 1) {
                return g.a(context, "init", obtainBundleFromProperties(map)).getString("result", "");
            }
            if (!isLoad) {
                initPlugin(context, map);
                isLoad = true;
            }
            return gz(context);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean initAppkey(Context context) {
        String[] strArrC = com.baidu.mshield.utility.a.c(context);
        return !(strArrC == null || strArrC.length != 2 || TextUtils.isEmpty(strArrC[0]) || TextUtils.isEmpty(strArrC[1])) || com.baidu.mshield.key.a.a(context);
    }

    private static void initPlugin(Context context, HashMap<String, String> map) {
        new Thread(new a(context, map)).start();
    }

    private static Bundle obtainBundleFromProperties(HashMap<String, String> map) {
        Bundle bundle = new Bundle();
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    bundle.putString(str, map.get(str));
                }
            } catch (Throwable th) {
                com.baidu.mshield.utility.a.a(th);
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void registerSDKReceiver(Context context) {
        try {
            sdkRceiver = new Receiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.b.r.p");
            if (Build.VERSION.SDK_INT >= 33) {
                try {
                    context.registerReceiver(sdkRceiver, intentFilter, 4);
                } catch (Throwable th) {
                    com.baidu.mshield.utility.a.a(th);
                }
            } else {
                context.registerReceiver(sdkRceiver, intentFilter);
            }
        } catch (Throwable th2) {
            com.baidu.mshield.utility.a.a(th2);
        }
    }

    public static void setAgreePolicy(Context context, boolean z) {
        try {
            if (com.baidu.mshield.utility.a.h(context) == 1) {
                com.baidu.mshield.core.a.a(z);
            } else {
                Bundle bundle = new Bundle();
                bundle.putBoolean("_agree_policy", z);
                g.a(context, "setAgreePolicy", bundle);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void setAppStatus(Context context, boolean z) {
        try {
            if (com.baidu.mshield.utility.a.h(context) != 1) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("_app_status", z);
                g.a(context, "setAppStatus", bundle);
            } else if (isLoad) {
                com.baidu.mshield.core.a.b(z);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void ud(Context context, HashMap<String, String> map) {
        try {
            if (com.baidu.mshield.utility.a.h(context) != 1) {
                g.a(context, "ud", obtainBundleFromProperties(map));
            } else if (isLoad) {
                com.baidu.mshield.core.a.a(context, map);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static void unInitPlugin(Context context) {
        try {
            unregisterSDKReceiver(context);
            EngineImpl.getInstance(context).unload();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    private static void unregisterSDKReceiver(Context context) {
        try {
            Receiver receiver = sdkRceiver;
            if (receiver != null) {
                context.unregisterReceiver(receiver);
                sdkRceiver = null;
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public static String gzfi(Context context, String str, int i, HashMap<String, String> map) {
        return gzfi(context, str, i, null, map);
    }
}
